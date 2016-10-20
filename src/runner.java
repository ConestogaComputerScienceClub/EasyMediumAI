import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class runner {

	static int BOARD_SIZE = 20;
	static int DURATION = 120000;
	ArrayList<Point> foods = new ArrayList<Point>();
	static Point foodM = new Point(5, 5);
	static Point user = new Point(0, 0);
	static int points = 0;
	static boolean isRunning = false;

	public static void main(String[] args) {
		new Timer();
		while (isRunning) {
			if (user.x == foodM.x && user.y == foodM.y) {
				points++;
				Random rand = new Random();
				foodM.x = rand.nextInt(BOARD_SIZE);
				foodM.y = rand.nextInt(BOARD_SIZE);
			}
			int dir = move(user, foodM);
			switch (dir) {
			case 1:
				user.y++;
				break;
			case 2:
				user.x++;
				break;
			case 3:
				user.y--;
				break;
			case 4:
				user.x--;
				break;
			}
		}
	}

	/** ONLY TOUCH THIS CODE! 
	 * 
	 * @param you
	 * @param food
	 * @return 1 is up. 2 is right. 3 is down. 4 is left.
	 */
	public static int move(Point you, Point food) {
		// TODO: Fill this method out!
		
		
		return 0;
	}
}

class Timer implements Runnable {

	Thread thread;

	Timer() {
		thread = new Thread(this, "Timer");
		thread.start();
	}

	@Override
	public void run() {
		runner.isRunning = true;
		try {
			Thread.sleep(runner.DURATION);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		runner.isRunning = false;
		System.out.println(runner.points + " points!");
	}

}

