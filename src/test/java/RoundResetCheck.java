import COMP2042_CW_angjiahau.Models.Animal;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundResetCheck extends ApplicationTest {
    /** Reference variable to create animal object for testing  */
    Animal animal;
    /** Variable to initialize internal graphics*/
    private final JFXPanel panel = new JFXPanel();

    /**
     * Method to create animal object.
     */
    void setAnimal(){
        animal = new Animal("froggerUp");
    }

    /**
     * Test method to make sure that each round starts with player having 0 points and no froggers at the end points.
     */
    @Test
    void startCheck(){
        setAnimal();
        animal.reset();
        assertEquals(animal.getPoints(), 0);
        assertEquals(animal.getEnd(), 0);
    }

}
