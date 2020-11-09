package COMP2042_CW_angjiahau;

import java.io.File; 


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Music {
	MediaPlayer mediaPlayer;
	public static final String MISC_RESOURCE_PATH = "src/main/resources/misc/";
	public Music() {
		
	}
	
	public void playMusic() {
		String musicFile = MISC_RESOURCE_PATH + "Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void hopSound() {
		String musicFile = MISC_RESOURCE_PATH + "/sound-frogger-hop.mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.play();   
	}
	
	public void squashSound() {
		String musicFile = MISC_RESOURCE_PATH + "/sound-frogger-squash.mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.play();   
	}
	
	public void plunkSound() {
		String musicFile = MISC_RESOURCE_PATH + "/sound-frogger-plunk.mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.play();   
	}
	
	
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
