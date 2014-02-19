import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;
import javax.swing.BoxLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Demonstrates a graphical user interface and an event listener.
 *
 * @author Hang Lin lin1412
 * @version 2010.10.10
 */
public class ShapeMakerPanel
    extends JPanel
{
    /**
     * start is the point of the click.
     */
    protected static Point start;

    /**
     * end is the point of the release.
     */
    protected static Point end;
    /**
     * the color of the shape
     */
    protected static Color color;
    /**
     * if the shape is filled or not
     */
    protected static boolean fill;
    private JComboBox      shapeChoice;
    private JButton        undo;
    private JButton        clear;
    private JPanel         currentColor;
    private JCheckBox      filled;
    private List<Shape>    shapeList = new ArrayList<Shape>();
    private Shape          drawShape;

    // ----------------------------------------------------------
    /**
     * Create a new ShapeMakerPanel object.
     */
    public ShapeMakerPanel()
    {
        setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
        add(new ControlPanel());
        add(new DrawingArea());
    }
    /**
     * @return a list of the shapes in the list.
     */
    public List<Shape> getShapes()
    {
        return shapeList;
    }

    // ---------------------------------------------
    /**
     * makes an inner class of ControlPanel.
     */
    private class ControlPanel
        extends JPanel
    {
        /**
         * creates control panel object.
         */
        public ControlPanel()
        {
            setName("controlPanel");
            //make a JComboBox with the name shapeChoice and add different
            //shape choice that can be drawn.
            shapeChoice = new JComboBox();
            Circles circles = new Circles(start, end, color, fill);
            shapeChoice.addItem( circles );
            Lines lines = new Lines(start, end, color, fill);
            shapeChoice.addItem( lines );
            Ovals ovals = new Ovals(start, end, color, fill);
            shapeChoice.addItem( ovals );
            Rectangles rectangles = new Rectangles(start, end, color, fill);
            shapeChoice.addItem( rectangles );
            Squares squares = new Squares(start, end, color, fill);
            shapeChoice.addItem( squares );
            shapeChoice.setName( "shapeChoice" );
            BoxListener boxListener = new BoxListener();
            shapeChoice.addActionListener( boxListener );
            shapeChoice.setSelectedIndex( 0 );
            add( shapeChoice );

            //make a JPanel with a color selection.
            currentColor = new JPanel();
            currentColor.setName( "currentColor" );
            currentColor.setBackground( Color.black );
            ColorListener colorAction = new ColorListener();
            currentColor.addMouseListener( colorAction );
            color = Color.black;
            add( currentColor );

            //make a JCheckBox with the option to draw a shape filled or not.
            filled = new JCheckBox("filled");
            filled.setName( "filled" );
            add( filled );
            fill = false;

            //make a JButton for the undo option.
            undo = new JButton("undo");
            undo.setName( "undo" );
            UndoListener undoListener = new UndoListener();
            undo.addMouseListener( undoListener);
            add( undo );

            //make a JButton for the clear option.
            clear = new JButton("clear");
            clear.setName( "clear" );
            ClearListener clearListener = new ClearListener();
            clear.addMouseListener( clearListener );
            add( clear );
        }
    }



    // ---------------------------------------------
    /**
     * creates a listener class for the color selection panel.
     */
    private class ColorListener
        extends MouseInputAdapter
    {
        /**
         * opens up color chooser when clicked
         * @param action The event to be handled
         */
        public void mouseClicked( MouseEvent action )
        {
            Color newColor =
                JColorChooser.showDialog(
                    ShapeMakerPanel.this,
                    "Choose Shape Color",
                    currentColor.getBackground() );
            if ( newColor != null )
            {
                currentColor.setBackground( newColor );
                color = newColor;
            }
        }
    }

    //----------------------------------------------------
    /**
     * creates a listener class for the undo button
     */
    private class UndoListener
        extends MouseInputAdapter
    {
        /**
         * undo the drawing when clicked and set a point to null
         * @param action The event to be handled
         */
        public void mouseClicked( MouseEvent action )
        {
            if ( shapeList.size() != 0)
            {
                shapeList.remove(shapeList.size() - 1);
                start = null;
            }
            repaint();
        }
    }
    //-------------------------------------------------
    /**
     * creates a listener class for the clear button
     */
    private class ClearListener
        extends MouseInputAdapter
    {
        /**
         * remove all drawing on drawing area and set a point to null
         * @param action The event to be handled
         */
        public void mouseClicked( MouseEvent action )
        {
            if ( shapeList.size() != 0)
            {
                shapeList.removeAll( shapeList );
                start = null;
            }
            repaint();
        }
    }

    /**
     * creates a listener class for the shape selection box.
     */
    private class BoxListener
        implements ActionListener
    {
        /**
         * gets the choice from the shape selection box.
         * @param action The event to be handled

         */
        public void actionPerformed( ActionEvent action )
        {
            JComboBox box = (JComboBox)action.getSource();
            drawShape = (Shape)shapeChoice.getSelectedItem();
            box.updateUI();
        }
    }

    // ---------------------------------------------
    /**
     * creates an inner drawing area class.
     */
    private class DrawingArea
        extends JPanel
    {
        /**
         * makes an drawing area object with a dimension of 700 by 550.
         */
        public DrawingArea()
        {
            setName( "drawingArea" );
            ShapeListener listener = new ShapeListener();
            addMouseListener( listener );
            addMouseMotionListener( listener );

            setBackground( Color.white );
            setPreferredSize( new Dimension( 800, 600 ) );
        }

        /**
         * draws the shape.
         */
        public void paintComponent( Graphics page )
        {
            super.paintComponent( page );
            page.setColor( Color.black );

            //draw the shape as the mouse drags.
            if ( start != null && end != null )
            {
                if (drawShape.getClass().equals( Circles.class))
                {
                    drawShape = new Circles(start, end, color, fill);
                }
                if (drawShape.getClass().equals( Lines.class ))
                {
                    drawShape = new Lines(start, end, color, fill);
                }
                if (drawShape.getClass().equals( Ovals.class ))
                {
                    drawShape = new Ovals(start, end, color, fill);
                }
                if (drawShape.getClass().equals( Rectangles.class ))
                {
                    drawShape = new Rectangles(start, end, color, fill);
                }
                if (drawShape.getClass().equals( Squares.class ))
                {
                    drawShape = new Squares(start, end, color, fill);
                }
                drawShape.draw( page );
                end = null;
            }
            //draw the shapes that already in the shapeList ArrayList.
            for ( Shape s : shapeList)
            {
                s.draw( page );
            }
        }
    }

    //--------------------------------------------------
    /**
     * creates a listener for the mouse actions in the drawing area.
     */
    private class ShapeListener
        implements MouseListener, MouseMotionListener
    {
        private boolean onScreen = true;


        // ----------------------------------------------------------
        /**
         * Captures the initial position at which the mouse button is pressed.
         * @param event The event to be handled
         */
        public void mousePressed( MouseEvent event )
        {
            start = event.getPoint();
            if ( filled.isSelected())
            {
                fill = true;
            }
            else
            {
                fill = false;
            }
        }


        // ----------------------------------------------------------
        /**
         * Gets the current position of the mouse as it is dragged and redraws
         * the shape.
         * @param event The event to be handled
         */
        public void mouseDragged( MouseEvent event )
        {
            if ( onScreen)
            {
                end = event.getPoint();
                repaint();
            }

        }

        // ----------------------------------------------------------
        /**
         * Unused event handler, provided for interface compliance.
         * @param event The mouse event
         */
        public void mouseClicked( MouseEvent event )
        {
            // not used
        }

        // ----------------------------------------------------------
        /**
         * when the mouse is released add the shape to the shapeList.
         * @param event The mouse
         */
        public void mouseReleased( MouseEvent event )
        {
            if (onScreen)
            {
                shapeList.add( drawShape );
            }
        }


        // ----------------------------------------------------------
        /**
         * mouse is on screen
         * @param event The mouse event
         */
        public void mouseEntered( MouseEvent event )
        {
            onScreen = true;
        }


        // ----------------------------------------------------------
        /**
         * mouse is out of screen
         * @param event The mouse event
         */
        public void mouseExited( MouseEvent event )
        {
            onScreen = false;
        }


        // ----------------------------------------------------------
        /**
         * Unused event handler, provided for interface compliance.
         * @param event The mouse event
         */
        public void mouseMoved( MouseEvent event )

        {
            // not used
        }
    }

}
