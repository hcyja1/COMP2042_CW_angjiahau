package COMP2042_CW_angjiahau;
import javafx.scene.image.Image;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;

public class HighScore extends Actor{
	
	Image im1;
	public static final String HIGHSCORE_RESOURCE_PATH = RESOURCE_PATH + "/highscore/";
	
	public void act(long now) {
		
	}
	
	public HighScore(String highscoreImage) {
		im1 = new Image(HIGHSCORE_RESOURCE_PATH + highscoreImage + ".png");
		setImage(im1);
		setX(500);
		setY(20);	
	}
}
