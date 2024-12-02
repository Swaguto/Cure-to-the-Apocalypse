/*
 * aksharn's code, task 1
 */
import java.util.Scanner;

public class labNavigation {
    
    public static void main(String[] args) {
        new labNavigation();
    }

    // public labNavigation() { // FOR DEBUGGING ONLY!!
    //     start();
    // } 

    static Scanner input = new Scanner(System.in);
    
    // Checking if the user has been to the locations
    static int coastline = 0;
    static int forest = 0;
    static int smallTown = 0;
    static int pieces = 0;
    static int city = 0;
    static int abandonedStop = 0;

    public static void start() {
        System.out.println("Loading...");
        primary.timeDelay(3);
        asciiArtDUMP.asciiTitle1(); PlayMusicJavaSuperSimple.PlayMusic(PlayMusicJavaSuperSimple.filepath);
        primary.timeDelay(2);
        coastline();
    }

    public static void coastline() {
        if (coastline == 0) {
            asciiArtDUMP.coastlineASCII(true);
            primary.printSlow("\nWelcome to the coastline. You are quite far from where you need to be.");
            primary.timeDelay(1);
            primary.printSlow("You have started with 100 HP. Don't get attacked by the undead and/or infected.");
            primary.timeDelay(1);
            primary.printSlow("You are looking for pieces of a needle.");
            primary.timeDelay(1);
            primary.printSlow("Find the pieces, then make it to the laboratory where you can assemble them.");
            primary.timeDelay(1);
            primary.printSlow("Then, you will be told what to do next.");
            primary.timeDelay(1);
            primary.printSlow("Don't approach anyone. Good luck.");
            primary.timeDelay(1);
            coastline++;
        } else {
            asciiArtDUMP.coastlineASCII(false);
            primary.printSlow("\nWelcome back to the coastline. Guess you wanted to see the view again?");
            primary.timeDelay(1);
            primary.printSlow("Hopefully you're only here for a little while. There is work to be done.");
            primary.timeDelay(1);
            primary.printSlow("Time is running out. Enjoy the view for a little while, and then get back to finding the pieces.");
            primary.timeDelay(1);
        }
        labNavAttack.attack(15); gunAcquire();
        asciiArtDUMP.asciiMAP(1);
        primary.printSlow("You are in the area marked X on the map. You can go to the forest and the town of Etonbourne.");
        System.out.print("Where would you like to go next? (f/s) ");
        String nextLocation = "";
        while (!nextLocation.equalsIgnoreCase("s") || !nextLocation.equalsIgnoreCase("f")) {
            nextLocation = input.nextLine();
            if (nextLocation.equalsIgnoreCase("s")) 
                smallTown();
            else if (nextLocation.equalsIgnoreCase("f"))
                forest();
            else
                primary.printSlow("Invalid Destination.");
        }
    }

    public static void smallTown() {
        if (smallTown == 0) {
            asciiArtDUMP.smallTownASCII(true);
            primary.printSlow("\nWelcome to the town of Etonbourne. Population of 12 300. Most are dead or infected.");
            primary.timeDelay(3);
            primary.printSlow("Here you have found something quite important.");
            primary.timeDelay(1);
            primary.printSlow("You have found one of the three pieces of equipment needed to get to create the cure.");
            System.out.println("EQUIPMENT PIECES +1");
            pieces++;
            primary.timeDelay(1);
            primary.printSlow("But you might want to move quick. There's quite a lot of infected individuals here.");
            primary.timeDelay(1);
            primary.printSlow("Run. Now. It's your only hope.");
            primary.timeDelay(1);
            smallTown++;
        } else {
            asciiArtDUMP.smallTownASCII(false);
            primary.printSlow("\nWelcome back to Etonbourne.");
            primary.timeDelay(1);
            primary.printSlow("It is dangerous to stay here. You should leave immediately.");
            primary.timeDelay(1);
            primary.printSlow("They know you are here. If you don't leave now, you will be infected.");
            primary.timeDelay(1);
            primary.printSlow("Run.");
            primary.timeDelay(1);
        }
        labNavAttack.attack(3); gunAcquire();
        asciiArtDUMP.asciiMAP(3);
        primary.printSlow("You are in the area marked X on the map. You can go to the coastline, abandoned rest stop and Aranovo.");
        System.out.print("Where would you like to go next? (c/r/i) ");
        String nextLocation = "";
        while (!nextLocation.equalsIgnoreCase("c") || !nextLocation.equalsIgnoreCase("i") || !nextLocation.equalsIgnoreCase("r")) {
            nextLocation = input.nextLine();
            if (nextLocation.equalsIgnoreCase("c")) 
                coastline();
            else if (nextLocation.equalsIgnoreCase("i")) 
                city();
            else if (nextLocation.equalsIgnoreCase("r"))
                abandonedStop();
            else
                primary.printSlow("Invalid Destination.");
        }
    }

    public static void forest() {
        if (forest == 0) {
            asciiArtDUMP.forestASCII(true);
            primary.printSlow("\nWelcome to the forest. This forest is a sanctuary unaffected by the virus.");
            primary.timeDelay(1);
            primary.printSlow("However, you won't find anything useful here.");
            primary.timeDelay(1);
            primary.printSlow("You can use this forest as a small rest stop, but you still have work to do.");
            primary.timeDelay(1);
            primary.printSlow("Enjoy the peace for now, then it's time to start moving.");
            primary.timeDelay(1);
            forest++;
        } else {
            asciiArtDUMP.forestASCII(false);
            primary.printSlow("\nWelcome back to the forest. You seem to enjoy the sanctuary.");
            primary.timeDelay(1);
            primary.printSlow("There's nothing to do here. You're just running out the clock.");
            primary.timeDelay(1);
            primary.printSlow("Don't stay here for too long.");
            primary.timeDelay(1);
        }
        labNavAttack.attack(250); gunAcquire();// just to mess with people with infinitely bad luck
        asciiArtDUMP.asciiMAP(2);
        primary.printSlow("You are in the area marked X on the map. You can go to the coastline.");
        System.out.print("Where would you like to go next? (c) ");
        String nextLocation = "";
        while (!nextLocation.equalsIgnoreCase("c")) {
            nextLocation = input.nextLine();
            if (nextLocation.equalsIgnoreCase("c")) 
                coastline();
            else
                primary.printSlow("Invalid Destination.");
        }
    }

    public static void city() {
        if (city == 0) {
            asciiArtDUMP.cityASCII(true);
            primary.printSlow("\nWelcome to the city of Aranovo. Population of 561 000.");
            primary.timeDelay(3);
            primary.printSlow("An aggressive quarantine measure has been put in place to stop the spread of the virus.");
            primary.timeDelay(1);
            primary.printSlow("This has bought you some time to find another one of the pieces.");
            System.out.println("EQUIPMENT PIECES +1");
            pieces++;
            primary.timeDelay(1);
            primary.printSlow("However, you'll still find quite a few infected people here. And it will be quite hard to hide from them.");
            primary.timeDelay(1);
            primary.printSlow("So don't stick around too long. If you have all of the pieces needed, go to the laboratory immediately.");
            primary.timeDelay(1);
            primary.printSlow("Otherwise, find them. You won't be allowed in otherwise.");
            primary.timeDelay(1);
            city++;
            labNavAttack.attack(6);
        } else {
            asciiArtDUMP.cityASCII(false);
            primary.printSlow("\nWelcome back to Aranovo.");
            primary.timeDelay(1);
            primary.printSlow("Be ready to fight. Things have gotten way worse here since you left.");
            primary.timeDelay(1);
            primary.printSlow("Given this city's proximity to the laboratory, the infection has had time to settle and get comfortable here.");
            primary.timeDelay(1);
            primary.printSlow("Everytime you come back here, things will only get worse, and they'll get worse by a lot.");
            primary.timeDelay(1);
            primary.printSlow("Stay safe.");
            primary.timeDelay(1);
            labNavAttack.attack(3);
        }
        gunAcquire();
        asciiArtDUMP.asciiMAP(5);
        primary.printSlow("You are in the area marked X on the map. You can go to the laboratory, abandoned rest stop and Etonbourne.");
        System.out.print("Where would you like to go next? (l/r/s) ");
        String nextLocation = "";
        while (!nextLocation.equalsIgnoreCase("s") || !nextLocation.equalsIgnoreCase("l") || !nextLocation.equalsIgnoreCase("r")) {
            nextLocation = input.nextLine();
            if (nextLocation.equalsIgnoreCase("s")) {
                smallTown();
            } else if (nextLocation.equalsIgnoreCase("r")) {
                abandonedStop();
            } else if (nextLocation.equalsIgnoreCase("l")) {
                if (pieces < 3) { primary.printSlow("You can't go here."); continue; }
                else if (pieces >= 3) { laboratory(); } // The use of else causes bugs for whatever reason
            } else { primary.printSlow("Invalid Destination."); }
        }
    }

    public static void laboratory() {
        PlayMusicJavaSuperSimple.StopMusic();
        for (int i = 0; i < 5; i++) {
            System.out.println("");
            primary.timeDelay(1);
            int coastQueue = 1;
        }
        asciiArtDUMP.laboratoryASCII();
        PlayMusicJavaSuperSimple.PlayMusic("Halo Infinite - Through the Trees (8-bit).wav"); // music lab queue 
        primary.printSlow("Welcome to the laboratory.");
        primary.timeDelay(3);
        primary.printSlow("You have completed one of the three tasks safely before the cure can be distributed to the world.");
        primary.timeDelay(3);
        primary.printSlow("Now, you must assemble the needle and be ready to decode the viral genome.");
        primary.timeDelay(3);
        interiorLab.start();
    }

    public static void abandonedStop() {
        if (abandonedStop == 0) {
            asciiArtDUMP.abandonedStopASCII(true);
            primary.printSlow("\nWelcome to this abandoned rest stop.");
            primary.timeDelay(1);
            primary.printSlow("The original owners of this place are dead. Some of the first victims of the virus.");
            primary.timeDelay(1);
            primary.printSlow("This place was then quarantined off and abandoned.");
            primary.timeDelay(1);
            primary.printSlow("Now, it's been abandoned for months. The virus has contaminated virtually every space here.");
            primary.timeDelay(1);
            primary.printSlow("It's unlikely you'll find any undead(?), but the chance of getting infected is high..");
            primary.timeDelay(1);
            primary.printSlow("At least you found an equipment piece.");
            System.out.println("EQUIPMENT PIECES +1");
            pieces++;
            primary.timeDelay(1);
            primary.printSlow("You are in an area so remote and dangerous that the map does not even have it marked.");
            primary.timeDelay(1);
            primary.printSlow("If you come back here, you're virtually guaranteed to get attacked.");
            primary.timeDelay(1);
            primary.printSlow("Take this warning, and leave immediately. Don't investigate anything.");
            primary.timeDelay(1);
            abandonedStop++;
            labNavAttack.attack(7);
        } else {
            asciiArtDUMP.abandonedStopASCII(false);
            primary.printSlow("\nWelcome back to the rest stop.");
            primary.timeDelay(1);
            primary.printSlow("This was not a good choice. You shouldn't have come back.");
            primary.timeDelay(1);
            primary.printSlow("You're certainly infected with the virus now. Your time is limited.");
            primary.timeDelay(1);
            primary.printSlow("You will lose a lot of health every time you come back here again.");  charStats.healthp -= 25; charStats.endGame();
            primary.timeDelay(1);
            primary.printSlow("Good luck finishing your mission.");
            primary.timeDelay(1);
            labNavAttack.attack(2);
        }
        gunAcquire();
        asciiArtDUMP.asciiMAP(4);
        primary.printSlow("You are in the area marked X on the map. You can go to Aranovo and Etonbourne.");
        System.out.print("Where would you like to go next? (s/i) ");
        String nextLocation = "";
        while (!nextLocation.equalsIgnoreCase("s") || !nextLocation.equalsIgnoreCase("i")) {
            nextLocation = input.nextLine();
            if (nextLocation.equalsIgnoreCase("s")) 
                smallTown();
            if (nextLocation.equalsIgnoreCase("i")) 
                city();
        }
    }

    public static void gunAcquire() {
        int gunChance = (int) (Math.random()*100)+1;
        if (gunChance <= 5) {
            primary.printSlow("You acquired an M4A1.");
            asciiArtDUMP.M4A1_ASCII();
            primary.timeDelay(1);
            primary.printSlow("This is the best item you could have gotten. Use it wisely.");
            primary.timeDelay(1);
            charStats.M4A1_amount++;
        } else if (gunChance > 5 && gunChance <= 15) {
            primary.printSlow("You acquired a shotgun.");
            asciiArtDUMP.SHOTGUN_ASCII();
            primary.timeDelay(1);
            primary.printSlow("A fairly decent weapon. It should hold up well.");
            primary.timeDelay(1);
            charStats.SHOTGUN_amount++;
        } else if (gunChance > 15 && gunChance <= 25) {
            primary.printSlow("You acquired an UZI.");
            asciiArtDUMP.UZI_ASCII();
            primary.timeDelay(1);
            primary.printSlow("Despite having the weakest attack strength, it's still much better than nothing. This will certainly help you.");
            primary.timeDelay(1);
            charStats.UZI_amount++;
        } else {
            return;
        }
    }
}
