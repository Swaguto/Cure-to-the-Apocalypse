/*
 * PRIMARY CODE
 * Harsimran + Rohith (11/11/2024)
 * methods were worked on together, this is main file that starts everything
 */

import java.util.*; // for dialog boxes
import java.util.concurrent.TimeUnit; // date + scanner
import javax.swing.*; // timing

public class primary {
    static Date now; static Date end;
    public static void main(String[] args) throws InterruptedException {
        new primary();
    }

    static Scanner input = new Scanner(System.in);
    static String playerName = "";
    static int sec1 = 0;
    static int min1 = 0;

    public primary () { // starts everything
        now = new Date();
        sec1 = now.getSeconds();
        min1 = now.getMinutes();
        start();
    }

    static void printSlow(String word) { // printslow function
        int printSlowSpeed = 10; 
	    char[] chars = word.toCharArray();
	    for (int i = 0; i < chars.length; i++) {
	        System.out.print(chars[i]);
	        try {
                Thread.sleep(printSlowSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
	    }
	    System.out.println("");
	}
    
    public static void start() { // actual start method
        ImageIcon restartIcon = new ImageIcon(primary.class.getResource("/restart.png"));
        JOptionPane.showMessageDialog(null, "Welcome to Cure to the Apocalypse. Hope you enjoy.", "Cure to the Apocalypse", JOptionPane.INFORMATION_MESSAGE, restartIcon);
        playerName = JOptionPane.showInputDialog("Enter your name:"); // player name cfg
        // Title section
        asciiArtDUMP.titleScreen(); PlayMusicJavaSuperSimple.StopMusic();
        // Continue Prompt :/
        prompter("Start a new game? (y/n) ", "Starting a new game...\n", "Exiting Cure to the Apocalypse. See you soon!", true);
        // Backstory explanation
        backstory(); // shows backstory
        prompter("Continue? (y/n) ", "Continuing...", "Exiting Cure to the Apocalypse. See you soon!", true); // continue game promt
        labNavigation.start(); // starts task 1
    }

    public static void backstory() { // backstory code
        System.out.println("==============================================");
        System.out.println("                  BACKSTORY");
        System.out.println("==============================================\n");
        timeDelay(1);
        printSlow("A rare disease that normally is transmitted amongst birds has just mutated to become transmissible in humans.");
        timeDelay(1);
        printSlow("It is an extremely contagious viral infection, and has spread to every corner of the globe in a matter of weeks.");
        timeDelay(1);
        printSlow("Symptoms develop within two weeks of infection, starting with flu-like symptoms and progression to severe pneumonia, respiratory failure, and death.");
        timeDelay(1);
        printSlow("Many victims have also been reduced into an undead state, and should not be approached in any way.");
        timeDelay(1);
        printSlow("Despite not being so destructive initially, governments stalled and were more worried about the economy than stopping the virus. Now, it has mutated into something far worse than what humanity could have imagined.");
        timeDelay(1);
        printSlow("The world economy has been brought to a standstill, and countries have fallen into chaos. There is little time left to save humanity from this incoming apocalypse.");
        timeDelay(3);
        System.out.println("\n===================== YOU CAN SAVE THE WORLD =====================");
        printSlow("You have the chance to stop this outbreak. All you need to do is find a few important pieces to the puzzle.");
        timeDelay(1);
        printSlow("First, you must find the right equipment to produce the cure, which you might find in many different pieces.");
        timeDelay(1);
        printSlow("Next, you will need to decode the genome of the virus, as this is the only way to produce a cure.");
        timeDelay(1);
        printSlow("But you will not be able to do this alone. You will need to find the right doctors to help make the cure.");
        timeDelay(1);
        printSlow("Assuming that every doctor has not been wiped out by the infection, you may be able to stop the collapse of civilization, but you will have to act fast.");
        System.out.println("\n+=+=+=+=+ GOOD LUCK. +=+=+=+=+\n");
    }

    public static void conclusion() {
        for (int i = 0; i < 5; i++) {
            System.out.println("");
            timeDelay(1);
        }
        asciiArtDUMP.needleASCII();
        printSlow("The doctor has made the needle, and prepared the cure.");
        timeDelay(1);
        printSlow("Now, it is ready to be given to the world.");
        timeDelay(1);
        printSlow("The fight is finally over. The cure has been made.");
        timeDelay(3);
        printSlow("The cure to this enduring apocalypse.");
        timeDelay(4);
        asciiArtDUMP.titleScreen();
        timeDelay(5);
        System.out.println("\n==============================================");
        System.out.println("                     THE END");
        System.out.println("==============================================\n");
        printSlow("NAME: " + playerName);
        end = new Date();
        int sec2 = end.getSeconds();
        int min2 = end.getMinutes();
        printSlow("TOTAL TIME TAKEN TO FINISH: " + (min2-min1) + " MINUTES, " + (sec2-sec1) + " SECONDS");
        if (playAgain()) {
            charStats.resetStats();
            start();
        } else {
            ImageIcon endIcon = new ImageIcon(primary.class.getResource("/ending.png"));
            JOptionPane.showMessageDialog(null, "Thanks for playing Cure to the Apocalypse. Hope you enjoyed.", "Cure to the Apocalypse", JOptionPane.INFORMATION_MESSAGE, endIcon);
            ratingDrop.start(); // ask for user rating
            timeDelay(15);
            System.exit(0);
        }
    }

    public static void prompter (String prompt, String ifTrue, String ifFalse, boolean exit) {
        System.out.print(prompt);
        String ans = input.nextLine();
        if (!ans.equalsIgnoreCase("y")) {
            System.out.println(ifFalse);
            if (exit == true) {
                System.exit(0);
            }
        }
        System.out.println(ifTrue);
        timeDelay(3);
    }

    public static boolean playAgain() { // play again config, uses dialog boxes
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to restart?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION); // dialog option
        if (choice == JOptionPane.YES_OPTION) {
            // If the user chose 'Yes', show a message indicating restart
            JOptionPane.showMessageDialog(null, "restarting...");
            return true;
        } else {
            // If the user chose 'No', 'Cancel' or closed the dialog, show a message indicating the operation is canceled
            return false;
        }
    }

    // Only reason we're doing this is because we keep having to add the try {} and catch {}
    public static void timeDelay(int delay) { // time delay method
        try {
            TimeUnit.SECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
