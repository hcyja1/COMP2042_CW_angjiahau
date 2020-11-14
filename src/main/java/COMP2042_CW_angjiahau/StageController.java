package COMP2042_CW_angjiahau;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import javafx.scene.Scene;
import COMP2042_CW_angjiahau.World;
import COMP2042_CW_angjiahau.Levels.*;


public class StageController extends World {
	
	Level2 level2;
	World world;
	 private HashMap<String, World> screenMap;
	    private Scene scene;
	  

	    public StageController(int numWorld,Scene scene) {
	    	screenMap = new HashMap<>(numWorld);
	        this.scene=scene;
	    }

	    public void addScreen(String name, World world){
	         screenMap.put(name, world);
	    }

	   public void removeScreen(String name){
	        screenMap.remove(name);
	    }

	   public void activate(String name){
	        scene.setRoot( screenMap.get(name) );	     
	    }
	   
	   public void startScene() {
		   ((World)scene.getRoot()).start();	        
	   }
	   
	   public void changeScene(String name,World world) {			  		  
		   activate(name);		
		   startScene();		   		
		   }
	   	   
		@Override
		public void act(long now) {
			
		}
		
		public World getCurrentScene() {
			return (World) scene.getRoot();
		}

		public void nextScene(String key) {
			List<String> list = new ArrayList<>(screenMap.keySet());
			scene.setRoot(screenMap.get(list.get((list.indexOf(key) + 1) % list.size())));
			startScene();
		}

		public HashMap<String, World> getScreenMap() {
			return screenMap;
		}
		
}
