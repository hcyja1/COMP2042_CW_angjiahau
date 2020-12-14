package COMP2042_CW_angjiahau.Controllers;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import java.util.ArrayList;

public abstract class Actor extends ImageView{

    /**
     * Makes the object which extends {@link Actor} class move.
     * @param dx Horizontal distance
     * @param dy Vertical Distance
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * Getter method for parent of world.
     * @return Parent of {@link World}
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * Getter method for Width of bounds.
     * @return The width of this bounds.
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * Getter method for height of bounds.
     * @return The height of this bounds.
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * Used to get intersecting objects.
     * @param cls cls Name of Class parameter.
     * @param <A> Any class which extends Actor.
     * @return Array List of objects which has intersected with this bounds.
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }

    /**
     * Abstract method which is called in every frame as long as AnimationTimer is active.
     * @param now is the Timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
     */
    public abstract void act(long now);

}
