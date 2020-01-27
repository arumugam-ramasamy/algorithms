package com.evo.kafka;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.config.ConfigResource;
import org.apache.kafka.common.config.TopicConfig;

import kafka.log.LogConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminUtils {

    private AdminClient client = null;
    Logger logger = LoggerFactory.getLogger(AdminUtils.class) ;

    public void setup() {
        Map<String, Object> conf = new HashMap<>();
        conf.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        conf.put(AdminClientConfig.REQUEST_TIMEOUT_MS_CONFIG, "5000");
        client = AdminClient.create(conf);

    }


    public void teardown() {
        client.close();
    }


    public void testNames() throws InterruptedException, ExecutionException {
        ListTopicsResult ltr = client.listTopics();
        KafkaFuture<Set<String>> names = ltr.names();
        System.out.println(names.get());
    }

    public void testCreateTopic() {
        int partitions = 8;
        short replicationFactor = 1;
        try {
            KafkaFuture<Void> future = client
                    .createTopics(Collections.singleton(new NewTopic("tweet", partitions, replicationFactor)),
                            new CreateTopicsOptions().timeoutMs(10000))
                    .all();
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void printTopicDetails() {
        Collection<TopicListing> listings;
// Create  an AdminClient using the properties initialized earlier
        try  {
            listings = getTopicListing(client, true);
            listings.forEach(
                    topic -> System.out.println("Name: " + topic.name() + ", isInternal: " + topic.isInternal()));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            logger.debug("Failed to get topic list {0}", e.getCause());
        }
    }
    private  void printTopicDescription() {
        Collection<TopicListing> listings;
        // Create  an AdminClient using the properties initialized earlier
        try {
            listings = getTopicListing(client, false);
            List<String> topics = listings.stream().map(TopicListing::name)
                    .collect(Collectors.toList());
            DescribeTopicsResult result = client.describeTopics(topics);
            result.values().forEach((key, value) -> {
                try {
                    System.out.println(key + ": " + value.get());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (ExecutionException e) {
                    logger.debug("Failed to execute", e.getCause());
                }
            });
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            logger.debug("Failed to get topic list", e.getCause());
        }
    }
    private Collection<TopicListing> getTopicListing(AdminClient client, boolean isInternal)
            throws InterruptedException, ExecutionException {
        ListTopicsOptions options = new ListTopicsOptions();
        options.listInternal(isInternal);
        return client.listTopics(options).listings().get();
    }


    //@Test
    public void testDeleteTopic() {
        KafkaFuture<Void> future = client.deleteTopics(Collections.singleton("tweet")).all();
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void testChangeProperties() throws InterruptedException, ExecutionException {
        ConfigResource resource = new ConfigResource(ConfigResource.Type.TOPIC, "tweet");

        // get the current topic configuration
        DescribeConfigsResult describeConfigsResult = client.describeConfigs(Collections.singleton(resource));

        Map<ConfigResource, Config> config;
        config = describeConfigsResult.all().get();

        System.out.println(config);

        // create a new entry for updating the retention.ms value on the same topic
        ConfigEntry retentionEntry = new ConfigEntry(TopicConfig.RETENTION_MS_CONFIG, "60000");
        Map<ConfigResource, Config> updateConfig = new HashMap<ConfigResource, Config>();
        updateConfig.put(resource, new Config(Collections.singleton(retentionEntry)));

        AlterConfigsResult alterConfigsResult = client.alterConfigs(updateConfig);
        alterConfigsResult.all();

        describeConfigsResult = client.describeConfigs(Collections.singleton(resource));

        config = describeConfigsResult.all().get();
    }

    public static void main(String[] args) {
        AdminUtils au = new AdminUtils() ;
        au.setup();
        au.testCreateTopic();
        try {
            au.testNames();
            Collection<TopicListing> all =  au.getTopicListing(au.client, false) ;
            au.printTopicDetails();
            System.out.println(all.toArray().toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        au.testDeleteTopic();

        au.teardown();
    }

}
