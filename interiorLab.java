/*
 * INTERIOR LAB: TASK 2
 * Harsimran's code
 * For the second task, which is completing activities in the lab (14/11/2024)
 * 
 */
import java.util.Scanner;
import java.util.ArrayList;

public class interiorLab {
    public static void main(String[] args) {
        new interiorLab();
    }

    // public interiorLab() { // for debugging
    //     start();
    // }

    static Scanner input = new Scanner(System.in);
    // check for previous visits to locations
    static int locationA = 0;
    static int locationB = 0;
    static int locationC = 0;
    static int locationD = 0;
    static int locationE = 0;
    static int locationF = 0;
    static int locationG = 0;
    static int locationH = 0;
    static int locationI = 0;
    // all necessary boolean variables
    static boolean PPE = false;
    static boolean hasSample = false;
    static boolean replicationDone = false;
    static boolean triedToMakeNeedle = false;
    static boolean bossFightDone = false;

    public static void start() { // starts interior lab program
        System.out.println("Loading...\n");
        primary.timeDelay(3);
        asciiArtDUMP.laboratoryMapASCII();
        primary.timeDelay(1);
        primary.printSlow("Above is a map of the area of the laboratory you are in.");
        primary.timeDelay(1);
        primary.printSlow("The rest of the laboratory has been sectioned off, with high security clearances required to access most areas.");
        primary.timeDelay(1);
        primary.printSlow("However, you will not need anything beyond your current (basic) clearance.");
        primary.timeDelay(1);
        primary.printSlow("First, obtain a sample of the virus without hurting yourself.");
        primary.timeDelay(1);
        primary.printSlow("Then, begin to decode the viral genome and then transcribe it.");
        primary.timeDelay(1);
        primary.printSlow("Afterwards, begin to replicate the transcribed sample.");
        primary.timeDelay(1);
        primary.printSlow("Lastly, assemble all of your collected pieces together to make the special needle required.");
        primary.timeDelay(1);
        primary.printSlow("You will need a doctor for the final step, but you'll figure that out later. At least there's no risk of finding any undead.");
        primary.timeDelay(1);
        locationA();
    }

    public static void locationA() { // first location on map
        primary.printSlow("\nYou are at location A on the map.");
        primary.timeDelay(1);
        if (locationA == 0) { 
            primary.printSlow("You are at the entrance to this section of the laboratory, with a pathway to the next steps.");
            primary.timeDelay(1);
            primary.printSlow("You will first need to get PPE so you are safe when handling the virus. Check towards your left.");
            primary.timeDelay(1);
            locationA++;
        }
        System.out.print("You can go to B, C, or D. Where would you like to move? (b/c/d/show-map) "); 
        String move = "";
        while (!move.equalsIgnoreCase("b") && !move.equalsIgnoreCase("c") && !move.equalsIgnoreCase("d")) {
            move = input.nextLine();
            if (move.equalsIgnoreCase("b")) {
                locationB();
            } else if (move.equalsIgnoreCase("c")) {
                locationC();
            } else if (move.equalsIgnoreCase("d")) {
                locationD();
            } else if (move.equalsIgnoreCase("show-map")) {
                asciiArtDUMP.laboratoryMapASCII();
                primary.printSlow("You are at location A.");
            } else {
                primary.printSlow("Invalid choice!");
            }
        }
    }

    public static void locationB() { // for location B
        primary.printSlow("\nYou are at location B on the map.");
        primary.timeDelay(1);
        if (locationB == 0) {
            primary.printSlow("You need to be disinfected first.");
            primary.timeDelay(3);
            primary.printSlow("You're disinfected. You put on the PPE suit. Now, you can move on to the next step."); PPE = true; // allows user to go to C
            primary.timeDelay(1);
            primary.printSlow("Go to C, and obtain the viral sample. You will need to identify the correct sample.");
            primary.timeDelay(1);
            locationB++;
        } else {
            primary.printSlow("You already have your PPE suit on. You don't want to take it off.");
            primary.timeDelay(1);
            primary.printSlow("Don't just waste your own time.");
            primary.timeDelay(1);
        }
        System.out.print("You can go to A. Where would you like to move? (a/show-map) "); 
        String move = "";
        while (!move.equalsIgnoreCase("a")) {
            move = input.nextLine();
            if (move.equalsIgnoreCase("a")) {
                locationA();
            } else if (move.equalsIgnoreCase("show-map")) {
                asciiArtDUMP.laboratoryMapASCII();
                primary.printSlow("You are at location B.");
            } else {
                primary.printSlow("Invalid choice!");
            }
        }
    }

    public static void locationC() { // third location
        primary.printSlow("\nYou are at location C on the map."); primary.timeDelay(1);
        if (locationC == 0) {
            if (!PPE) { // stops user if they haven't done location B
                primary.printSlow("You don't have a PPE suit. You can't do this yet."); primary.timeDelay(1);
            } else {
                primary.printSlow("Now you need to grab the correct sample out of the five available."); primary.timeDelay(3);
                primary.printSlow("The System will randomly select a sample, and you have to make sure to grab the correct one."); primary.timeDelay(1);
                primary.printSlow("Get the wrong one, and you will lose health.");  primary.timeDelay(1);
                primary.printSlow("The viral sample looks like the following: A streak of thick criss-crossing lines that cover most of the petri dish."); primary.timeDelay(1);
                primary.printSlow("Now, the System will start giving you samples at random. Look out for ones that follow that description."); primary.timeDelay(1);
                System.out.println(""); primary.timeDelay(1);
                System.out.println(""); primary.timeDelay(1);
                System.out.println(""); primary.timeDelay(1);
                sampleCollector(); /* starts sample collection game */ locationC++;
            }
        } else {
            primary.printSlow("You've already obtained the sample you needed."); primary.timeDelay(1);
            primary.printSlow("Don't just waste your own time."); primary.timeDelay(1);
        }
        System.out.print("You can go to A. Where would you like to move? (a/show-map) "); String move = "";
        while (!move.equalsIgnoreCase("a")) {
            move = input.nextLine();
            if (move.equalsIgnoreCase("a")) {
                locationA();
            } else if (move.equalsIgnoreCase("show-map")) {
                asciiArtDUMP.laboratoryMapASCII();
                primary.printSlow("You are at location C.");
            } else {
                primary.printSlow("Invalid choice!");
            }
        }
    }

    public static void locationD() { // location D
        primary.printSlow("\nYou are at location D on the map."); primary.timeDelay(1);
        if (locationD == 0) {
            primary.printSlow("You are at the center of this section of the laboratory."); primary.timeDelay(1);
            primary.printSlow("The hallways to the left and right are blocked off. You can only go forward or backwards."); primary.timeDelay(1);
            primary.printSlow("Not much else to do here."); primary.timeDelay(1);
            locationD++;
        }
        System.out.print("You can go to A or E. Where would you like to move? (a/e/show-map) "); String move = "";
        while (!move.equalsIgnoreCase("a") && !move.equalsIgnoreCase("e")) {
            move = input.nextLine();
            if (move.equalsIgnoreCase("a")) {
                locationA();
            } else if (move.equalsIgnoreCase("e")) {
                locationE();
            } else if (move.equalsIgnoreCase("show-map")) {
                asciiArtDUMP.laboratoryMapASCII();
                primary.printSlow("You are at location D.");
            } else {
                primary.printSlow("Invalid choice!");
            }
        }
    }

    public static void locationE() { // location E
        primary.printSlow("\nYou are at location E on the map."); primary.timeDelay(1);
        if (locationE == 0) {
            primary.printSlow("You are at a key junction in this section of the laboratory."); primary.timeDelay(1);
            primary.printSlow("The forward hallway is blocked off. You can go to G or F."); primary.timeDelay(1);
            primary.printSlow("F is your final destination. G is where you will begin to prepare the sample."); primary.timeDelay(1);
            primary.printSlow("Location E itself has nothing special to it. You shouldn't waste your time here; move on."); primary.timeDelay(1);
            locationE++;
        }
        System.out.print("You can go to D, F or G. Where would you like to move? (d/f/g/show-map) "); String move = "";
        while (!move.equalsIgnoreCase("d") && !move.equalsIgnoreCase("f") && !move.equalsIgnoreCase("g")) {
            move = input.nextLine();
            if (move.equalsIgnoreCase("d")) {
                locationD();
            } else if (move.equalsIgnoreCase("f")) {
                locationF();
            } else if (move.equalsIgnoreCase("g")) {
                locationG();
            } else if (move.equalsIgnoreCase("show-map")) {
                asciiArtDUMP.laboratoryMapASCII();
                primary.printSlow("You are at location E.");
            } else {
                primary.printSlow("Invalid choice!");
            }
        }
    }

    public static void locationG() { // location G
        primary.printSlow("\nYou are at location G on the map."); primary.timeDelay(1);
        if (locationG == 0) {
            if (!hasSample) { // forbids if user hasn't done location C
                primary.printSlow("You don't have the viral sample. You can't do this yet."); primary.timeDelay(1);
            } else {
                primary.printSlow("Here, you will take single strands of DNA and find the appropriate corresponding nucleotide."); primary.timeDelay(1);
                primary.printSlow("A pairs with T, while G pairs with C."); primary.timeDelay(1);
                primary.printSlow("Be careful, the System will be looking for bad actors by seeing if you make mistakes while decoding."); primary.timeDelay(1);
                primary.printSlow("The System will take it from here."); primary.timeDelay(1);
                System.out.println(""); primary.timeDelay(1);
                System.out.println(""); primary.timeDelay(1);
                System.out.println(""); primary.timeDelay(1);
                DNAdecoding(); /* starts DNA decoding game */ locationG++;
            }
        } else {
            primary.printSlow("You have already decoded the sample."); primary.timeDelay(1);
        }
        System.out.print("You can go to E, H or I. Where would you like to move? (e/h/i/show-map) "); String move = "";
        while (!move.equalsIgnoreCase("e") && !move.equalsIgnoreCase("h") && !move.equalsIgnoreCase("i")) {
            move = input.nextLine();
            if (move.equalsIgnoreCase("e")) {
                locationE();
            } else if (move.equalsIgnoreCase("h")) {
                locationH();
            } else if (move.equalsIgnoreCase("i")) {
                locationI();
            } else if (move.equalsIgnoreCase("show-map")) {
                asciiArtDUMP.laboratoryMapASCII();
                primary.printSlow("You are at location G.");
            } else {
                primary.printSlow("Invalid choice!");
            }
        }
    }

    public static void locationH() { // location H
        primary.printSlow("\nYou are at location H on the map."); primary.timeDelay(1);
        if (locationH == 0) {
            primary.printSlow("You now need to have the sample be transcribed and replicated."); primary.timeDelay(1);
            primary.printSlow("Luckily, transcription will be done for you by the System. Doing that yourself would take a long time."); primary.timeDelay(1);
            primary.printSlow("Instead, you will have to carefully prepare the correct amount of replication needed to be done."); primary.timeDelay(1);
            primary.printSlow("You will need to determine the correct temperature and correct amount of replication substance to use."); primary.timeDelay(1);
            primary.printSlow("The correct temperature (in Celsius) is about 20x the given volume, and you will need 5x the volume for the replication fluid, plus ten."); primary.timeDelay(1);
            primary.printSlow("This won't take too long, but mess up and the System will punish you severely."); primary.timeDelay(1);
            primary.printSlow("Be careful."); primary.timeDelay(1);
            System.out.println(""); primary.timeDelay(1);
            System.out.println(""); primary.timeDelay(1);
            System.out.println(""); primary.timeDelay(1);
            replicationGame(); /* replication game started */ locationH++;
        } else {
            primary.printSlow("You have already transcribed & replicated the sample."); primary.timeDelay(1);
            primary.printSlow("You seem like a chronic time waster. Get moving."); primary.timeDelay(1);
        }
        System.out.print("You can go to G or I. Where would you like to move? (d/f/g/show-map) "); String move = "";
        while (!move.equalsIgnoreCase("i") && !move.equalsIgnoreCase("g")) {
            move = input.nextLine();
            if (move.equalsIgnoreCase("i")) {
                locationI();
            } else if (move.equalsIgnoreCase("g")) {
                locationG();
            } else if (move.equalsIgnoreCase("show-map")) {
                asciiArtDUMP.laboratoryMapASCII();
                primary.printSlow("You are at location H.");
            } else {
                primary.printSlow("Invalid choice!");
            }
        }
    }

    public static void locationI() { // location I
        primary.printSlow("\nYou are at location I on the map.");
        primary.timeDelay(1);
        if (locationI == 0) {
            if (!replicationDone) { // forbids if user hasn't done location H
                primary.printSlow("You haven't replicated the sample. You need to do that first."); primary.timeDelay(1);
            } else {
                primary.printSlow("You need to assemble the needle."); primary.timeDelay(1);
                primary.printSlow("You have all the pieces to do so."); primary.timeDelay(1);
                primary.printSlow("However..."); primary.timeDelay(3);
                primary.printSlow("It appears that the System cannot do this task for you.");  primary.timeDelay(1);
                primary.printSlow("You'll need to find the doctor."); primary.timeDelay(1);
                primary.printSlow("Look around the laboratory and see where."); primary.timeDelay(1);
                triedToMakeNeedle = true; /* prepares user for task 3 */ locationI++;
            }
        } else {
            if (!bossFightDone) { // if user hasn't done task 3 yet
                primary.printSlow("You have already been here. You still need to find a doctor."); primary.timeDelay(1);
            } else {
                primary.conclusion(); // ends the game, only possible after user returns here from task 3
            }
        }
        System.out.print("You can go to G or H. Where would you like to move? (d/f/g/show-map) "); String move = "";
        while (!move.equalsIgnoreCase("h") && !move.equalsIgnoreCase("g")) {
            move = input.nextLine();
            if (move.equalsIgnoreCase("h")) {
                locationH();
            } else if (move.equalsIgnoreCase("g")) {
                locationG();
            } else if (move.equalsIgnoreCase("show-map")) {
                asciiArtDUMP.laboratoryMapASCII();
                primary.printSlow("You are at location I.");
            } else {
                primary.printSlow("Invalid choice!");
            }
        }
    }

    public static void locationF() { // location to initiate task 3
        primary.printSlow("\nYou are at location F on the map."); primary.timeDelay(1);
        if (locationF == 0) {
            if (!triedToMakeNeedle) { // forbids if user hasn't done location I
                primary.printSlow("You haven't made the needle yet."); primary.timeDelay(1);
            } else {
                primary.printSlow("You haven't made the needle yet."); primary.timeDelay(3);
                primary.printSlow("But..."); primary.timeDelay(1);
                primary.printSlow("It appears you want to find the doctor."); primary.timeDelay(1);
                primary.printSlow("They'll be this way."); primary.timeDelay(1);
                System.out.println(""); primary.timeDelay(1);
                System.out.println(""); primary.timeDelay(1);
                System.out.println(""); primary.timeDelay(1);
                PlayMusicJavaSuperSimple.StopMusic(); finalBoss.start(); // after final boss is done, user navigates back to I, and game ends afterwards
                locationF++;
            }
        } else { // can only be triggered after user finishes task 3
            primary.printSlow("You have saved the doctor. Now, you're just one step away from saving the world."); primary.timeDelay(1);
            primary.printSlow("Don't waste any more time."); primary.timeDelay(1);
        }
        System.out.print("You can go to E. Where would you like to move? (e/show-map) "); String move = "";
        while (!move.equalsIgnoreCase("e")) {
            move = input.nextLine();
            if (move.equalsIgnoreCase("e")) {
                locationE();
            } else if(move.equalsIgnoreCase("show-map")) {
                asciiArtDUMP.laboratoryMapASCII();
                primary.printSlow("You are at location F.");
            } else {
                primary.printSlow("Invalid choice!");
            }
        }
    }

    /* 
     * ALL MISSION 2 TASKS ARE BELOW
     */
    public static void sampleCollector() { // for location C game
        String answer = ""; String correctAnswer = "N/A"; // important variables
        primary.printSlow("Welcome to The System™, designed for all sorts of hazardous biological work & logistics!"); primary.timeDelay(1);
        primary.printSlow("You are looking for viral sample A, which has caused a major outbreak in recent time."); primary.timeDelay(1);
        primary.printSlow("We expect you to know which one you are looking for. Choose the wrong one, and The System™ will physically harm you for every wrong choice to deter bad actors."); primary.timeDelay(2);
        while (!hasSample) {
            int randomizer = (int) (Math.random()*5) + 1; /* randomizes */ asciiArtDUMP.labCultures(randomizer); // selects random ASCII art of culture
            System.out.print("Is this your sample? (y/n) ");
            if (randomizer == 1) { correctAnswer = "y"; } else { correctAnswer = "n"; } // determines correct answer
            answer = input.nextLine();
            if (answer.equalsIgnoreCase(correctAnswer)) { // if answer is correct
                if (correctAnswer == "y") {
                    primary.printSlow("You have obtained the correct sample!"); primary.timeDelay(1);
                    primary.printSlow("You may now continue forward. Thank you for utilizing The System™."); hasSample = true; /* ends task and allows user to go to location G */ primary.timeDelay(2);
                } else { // if the answer was correct but they weren't looking for that culture
                    primary.printSlow("Choosing the next sample..."); primary.timeDelay(2);
                }
            } else {
                primary.printSlow("That is not correct! We detect that you may potentially be unauthorized to acces this. You have lost 25 health points.");
                charStats.healthp -= 25; charStats.endGame(); // takes health away
                primary.timeDelay(1);
                primary.printSlow("Choosing the next sample..."); primary.timeDelay(2);
            }
        }
    }

    public static void DNAdecoding() { // for location G game
        ArrayList<String> nucleotides = new ArrayList<String>(); ArrayList<String> correctSequence = new ArrayList<String>(); ArrayList<String> userSequence = new ArrayList<String>(); // arraylist variables
        primary.printSlow("Welcome to The System™, designed for all sorts of hazardous biological work & logistics!"); primary.timeDelay(1);
        primary.printSlow("It appears you want to decode this viral sample."); primary.timeDelay(1);
        primary.printSlow("You will decode them in a series of four arrays of eight nucleotides."); primary.timeDelay(1);
        primary.printSlow("To detect bad actors, The System™ will physically attack the user if they make a mistake."); primary.timeDelay(2);
        for (int i = 0; i < 4; i++) { // loops 4 times
            for (int j = 0; j < 8; j++) {
                int randomizer = (int) (Math.random()*4)+1; // create random sequence
                String random = randomizer == 1 ? "A" : randomizer == 2 ? "T" : randomizer == 3 ? "G" : "C"; // create initial sequence array (this is the one the user will see)
                nucleotides.add(random); 
                String correspondingSequence = nucleotides.get(j) == "A" ? "T" : nucleotides.get(j) == "T" ? "A" : nucleotides.get(j) == "G" ? "C" : "G"; // create correct sequence array (this is the one we check to see if they have the correct answers)
                correctSequence.add(correspondingSequence);
            }
            primary.printSlow("You will find the appropriate base pairs for the following sequence:"); primary.timeDelay(1);
            System.out.println(nucleotides); // shows sequence to user
            for (int k = 0; k < 8; k++) { // get answers from user
                System.out.print("Find the correct pair for nucleotide #" + (k+1) + ": "); userSequence.add(input.nextLine());
            }
            if (userSequence.equals(correctSequence)) { // if answer is correct
                primary.printSlow("That is correct! Checking for another sequence..."); primary.timeDelay(2);
            } else {
                primary.printSlow("That is not correct! We detect that you may potentially be unauthorized to acces this. You have lost 25 health points.");
                charStats.healthp -= 25; charStats.endGame(); /* ends user if health depleted too much */ primary.timeDelay(1);
                primary.printSlow("Checking for another sequence..."); primary.timeDelay(1);
            }
            nucleotides.clear(); correctSequence.clear(); userSequence.clear(); // resets arrays
        }
        primary.printSlow("You are now complete! Thank you for utilizing The System™."); primary.timeDelay(1); // ends game
    }
    
    public static void replicationGame() { // for location H game
        primary.printSlow("Welcome to The System™, designed for all sorts of hazardous biological work & logistics!"); primary.timeDelay(1);
        primary.printSlow("It appears you want to replicate this DNA sample."); primary.timeDelay(1);
        primary.printSlow("It will need to be transcribed first before The System™ can do that. Luckily, The System™ can do it for you!"); primary.timeDelay(1);
        primary.printSlow("Afterwards, you will need to set the appropriate temperature and amount of replication substance™ to use."); primary.timeDelay(1);
        primary.printSlow("Incorrect attemps will once again result in physical harm from The System™'s state of the art security features."); primary.timeDelay(2);
        for (int i = 0; i < 4; i++) { // loop 4 times
            int volume = (int) (Math.random()*13)+1; // randomized volume
            primary.printSlow("The volume of vial #" + (i+1) + " is " + volume); primary.timeDelay(1);
            primary.printSlow("Transcribing..."); primary.timeDelay(3);
            System.out.print("Transcribing done! Now, heat the sample to the correct temperature: "); int temp = input.nextInt(); // ask user for correct temp
            if (temp == (volume*20)) { // temp = vol*20
                primary.printSlow("Correct temperature! Heating the sample...");
            } else {
                primary.printSlow("That is not correct! We detect that you may potentially be unauthorized to acces this. You have lost 25 health points.");
                charStats.healthp -= 25; charStats.endGame(); /* end game if user losees all health */ primary.timeDelay(1);
                primary.printSlow("Correcting & heating the sample...");
            } primary.timeDelay(2);
            System.out.print("Heating complete! Now, add the correct amount of replication substance™: "); /* ask for replication substance */ int amount = input.nextInt();
            if (amount == (volume*5)+10) { // amount = vol*5 + 10
                primary.printSlow("Correct amount! Adding to sample...");
            } else {
                primary.printSlow("That is not correct! We detect that you may potentially be unauthorized to acces this. You have lost 25 health points.");
                charStats.healthp -= 25; charStats.endGame(); primary.timeDelay(1);
                primary.printSlow("Correcting & adding to sample...");
            } primary.timeDelay(2);
            primary.printSlow("Adding done! Now the volume of replication substance™ will become the sample itself."); primary.timeDelay(1);
            primary.printSlow("Checking for more vials...\n"); /* continues */  primary.timeDelay(1);
        }
        System.out.println("You are now complete! Thank you for utilizing The System™."); replicationDone = true; /* allows user to go to location I */ primary.timeDelay(1);
    }
}
