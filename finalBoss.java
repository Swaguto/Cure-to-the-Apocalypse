/*
 * FINAL BOSS FIGHT: TASK 3
 * Harsimran's code
 * For the final task, which is the bossfight (15/11/2024)
 */
import java.util.Scanner; // input import
import java.util.Date; // for timed attacks

public class finalBoss {
    static Date now; static Date end; // for timed attacks
    // public static void main(String[] args) {
    //     new finalBoss(); // for debugging
    // }

    // public finalBoss() {
    //     // for debugging only
    //     start();
    // }
    // necessary variables
    static Scanner input = new Scanner(System.in); 
    static int bossHealth = 100;
    static int bossAttack = 10;
    static int bossDefense = 0;
    static int attackTimes = 0;
    static String weaponSelect = ""; // Variable needed to determine which weapon user has chosen

    public static void start() { // starter, barely counts as a method
        System.out.println("Loading...\n"); // dialogue
        primary.timeDelay(3);
        asciiArtDUMP.hallwayASCII();
        primary.timeDelay(4);
        primary.printSlow("You won't find the doctor here.");
        primary.timeDelay(1);
        primary.printSlow("Or, anywhere, as a matter of fact.");
        primary.timeDelay(1);
        primary.printSlow("The doctor is being held hostage.");
        primary.timeDelay(3);
        primary.printSlow("I'm afraid I made a big mistake.");
        primary.timeDelay(1);
        primary.printSlow("I have been too obvious.");
        primary.timeDelay(1);
        primary.printSlow("I knew you were one of the few people left who were more than capable enough of stopping the virus.");
        primary.timeDelay(1);
        primary.printSlow("So, I lead you into what I hoped would be the end for all of this.");
        primary.timeDelay(1);
        primary.printSlow("But, I forgot to tell you why the System was so hostile.");
        primary.timeDelay(1);
        primary.printSlow("That was the goal of it, to stop you dead in your tracks.");
        primary.timeDelay(1);
        primary.printSlow("But you've made it through, so it's time for you to fight the maker of this virus.");
        primary.timeDelay(1);
        primary.printSlow("He won't let you stop his virus from taking over. You might not win this fight.");
        primary.timeDelay(1);
        primary.printSlow("This is your last chance to same humanity. Don't lose it.");
        primary.timeDelay(1);
        primary.printSlow("Good luck. You'll need it.\n");
        primary.timeDelay(3); PlayMusicJavaSuperSimple.PlayMusic(PlayMusicJavaSuperSimple.filepathBoss); // music cue
        gunSelect(); // check for guns
        while (bossHealth > 0 && charStats.healthp > 0) { // attack sequencer
            stats();
            playerMakeMove();
            if (bossHealth <= 0) {
                endAttackSequence();
                break;
            }
            zombieMakeMove();
        }
        interiorLab.bossFightDone = true; // for interior lab to continue
        PlayMusicJavaSuperSimple.StopMusic(); PlayMusicJavaSuperSimple.PlayMusic(PlayMusicJavaSuperSimple.filepathLab); // starts original lab music
    }

    public static void stats() { // shows stats of attacker and allows player to make move
        asciiArtDUMP.finalBossASCII();
        System.out.println("\n========== THE CREATOR ==========");
        System.out.println("HEALTH: " + bossHealth + " pts");
        System.out.println("ATTACK STRENGTH: " + bossAttack + " pts");
        System.out.println("CURRENT DEFENSE STRENGTH: " + bossDefense + " pts");
        System.out.println("SOMETIMES WILL DEFEND HIMSELF FROM ATTACKS.");
        System.out.println("YOU CAN'T PREDICT HIS NEXT MOVE.");
        System.out.println("HARDER TO KILL. CAN DO STRONG ATTACKS, AND YOU CAN'T RUN AWAY FROM HIM.");
        System.out.println("\nPOSSIBLE MOVES:");
        System.out.println("(a) Attack");
        System.out.println("(b) Defend");
        System.out.println("(c) Heal");
        System.out.println("(d) Special Move");
        System.out.print("Your choice? (a/b/c/d) ");
    }

    public static void playerMakeMove() { // makes move for player
        charStats.defensep = 0; // resets previous defense points
        String moveChoice = input.nextLine(); // player input
        while (!moveChoice.equalsIgnoreCase("a") && !moveChoice.equalsIgnoreCase("b") && !moveChoice.equalsIgnoreCase("c") && !moveChoice.equalsIgnoreCase("d")) {
            primary.printSlow("INVALID CHOICE.");
            System.out.print("Your choice? (a/b/c/d) ");
            moveChoice = input.nextLine();
        } // checks for invalid input
        if (moveChoice.equalsIgnoreCase("a")) { // attack move
            int randomizer = (int) (Math.random()*3)+1; // random chance for timed attack
            int addedAttack = 0;
            if (randomizer == 1) { // timed attack
                primary.printSlow("You have a bit of strength ready, you can do a strong attack!"); primary.timeDelay(1);
                primary.printSlow("If you press enter exactly five seconds from now, you will have a stronger attack!");
                now = new Date(); int sec1 = now.getSeconds(); input.nextLine(); end = new Date(); int sec2 = end.getSeconds(); // elapsed seconds determiner
                int elapsed_sec = Math.abs(5 - (sec2 - sec1));
                if (elapsed_sec == 0) { // strength of timed attacks
                    primary.printSlow("You hit right on the spot! Your attack strength has increased by 5 points."); addedAttack = 5;
                } else if (elapsed_sec == 1) {
                    primary.printSlow("You almost hit it! Your attack strength has increased by 3 points."); addedAttack = 3;
                } else if (elapsed_sec == 2) {
                    primary.printSlow("You barely made it. Your attack strength has increased by 1 point."); addedAttack = 5;
                } else {
                    primary.printSlow("You missed your chance. Your attack strength hasn't changed.");
                }
            } primary.timeDelay(1);
            bossHealth -= charStats.attackp + addedAttack; // actual attack
            primary.printSlow("You ATTACKED the creator."); primary.timeDelay(1);
            primary.printSlow("It's health has gone down by " + ((charStats.attackp+addedAttack)-bossDefense) + " points."); primary.timeDelay(1);
            attackTimes++; // for special move charge
        }
        if (moveChoice.equalsIgnoreCase("b")) { // defend move
            charStats.defensep = (int) (Math.random()*10) + 1; // random defense points
            primary.printSlow("You are DEFENDING yourself."); primary.timeDelay(1);
            primary.printSlow("Your defense is at " + charStats.defensep + " points."); primary.timeDelay(1);
        }
        if (moveChoice.equalsIgnoreCase("c")) { // heal move
            primary.printSlow("You have decided to HEAL yourself."); primary.timeDelay(1); 
            charStats.healthHeal(); /*  charStats bandage healing */ primary.timeDelay(1);
            charStats.healthDisplay(); primary.timeDelay(1);
        }
        if (moveChoice.equalsIgnoreCase("d")) { // special attack
            primary.printSlow("You want to try your SPECIAL ATTACK."); primary.timeDelay(1);
            if (attackTimes >= 5) { // check for enough uses of attack move
                primary.printSlow("You wind up yourself..."); primary.timeDelay(2);
                primary.printSlow("You attack with all your might..."); primary.timeDelay(2);
                charStats.attackp += 20;
                bossHealth -= charStats.attackp;
                primary.printSlow("You managed to attack " + charStats.attackp + " health points!"); charStats.attackp -= 20;
                attackTimes = 0;
                primary.timeDelay(2);
            } else { // if they didn't attack enough
                primary.printSlow("You wind up yourself..."); primary.timeDelay(2);
                primary.printSlow("...and you stumble."); primary.timeDelay(2);
                primary.printSlow("Your special attack charge is at " + attackTimes + ". You need to attack " + (5 - attackTimes) + " more time(s) to use your special!"); primary.timeDelay(2);
            }
        }
    }

    public static void zombieMakeMove() { // makes all moves for the boss
        bossDefense = 0; // resets boss defense
        int randomizer = (int) (Math.random()*3)+1; // random attack selection
        switch (randomizer) {
        case 1: // attack move
            primary.printSlow("\nIT IS THE CREATOR'S TURN."); primary.timeDelay(1);
            primary.printSlow("IT HAS ATTACKED YOU."); primary.timeDelay(1);
            primary.printSlow("YOU HAVE LOST " + (bossAttack - charStats.defensep) + " HEALTH POINTS."); primary.timeDelay(1);
            charStats.healthp -= (bossAttack - charStats.defensep); bossAttack += 1; // increments boss attack after every attack turn
            charStats.endGame(); charStats.healthDisplay(); 
            primary.timeDelay(3); break;
        case 2: // defend move
            primary.printSlow("\nIT IS THE CREATOR'S TURN."); primary.timeDelay(1);
            primary.printSlow("HE IS DEFENDING HIMSELF."); primary.timeDelay(1);
            primary.printSlow("HIS DEFENSE STRENGTH IS NOW AT " + (charStats.attackp/2) + ".");
            bossDefense += (charStats.attackp/2); // boss defense is always half of user's original attack p
            primary.timeDelay(1); break;
        case 3: // STRONG attack move
            primary.printSlow("\nIT IS THE CREATOR'S TURN."); primary.timeDelay(1);
            primary.printSlow("IT'S TRYING TO HIT A STRONG ATTACK ON YOU."); primary.timeDelay(1);
            System.out.println("IF YOU PRESS ENTER EXACTLY FIVE SECONDS FROM NOW, YOU CAN STOP THE ATTACK"); // timed attack
            now = new Date(); int sec1 = now.getSeconds(); input.nextLine(); end = new Date(); int sec2 = end.getSeconds(); // attack timer
            int elapsed_sec = sec2 - sec1; primary.timeDelay(1);
            if (elapsed_sec != 5) { // if user didn't hit at exactly 5 sec
                primary.printSlow("YOU HAVE LOST " + ((bossAttack+10) - charStats.defensep) + " HEALTH POINTS."); primary.timeDelay(1);
                charStats.healthp -= ((bossAttack+10) - charStats.defensep);
                charStats.endGame(); charStats.healthDisplay();
            } else {
                primary.printSlow("YOU BLOCKED THE ATTACK SUCCESSFULLY."); primary.timeDelay(1);
            }
            primary.timeDelay(3); break;
        }
    }

    public static void endAttackSequence() { // boss ender
        boolean result = ticTacToe.start(); // starts tictactoe finale
        if (result) {
            PlayMusicJavaSuperSimple.StopMusic(); // music stops
            primary.printSlow("You have ended the creator's life and have saved the doctor."); primary.timeDelay(2);
            primary.printSlow("You made it. Now, just go back to where you would have made the needle, and it'll all be over."); primary.timeDelay(2);
            primary.printSlow("The doctor is now able to make the needle to start curing those who are infected."); primary.timeDelay(3);
        } else {
            charStats.healthp = 0; charStats.endGame();
        }
    }

    public static void gunSelect() { // gun selection method
        if (charStats.M4A1_amount > 0 || charStats.SHOTGUN_amount > 0 || charStats.UZI_amount > 0) { // checks for guns in inventory
            System.out.println("You have the following weapon inventory: ");
            System.out.println("M4A1 (m): " + charStats.M4A1_amount);
            System.out.println("Shotgun (s): " + charStats.SHOTGUN_amount);
            System.out.println("UZI (u): " + charStats.UZI_amount);
            System.out.print("Which do you want to select (m/s/u)? ");
            do {
                weaponSelect = input.nextLine();
                if (weaponSelect.equalsIgnoreCase("m") && charStats.M4A1_amount > 0) { // if user has M4A1
                    asciiArtDUMP.M4A1_ASCII();
                    primary.printSlow("You have selected the M4A1."); primary.timeDelay(1);
                    primary.printSlow("Your attack strength has increased by 20 points."); primary.timeDelay(3);
                    charStats.attackp += 20; break;
                } else if (weaponSelect.equalsIgnoreCase("s") && charStats.SHOTGUN_amount > 0) { // if user has shotgun
                    asciiArtDUMP.SHOTGUN_ASCII();
                    primary.printSlow("You have selected the shotgun."); primary.timeDelay(1);
                    primary.printSlow("Your attack strength has increased by 15 points."); primary.timeDelay(3);
                    charStats.attackp += 15; break;
                } else if (weaponSelect.equalsIgnoreCase("u") && charStats.UZI_amount > 0) { // if user has UZI
                    asciiArtDUMP.UZI_ASCII();
                    primary.printSlow("You have selected the UZI."); primary.timeDelay(1);
                    primary.printSlow("Your attack strength has increased by 10 points."); primary.timeDelay(3);
                    charStats.attackp += 10; break;
                } else {
                    primary.printSlow("Invalid choice!");
                }
            } while (true);
        }
    }
}


