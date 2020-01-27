package com.evo.kafka.utils;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.apache.kafka.clients.admin.TopicListing;

import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class AdminUtil {
    public static void main(String args []) {
// First we need to initialize Kafka properties
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092,localhost:9093,localhost:9093");
        properties.put("client.id","java-admin-client");
        System.out.println("***** Topics *****");
        printTopicDetails(properties);
        System.out.println("***** Topics Description *****");
        printTopicDescription(properties);
    }
    private static void printTopicDetails(Properties properties) {
        Collection<TopicListing> listings;
// Create  an AdminClient using the properties initialized earlier
        try (AdminClient client = AdminClient.create(properties)) {
            listings = getTopicListing(client, true);
            listings.forEach(
                    topic -> System.out.println("Name: " + topic.name() + ", isInternal: " + topic.isInternal()));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            //LOGGER.log(Level.SEVERE, "Failed to get topic list {0}", e.getCause());
        }
    }
    private static void printTopicDescription(Properties properties) {
        Collection<TopicListing> listings;
        // Create  an AdminClient using the properties initialized earlier
        try (AdminClient client = AdminClient.create(properties)) {
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
                    //LOGGER.log(Level.SEVERE, "Failed to execute", e.getCause());
                }
            });
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
           // LOGGER.log(Level.SEVERE, "Failed to get topic list", e.getCause());
        }
    }
    private static Collection<TopicListing> getTopicListing(AdminClient client, boolean isInternal)
            throws InterruptedException, ExecutionException {
        ListTopicsOptions options = new ListTopicsOptions();
        options.listInternal(isInternal);
        return client.listTopics(options).listings().get();
    }
}