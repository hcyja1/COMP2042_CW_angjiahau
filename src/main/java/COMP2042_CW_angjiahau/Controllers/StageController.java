package COMP2042_CW_angjiahau.Controllers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.Scene;

public class StageController extends World {

		/** Linked Hash Map variable used to store Scenes in order. */
		 private final LinkedHashMap<String, World> screenMap;
		 /**Reference variable to access methods in {@link javafx.scene.Scene} package. */
		 private final Scene scene;

		/**
		 * Constructor which acts as a setter for scene
		 * @param numWorld Number of scenes to be added
		 * @param scene Scene to be added
		 */
	    public StageController(int numWorld,Scene scene) {
	    	screenMap = new LinkedHashMap<>(numWorld);
	        this.scene=scene;
	    }

		/**
		 * Adds scenes to be stored into the {@link #screenMap} LinkedHashMap.
		 * @param name Name of scene
		 * @param world Class name of scene which extends world
		 */
		public void addScreen(String name, World world){
				 screenMap.put(name, world);
			}

		/**
		 * Sets the value of property root to be screen name previously added into {@link #screenMap}.
		 * @param name Name of Class scene which extends world
		 */
		public void activate(String name){
				scene.setRoot( screenMap.get(name) );
			}

		/**
		 * Gets the value of property root to be screen name previously added into {@link #screenMap} and starts it.
		 */
		public void startScene() {
			   ((World)scene.getRoot()).start();
		   }

		/**
		 * Sets the value of property root to be screen name previously added into {@link #screenMap} and then starts it.
		 * @param name Name of screen added.
		 * @param world Name of Class scene which extends world
		 */
		public void changeScene(String name,World world) {
			   activate(name);
			   startScene();
			   }

		/**
		 * Switches to next scene within scenes added to stage controller.
		 * @param key Map Entry Key
		 */
		public void nextScene(String key) {
			List<String> list = new ArrayList<>(screenMap.keySet());
			scene.setRoot(screenMap.get(list.get((list.indexOf(key) + 1) % (list.size()))));
			startScene();
		}

		/**
		 * Used as a getter method.
		 * @return {@link #screenMap}.
		 */
		public LinkedHashMap<String, World> getScreenMap() {
			return screenMap;
		}

		/**
		 * Overriden method which is called in every frame as long as AnimationTimer is active.
		 * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
		 */
		@Override
		public void act(long now) {

		}

}
