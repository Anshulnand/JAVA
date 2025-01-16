import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
       
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; 

        Scanner scanner = new Scanner(System.in);
        int userGuess = 0;

        System.out.println("=== Welcome to the Number Guessing Game! ===");
        System.out.println("I have picked a number between 1 and 100. Can you guess it?");

       
        while (true) {
           
            System.out.print("Enter your guess: ");

            
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.next(); 
                continue;
            }

            userGuess = scanner.nextInt();

           
            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                break; 
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Too low! Try again.");
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
