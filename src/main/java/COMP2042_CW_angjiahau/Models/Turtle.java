package COMP2042_CW_angjiahau.Models;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import java.util.HashMap;

import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;

public class Turtle extends Platform {
	public static final String PLATFORM_RESOURCE_PATH = RESOURCE_PATH + "/platforms/";
	HashMap<String,Image> TurtleAnimation = new HashMap<String,Image>();

	@Override
	public void act(long now) {
		turtleAnimation(now);
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
		setImage(TurtleAnimation.get("turtleAnimation2"));
	}

	public void turtleAnimation(long time){

		if (time/900000000  % 3 ==0) {
			setImage(TurtleAnimation.get("turtleAnimation2"));
		}
		else if (time/900000000 % 3 == 1) {
			setImage(TurtleAnimation.get("turtleAnimation1"));
		}
		else if (time/900000000 %3 == 2) {
			setImage(TurtleAnimation.get("turtleAnimation3"));
		}

	}

	public void addHashTurtle(int w,int h){
		for(int animationImages=0;animationImages<=3;animationImages++) {
			TurtleAnimation.put("turtleAnimation"+animationImages, new Image(PLATFORM_RESOURCE_PATH + "TurtleAnimation" + animationImages + ".png", w, h, true, true));
		}
	}


}
