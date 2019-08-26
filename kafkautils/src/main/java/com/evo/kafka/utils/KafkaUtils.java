package com.evo.kafka.utils;

import com.evo.kafka.exception.ConnectionException;
import com.evo.kafka.exception.TopicOperationException;
import kafka.admin.AdminOperationException;
import kafka.admin.RackAwareMode;
import kafka.zk.AdminZkClient;
import kafka.zk.KafkaZkClient;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.utils.Time;
import scala.collection.Seq;

import java.util.Properties;

public class KafkaUtils {

    String zookeeper;
    KafkaZkClient zkClient;
    AdminZkClient adminZkClient;


    public KafkaUtils(String zk) {
        this.zookeeper = zk;
    }


    public void connect() {
        Boolean isSucre = false;
        int sessionTimeoutMs = 200000;
        int connectionTimeoutMs = 15000;
        int maxInFlightRequests = 1;
        Time time = Time.SYSTEM;
        String metricGroup = "myGroup";
        String metricType = "myType";

        try {

            zkClient = KafkaZkClient.apply(
                    zookeeper, isSucre, sessionTimeoutMs,
                    connectionTimeoutMs, maxInFlightRequests,
                    time, metricGroup, metricType);
            adminZkClient = new AdminZkClient(zkClient);
        }
        catch (Exception e) {
           throw new ConnectionException(this.zookeeper, e.getStackTrace().toString(), e, this.getClass()) ;
        }
    }


    public boolean topicExists(String topicName1) {
        if (this.zkClient == null)
            connect();
        return zkClient.topicExists(topicName1);
        //assert (true == zkClient.topicExists(topicName1)) ;
    }

    public void getAllTopics() {
        Seq allTopic = zkClient.getAllTopicsInCluster();
        System.out.println("Cluset has " + allTopic.length() + " topics");
    }

    public void createTopic(String topicName1) {

     /*   if (topicName1 == null) {
            throw NullPointerException() ;
        }*/
        int partitions = 3;
        int replication = 1; // you should have replication factor less than or equal to number of nodes in Kafka cluster
        Properties topicConfig = new Properties(); // you can pass topic
        try {
            adminZkClient.createTopic(topicName1, partitions, replication, topicConfig, RackAwareMode.Disabled$.MODULE$);
        }
        catch (IllegalArgumentException | KafkaException | AdminOperationException e) {
            throw new TopicOperationException(topicName1, e.getMessage(), e, this.getClass());
        }
    }


    public void deleteTopic(String topicName1) {
        if (topicExists(topicName1))
            adminZkClient.deleteTopic(topicName1);
    }

    public static void main(String[] args) {

        KafkaUtils ku = new KafkaUtils("localhost:2180");
        ku.connect();
        //ku.createTopic("test");
        ku.getAllTopics();
        ku.deleteTopic("test");
    }

}
