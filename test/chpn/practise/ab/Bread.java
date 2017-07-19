package chpn.practise.ab;

import java.util.concurrent.atomic.AtomicInteger;

public class Bread {
	static AtomicInteger ai = new AtomicInteger(0);
	private int id;
	private int prodcerId ;
	public Bread( int  producerId ){
		id = ai.incrementAndGet() ;
		this.prodcerId = producerId;
	}
	public String toString(){
		return prodcerId + "-" + id;
	}
}
