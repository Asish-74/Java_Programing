import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        float celsius = input.nextFloat();

        // Convert Celsius to Fahrenheit
        double fahrenheit = (celsius * 9/5) + 32;

        System.out.println("Temperature in Fahrenheit: " + fahrenheit);

        input.close(); // Close the Scanner when you're done with it
    }
}
