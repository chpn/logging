package chpn.practise.ab;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/** 
 * 生产者 
 * @author 百恼 2013-11-16下午07:44:36 
 * 
 */
public class Producer implements Runnable {
	
	int id;
	//容器  
	private final ArrayBlockingQueue< Bread > queue;

	public Producer(int id ,  ArrayBlockingQueue< Bread > queue ) {
		this.queue = queue;
		this.id = id;
	}

	/* (non-Javadoc) 
	 * @see java.lang.Runnable#run() 
	 */
	@Override
	public void run() {
		while ( true ) {
			produce();
		}
	}
	static Random rd = new Random();
	public void produce() {
		/** 
		 * put()方法是如果容器满了的话就会把当前线程挂起 
		 * offer()方法是容器如果满的话就会返回false，也正是我在前一篇中实现的那种策略。 
		 */
		try {
			Bread bread = new Bread( id );
			queue.put( bread );
			System.out.println( "Produce:" + bread );
			
			Thread.sleep( rd.nextInt( 2000 ) );
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
	}
}