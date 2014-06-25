package com.stanislav.ivanov.producerconsumer;


public class Consumer extends Thread {
	
	private final ProductQueue<String> queue;
	private final int sleepTime;
	private volatile int consumed = 0;

	/**
	 * Initiate consumer
	 * @param queue Queue to consume from
	 * @param delay Delay between consumes
	 */
	public Consumer (ProductQueue<String> queue, int delay) {
		this.queue = queue;
		sleepTime = delay;
	}
	
	public void run() {
		try {
			while (true) {
				String message = queue.get();
				System.out.println(getName() + " : get " + message);
				consumed++;
				sleep(sleepTime);
			}
		} catch (InterruptedException e) {
			
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int getConsumedCount() {
		return consumed;
	}
}
