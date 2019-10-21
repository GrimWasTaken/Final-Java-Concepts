package Threads;

//Runnable example
class Hi implements Runnable
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println("One says hi");
			try {Thread.sleep(1000); } catch(Exception e) {}
		}
	}
}

//Extending example
class Hello extends Thread
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println("Two says hi");
			try {Thread.sleep(1000); } catch(Exception e) {}
		}
	}
}

public class ThreadDemo 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Runnable demo
		Runnable hiInstance = new Hi();
		Thread threadOne = new Thread(hiInstance);
		
		//Extending demo
		Hello threadTwo = new Hello();
		
		//Lambda demo
		Thread threadThree = new Thread(() ->
		{
			for(int i=1;i<=5;i++)
			{
				System.out.println("Three says hi");
				try {Thread.sleep(1000); } catch(Exception e){}
			}
		});
		
		//Run threads
		//Sleep after starting to initialize in order
		threadOne.start();
		try {Thread.sleep(10); } catch(Exception e) {}
		threadTwo.start();
		try {Thread.sleep(10); } catch(Exception e) {}
		threadThree.start();
		try {Thread.sleep(10); } catch(Exception e) {}
		
		//Priority demo
		threadOne.setPriority(Thread.MAX_PRIORITY);
		threadTwo.setPriority(5);
		threadThree.setPriority(Thread.MIN_PRIORITY);
		
		//Stop simultaneous output
		threadOne.join();
		threadTwo.join();
		threadThree.join();
		
		if(!threadThree.isAlive()) {System.out.println("Bye");}
		
	}
}