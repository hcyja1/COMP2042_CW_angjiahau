package COMP2042_CW_angjiahau.Models;

import COMP2042_CW_angjiahau.Controllers.Actor;
import javafx.scene.image.Image;

public class Digit extends Actor {
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/main/resources/numbers/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	

}