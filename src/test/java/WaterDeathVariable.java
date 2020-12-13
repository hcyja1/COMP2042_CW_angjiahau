import COMP2042_CW_angjiahau.Controllers.Actor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WaterDeathVariable extends Actor {
    int waterLevel = 0;
    boolean waterDeath = false;

    public void waterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public void checkWaterDeath(){
        if (getY()<waterLevel){
            waterDeath = true;
        }
    }

    @Test
    void checkIfWaterLevelCanBeVariable(){
        waterLevel(413);
        checkWaterDeath();
        if(getY()<413){
            assertTrue(waterDeath, "Water Death can be varied upon levels");
        }
    }

    @Override
    public void act(long now) {

    }
}
