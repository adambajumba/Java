
import java.util.Scanner;
//Code by Isaac Jumba
 
public class FigureInWords {
	static int inputValue;
	
	//Function to check that the integer entered  is between zero and nineteen
	public static String [] num_less_than_20 = {"Zero", "One", "Two", "Three","Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteeen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	
	//Function to convert values into tens value
	public static String [] num_in_tens = {" ", " ", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
			"Eighty", "Ninety"};
	
	//Function for classifying input into range values
	public static boolean numIsBetween(int value, int lowerRange, int upperRange){
		return (lowerRange <= value) && (value <= upperRange);
	}
	
	//Function to convert figures/input into words recursively
	public static String convert_to_words (int inputValue) {

		//For negative integer values
		if(inputValue < 0 ){
			return "Negative " + convert_to_words(-1 * inputValue);
		}
		
		//For integer values between 0 and 19
		else if (numIsBetween (inputValue, 0, 19)){
			return num_less_than_20[inputValue];
		}

		//For integer values between 20 and 99
		else if (numIsBetween (inputValue, 20, 99)){
			//if number is divisible by 10
			if(inputValue % 10 == 0){
				return num_in_tens[(inputValue/10)];
			}

			//for values between 20 and 99 not divisible by 10
			//changes the value to tens and ones			
			int tensValue = (inputValue / 10) * 10;
			int remainderValue = inputValue % 10;
			
			return convert_to_words(tensValue) + " " + convert_to_words(remainderValue);
			}

			//recursively convert input values between 100 and 999
			//using the num_above_99 function
			else if(numIsBetween ( inputValue, 100, 999)){
				return num_above_99 (inputValue, 100, "Hundred");
			}

			//recursively convert input values between 1000 and 999999
			//using the num_above_99 function
			else if (numIsBetween (inputValue, 1000, 999999)){
				return num_above_99 (inputValue, 1000, "Thousand");
			}

			//recursively convert input values between 1000000 and 999999999
			//using the num_above_99 function
			else if (numIsBetween (inputValue, 1000000, 999999999)){
				return num_above_99 (inputValue, 1000000, "Million");
			}

			//recursively convert input values between 1000000000 and 2147483647
			//using the num_above_99 function
			else if (numIsBetween (inputValue, 1000000000, 2147483647)){
				return num_above_99 (inputValue, 1000000000, "Billion");
			}

			else{
				return " ";
			}
	}
	
	public static String num_above_99 (int inputValue, int valueRange, String rangeName) {
		int unitValue = inputValue / valueRange;
		int remainderValue = inputValue % valueRange;
		
		if (remainderValue > 0){

			return (convert_to_words (unitValue)) + " " + rangeName + " " +
			 ((valueRange == 100) || (remainderValue < 100)? "and " : " ") + convert_to_words(remainderValue);
		}

		else {
			return (convert_to_words (unitValue)) + " " + rangeName;
		}
		
	}
	
	public static void doItAgain(){

		System.out.print("Enter a number to convert to words (or 'done' to quit):");

		Scanner input = new Scanner(System.in);
		verify(input.nextLine());

		System.out.println(convert_to_words(inputValue));

		doItAgain();
	}
	
	//function to check for users input options- whether integer or string
	public static void verify (String statement){
		if (statement.equalsIgnoreCase("done")) {
			exit("Thank you for using our service.");
		}

		else{
			try{
				inputValue = Integer.parseInt(statement);
			}
			catch(NumberFormatException err){
				exit("You entered a wrong value!");
			}
		}
	}
		
	//function to exit the program 
	private static void exit(String lastWords){
		    System.out.println(lastWords);
		    System.exit(0);
	}
	
	//Main method to implement the method
	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("Welcome to Figures to Words Converter");
		System.out.println("*************************************");
		
		//function to allow user to input the integer figures
		doItAgain();
	}
	
}
