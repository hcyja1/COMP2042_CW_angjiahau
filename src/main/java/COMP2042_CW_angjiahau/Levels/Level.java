package COMP2042_CW_angjiahau.Levels;

import java.util.List;

import COMP2042_CW_angjiahau.Actor;
import COMP2042_CW_angjiahau.Animal;
import COMP2042_CW_angjiahau.Digit;
import COMP2042_CW_angjiahau.World;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;

public class Level extends World {
	
	Animal animal;
	
	@Override
	public void act(long now) {
			
	}
	
	@Override
	public void createTimer() {
	 super.createTimer(new AnimationTimer() {
	        @Override
	        public void handle(long now) {
	            act(now);
	            List<Actor> actors = getObjects(Actor.class);

	            for (Actor anActor: actors) {
	                anActor.act(now);
	            }
	        }
	    });
	}
	    public void setNumber(int n) {
	        int shift = 0;
	        while (n > 0) {
	            int d = n / 10;
	            int k = n - d * 10;
	            n = d;
	            add(new Digit(k, 30, 550 - shift, 40));
	            shift+=30;
	        }
	}
	   
	 
}

