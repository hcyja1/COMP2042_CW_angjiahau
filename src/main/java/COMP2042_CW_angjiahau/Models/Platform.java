package COMP2042_CW_angjiahau.Models;

import COMP2042_CW_angjiahau.Controllers.Actor;

public class Platform extends Actor {
    private double speed;
    boolean sunk = false;

    public Platform(double xpos, double ypos, double speed){
        super();
        setX(xpos);
        setY(ypos);
        this.speed = speed;
    }

    public double getSpeed(){
        return speed;
    }
    public boolean getLeft() {
        return speed < 0;
    }

    @Override
    public void act(long now) {
        move(speed , 0);
    }


}
