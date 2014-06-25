package com.stanislav.ivanov.producerconsumer;

import org.junit.Assert;
import org.junit.Test;

import com.stanislav.ivanov.producerconsumer.Consumer;
import com.stanislav.ivanov.producerconsumer.Producer;
import com.stanislav.ivanov.producerconsumer.ProductQueue;

public class ProducerConsumerTest {

	@Test
	public void testMaxQueueSize() {

		int maxQueueSize = 5;
		ProductQueue<String> queue = new ProductQueue<>(maxQueueSize);
		
		Producer producer = new Producer(queue, 50);
		producer.start();
		
		try {
			Thread.sleep(230);
			Assert.assertEquals(5, producer.getProducedCount());
			
			Thread.sleep(200);
			// 5 instead of 8, because of the blocking queue.
			Assert.assertEquals(5, producer.getProducedCount());
			Assert.assertEquals(maxQueueSize, queue.getSize());
			
			producer.interrupt();
			
		} catch (InterruptedException e) {
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testMoreProduction() {

		ProductQueue<String> queue = new ProductQueue<>(5);
		
		Producer producer = new Producer(queue, 100);
		producer.start();
		
		Consumer consumer1 = new Consumer(queue, 300);
		consumer1.setName("consumer-1");
		consumer1.start();

		Consumer consumer2 = new Consumer(queue, 400);
		consumer2.setName("consumer-2");
		consumer2.start();
		
		try {
			Thread.sleep(80);
			Assert.assertEquals(1, producer.getProducedCount());
			Assert.assertEquals(1, consumer1.getConsumedCount());
			Assert.assertEquals(0, consumer2.getConsumedCount());
			Assert.assertEquals(0, queue.getSize());
			
			Thread.sleep(150);
			Assert.assertEquals(3, producer.getProducedCount());
			Assert.assertEquals(1, consumer1.getConsumedCount());
			Assert.assertEquals(1, consumer2.getConsumedCount());
			Assert.assertEquals(1, queue.getSize());
			
			Thread.sleep(120);
			Assert.assertEquals(4, producer.getProducedCount());
			Assert.assertEquals(2, consumer1.getConsumedCount());
			Assert.assertEquals(1, consumer2.getConsumedCount());
			Assert.assertEquals(1, queue.getSize());
			
			Thread.sleep(200);
			Assert.assertEquals(6, producer.getProducedCount());
			Assert.assertEquals(2, consumer1.getConsumedCount());
			Assert.assertEquals(2, consumer2.getConsumedCount());
			Assert.assertEquals(2, queue.getSize());
			
			producer.interrupt();
			consumer1.interrupt();
			consumer2.interrupt();
			
		} catch (InterruptedException e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testMoreConsumption() {

		ProductQueue<String> queue = new ProductQueue<>(5);
		
		Producer producer = new Producer(queue, 200);
		producer.start();
		
		Consumer consumer1 = new Consumer(queue, 100);
		consumer1.setName("consumer-1");
		consumer1.start();

		Consumer consumer2 = new Consumer(queue, 100);
		consumer2.setName("consumer-2");
		consumer2.start();
		
		try {
			Thread.sleep(300);
			producer.interrupt();
			consumer1.interrupt();
			consumer2.interrupt();
			
		} catch (InterruptedException e) {
			Assert.fail(e.getMessage());
		}
		
		Assert.assertEquals(0, queue.getSize());
	}
	
}
