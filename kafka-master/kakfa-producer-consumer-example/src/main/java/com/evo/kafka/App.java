package com.evo.kafka;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.evo.kafka.constants.IKafkaConstants;
import com.evo.kafka.consumer.ConsumerCreator;
import com.evo.kafka.producer.ProducerCreator;
import com.evo.kafka.utils.ConsumerGroupLag;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;

public class App {
	public static void main(String[] args) {
		//runProducer();
		runConsumer();
	}

	static void runConsumer() {
		Consumer<Object, Object> consumer = ConsumerCreator.createConsumer();

		//ConsumerGroupLag cLag = ConsumerCreator.createLagObject() ;

		int noMessageToFetch = 0;

		while (true) {
			final ConsumerRecords<Object, Object> consumerRecords = consumer.poll(1000);
			if (consumerRecords.count() == 0) {
				noMessageToFetch++;
				if (noMessageToFetch > IKafkaConstants.MAX_NO_MESSAGE_FOUND_COUNT)
					break;
				else
					continue;
			}
			/*try {
				List<Long> offsets = cLag.getOffset();
				for (Long offset : offsets) {
					System.out.println( "The currentoffset is " + offset);
				}
			}
			catch (Exception e) {
				System.out.println (e.getStackTrace()) ;
			}*/
			consumerRecords.forEach(record -> {
				System.out.println("Record Key " + record.key());
				System.out.println("Record value " + record.value());
				System.out.println("Record partition " + record.partition());
				System.out.println("Record offset " + record.offset());
			});
			consumer.commitAsync();
		}
		consumer.close();
	}

	static void runProducer() {
		Producer<Object, Object> producer = ProducerCreator.createProducer();

		for (Integer index = 0; index < IKafkaConstants.MESSAGE_COUNT; index++) {
			final ProducerRecord<Object, Object> record = new ProducerRecord<>(IKafkaConstants.TOPIC_NAME,
					index.toString(),
					"This is record " + index);
			try {
				RecordMetadata metadata = producer.send(record).get();
				System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
						+ " with offset " + metadata.offset());
			} catch (ExecutionException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			} catch (InterruptedException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			}
		}
	}
}

