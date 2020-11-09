package COMP2042_CW_angjiahau;

import javafx.scene.image.Image;
import static COMP2042_CW_angjiahau.Main.RESOURCE_PATH;

public class Log extends Actor {
	private static final String LOG_RESOURCE_PATH = RESOURCE_PATH+"platforms/log";
	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	public Log(int size, int xpos, int ypos, double s, int variant) {
		setImage(new Image( LOG_RESOURCE_PATH + variant+ ".png", size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	public boolean getLeft() {
		return speed < 0;
	}
}
