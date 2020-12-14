package COMP2042_CW_angjiahau.Controllers;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music {

	/** Reference variable to MediaPlayer to access methods in {@link MediaPlayer}*/
	MediaPlayer mediaPlayer;

	/** String variable which holds resource path for music files*/
	public static final String MISC_RESOURCE_PATH = "src/main/resources/misc/";

	/** Empty constructor to construct music object to access methods within {@link Music} class*/
	public Music() {
	}

	/**
	 * Method used to play frogger main theme song.
	 */
	public void playMusic() {
		String musicFile = MISC_RESOURCE_PATH + "Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}

	/**
	 * Method used to play hop sounds whenever frogger moves.
	 */
	public void hopSound() {
		String musicFile = MISC_RESOURCE_PATH + "/sound-frogger-hop.mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.play();   
	}

	/**
	 * Method used to play squashing sounds when frogger gets crushed by obstacle.
	 */
	public void squashSound() {
		String musicFile = MISC_RESOURCE_PATH + "/sound-frogger-squash.mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.play();   
	}

	/**
	 * Method used to play plunk sound when frogger dies from water.
	 */
	public void plunkSound() {
		String musicFile = MISC_RESOURCE_PATH + "/sound-frogger-plunk.mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.play();   
	}

	/**
	 * Method used to stop media player.
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
