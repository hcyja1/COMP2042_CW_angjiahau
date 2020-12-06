package COMP2042_CW_angjiahau.Models;
import javafx.scene.image.Image;
import java.util.HashMap;

import static COMP2042_CW_angjiahau.Models.Turtle.PLATFORM_RESOURCE_PATH;

public class WetTurtle extends SinkingPlatform {
	HashMap<String,Image> WetTurtleAnimation = new HashMap<String,Image>();

	@Override
	public void act(long now) {
		if (now/900000000  % 4 ==0) {
			setImage(WetTurtleAnimation.get("wetturtleAnimation2"));
			setSunk(false);
		}
		else if (now/900000000 % 4 == 1) {
			setImage(WetTurtleAnimation.get("Turtle"));
			setSunk(false);
		}
		else if (now/900000000 %4 == 2) {
			setImage(WetTurtleAnimation.get("wetturtleAnimation3"));
			setSunk(false);
		} else if (now/900000000 %4 == 3) {
			setImage(WetTurtleAnimation.get("wetturtleAnimation4"));
			setSunk(true);
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
		setImage(WetTurtleAnimation.get("wetturtleAnimation2"));
	}

	public void addHashWetTurtle(int w,int h){
		WetTurtleAnimation.put("Turtle", new Image(PLATFORM_RESOURCE_PATH+ "TurtleAnimation2.png", w, h, true, true));
		for(int animationImages=0;animationImages<=4;animationImages++) {
			WetTurtleAnimation.put("wetturtleAnimation"+animationImages, new Image(PLATFORM_RESOURCE_PATH + "TurtleAnimation" + animationImages + "Wet.png", w, h, true, true));
		}
	}

}

