public class charStats {
    // banndage count (user always starts with 10 and cannot replenish the bandage count)
    static int bandages = 10; 

    // health points
    static int healthp = 100;
    static int healhp  = 15;

       // defense and attack 
    static int attackp = 3;
    static int defensep = 0;

    // weapon stats
    static int M4A1 = 20;
    static int SHOTGUN = 15;
    static int UZI = 10;
    static int M4A1_amount = 0;
    static int SHOTGUN_amount = 0;
    static int UZI_amount = 0;

    public static void resetStats() {
        // resetting main stats
        bandages = 10; 
        healthp = 100;
        attackp = 3;
        defensep = 0;
        M4A1_amount = 0;
        SHOTGUN_amount = 0;
        UZI_amount = 0;
        // resetting final boss stats
        finalBoss.bossHealth = 100;
        finalBoss.bossAttack = 10;
        finalBoss.bossDefense = 0;
        finalBoss.attackTimes = 0;
        // resetting interior lab stats
        interiorLab.locationA = 0;
        interiorLab.locationB = 0;
        interiorLab.locationC = 0;
        interiorLab.locationD = 0;
        interiorLab.locationE = 0;
        interiorLab.locationF = 0;
        interiorLab.locationG = 0;
        interiorLab.locationH = 0;
        interiorLab.locationI = 0;
        interiorLab.PPE = false;
        interiorLab.hasSample = false;
        interiorLab.replicationDone = false;
        interiorLab.triedToMakeNeedle = false;
        interiorLab.bossFightDone = false;
        // resetting lab navigation stats
        labNavigation.coastline = 0;
        labNavigation.forest = 0;
        labNavigation.smallTown = 0;
        labNavigation.pieces = 0;
        labNavigation.city = 0;
        labNavigation.abandonedStop = 0;
    }
    
    public static void endGame() { // ends game and allows player to continue
        if (healthp <= 0)  {
            primary.printSlow("You have lost all health points.");
            primary.timeDelay(1);
            primary.printSlow("You have DIED.");
            primary.timeDelay(1);
            primary.printSlow("Play again another time!");
            primary.timeDelay(1);
            if (primary.playAgain()) { // restart game
                charStats.resetStats();
                primary.start();
            } else {
                System.out.println("Exiting Cure to the Apocalypse. See you soon!");
                primary.timeDelay(2);
                System.exit(0);
            }
        }
    }

    public static void healthDisplay(){
        primary.printSlow("Your current health is " + healthp + "."); // helath display
    }

    public static void healthHeal(){ // healing system
        if (healthp >= 100 || healthp + healhp > 100){
            primary.printSlow("You cannot heal. Wait until you have taken enough damage.");
        }
        else {
            primary.printSlow("You healed " + healhp + " health points.");
            healthp += healhp;
            bandages -= 1;
            primary.printSlow("You only have " + bandages +  " more bandages.");
            if (bandages <= 0){
                primary.printSlow("You cant heal anymore!");
            }
        }
    }
}
