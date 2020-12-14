package COMP2042_CW_angjiahau.Controllers;
import javafx.scene.image.Image;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class HighScore extends Actor {
	/** List Variable which stores a list of highscores*/
	static List<Integer> highscorelist;
	/** Reference variable used to set image of high score label in game*/
	Image im1;
	/** String variable used to store resource path of highscore image*/
	public static final String HIGHSCORE_RESOURCE_PATH = RESOURCE_PATH + "/highscore/";
	/** String variable used to store resource path of highscore files*/
	public static final String HIGHSCOREFILE_RESOURCE_PATH = RESOURCE_PATH.replace("file:","") + "/highscore/";

	/**
	 * Constructor used to add high score image.
	 * @param highscoreImage name of the high score image in .png format.
	 */
	public HighScore(String highscoreImage) {
		im1 = new Image(HIGHSCORE_RESOURCE_PATH + highscoreImage + ".png");
		setImage(im1);
		setX(500);
		setY(20);	
	}

	/**
	 * Makes sure after each round, a high score file for the level will be created(if it does not already exist).
	 * The high score of the player will be compared to the existing(if any) high scores within the high score file
	 * and stored if it is higher or equal to any of the existing high score values.
	 * Each high score file is limited to a maximum of 3 high score values.
	 * @param levelNumber Name of the level
	 * @param points Total score earned by player in the round
	 * @return {@link #highscorelist}
	 * @throws IOException Checks for IOException. Will state that there is an error in the high score controller if error is found.
	 */
	public static List <Integer> HighScoreController(String levelNumber,int points) throws IOException {

		 highscorelist = new ArrayList<>();
		File highscorefile = new File(HIGHSCOREFILE_RESOURCE_PATH + "HighScore" +  levelNumber + ".txt");

			try {
				if (!highscorefile.exists()) {
					highscorefile.createNewFile();
				}

				highscorelist.add(points);

				Scanner reader = new Scanner(highscorefile);
				while (reader.hasNextLine()) {
					String data = reader.nextLine();
					highscorelist.add(Integer.parseInt(data));
				}
				highscorelist.sort(Collections.reverseOrder());
				highscorelist = highscorelist.stream().limit(3).collect(Collectors.toList());
				PrintWriter writer = new PrintWriter(highscorefile);
				highscorelist.forEach(highscore ->{
					writer.println(highscore.toString());
				});
				writer.close();

			} catch(IOException e){
				System.out.println("Error in High Score Controller");
			}

		return highscorelist;
	}

	/**
	 * Displays the highscore list from the level.
	 * @return A string which shows the current value of high scores within the high score file of the level.
	 */
	public static String displayHighScore() {
		StringBuilder sb = new StringBuilder();
		for (Integer s : highscorelist)
				{
					sb.append("\n");
					sb.append(s);
					sb.append("\n");
				}
				return sb.toString();
			}

	/**
	 * Checks to see if the final score is higher than any of the current scores within high score file.
	 * @param y Points earned by player by the end of the round.
	 * @return true or false.
	 */
	public static Boolean checkHigher(int y) {
		for (Integer integer : highscorelist) {
			if (y >= integer) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Overriden method which is called in every frame as long as AnimationTimer is active.
	 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	@Override
	public void act(long now) {
	}


}
