package COMP2042_CW_angjiahau.Controllers;
import javafx.scene.image.Image;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class HighScore extends Actor {
	static List<Integer> highscorelist;
	Image im1;
	public static Boolean scoreHigher=false;
	public static final String HIGHSCORE_RESOURCE_PATH = RESOURCE_PATH + "/highscore/";
	public static final String HIGHSCOREFILE_RESOURCE_PATH = RESOURCE_PATH.replace("file:","") + "/highscore/";

	public void act(long now) {
		
	}
	
	public HighScore(String highscoreImage) {
		im1 = new Image(HIGHSCORE_RESOURCE_PATH + highscoreImage + ".png");
		setImage(im1);
		setX(500);
		setY(20);	
	}

	public static List <Integer> HighScoreController(String levelNumber,int x) throws IOException {

		 highscorelist = new ArrayList<>();
		File highscorefile = new File(HIGHSCOREFILE_RESOURCE_PATH + "HighScore" +  levelNumber + ".txt");

			try {
				if (!highscorefile.exists()) {
					highscorefile.createNewFile();
				}
				highscorelist.add(x);

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

	public static Boolean checkHigher(int y) {
		for (int i = 0; i < highscorelist.size(); i++) {
			if (y >= highscorelist.get(i) ) {
				return true;
			}
		}
		return false;
	}


}
