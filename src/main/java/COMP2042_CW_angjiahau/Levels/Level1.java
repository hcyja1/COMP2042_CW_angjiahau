package COMP2042_CW_angjiahau.Levels;
import COMP2042_CW_angjiahau.Actor;
import COMP2042_CW_angjiahau.Animal;
import COMP2042_CW_angjiahau.BackgroundImage;
import COMP2042_CW_angjiahau.Digit;
import COMP2042_CW_angjiahau.End;
import COMP2042_CW_angjiahau.HighScore;
import COMP2042_CW_angjiahau.Log;
import COMP2042_CW_angjiahau.Obstacle;
import COMP2042_CW_angjiahau.Turtle;
import COMP2042_CW_angjiahau.WetTurtle;
import COMP2042_CW_angjiahau.World;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.List;
import java.io.File;
import java.util.List;


public class Level1 extends World {
	 Animal animal;
	 
	public Level1()  {
		//add background image
				BackgroundImage froggerback = new BackgroundImage("iKogsKW");
				add(froggerback);
				
				
				//Add platforms	
				add(new Log(150, 0, 166, 0.75,3) );		
				add(new Log(150, 220, 166, 0.75,3) );
				add(new Log(150, 440, 166, 0.74,3) );
				add(new Log(150, 0, 276, -2,1) );
				add(new Log(300, 400, 276, -2,1) );
				add(new Log(150, 50, 329, 0.75,3) );
				add(new Log(150, 270, 329, 0.75,3) );
				add(new Log(150, 490, 329, 0.75,3) );	
				
				add(new Turtle(500, 376, -1, 130, 130));
				add(new Turtle(300, 376, -1, 130, 130));
				add(new WetTurtle(700, 376, -1, 130, 130));
				add(new WetTurtle(600, 217, -1, 130, 130));
				add(new WetTurtle(400, 217, -1, 130, 130));
				add(new WetTurtle(200, 217, -1, 130, 130));
				
				//set 5 slots for frog to be filled in 
				add(new End(13,96));
				add(new End(141,96));
				add(new End(141 + 141-13,96));
				add(new End(141 + 141-13+141-13+1,96));
				add(new End(141 + 141-13+141-13+141-13+3,96));
				
				//intialize starting main actor image 
				animal = new Animal("froggerUp");						
				add(animal);
						
				//add obstacles
				add(new Obstacle(0, 649, 1, 120, 120, "truck1Right"));
				add(new Obstacle(300, 649, 1, 120, 120, "truck1Right"));
				add(new Obstacle(600, 649, 1, 120, 120, "truck1Right"));
				add(new Obstacle(100, 597, -1, 50, 50, "car1Left"));
				add(new Obstacle(250, 597, -1, 50, 50, "car1Left"));
				add(new Obstacle(400, 597, -1, 50, 50, "car1Left"));
				add(new Obstacle(550, 597, -1, 50, 50, "car1Left"));
				add(new Obstacle(0, 540, 1, 200, 200, "truck2Right"));
				add(new Obstacle(500, 540, 1, 200, 200, "truck2Right"));
				add(new Obstacle(500, 490, -5, 50, 50, "car1Left"));
				
				
				add(new Digit(0, 30, 550, 40));
				add(new HighScore("hi-scoreImage"));
						
	}
	
	
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
	               
					if (animal.changeScore()) {
	                    setNumber(animal.getPoints());
	                }
	                if (animal.getStop()) {
	                    System.out.print("STOPP:");
	                    stop();
	                    stop();
	                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                    alert.setTitle("You Have Won The Game!");
	                    alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
	                    alert.setContentText("Highest Possible Score: 800");
	                    alert.show();
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
