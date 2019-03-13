package com.learning.nf.concurrency.blockingqueue;

public class BlockingQueue<T> {
	
	int capacity;
	int size;
	T[] array;
	int head;
	int tail;
	Object lock = new Object();
	
	BlockingQueue(int capacity) {
		array = (T[])new Object[capacity];
		this.capacity = capacity;
		
	}
	
	public void enqueue(T item) throws InterruptedException {
		synchronized (lock) {

            while (size == capacity) {
                lock.wait();
            }

            if (tail == capacity) {
                tail = 0;
            }

            array[tail] = item;
            size++;
            tail++;
            lock.notify();
        }
	}
	
	public T dequeue() throws InterruptedException {
		
		synchronized(lock) {
			
			while(size == 0) {
				lock.wait();
			}
			
			if (head == capacity) {
                head = 0;
            }
			
			T item = array[head];
			array[head] = null;
			head++;
			size--;
			
			lock.notify();
			
			return item;
		}
		
	}

}
