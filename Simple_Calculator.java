import java.util.Scanner;

class Calculator {
	private double num1, num2;
    private char operation;
    
    public synchronized void setValues(double num1, double num2, char operation) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
    }

    public synchronized double calculate() {
        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}

class CalculationThread extends Thread {
    private Calculator calculator;
    
    public CalculationThread(Calculator calculator) {
        this.calculator = calculator;
    }

    public void run() {
        synchronized(calculator){
            double result = calculator.calculate();
            System.out.println("Result: " + result);
        }
    }
}

public class Simple_Calculator {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        int conti = 1; // Looping variable
	do{
        	System.out.print("Enter first number: ");
       		double num1 = sc.nextDouble();
        
        	System.out.print("Enter second number: ");
        	double num2 = sc.nextDouble();
        
        	System.out.print("Choose operation (+, -, *, /): ");
        	char operation = sc.next().charAt(0);

        	calculator.setValues(num1, num2, operation);
        
        	CalculationThread calThread = new CalculationThread(calculator);
        	calThread.start();
        
        	try{
            		calThread.join();
        	} catch(InterruptedException e){
            		System.out.println("Thread interrupted.");
		}
		
		System.out.print("\nDo you want to continue? (1->Yes, 0->No): ");
		conti = sc.nextInt();
        }while(conti == 1);
        
        sc.close();
    }
}
