import COMP2042_CW_angjiahau.Main;
import java.util.concurrent.TimeoutException;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class ApplicationTimeoutTest extends ApplicationTest {

    /**
     * jUnit test to make sure application is not lagging and does not take more than 5 seconds to load.
     */
    @Test
    void timeoutNotExceeded(){
        assertTimeout(ofSeconds(5), () -> ApplicationTest.launch(Main.class));
    }

    /**
     * Resource management
     * @throws TimeoutException throws TimeoutException
     */
    @After
    public void afterEachTest() throws TimeoutException {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

}
