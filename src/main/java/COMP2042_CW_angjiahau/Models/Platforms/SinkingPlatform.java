package COMP2042_CW_angjiahau.Models.Platforms;

public class SinkingPlatform extends Platform {

    /** Double variable to set speed of moving Sinking platform */
     double speed;
    /** Boolean variable to determine if frogger character will be sunk or not */
    boolean sunk;

    /**
     * Setter method for classes which inherit sinking platform to call super().
     * @param xpos Initial x-position for Sinking Platform object constructed.
     * @param ypos Initial y-position for Sinking Platform object constructed.
     * @param speed Speed for Sinking Platform object constructed.
     */
    public SinkingPlatform(double xpos, double ypos, double speed) {
        super(xpos,ypos,speed);
        this.speed = speed;
    }

    /**
     * Getter Method to check for boolean value of sunk.
     * @return boolean value of sunk.
     */
    public boolean isSunk() {
        return sunk;
    }

    /**
     * Setter method to set boolean value of sunk.
     * @param sunk sets value of sunk to be either true or false, as seen in {@link WetTurtle} playWetTurtleAnimation() method.
     */
    public void setSunk(boolean sunk){
        this.sunk=sunk;
    }

    /**
     * Getter method to for velocity of Sinking Platform object generated.
     * @return speed of moving Sinking Platform object.
     */
    public double getSpeed(){
        return speed;
    }


}
