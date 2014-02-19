import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;


// -------------------------------------------------------------------------
/**
 * Draws a rectangle when called.
 *
 * @author Hang
 * @version Oct 10, 2010
 */
public class Rectangles
    implements Shape
{
    /**
     * the cord of beginning of shape
     */
    Point   start;

    /**
     * the cord of ending of shape
     */
    Point   end;

    /**
     * the color of the shape
     */
    Color   color;

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
    public Rectangles( Point first, Point last, Color look, boolean fill )
    {
        start = first;
        end = last;
        color = look;
        filled = fill;
    }


    // ----------------------------------------------------------

    /**
     * @param context
     *            is the drawing area of the shape.
     */
    public void draw( Graphics context )
    {
        context.setColor( color );
        int absx = Math.abs( end.x - start.x );
        int absy = Math.abs( end.y - start.y );
        int topLeftX = Math.min( start.x, end.x );
        int topLeftY = Math.min( start.y, end.y );

        //shape is not filled.
        if ( !filled)
        {
            context.drawRect( topLeftX, topLeftY, absx, absy);
        }

        //shape is filled.
        if ( filled )
        {
            context.fillRect( topLeftX, topLeftY, absx, absy);
        }
    }


    /**
     * @return the color of the shape.
     */
    public Color getColor()
    {
        return color;
    }

    // ----------------------------------------------------------

    /**
     * @return the string Rectangles.
     */
    public String toString()
    {
        return "Rectangles";
    }

}
