package threads;


class PrintAnjan extends Thread
{
	public void run()
	{
		for(int i = 1; i<=100; i++)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Anjan");
		}
	}
}

class PrintBharath implements Runnable
{
	public void run()
	{
		for(int i = 1; i<=100; i++)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Bharath");
		}
	}
}

public class MakingThreads 
{
	public static void main(String[] args) throws InterruptedException 
	{
		PrintAnjan a = new PrintAnjan();
		PrintBharath b = new PrintBharath();
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		
		t2.start(); 
		t1.start();
	}
}
