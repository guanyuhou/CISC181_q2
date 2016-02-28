package main_package;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//ask for input initial tuition, APR, and scheduled years to pay
		System.out.print("Initial Tuition Cost is: ");
		final double ini_tui = in.nextDouble();
		System.out.print("Repayment APR is: ");
		final double apr = in.nextDouble();
		System.out.print("How Many Years Are Repayment Scheduled: ");
		final long schedule = in.nextLong();
		
		double[] rates = new double[3];
		for (int i=2; i<5; i++)
		{
			System.out.print("Enter the Percentage Increase for Year-" + i + ": ");
			double inc_rate = in.nextDouble();
			rates[i-2] = inc_rate;
		}
		
		in.close();
		
		String res_total_tui = String.format("%.2f", totalTuition(ini_tui, rates));
		System.out.println("Your Total Cost of Tuition is $" + res_total_tui);
		
		double month_pay = monthPayment(totalPayment(ini_tui, rates, apr), schedule);
		String res_month_pay = String.format("%.2f", month_pay);
		System.out.println("Monthly Payment is $" + res_month_pay);
		
	}
	
	public static double totalTuition(double ini_val, double[] rate_list)
	{
		//this method calculates the total tuition cost
		double term_cost = ini_val;
		double total_cost = ini_val;
		for (int i=0; i<3; i++)
		{
			term_cost = term_cost * (1 + (rate_list[i] / 100));
			total_cost += term_cost;
		}
		return total_cost;
	}
	
	public static double totalPayment(double ini_val, double[] rate_list, double apr)
	{
		//this method calculates the total payment after year 4 with interest rate
		double term_cost = ini_val;
		double total_pay = ini_val;
		for (int i=0; i<3; i++)
		{
			total_pay = total_pay * (1 + (apr / 100));
			term_cost = term_cost * (1 + (rate_list[i] / 100));
			total_pay += term_cost;
		}
		return total_pay;
	}
	
	public static double monthPayment(double total_pay, long year)
	{
		return (total_pay / (12 * year));
	}
	
}
