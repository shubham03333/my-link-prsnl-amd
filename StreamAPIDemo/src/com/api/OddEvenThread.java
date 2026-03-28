package com.api;

public class OddEvenThread {

	
	private int number=1;
	private final int MAX=10;
	
	public synchronized void oddThread() 
	{
		while(number<=MAX)
		{			
				if(number%2!=0)
				{					
					System.out.println("Odd Numbers: "+number);
					number++;
					notify();
				}
				else 
				{
						try 
						{
							wait();
						}
						catch(InterruptedException e)
						{
							e.printStackTrace();
						}
				}
				
		}
			
	}
	
	
	public synchronized void evenThread()
	{
		while(number<=MAX)
		{
			if(number % 2==0)
			{
				System.out.println("Even Numbers: "+number);
				number++;
				notify();
			}
			else
			{
				try
				{
				wait();	
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			
		}
	}
	
	
	
	
	
	public static void main(String[] args)
	{
			OddEvenThread number= new OddEvenThread();
			
			Thread odd= new Thread(()-> number.oddThread());
			Thread even= new Thread(()-> number.evenThread());
			
			odd.start();
			even.start();
		
	}
	
}
