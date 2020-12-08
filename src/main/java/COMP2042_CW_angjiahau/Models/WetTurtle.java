package COMP2042_CW_angjiahau.Models;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.HashMap;

import static COMP2042_CW_angjiahau.Models.Turtle.PLATFORM_RESOURCE_PATH;

public class WetTurtle extends SinkingPlatform {
	HashMap<String,Image> WetTurtleAnimation = new HashMap<String,Image>();
	Timeline timeline;

	@Override
	public void act(long now) {

		 if (now/900000000 %4 == 3) {
			setSunk(true);
		}else{
		 	setSunk(false);
		 }

		move(speed , 0);
		if (getX() > 600 && getSpeed()>0)
			setX(-200);
		if (getX() < -75 && getSpeed()<0)
			setX(600);
	}
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		super(xpos,ypos,s);
		addHashWetTurtle(w,h);
		setX(xpos);
		setY(ypos);
	}

	public void addHashWetTurtle(int w,int h){
		WetTurtleAnimation.put("Turtle", new Image(PLATFORM_RESOURCE_PATH+ "TurtleAnimation2.png", w, h, true, true));
		for(int animationImages=0;animationImages<=4;animationImages++) {
			WetTurtleAnimation.put("wetturtleAnimation"+animationImages, new Image(PLATFORM_RESOURCE_PATH + "TurtleAnimation" + animationImages + "Wet.png", w, h, true, true));
		}
	}

	public void playWetTurtleAnimation(){
		 timeline = new Timeline(
				new KeyFrame(Duration.seconds(0), new KeyValue(imageProperty(),WetTurtleAnimation.get("Turtle"))),
				new KeyFrame(Duration.seconds(1), new KeyValue(imageProperty(),WetTurtleAnimation.get("wetturtleAnimation2"))),
				new KeyFrame(Duration.seconds(2), new KeyValue(imageProperty(),WetTurtleAnimation.get("wetturtleAnimation3"))),
				new KeyFrame(Duration.seconds(3), new KeyValue(imageProperty(),WetTurtleAnimation.get("wetturtleAnimation4"))),
				new KeyFrame(Duration.seconds(4), new KeyValue(imageProperty(), null))
		);

		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	public void stopWetTurtleAnimation(){
		timeline.stop();
	}

}

