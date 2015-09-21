import java.util.Scanner;

//Modified Calculator
//Isaac Jumba

public class Calculator {

	//Addition
	public static void summation (double x, double y) {

		double result = x + y;
		System.out.println("The Sum is: " + result);
	}

	//Subtraction
		public static void subtraction (double x, double y) {

		double result = x - y;
		System.out.println("The Difference is: " + result);

	}

	//Multiplication
	public static void multiplication (double x, double y) {

		double result = x * y;
		System.out.println("The Product is: " + result);

	}

	//Division
	public static void division(double x, double y) {

		double result = x / y;
		System.out.println("The Quotient is: " + result);
	}

	//Squareroot
	public static void squareRoot(int value1) {

		double i;
		double result = value1 / 2;
		do{
			i = result;
			result = (i + (value1 / i)) / 2;
		} while ((i - result) != 0);
 
		System.out.println("The square root of "+value1+" is "+result);
	}

	//Power
	public static void power(double x, double y){

		double result = 1;
		for (int i = 1; i <= y; i ++ ) {
		result *= x;
		}

		System.out.println(x+" raised to power of "+y+" is "+result);

	}

	//Modulus
	public static void modulus(double x, double y) {

		double result = x % y;
		System.out.println(x +" modulo "+ y +" is "+ result);

	}
	//Average
	public static void average(int value1, int value2){

		float result = (float) value1 + (((float) value2-(float) value1) / 2);
		System.out.println("The average is: "+ result);

	}
	//main class
	public static void main(String[] args) {

		Scanner in=new Scanner(System.in);

		System.out.println("Welcome to our Calculator");

		System.out.println("Please enter select the type of operation you wish to perfom");		
		System.out.println("1 for Addition\n" + "2 for Subtraction\n"  + "3 for Multiplication\n" + "4 for Division\n" + "5 for Squareroot\n" +"6 for Average\n" + "7 for Modulus\n"+ "8 for Power\n");

		int inputChoice = in.nextInt();
		if(inputChoice == 1 || inputChoice == 2 || inputChoice ==3 || inputChoice == 4 || inputChoice == 7) {

			System.out.println("Please enter the first number");

			double num1 = in.nextDouble();

			System.out.println("Please enter the second number");

			double num2 = in.nextDouble();
			
			if(inputChoice == 1){
				summation(num1, num2);
			}
			if(inputChoice == 2){
				subtraction(num1, num2);
			}
			if(inputChoice == 3){
				multiplication(num1, num2);
			}
			if(inputChoice == 4){
				division(num1, num2);
			}
			if(inputChoice == 7){
				modulus(num1, num2);
				
			}
								
		}
		else
			if(inputChoice == 5){

				System.out.println("Please enter an number to find its Squareroot");
				int num = in.nextInt();
				squareRoot(num);
			}
		else
			if(inputChoice == 8){

			System.out.println("Please enter the base number");
			double value1 = in.nextDouble();

			System.out.println("Please enter the exponent number");
			double value2 = in.nextDouble();
			power(value1, value2);

			}
		else 
			if(inputChoice == 6){
			System.out.println("Please enter the first value");
			int value1 = in.nextInt();

			System.out.println("Please enter the second value");
			int value2 = in.nextInt();
			average(value1, value2);
		}		
	}
}