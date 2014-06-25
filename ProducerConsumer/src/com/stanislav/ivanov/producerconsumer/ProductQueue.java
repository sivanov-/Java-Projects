package com.stanislav.ivanov.producerconsumer;
import java.util.Vector;

public class ProductQueue<T> {
	
	private final int maxQueueSize;
	
	public static final int MAX_SIZE = 1000;
	
	/**
	 * Initialize the queue with maximum size.
	 * 
	 * @param size Set the maximum allowed queue size. 
	 * 		It must be less than {@link ProductQueue#MAX_SIZE}.
	 * @throws IllegalArgumentException
	 * 		If size it less than 0 or greater than {@link ProductQueue#MAX_SIZE}..
	 */
	public ProductQueue(int size) throws IllegalArgumentException {
		
		if ((size > 1000) || (size < 0) ) {
			throw new IllegalArgumentException("Valid values are from 0-1000");
		}
		
		maxQueueSize = size;
	}
	
	// Use Vector because it is thread-safe.  
	private volatile Vector<T> qeue = new Vector<>();
	
	/**
	 * TODO: Add comment
	 * @param obj
	 * @throws InterruptedException
	 */
	public synchronized void put(T obj) throws InterruptedException {
		
		System.out.println("[put] Items in the queue: " + qeue.size());
		
		while (qeue.size() == maxQueueSize) {
			System.out.println("[put] Queue is full. Wait...");
			wait();
		}

		qeue.addElement(obj);
		notify();
	}
	
	// TODO: add comment
	public synchronized T get() throws InterruptedException {

		System.out.println("[get] Items in the queue: " + qeue.size());
		
		while (qeue.size() == 0) {
			System.out.println("[get] Queue is empty. Wait...");
			wait();
		}
		
		T message = qeue.firstElement();
		qeue.removeElement(message);
		notify();
		return message;
	}
	
	public int getSize() {
		return qeue.size();
	}
	
}
