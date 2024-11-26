/*
 * Adapted from TicTacToe WEAK_AI
 * changed up by rohith
 */
import java.util.Scanner;

public class ticTacToe {
   public static void main (String args[]) {
       new ticTacToe ();
   }

   static Scanner input = new Scanner(System.in);

   // Variables
   static char a = ' ';
   static char b = ' ';
   static char c = ' ';
   static char d = ' ';
   static char e = ' ';
   static char f = ' ';
   static char g = ' ';
   static char h = ' ';
   static char i = ' ';

   static char turn = 'x';

   public static boolean start () { // start method
    primary.printSlow("The Creator is on his last legs.");
    primary.timeDelay(1);
    primary.printSlow("But, he refuses to go out without a fight, a mental one.");
    primary.timeDelay(1);
    primary.printSlow("Embark into his mind, and beat him at his own game.");
    primary.timeDelay(1);
    primary.printSlow("A simple game of Tic Tac Toe.");
    primary.timeDelay(1);
    primary.printSlow("Just win, or at least draw, and he will be gone.");
    primary.timeDelay(1);
    primary.printSlow("Good luck.\n");
    primary.timeDelay(1);
       while (!isDone ()){
           printboard ();
           if (turn == 'x') {
               makemoveAI (turn);
			   primary.timeDelay(2);
               turn = 'o';
           } else {
               makemove (turn);
			   primary.timeDelay(2);
               turn = 'x';
           }
       }
       printboard ();
	   // winning conditions (user must win OR tie to proceed)
       if (printWinner() == 'o' || printWinner() == 't') {
		primary.printSlow("You have won.");
		primary.timeDelay(1);
		primary.printSlow("The fight is over.");
		primary.timeDelay(1);
		return true;
	   } else {
		primary.printSlow("You have lost.");
		primary.timeDelay(1);
		primary.printSlow("The fight is over.");
		primary.timeDelay(1);
		return false;
	   }
   }

   public static void printboard () { // prints out board
       System.out.println("   1   2   3");
       System.out.println("1  "+a+" | "+b+" | "+c+"");
       System.out.println(" ------------");
       System.out.println("2  "+d+" | "+e+" | "+f+"");
       System.out.println(" ------------");
       System.out.println("3  "+g+" | "+h+" | "+i+"\n");
   }

   public static void makemove (char piece) { // makes a move
	   primary.printSlow("Your turn.");
	   primary.timeDelay(1);
       System.out.print("Enter the x-coordinate: ");
       int x = input.nextInt();
       System.out.print("Enter the y-coordinate: ");
       int y = input.nextInt(); System.out.println(""); // small formatting thing
       while (!isValid (x, y)) {
           primary.printSlow("Error - invalid coordinate. Try again.");
           System.out.print("\nEnter the x-coordinate: ");
           x = input.nextInt();
           System.out.print("\nEnter the y-coordinate: ");
           y = input.nextInt();
       }
       if (x == 1 && y == 1)
           a = piece;
       else if (x == 2 && y == 1)
           b = piece;
       else if (x == 3 && y == 1)
           c = piece;
       else if (x == 1 && y == 2)
           d = piece;
       else if (x == 2 && y == 2)
           e = piece;
       else if (x == 3 && y == 2)
           f = piece;
       else if (x == 1 && y == 3)
           g = piece;
       else if (x == 2 && y == 3)
           h = piece;
       else
           i = piece;
   }

   public static boolean isValid (int x, int y) {
       if ((x < 1 || x > 3) || (y < 1 || y > 3))
           return false;
       else if (x == 1 && y == 1 && a != ' ')
           return false;
       else if (x == 2 && y == 1 && b != ' ')
           return false;
       else if (x == 3 && y == 1 && c != ' ')
           return false;
       else if (x == 1 && y == 2 && d != ' ')
           return false;
       else if (x == 2 && y == 2 && e != ' ')
           return false;
       else if (x == 3 && y == 2 && f != ' ')
           return false;
       else if (x == 1 && y == 3 && g != ' ')
           return false;
       else if (x == 2 && y == 3 && h != ' ')
           return false;
       else if (x == 3 && y == 3 && i != ' ')
           return false;
       return true;
   }

   public static boolean isDone () {
       if (a == b && a == c && a != ' ')
           return true;
       else if (d == e && d == f && d != ' ')
           return true;
       else if (g == h && g == i && g != ' ')
           return true;
       else if (a == d && a == g && a != ' ')
           return true;
       else if (b == e && b == h && b != ' ')
           return true;
       else if (c == f && c == i && c != ' ')
           return true;
       else if (a == e && a == i && a != ' ')
           return true;
       else if (c == e && c == g && c != ' ')
           return true;
       //cat's game: tie
       else if(a!=' ' && b!=' ' && c!=' ' && d!=' ' && e!=' ' && f!=' ' && h!=' ' && i!=' ' )
           return true;
       else
           return false;
   }

   public static char printWinner () {
       if (a == b && a == c && a != ' ')
           return a;
       else if (d == e && d == f && d != ' ')
           return d;
       else if (g == h && g == i && g != ' ')
           return g;
       else if (a == d && a == g && a != ' ')
           return a;
       else if (b == e && b == h && b != ' ')
           return b;
       else if (c == f && c == i && c != ' ')
           return c;
       else if (a == e && a == i && a != ' ')
           return a;
       else if (c == e && c == g && c != ' ')
           return c;
       else
           return 't';
   }

   public static void makemoveAI(char piece) { // randomizer 
       int x = (int)(Math.random()*3)+1;
       int y =  (int)(Math.random()*3)+1;
       while (!isValid (x, y))
       {
           x = (int)(Math.random()*3)+1;
           y =  (int)(Math.random()*3)+1;
       }
       primary.printSlow("THE CREATOR'S TURN.");
	   primary.timeDelay(1);
       primary.printSlow("IT PICKED ("+x+", "+y+")\n");
       if (x == 1 && y == 1)
           a = piece;
       else if (x == 2 && y == 1)
           b = piece;
       else if (x == 3 && y == 1)
           c = piece;
       else if (x == 1 && y == 2)
           d = piece;
       else if (x == 2 && y == 2)
           e = piece;
       else if (x == 3 && y == 2)
           f = piece;
       else if (x == 1 && y == 3)
           g = piece;
       else if (x == 2 && y == 3)
           h = piece;
       else if (x == 3 && y == 3)
           i = piece;
   }
}
