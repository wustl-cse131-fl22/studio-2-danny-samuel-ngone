package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out.println("How much money did you start with? ");
		double startAmount = in.nextDouble();
		System.out.println("What is the probability that you would win a single game (between 0-1)? ");
		double winChance = in.nextDouble();
		System.out.println("At what money value would your day be a success and you would walk away? ");
		double winLimit = in.nextDouble();
		System.out.println("How many days would you like to play?");
		int totalSimulations = in.nextInt();
		
		
		int simulations = 1;
		int losses = 0;
		
		
		while (simulations<=totalSimulations)
		{
			int plays = 0;
			double currentAmount = startAmount;
			while ((currentAmount>0) && (currentAmount<winLimit))
			{
				
				double rnd = Math.random();
				if (rnd<=winChance) 
				{
					currentAmount++;
				}
				else 
				{
					
				currentAmount--;
				
				}
			
				plays++;
			}
			if (currentAmount>=winLimit)
			{
				System.out.println("Simulation " + simulations + ": " + plays + " WIN" );
			}
			else {
				System.out.println("Simulation " + simulations + ": " + plays + " LOSE");
				losses++;
			}
			simulations++;
		}
		double expectedRuin = 0;
		if(winChance == 0.5)
		{
			expectedRuin = 1 - (startAmount/winLimit);
		}
		else 
		{
			double a = (1-winChance)/ winChance;
			expectedRuin = (Math.pow(a, startAmount)-Math.pow(a, winLimit))/(1-Math.pow(a, winLimit));
		}
		System.out.println("Losses: " + losses + " Simulations: " + totalSimulations);
		System.out.println("Ruin Rate from Simulation: " + ((double) losses/totalSimulations)+ " Expected Ruin Rate: " + expectedRuin);
		
	}
}
