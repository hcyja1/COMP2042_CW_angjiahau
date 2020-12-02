package COMP2042_CW_angjiahau.Models;

import COMP2042_CW_angjiahau.Controllers.Actor;

public class SinkingPlatform extends Platform {
    double speed;
    boolean sunk;

    public SinkingPlatform(double xpos, double ypos, double speed) {
        super(xpos,ypos,speed);
        this.speed = speed;
    }

    public boolean isSunk() {
        return sunk;
    }

    public void setSunk(boolean sunk){
        this.sunk=sunk;
    }

    public double getSpeed(){
        return speed;
    }


}
