package com.pooja.lambda;

public class RunnableLambda {

	public static void main(String args[]) throws InterruptedException {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<3;i++) {
					System.out.println("Running thread ::"+Thread.currentThread().getName());
				}
				
			}
		};
		
		Runnable lambdaRunnable = ()->{
			for(int i=0;i<3;i++) {
				System.out.println("Running thread ::"+Thread.currentThread().getName());
			}
		};
		
		System.out.println("Using anonymous class");
		Thread t=new Thread(runnable);
		t.start();
		t.join();
		System.out.println("Using lambda expr");
		Thread t1=new Thread(lambdaRunnable);
		t1.start();
		t1.join();
	}
}
