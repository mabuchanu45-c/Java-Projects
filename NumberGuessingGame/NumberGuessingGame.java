import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
  
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int round = 1;

        while (playAgain) {
            int target = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\n--- Round " + round + " ---");
            System.out.println("Guess a number between 1 and 100. You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                attempts++;

                if (guess < target) {
                    System.out.println("Too Low!");
                } else if (guess > target) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                    guessedCorrectly = true;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You Lost! The number was " + target);
            } else {
                System.out.println("Round " + round + " summary — guessed in " + attempts + " attempts.");
            }

            System.out.print("Play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
            round++;
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}