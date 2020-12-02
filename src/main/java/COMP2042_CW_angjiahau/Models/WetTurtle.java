package COMP2042_CW_angjiahau.Models;

import COMP2042_CW_angjiahau.Controllers.Actor;
import javafx.scene.image.Image;
import static COMP2042_CW_angjiahau.Models.Turtle.PLATFORM_RESOURCE_PATH;

public class WetTurtle extends Actor {
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	private double speed;
	int i = 1;
	boolean bool = true;
	boolean sunk = false;
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image(PLATFORM_RESOURCE_PATH + "TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image(PLATFORM_RESOURCE_PATH+ "TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image(PLATFORM_RESOURCE_PATH+ "TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image(PLATFORM_RESOURCE_PATH+ "TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	public boolean isSunk() {
		return sunk;
	}
	public double getSpeed(){
		return speed;
	}
}