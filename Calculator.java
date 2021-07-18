import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Calculator{
	private boolean notOperation = false;
	public Calculator(){
		display();
	}

	private boolean isNumber(String number){ // check if the input of the user is Number or not
		try{
			Float.parseFloat(number);
		}catch(Exception e){
			return false;// if the user input is not number it throws flase
		}
		return true;
	}

	private void Operation(String operator, String x, String y){// checking what operation going to perform
		switch(operator){
			case "+":
				System.out.print("Result: " + addition(x, y));
				break;

			case "-":
				System.out.print("Result: " + substraction(x, y));
				break;

			case "*":
				System.out.print("Result: " + multiplication(x, y));
				break;

			case "/":
				System.out.print("Result: " + division(x, y));
				break;

				default:
				notOperation = true;

		}
	}

	private Float addition(String x, String y){
		return Float.valueOf(x) + Float.valueOf(y);
	}

	private Float substraction(String x, String y){
		return Float.valueOf(x) - Float.valueOf(y);
	}

	private Float multiplication(String x, String y){
		return Float.valueOf(x) * Float.valueOf(y);
	}

	private Float division(String x, String y){
		return Float.valueOf(x) / Float.valueOf(y);
	}

	private void display(){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String x, y, option, operator;
		boolean again = false;

		try{
			do{
				again = false;

				do{
					System.out.print("Enter the First Number: ");
					x = in.readLine();
				}while(!isNumber(x)); // check if the input is number.

				do{
					System.out.print("Enter the Second Number: ");
					y = in.readLine();
				}while(!isNumber(y)); // check if the input is number.			

				do{
					notOperation = false;
					System.out.print("Select the operator to perform (+, -, *, /) :");
					operator = in.readLine();
					Operation(operator, x, y);
				}while(notOperation == true);

				System.out.print("\nDo you want to perform another Operation? y/n: "); 
				option = in.readLine();

				if(option.equalsIgnoreCase("y")){
					again = true;
				}else{
					System.exit(0);
				}
			}while(again == true); 
			

		}catch(IOException e){
			System.err.print(e.getMessage());
		}
	}

	public static void main(String []args){
		new Calculator();
	}
}
