package COMP2042_CW_angjiahau.Controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import COMP2042_CW_angjiahau.Models.Animal;
import COMP2042_CW_angjiahau.Models.Display.Digit;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;

public class Level extends World {

	/**Reference variable to create animal object. Set as private final as there can only be one moving frogger in each round.*/
	private final Animal animal;
	/** Array List variable which stores how many froggers have reached home.*/
	ArrayList<End> ends = new ArrayList<>();
	/** Array List variable for scoreboard*/
	ArrayList<Digit> digits = new ArrayList<>();

	/**Enumeration which stores the y-coordinate for each row.*/
	public enum Rows{
		/** Row 1 */
		ROW1(649),
		/** Row 2 */
		ROW2(597),
		/** Row 3 */
		ROW3(540),
		/** Row 4 */
		ROW4(490),
		/** Row 5 */
		ROW5(435),
		/** Row 6 */
		ROW6(376),
		/** Row 7 */
		ROW7(329),
		/** Row 8 */
		ROW8(276),
		/** Row 9 */
		ROW9(217),
		/** Row 10 */
		ROW10(166);

		/** Private final integer which stores y-coordinate for each row*/
		private final int yCoordinate;

		/**
		 * Setter method.
		 * @param yCoordinate y-coordinate of row
		 */
		Rows(final int yCoordinate) {
			this.yCoordinate = yCoordinate;
		}

		/**
		 * Getter method which returns y-coordinate value in enumeration
		 * @return y-coordinate of the enumeration row.
		 */
		public int getValue() { return this.yCoordinate; }

	}

	/**
	 * Constructor method which has variables to be inherited by other level classes
	 * Adds the 5 slots of home(end) for frogger character to reach.
	 * Initializes main character to be played.
	 */
	public Level() {
	ends.add(new End(13,96));
	ends.add(new End(141,96));
	ends.add(new End(141 + 141-13,96));
	ends.add(new End(141 + 141-13+141-13+1,96));
	ends.add(new End(141 + 141-13+141-13+141-13+3,96));

	animal = new Animal("froggerUp");
	add(animal);

	ends.forEach(new Consumer<End>() {
		@Override
		public void accept(End end) {
			add(end);
		}
	});
}

	/**
	 * Overriden method which is called in every frame as long as AnimationTimer is active.
	 * This Overriden method makes sure the score and scoreboard at top right is kept updated according to the level's occurrence.
	 * It also makes sure that the game ends when 5 frogs are brought home to the end.
	 * Lastly, the method makes sure after each round, a high score file for the level will be created(if it does not already exist)
	 * the high score of the player will be compared to the existing(if any) high scores within the high score file, and stored if it is higher or equal to any of the existing high score values.
	 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	@Override
	public void act(long now) {
		if (getAnimal().changeScore()) {
			setNumber(getAnimal().getPoints());
		}
		if (getAnimal().getStop()) {
			stop();
			highScoreCaller();
		}
	}

	/**
	 * Called in each level class to make sure main character exists.
	 * @return instance of frogger animal
	 */
	public Animal getAnimal(){
		return animal;
	}

	/**
	 * Makes sure after each round, a high score file for the level will be created(if it does not already exist).
	 * The high score of the player will be compared to the existing(if any) high scores within the high score file,
	 * and stored if it is higher or equal to any of the existing high score values.
	 */
	public void highScoreCaller(){
		try {
			HighScore.HighScoreController(getClass().getSimpleName(), getAnimal().getPoints());
		} catch(IOException e){
			e.printStackTrace();
			System.out.println("Error in File Controller");
		}

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("You Have Won The Round!");
		if(HighScore.checkHigher(getAnimal().getPoints())){
			alert.setHeaderText("You have a new High Score: "+ getAnimal().getPoints()+"!");
		}else {
			alert.setHeaderText("Your High Score: " + getAnimal().getPoints() + "!");
		}
		alert.setContentText("Current Highscore List : " + HighScore.displayHighScore());
		alert.show();
	}

	/**
	 * Created animation timer and makes sure all actions from objects which inherits from actors are listened to and carried out.
	 */
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

	/**
	 * Sets initial scoreboard to 0 and "hi-score" label on the top right corner of each level.
	 */
	public void showInitialHighScore(){
		add(new Digit(0, 30, 550, 40));
		add(new HighScore("hi-scoreImage"));
	}

	/**
	 * Sets scoreboard value
	 * @param n Number
	 */
	public void setNumber(int n) {
		digits.forEach(new Consumer<Digit>() {
			@Override
			public void accept(Digit digit) {
				remove(digit);
			}
		});
		digits.clear();
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            Digit temp = new Digit(k, 30, 550 - shift, 40);
            digits.add(temp);
            add(temp);
            shift+=30;
        }
}

	/**
	 * Makes sure Timer is started causing it to start sending events to its listeners.
	 * This method also makes sure each round is properly reset.
	 */
	    @Override
		public void start() {
			super.start();
			getAnimal().reset();
			ends.forEach(new Consumer<End>() {
				@Override
				public void accept(End end) {
					end.reset();
				}
			});
			setNumber(0);
		}


}

