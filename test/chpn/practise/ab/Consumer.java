package chpn.practise.ab;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/** 
 * 消费者 
 * @author 百恼  2013-11-16下午07:42:08 
 * 
 */
public class Consumer implements Runnable {
	int id;
	static Random rd = new Random();
	//容器  
	private final ArrayBlockingQueue< Bread > queue;

	public Consumer( int id ,  ArrayBlockingQueue< Bread > queue ) {
		this.queue = queue;
		this.id = id ;
	}

	/* (non-Javadoc) 
	 * @see java.lang.Runnable#run() 
	 */
	@Override
	public void run() {
		while ( true ) {
			consume();
		}
	}

	public void consume() {
		/** 
		 * take()方法和put()方法是对应的，从中拿一个数据，如果拿不到线程挂起 
		 * poll()方法和offer()方法是对应的，从中拿一个数据，如果没有直接返回null 
		 */
		try {
			Bread bread = queue.take();
			System.out.println( id + " consume:" + bread +"  " + queue.size() );
			Thread.sleep( rd.nextInt( 2000 ) );
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
	}
}
