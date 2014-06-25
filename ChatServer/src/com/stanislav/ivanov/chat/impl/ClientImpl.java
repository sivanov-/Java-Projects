package com.stanislav.ivanov.chat.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.stanislav.ivanov.chat.Client;
import com.stanislav.ivanov.chat.ClientCallback;


public class ClientImpl implements Client {

	private Socket socket;
	private int timeout = (int)TimeUnit.MINUTES.toMillis(5);
	private Thread readerThread;
	private Thread writerThread;
	private BlockingQueue<String> sendMsgQueue;
	
	public ClientImpl(final Socket socket, final ClientCallback callback) throws IOException {
		
		this.socket = socket;
		socket.setSoTimeout(timeout);
		sendMsgQueue = new LinkedBlockingQueue<>();
		
		readerThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					InputStream inputStream = socket.getInputStream();
					Reader streamReader = new InputStreamReader(inputStream);
					BufferedReader inputReader = new BufferedReader(streamReader);
					
					while(!Thread.currentThread().isInterrupted()) {
						try {
							String data = inputReader.readLine();
							if (data == null) {
								break;
							}
							callback.onDataReceived(data);
							
						} catch (SocketTimeoutException e) {
							// TODO: send 'keep alive'
							
						}
					}
					
				} catch (IOException e) {
					callback.onError(e);
				}
				
			}
		});
		readerThread.start();
		
		writerThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					OutputStream outputStream = socket.getOutputStream();
					Writer streamWriter = new OutputStreamWriter(outputStream);
					PrintWriter writer = new PrintWriter(streamWriter);
					
					while(!Thread.currentThread().isInterrupted()) {
						String data = sendMsgQueue.take();
						writer.println(data);
						writer.flush();
					}
					
				} catch (Exception e) {
					callback.onError(e);
				}
				
			}
		});
		writerThread.start();
	}
	
	public void disconnect() throws Exception {
		readerThread.interrupt();
		writerThread.interrupt();
		socket.close();
	}
	
	public void sendData(String data) {
		sendMsgQueue.offer(data);
	}
	
}
