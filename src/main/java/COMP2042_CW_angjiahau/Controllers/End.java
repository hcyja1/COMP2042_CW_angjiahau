package COMP2042_CW_angjiahau.Controllers;
import javafx.scene.image.Image;

public class End extends Actor {
	boolean activated = false;

	@Override
	public void act(long now) {
	}
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/main/resources/misc/Frog.png", 60, 60, true, true));
	}
	
	public void setEnd() {
		setImage(new Image("file:src/main/resources/misc/FrogEnd.png", 70, 70, true, true));
		activated = true;
		toFront();
	}
	public boolean isActivated() {
		return activated;
	}
	public void reset() {
		activated = false;
		setImage(new Image("file:src/main/resources/misc/End.png", 60, 60, true, true));
	}



	
	

}
