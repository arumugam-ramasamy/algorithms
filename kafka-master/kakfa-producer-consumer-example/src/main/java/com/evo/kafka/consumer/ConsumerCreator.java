package com.evo.kafka.consumer;

import java.util.*;

import com.evo.kafka.constants.IKafkaConstants;
import com.evo.kafka.utils.ConsumerGroupLag;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumerCreator {



	public static Consumer<Object, Object> createConsumer() {
		ConsumerRebalanceListener listener = new ConsumerRebalanceListener() {

			@Override
			public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
				//System.out.println("C : , Revoked topicPartitions : {}", partitions);
				System.out.println ("revokded topic partition") ;
				//commitOffsets(partitionToUncommittedOffsetMap);
			}

			@Override
			public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
				for (TopicPartition tp : partitions) {
					//OffsetAndMetadata offsetAndMetaData = consumer.committed(tp);
					//long startOffset = offsetAndMetaData != null ? offsetAndMetaData.offset() : -1L;
					//System.out.println("C : {}, Assigned topicPartion : {} offset : {}", clientId, tp, startOffset);
					System.out.println (" partition assignment");

					/*if(startOffset >= 0)
						consumer.seek(tp, startOffset);*/
				}
			}
		};

		final Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, IKafkaConstants.KAFKA_BROKERS);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, IKafkaConstants.GROUP_ID_CONFIG);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, IKafkaConstants.MAX_POLL_RECORDS);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, IKafkaConstants.OFFSET_RESET_EARLIER);
		System.out.println ("Came here before kafka consumer") ;
		final Consumer<Object, Object> consumer = new KafkaConsumer<>(props);
		//consumer.subscribe(Collections.singletonList(IKafkaConstants.TOPIC_NAME), listener);
		System.out.println ("Came here after kafka consumer") ;
		TopicPartition tp = new TopicPartition("test", 0);
		TopicPartition tp1 = new TopicPartition("test",1 );
		List<TopicPartition> tps = new ArrayList<>();
		tps.add(tp) ;
		tps.add(tp1) ;
		consumer.assign(tps);
		System.out.println ("Came here after kafka consumer what ") ;
		return consumer;
	}

	public static ConsumerGroupLag createLagObject () {
		ConsumerGroupLag cLag = new ConsumerGroupLag() ;
		cLag.setBootstrapServer(IKafkaConstants.KAFKA_BROKERS);
		cLag.setGroup(IKafkaConstants.GROUP_ID_CONFIG);
		return cLag ;
	}

}
