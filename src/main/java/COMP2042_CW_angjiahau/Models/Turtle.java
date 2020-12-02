package COMP2042_CW_angjiahau.Models;

import COMP2042_CW_angjiahau.Controllers.Actor;
import javafx.scene.image.Image;

import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;

public class Turtle extends Platform {
	Image turtle1;
	Image turtle2;
	Image turtle3;
	public static final String PLATFORM_RESOURCE_PATH = RESOURCE_PATH + "/platforms/";

	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}

		super.act(now);
		if (getX() > 600 && getSpeed()>0)
			setX(-200);
		if (getX() < -75 && getSpeed()<0)
			setX(600);
	}
	
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		super(xpos,ypos,s);
		turtle1 = new Image(PLATFORM_RESOURCE_PATH+ "TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image(PLATFORM_RESOURCE_PATH + "TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image(PLATFORM_RESOURCE_PATH + "TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		setImage(turtle2);
	}

	
	
}
