/*
 * random encounter
 * rohith (13/11/2024)
 * for random encounters in task 1
 */

import java.util.Scanner;

public class labNavAttack {
    public static void main(String[] args) {
        new labNavAttack();
    }

    // following code snippet for debugging purposes only
    public labNavAttack() {
        attack(1);
    }

    // code beyond this comment is what we'll actually keep
    static Scanner input = new Scanner(System.in);
    static int zombieHealth = 20;
    static int zombieAttack = 6;
    static String weaponSelect = ""; // Variable needed to determine which weapon user has chosen in the end

    public static void attack(int probability) { // not a true method, basically just the starting function
        zombieAttack = 6;
        zombieHealth = 20;
        int randomizer = (int) (Math.random()*probability) + 1;
        if (randomizer == 1) {
            PlayMusicJavaSuperSimple.StopMusic();
            PlayMusicJavaSuperSimple.PlayMusic(PlayMusicJavaSuperSimple.filepathEncounter); // introduction into the fight
            primary.printSlow("\nYOU'VE RAN INTO TROUBLE.");
            primary.timeDelay(1);
            primary.printSlow("BE READY TO FIGHT.");
            primary.timeDelay(1);
            primary.printSlow("GOOD LUCK.\n");
            primary.timeDelay(1);
            // gun selection sequence
            if (charStats.M4A1_amount > 0 || charStats.SHOTGUN_amount > 0 || charStats.UZI_amount > 0) { //weapon damage configuration
                primary.printSlow("But, you have a weapon that will make this easy.");
                primary.timeDelay(1);
                System.out.println("You have the following weapon inventory: ");
                System.out.println("M4A1 (m): " + charStats.M4A1_amount);
                System.out.println("Shotgun (s): " + charStats.SHOTGUN_amount);
                System.out.println("UZI (u): " + charStats.UZI_amount);
                System.out.print("Which do you want to select (m/s/u/none)? ");
                do {
                    weaponSelect = input.nextLine();
                    if (weaponSelect.equalsIgnoreCase("m") && charStats.M4A1_amount > 0) {
                        asciiArtDUMP.M4A1_ASCII();
                        primary.printSlow("You have selected the M4A1.");
                        primary.timeDelay(1);
                        primary.printSlow("Your attack strength has increased by 20 points.");
                        primary.timeDelay(2);
                        charStats.attackp += 20; break;
                    } else if (weaponSelect.equalsIgnoreCase("s") && charStats.SHOTGUN_amount > 0) {
                        asciiArtDUMP.SHOTGUN_ASCII();
                        primary.printSlow("You have selected the shotgun.");
                        primary.timeDelay(1);
                        primary.printSlow("Your attack strength has increased by 15 points.");
                        primary.timeDelay(2);
                        charStats.attackp += 15; break;
                    } else if (weaponSelect.equalsIgnoreCase("u") && charStats.UZI_amount > 0) {
                        asciiArtDUMP.UZI_ASCII();
                        primary.printSlow("You have selected the UZI.");
                        primary.timeDelay(1);
                        primary.printSlow("Your attack strength has increased by 10 points.");
                        primary.timeDelay(2);
                        charStats.attackp += 10; break;
                    } else if (weaponSelect.equalsIgnoreCase("none")) {
                        primary.printSlow("You have chosen to go without a weapon.");
                        primary.timeDelay(1);
                        primary.printSlow("Hope you know what you are doing.");
                        primary.timeDelay(2); break;
                    } else{
                        primary.printSlow("Invalid choice!");
                    }
                } while (true);
            }
            // main attack sequence
            while (zombieHealth > 0 && charStats.healthp > 0) {
                stats();
                playerMakeMove();
                if (zombieHealth <= 0) {
                    endAttackSequence();
                    break;
                }
                zombieMakeMove();
            }
        } else {
            return;
        }
    }

    public static void stats() {
        asciiArtDUMP.undead();
        System.out.println("\n========== UNDEAD INDIVIDUAL ==========");
        System.out.println("HEALTH: " + zombieHealth + " pts");
        System.out.println("ATTACK STRENGTH: " + zombieAttack + " pts");
        System.out.println("CAN'T DEFEND ITSELF AGAINST ATTACKS.");
        System.out.println("EASY TO KILL, BUT VERY PERSISTENT IF YOU TRY TO RUN.");
        System.out.println("\nPOSSIBLE MOVES:");
        System.out.println("(a) Attack");
        System.out.println("(b) Defend");
        System.out.println("(c) Heal");
        System.out.println("(d) Run Away");
        System.out.print("Your choice? (a/b/c/d) ");
    }

    // Move system for the player
    public static void playerMakeMove() {
        charStats.defensep = 0;
        String moveChoice = input.nextLine();
        while (!moveChoice.equalsIgnoreCase("a") && !moveChoice.equalsIgnoreCase("b") && !moveChoice.equalsIgnoreCase("c") && !moveChoice.equalsIgnoreCase("d")) {
            primary.printSlow("INVALID CHOICE.");
            System.out.print("Your choice? (a/b/c/d) ");
            moveChoice = input.nextLine();
        }
        if (moveChoice.equalsIgnoreCase("a")) { // attack move
            zombieHealth -= charStats.attackp;
            primary.printSlow("You ATTACKED the individual.");
            primary.timeDelay(1);
            primary.printSlow("It's health has gone down by " + charStats.attackp + " points.");
            primary.timeDelay(1);
        }
        if (moveChoice.equalsIgnoreCase("b")) { // defend move
            charStats.defensep = (int) (Math.random()*5) + 1;
            primary.printSlow("You are DEFENDING yourself.");
            primary.timeDelay(1);
            primary.printSlow("Your defense is at " + charStats.defensep + " points.");
            primary.timeDelay(1);
        }
        if (moveChoice.equalsIgnoreCase("c")) { // heal move
            primary.printSlow("You have decided to HEAL yourself.");
            primary.timeDelay(1);
            charStats.healthHeal();
            primary.timeDelay(1);
            charStats.healthDisplay();
            primary.timeDelay(1);
        }
        if (moveChoice.equalsIgnoreCase("d")) { // run away move
            primary.printSlow("You want to risk it by RUNNING, it seems."); primary.timeDelay(1);
            primary.printSlow("You try to run away.");
            primary.timeDelay(1); int randomizer = (int) (Math.random()*2)+1;
            switch (randomizer) {
            case 1:
                primary.printSlow("You struggle, but you can't run away.");
                primary.timeDelay(1);
                primary.printSlow("You lost 50 health points!");
                charStats.healthp -= 50;
                charStats.endGame(); break;
            case 2:
                primary.printSlow("You struggle, and you manage to ESCAPE.");
                primary.timeDelay(1);
                zombieHealth = 0; break;
            }
        }
    }

//player health point loss 
    public static void zombieMakeMove() {
        primary.printSlow("\nIT IS THE INDIVIDUAL'S TURN.");
        primary.timeDelay(1);
        primary.printSlow("IT HAS ATTACKED YOU.");
        primary.timeDelay(1);
        primary.printSlow("YOU HAVE LOST " + (zombieAttack - charStats.defensep) + " HEALTH POINTS.");
        primary.timeDelay(1);
        charStats.healthp -= (zombieAttack - charStats.defensep);
        charStats.endGame();
        charStats.healthDisplay();
        primary.timeDelay(3);
    }

//player elimination
    public static void endAttackSequence() {
        primary.printSlow("The individual is DEAD.");
        primary.timeDelay(1);
        primary.printSlow("You have lived to see another day.");
        primary.timeDelay(1);
        if (weaponSelect.equalsIgnoreCase("m")) { charStats.attackp -= 20; charStats.M4A1_amount--; primary.printSlow("(One of) your M4A1s has jammed, it can't be used anymore.\n"); }
        if (weaponSelect.equalsIgnoreCase("s")) { charStats.attackp -= 15; charStats.SHOTGUN_amount--; primary.printSlow("(One of) your shotguns has jammed, it can't be used anymore.\n"); }
        if (weaponSelect.equalsIgnoreCase("u")) { charStats.attackp -= 10; charStats.UZI_amount--; primary.printSlow("(One of) your UZIs has jammed, it can't be used anymore.\n"); }
        charStats.attackp += 3;
        PlayMusicJavaSuperSimple.StopMusic();
        primary.timeDelay(2);
        PlayMusicJavaSuperSimple.PlayMusic(PlayMusicJavaSuperSimple.filepath);
    }
}