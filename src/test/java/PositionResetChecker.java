import COMP2042_CW_angjiahau.Models.Animal;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.jupiter.api.Assertions.*;


public class PositionResetChecker extends ApplicationTest {
        /** Reference variable to create animal object for testing  */
        Animal animal;
         /** Variable to initialize internal graphics*/
        private final JFXPanel panel = new JFXPanel();
        /** Double variable for y-coordinate starting position of animal object*/
       double startingYPosition = 679.8+(13.3333333*2);
       /** Double variable for x-coordinate starting position of animal object*/
       int startingXPosition = 300;

        /**
         * Method to create animal object.
         */
        void setAnimal(){
               animal = new Animal("froggerUp");
           }

        /**
         * Test to see if animal will return back to original spawn position upon death reset.
         */
        @Test
            void DeathResetChecker(){
               setAnimal();
               animal.setY(50);
               animal.deathReset();
                assertEquals(startingXPosition, animal.getX());
                assertEquals(startingYPosition, animal.getY());
            }

        /**
         * Test to see if animal will return back to respawn position upon going out of bounds, for negative y-position.
         */
        @Test
        void outOfBoundsCheckerOne(){
            setAnimal();
            animal.setX(50);
            animal.setY(-3);
            animal.checkoutOfBounds();
            assertTrue(animal.getY()>0);
        }

        /**
         * Test to see if animal will return back to respawn position upon going out of bounds, after exceeding y-position.
         */
        @Test
        void outOfBoundsCheckerTwo(){
            setAnimal();
            animal.setX(50);
            animal.setY(800);
            animal.checkoutOfBounds();
            assertEquals(startingXPosition, animal.getX());
        }

}