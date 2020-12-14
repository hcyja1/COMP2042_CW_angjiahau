package COMP2042_CW_angjiahau.Controllers;
import java.util.ArrayList;
import java.util.List;
import COMP2042_CW_angjiahau.Models.Platforms.Turtle;
import COMP2042_CW_angjiahau.Models.Platforms.WetTurtle;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;


public abstract class World extends Pane {

	/** Private Variable declaration to access methods within {@link javafx.animation.AnimationTimer} package */
    private AnimationTimer timer;
    /** Boolean variable used to determine if scene should be switched */
    protected boolean switchScene;
    /** List to add instances of wet turtles*/
	List<WetTurtle>  wetturtles;
	/** List to add instance of turtles*/
	List<Turtle>  turtles;


	/**
	 * Constructor consists of code which will act as key pressed and released listeners for environment and actor.
	 */
    public World() {
    	sceneProperty().addListener(new ChangeListener<Scene>() {
			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {
						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {
						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
			}
		});
    }

	/**
	 * Creates animation timer object and assigns it to previously declared {@link #timer} reference variable.
	 */
	public void createTimer() {
        timer = new AnimationTimer() {
			/**
			 * Method which is called in every frame as long as AnimationTimer is active.
			 * Makes sure methods in act(now) within other classes are executed.
			 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
			 */
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);

                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

	/**
	 * Setter method for creation of timer.
	 * @param timer name of Animation Timer
	 */
	public void createTimer(AnimationTimer timer) {
    	this.timer=timer;   	
    }

	/**
	 * Creates and starts an animation timer.
	 * Also will get all instances of wet turtles and turtles, then play their respective animations.
	 */
	public void start() {
    	createTimer();
    	timer.start();
    	switchScene = false;

		wetturtles = getObjects(WetTurtle.class);
		turtles = getObjects(Turtle.class);

		for(WetTurtle wetturtle : wetturtles){
			wetturtle.playWetTurtleAnimation();
		}
    	for(Turtle turtle : turtles){
    		turtle.playTurtleAnimation();
		}

    }

	/**
	 * Used as a call to change to the next scene added into controller of {@link StageController} class, and to stop timer.
	 * Will also stop all turtle and wet turtle animation from the round.
	 */
	public void stop() {

    	switchScene = true;
    	timer.stop();

		for(WetTurtle wetturtle : wetturtles){
			wetturtle.stopWetTurtleAnimation();
		}

		for(Turtle turtle : turtles){
			turtle.stopTurtleAnimation();
		}

    }

	/**
	 * Used as a getter.
	 * @return boolean {@link #switchScene}.
	 */
	public boolean switchScene() {
    	return switchScene;
    }

	/**
	 * Used as a setter to set boolean value {@link #switchScene} to false.
	 */
	public void resetSwitchScene() {
    	switchScene = false;
	}

	/**
	 * Used to add objects which inherit actor.
	 * @param actor Objects which will act or have influence in game rounds.
	 */
	public void add(Actor actor) {
        getChildren().add(actor);
    }

	/**
	 * Used to remove objects which inherit actor.
	 * @param actor Objects which will act or have influence in game rounds.
	 */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }


	/**
	 * Used to get objects added to Array List of classes which extends actor.
	 * @param cls Name of Class parameter.
	 * @param <A> Any class which extends Actor.
	 * @return Array List which has class instances added.
	 */
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

	/**
	 * Abstract method which will be called in every frame as long as Animation Timer is active.
	 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	public abstract void act(long now);
    
   
}
