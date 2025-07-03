package bmicalculator;

import java.util.Scanner;
import java.util.Locale;

public class BMICalculator {

	public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);
      scanner.useLocale(Locale.US);
      
      char repeat;
      do {
	  
    	  int unitChoice = getUnitChoice(scanner);
    	  
    	  double weight = (unitChoice == 1)
    			  ? getValidInput(scanner, "Enter your weight in kilograms:", 10, 600)
    	  		: getValidInput(scanner, "Enter your weight in pounds :", 22, 1300);
    	  
    	  double height = (unitChoice == 1)
    			  ? getValidInput(scanner, "Enter your height in meters: ", 0.5, 2.5)                                       
    	  		: getValidInput(scanner, "Enter your height in inches:", 20, 100);
    	  
    	  double bmi = calculateBMI(unitChoice, weight, height);
    	  	System.out.println("Your BMI is "+ bmi);
    			  
    	  
    	  System.out.println("Do you want to calculate again? (Y/N)");
    	  repeat = scanner.next().charAt(0);
    	  System.out.println();
    	  
    			  
    	  
      }while (repeat == 'Y' || repeat == 'y' );
	}


public static int getUnitChoice(Scanner scanner) {
	int choice;

	
while (true) {
	System.out.println("select a preferred unit;\n");
	System.out.println("1. Metric (kg, m)");
	System.out.println("2. Imperial (lbs, in)");
	System.out.println("Please Select Either Option 1 or 2: ");
	
	if(scanner.hasNextInt()) {
		choice = scanner.nextInt();
		if(choice == 1 || choice == 2){
			break;
		} else {
			System.out.println("invalid choice. Please Enter Either 1 or 2 :");
		}
	}else {
		System.out.println("Invalid input. Please Enter number 1 or 2");
	}
	
	
	}
	
	return choice;
}

public static double getValidInput(Scanner scanner, String prompt, double min, double max) {
	double value;
	
	while(true) {
	System.out.println(prompt);
	
	
	if(scanner.hasNextDouble()) {
	value = scanner.nextDouble();
	
	if(value >= min && value <= max) {
		break;
	}else {
		System.out.printf("Please enter a value between %.2f and %.2f.\n", min, max);
	}
	}else {
		System.out.println("Invalid input, Please enter a value");
		scanner.next();
	}

}
	return value;

}


public static double calculateBMI(int unitChoice, double weight, double height) {
      double totalBMI;
      
      if(unitChoice == 1) {
    	  totalBMI = weight / (height * height);
    	  
      } else { 
    	  totalBMI = 703 * weight / (height * height);
    	  
      }
      
      return totalBMI;
}

}




