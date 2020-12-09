package COMP2042_CW_angjiahau.Models;
import javafx.animation.*;
import javafx.scene.image.*;
import javafx.util.Duration;

import java.util.HashMap;

import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;

public class Turtle extends Platform {
	public static final String PLATFORM_RESOURCE_PATH = RESOURCE_PATH + "/platforms/";
	HashMap<String,Image> TurtleAnimation = new HashMap<>();
	Timeline timeline = new Timeline();

	@Override
	public void act(long now) {
		super.act(now);
		if (getX() > 600 && getSpeed()>0)
			setX(-200);
		if (getX() < -75 && getSpeed()<0)
			setX(600);
	}
	
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		super(xpos,ypos,s);
		addHashTurtle(w,h);
		setX(xpos);
		setY(ypos);
	}

	public void addHashTurtle(int w,int h){
		for(int animationImages=0;animationImages<=3;animationImages++) {
			TurtleAnimation.put("turtleAnimation"+animationImages, new Image(PLATFORM_RESOURCE_PATH + "TurtleAnimation" + animationImages + ".png", w, h, true, true));
		}
	}

	public void playTurtleAnimation(){
		timeline = new Timeline(
				new KeyFrame(Duration.seconds(0), new KeyValue(imageProperty(),TurtleAnimation.get("turtleAnimation1"))),
				new KeyFrame(Duration.seconds(1), new KeyValue(imageProperty(),TurtleAnimation.get("turtleAnimation2"))),
				new KeyFrame(Duration.seconds(2), new KeyValue(imageProperty(),TurtleAnimation.get("turtleAnimation3"))),
				new KeyFrame(Duration.seconds(3), new KeyValue(imageProperty(), null))
		);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	public void stopTurtleAnimation(){
		timeline.stop();
	}
}
