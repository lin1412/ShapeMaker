import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

// -------------------------------------------------------------------------
/**
 *  Draws a line when called.
 *
 *  @author Hang
 *  @version Oct 10, 2010
 */
public class Lines implements Shape
{
    /**
     * the cord of beginning of shape
     */
    Point start;
    /**
     * the cord of ending of shape
     */
    Point end;
    /**
     * the color of the shape
     */
    Color color;
    /**
     * boolean for filled shape of not
     */
    boolean filled;


    //-------------------------------------------------------
    /**
     * Create a new Squares object.
     * @param first starting cord
     * @param last ending cord
     * @param look the color
     * @param fill if the shape is filled
     */
    public Lines( Point first, Point last, Color look, boolean fill )
    {
        start = first;
        end = last;
        color = look;
        filled = fill;
    }
    //-------------------------------------------------------------

    /**
     * @param context is the drawing area of the shape.
     */
    public void draw( Graphics context )
    {
        context.setColor(color);
        context.drawLine(start.x, start.y, end.x, end.y);
    }
    /**
     * @return the color of the shape.
     */
    public Color getColor()
    {
        return color;
    }
    /**
     * @return a String of Lines.
     */
    public String toString()
    {
        return "Lines";
    }

}
