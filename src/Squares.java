import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;


// -------------------------------------------------------------------------
/**
 * Draws a square when called.
 *
 * @author Hang
 * @version Oct 10, 2010
 */
public class Squares
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
    public Squares( Point first, Point last, Color look, boolean fill )
    {
        start = first;
        end = last;
        color = look;
        filled = fill;
    }


    // -------------------------------------------------------------
    /**
     * @param context
     *            is the drawing area of the shape.
     */
    public void draw( Graphics context )
    {
        context.setColor( color );
        int rangex = end.x - start.x;
        int rangey = end.y - start.y;
        int absx = Math.abs( rangex );
        int absy = Math.abs( rangey );
        int distance = Math.min( absx, absy);

        // shape is not filled.
        if ( !filled)
        {
            // draw on bottom right
            if ( rangex > 0 && rangey > 0 )
            {
                context.drawRect( start.x, start.y, distance, distance );
            }
            // draw on bottom left
            if ( rangex < 0 && rangey > 0 )
            {
                context.drawRect( start.x - distance, start.y,
                    distance, distance );
            }
            // draw on top right
            if ( rangex > 0 && rangey < 0 )
            {
                context.drawRect( start.x, start.y - distance,
                    distance, distance);
            }
            // draw on top left
            if ( rangex < 0 && rangey < 0 )
            {
                context.drawRect( start.x - distance, start.y - distance,
                    distance, distance );
            }
        }

        // shape is filled
        if ( filled )
        {
            // draw on bottom right
            if ( rangex > 0 && rangey > 0 )
            {
                context.fillRect( start.x, start.y, distance, distance );
            }
            // draw on bottom left
            if ( rangex < 0 && rangey > 0 )
            {
                context.fillRect( start.x - distance, start.y,
                    distance, distance);
            }
            // draw on top right
            if ( rangex > 0 && rangey < 0 )
            {
                context.fillRect( start.x, start.y - distance,
                    distance, distance);
            }
            // draw on top left
            if ( rangex < 0 && rangey < 0 )
            {
                context.fillRect( start.x - distance, start.y - distance,
                    distance, distance );
            }
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
     * @return the String Squares.
     */
    public String toString()
    {
        return "Squares";
    }

}