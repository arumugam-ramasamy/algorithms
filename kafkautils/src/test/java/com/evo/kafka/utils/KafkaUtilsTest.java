package com.evo.kafka.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class KafkaUtilsTest {

    KafkaUtils kc ;
    Logger logger =  LoggerFactory.getLogger(KafkaUtilsTest.class) ;



    @Parameters(value="exampleDesc")
    @BeforeTest
    public void connect (String connect) {
        //connect = "localhost:2181" ;
        System.out.println(connect) ;
        kc = new KafkaUtils(connect) ;
        try {
            kc.connect();
        }
        catch (Exception e) {

        }

    }

    @Test
    public void testConnect() {
        assertNotEquals(kc.adminZkClient, null);
    }

    @Test
    public void testTopicExists() {
    }

    @Test
    public void testCreateTopic() {
    }

    @Test
    public void testDeleteTopic() {
    }
}