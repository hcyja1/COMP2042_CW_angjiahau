import COMP2042_CW_angjiahau.Models.Animal;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeathAnimationCheck extends ApplicationTest {

    /** Reference variable to create animal object for testing  */
    Animal animal;
    /** Variable to initialize internal graphics*/
    private final JFXPanel panel = new JFXPanel();


    /**
     * Method used to create animal object.
     */
    void setAnimal(){
        animal = new Animal("froggerUp");
    }

    /**
     * Test case to see if animation images for car death has been successfully added into {@link Animal}class.
     */
    @Test
    void CarHashMapNotEmpty(){
        setAnimal();
        assertTrue(animal.checkCarHash().size()>=1);
    }

    /**
     * Test case to see if animation images for water death has been successfully added into {@link Animal}class.
     */
    @Test
    void WaterHashMapNotEmpty(){
        setAnimal();
        assertTrue(animal.checkWaterHash().size()>=1);
    }
}
