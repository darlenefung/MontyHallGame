import java.util.Scanner;

/**
 * the Monty Hall Game asks the user to pick a door out of 3, 
 * and later asks if the user wants to switch to increase his chances of 
 * winning something valuable behind one of the doors
 * @author Darlene Fung 
 */
public class MontyHallGame
{
	public static void main(String[] args)
	{
		// welcome message
		welcome();
		
		game();
	}
	
	/**
	 * this method prints a welcome message so the user knows the directions
	 */ 
	public static void welcome()
	{
		System.out.println(" ------ The Monty Hall Game ------ ");
		System.out.println("Pick a door number first. You will have a chance to switch once the contents of another door has been revealed. ");
		
	}
	
	/**
	 * this method runs the game 
	 */
	public static void game()
	{
		// gets input from the keyboard
		Scanner keyboard = new Scanner(System.in); 
		int car = (int)(Math.random() * 3 + 1); 
		
		System.out.print("Please choose a door (1, 2, or 3): ");
		int user_pick = keyboard.nextInt();
		keyboard.nextLine(); // get rid of new line from buffer
		
		System.out.println("You chose door: " + user_pick);
		
		int reveal = doorToReveal(car, user_pick); 
		System.out.println("Open door #: " + reveal);
		
		// ask the user if they want to switch doors
		System.out.print("Do you want to switch?");
		String answer = keyboard.nextLine();
		
		if (answer.equals("yes"))
		{
			user_pick = doorToReveal(user_pick, reveal);
		}
		
		if (car == user_pick)
			System.out.print("You win!1!");
		else
			System.out.println("Sorry, you loose. ");
			
	}
	
	/**
	 * this method picks a random door to reveal to the user
	 */
	public static int doorToReveal(int c, int u)
	{
		for (int i = 1; i < 4; i++)
		{
			if (i != c && i != u)
			{
				return i;
			}
		} 
		return -1; 
	}	
	
	/**
	 * this method is another way to reveal a random door to the user
	 */	
	public static int doorToReveal1(int c, int u)
	{
		int r = (int)(Math.random() * 3 + 1);
		while ( r == c || r == u)
		{
			r = (int) (Math.random() * 3 + 1);
		}
		return r; 
	}
	
}