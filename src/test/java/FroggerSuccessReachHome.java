import COMP2042_CW_angjiahau.Models.Animal;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FroggerSuccessReachHome{
    /** Reference variable to create animal object for testing  */
    Animal animal;
    /** Variable to initialize internal graphics*/
    private final JFXPanel panel = new JFXPanel();
    /**Double variable for starting X position*/
    final private int startingXPos=300;
    /**Double variable for starting Y position*/
    final double startingYPosition = 679.8+(13.3333333*2);

    /**
     * Method to create animal object.
     */
    void setAnimal(){
        animal = new Animal("froggerUp");
    }

    /**
     * Starting initilisation for test. Creates animal object, sets x-position to 50 and y-position to 500.
     * Then, make sure points and end == 0.
     */
    void start(){
        setAnimal();
        animal.setX(50);
        animal.setY(500);
        animal.reset();
    }

    /**
     * Test method to make sure that points are added by 50 when a frogger reaches home.
     */
    @Test
    void FroggerPointsAdds(){
        start();
        animal.froggerReachesHome();
        assertEquals(animal.getPoints(),50);
    }
    /**
     * Test method to make sure that end is added by 1 when a frogger reaches home.
     */
    @Test
    void FroggerEndAdds(){
        start();
        animal.froggerReachesHome();
        assertEquals(animal.getEnd(),1);
    }
    /**
     * Test method to make sure that frog goes back to starting x-position upon reaching end point(home).
     */
    @Test
    void FroggerStartingXPosition(){
        start();
        animal.froggerReachesHome();
        assertEquals(animal.getX(),startingXPos);
    }

    /**
     * Test method to make sure that frog goes back to starting y-position upon reaching end point(home).
     */
    @Test
    void FroggerStartingYPosition(){
        start();
        animal.froggerReachesHome();
        assertEquals(animal.getY(),startingYPosition);
    }


}