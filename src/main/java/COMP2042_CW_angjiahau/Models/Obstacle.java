package COMP2042_CW_angjiahau.Models;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;

import COMP2042_CW_angjiahau.Controllers.Actor;
import javafx.scene.image.Image;

public class Obstacle extends Actor {
	private static final String OBSTACLE_RESOURCE_PATH = RESOURCE_PATH+"obstacles";
	private int speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	public Obstacle(int xpos, int ypos, int s, int w, int h, String type) {
		setImage(new Image(OBSTACLE_RESOURCE_PATH+"/"+type+".png", w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed=s;
		if(s<0) {
		setRotate(180);
		}
	}
	
	

}
