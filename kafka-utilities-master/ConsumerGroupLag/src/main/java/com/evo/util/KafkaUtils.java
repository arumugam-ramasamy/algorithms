package com.evo.util;

import kafka.admin.RackAwareMode;
import kafka.zk.AdminZkClient;
import kafka.zk.KafkaZkClient;
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

    public void connect_() {
        Boolean isSucre = false;
        int sessionTimeoutMs = 200000;
        int connectionTimeoutMs = 15000;
        int maxInFlightRequests = 1;
        Time time = Time.SYSTEM;
        String metricGroup = "myGroup";
        String metricType = "myType";
        zkClient = KafkaZkClient.apply(
                zookeeper, isSucre, sessionTimeoutMs,
                connectionTimeoutMs, maxInFlightRequests,
                time, metricGroup, metricType);
        adminZkClient = new AdminZkClient(zkClient);
    }

    public boolean topicExists (String topicName1) {
        if (this.zkClient == null)
            connect_();
        return zkClient.topicExists(topicName1);
    }

    public void getAllTopics () {
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

        adminZkClient.createTopic(topicName1, partitions, replication, topicConfig, RackAwareMode.Disabled$.MODULE$);
    }


    public void deleteTopic (String topicName1) {

        adminZkClient.deleteTopic(topicName1);
    }

    public static void main (String [] args) {

        KafkaUtils ku = new KafkaUtils("localhost:2182") ;
        ku.connect_();
        ku.createTopic("test");
        ku.getAllTopics();
    }

}
