package COMP2042_CW_angjiahau.Models.Platforms;

import COMP2042_CW_angjiahau.Controllers.Actor;

public class Platform extends Actor {
    /** Double variable to set speed of moving Platform */
    double speed;

     /**
     * Setter method for classes which inherit platform to call super().
     * @param xpos Initial x-position for Platform object constructed.
     * @param ypos Initial y-position for  Platform object constructed.
     * @param speed Speed for Sinking object constructed.
     */
    public Platform(double xpos, double ypos, double speed){
        super();
        setX(xpos);
        setY(ypos);
        this.speed = speed;
    }

    /**
     * Getter method to for velocity of Platform object generated.
     * @return speed of moving Platform object.
     */
    public double getSpeed(){
        return speed;
    }

    /**
     * Overriden method which is called in every frame as long as AnimationTimer is active.
     * This Overriden method makes sure the platform objects are moving with a velocity of the set speed.
     * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
     */
    @Override
    public void act(long now) {
        move(speed , 0);
    }


}
