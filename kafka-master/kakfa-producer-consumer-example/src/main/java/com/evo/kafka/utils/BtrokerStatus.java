package com.evo.kafka.utils;


import kafka.utils.ZkUtils;
import org.I0Itec.zkclient.ZkClient;

public class BtrokerStatus {

    public static boolean isBrokerRunning() {
        boolean flag = false;
        ZkClient zkClient = new ZkClient("localhost:2181", 10000); //, kafka.utils.ZKStringSerializer$.MODULE$);
        if (zkClient != null) {
            int brokersCount = zkClient.countChildren(ZkUtils.BrokerIdsPath());
            if (brokersCount > 0) {
                flag = true;
            } else {
            }
            zkClient.close();

        }
        return flag;
    }
}

