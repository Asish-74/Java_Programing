import java.util.Scanner;

public class TextAdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerName;

        // Introduction and setup
        System.out.println("Welcome to the Text Adventure Game!");
        System.out.print("Enter your name: ");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!\n");

        // Start the game
        System.out.println("You find a Hounted Forest. You have a choice to go left or right.");
        System.out.print("Enter 'left' or 'right': ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("left")) {
            // Option 1
            System.out.println("You chose to go left. You find a treasure chest!");
            System.out.print("Do you want to open it? (yes/no): ");
            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("Congratulations! You found a valuable treasure!");
            } else if (choice.equalsIgnoreCase("no")) {
                System.out.println("You left the treasure behind and continue your journey.");
            } else {
                System.out.println("Invalid input. You wander aimlessly.");
            }
        } else if (choice.equalsIgnoreCase("right")) {
            // Option 2
            System.out.println("You chose to go right. You encounter a ferocious monster!");
            System.out.print("Do you want to fight or run? (fight/run): ");
            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("fight")) {
                System.out.println("You bravely fought the monster and emerged victorious!");
            } else if (choice.equalsIgnoreCase("run")) {
                System.out.println("You decided to run away, narrowly escaping the monster.");
            } else {
                System.out.println("Invalid input. The monster catches up with you.");
            }
        } else {
            System.out.println("Invalid input. You are lost in the forest.");
        }

        // End of the game
        System.out.println("\nThanks for playing, " + playerName + "!");
        scanner.close();
    }
}
