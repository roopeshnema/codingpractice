package com.learning.corejava.concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	
	public static void main(String[] args){
		CyclicBarrier waitingPoint = new CyclicBarrier(4, new MixedDoubleTennisGame());
		
		new Player(waitingPoint,"Mohan");
		new Player(waitingPoint,"Siva");
		new Player(waitingPoint,"Ram");
		new Player(waitingPoint,"Hari");
	}

}
