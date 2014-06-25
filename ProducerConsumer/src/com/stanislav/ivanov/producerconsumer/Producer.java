package com.stanislav.ivanov.producerconsumer;
import java.util.Date;

public class Producer extends Thread {
	
	private final ProductQueue<String> queue;
	private final int sleepTime;
	private volatile int produced;

	/**
	 * TODO:
	 * 
	 * @param queue
	 * @param productionTime
	 */
	public Producer (ProductQueue<String> queue, int productionTime) {
		this.queue = queue;
		sleepTime = productionTime;
	}
	
	public void run() {
		try {
			while (true) {
				String message = new Date().toString();
				System.out.println("producer : put " + message);
				queue.put(message);
				produced++;
				sleep(sleepTime);
			}
		}  catch (InterruptedException e) {
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int getProducedCount() {
		return produced;
	}
}
