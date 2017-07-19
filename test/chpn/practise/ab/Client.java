package chpn.practise.ab;

import java.util.concurrent.ArrayBlockingQueue;

public class Client {

	/** 
	 * @param args 
	 * @throws InterruptedException 
	 */
	public static void main( String[] args) throws InterruptedException {
		int capacity = 10;
		ArrayBlockingQueue< Bread > queue = new ArrayBlockingQueue< Bread >( capacity );

		new Thread( new Producer( 1 , queue ) ).start();
		new Thread( new Producer( 2 , queue ) ).start();
		Thread.sleep( 1000 );
		new Thread( new Consumer( 1 , queue ) ).start();
		new Thread( new Consumer( 2 ,  queue ) ).start(); 
	}

}