import java.awt.Color;
import java.awt.Graphics;

/**
 * This is the interface for all the shape classes.
 *
 * @author Hang Lin lin1412
 * @version 2010.10.10
 */
public interface Shape
{
    // ----------------------------------------------------------
    /**
     * The abstract method for drawing a shape.
     * @param context is the drawing area the shapes are placed.
     */
    public void draw(Graphics context);
    // ----------------------------------------------------------
    /**
     * The abstract method to return the shape's color.
     * @return the shape's color.
     */
    public Color getColor();
    // ----------------------------------------------------------
    /**
     * @return the String of the Shape.
     */
    public String toString();
}
