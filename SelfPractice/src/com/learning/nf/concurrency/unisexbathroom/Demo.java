package com.learning.nf.concurrency.unisexbathroom;

public class Demo {
	
	public static void main( String args[] ) throws InterruptedException {
        runTest();
    }
	
	public static void runTest() throws InterruptedException {

        final UnisexBathroom unisexBathroom = new UnisexBathroom();

        Thread female1 = new Thread(new Runnable() {
            public void run() {
                try {
                	unisexBathroom.femaleUseBathRoom("Lisa");
                } catch (InterruptedException ie) {

                }
            }
        });
        
        Thread male1 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathRoom("John");
                } catch (InterruptedException ie) {

                }
            }
        });
        
        Thread male2 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathRoom("Bob");
                } catch (InterruptedException ie) {

                }
            }
        });
        

        Thread male3 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathRoom("Anil");
                } catch (InterruptedException ie) {

                }
            }
        });
        
        Thread male4 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathRoom("Wentao");
                } catch (InterruptedException ie) {

                }
            }
        });
        
        female1.start();
        male1.start();
        male2.start();
        male3.start();
        male4.start();

        female1.join();
        male1.join();
        male2.join();
        male3.join();
        male4.join();
        
	 }
}
