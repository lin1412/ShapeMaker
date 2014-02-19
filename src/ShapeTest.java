import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.Color;


/**
 * This class tests the shape Classes and
 * the methods within the ShapeMakerPanel class.
 * @author Hang Lin lin1412
 * @version 2010.10.14
 */

public class ShapeTest
    extends student.GUITestCase
{

    // ----------------------------------------------------------
    /**
     * test drawing circle on the panel.
     */
    public void testCircle() {
        ShapeMakerPanel panel = new ShapeMakerPanel();
        showInFrame(panel);

        //not filled shapes

        mousePress(panel, 100, 100);
        mouseMove(panel, 300, 300);
        mouseRelease();

        mousePress(panel, 700, 100);
        mouseMove(panel, 600, 300);
        mouseRelease();

        mousePress(panel, 100, 500);
        mouseMove(panel, 400, 400);
        mouseRelease();

        mousePress(panel, 700, 550);
        mouseMove(panel, 500, 400);
        mouseRelease();
        assertEquals(Color.black, panel.getShapes().get(0).getColor());

        //--------------------------------------------
        //filled shapes
        click(getComponent(JPanel.class, "currentColor"));
        selectColorInChooser(Color.blue);
        click(getComponent(JCheckBox.class, "filled"));

        mousePress(panel, 150, 150);
        mouseMove(panel, 200, 300);
        mouseRelease();

        mousePress(panel, 700, 200);
        mouseMove(panel, 300, 400);
        mouseRelease();

        mousePress(panel, 200, 400);
        mouseMove(panel, 400, 300);
        mouseRelease();

        mousePress(panel, 700, 500);
        mouseMove(panel, 500, 350);
        mouseRelease();

        click(panel);

        for ( int i = 0; i < panel.getShapes().size(); i++)
        {
            assertTrue(panel.getShapes().get(i) instanceof Circles );
        }
    }

    // ----------------------------------------------------------
    /**
     * test drawing lines on the panel.
     */
    public void testLines() {
        ShapeMakerPanel panel = new ShapeMakerPanel();
        showInFrame(panel);
        selectItem(getComponent(JComboBox.class, "shapeChoice"), "Lines");

        mousePress(panel, 100, 100);
        mouseMove(panel, 600, 500);
        mouseRelease();
        assertEquals(Color.black, panel.getShapes().get(0).getColor());

        assertTrue(panel.getShapes().get(0) instanceof Lines );

    }

 // ----------------------------------------------------------
    /**
     * test drawing lines on the panel.
     */
    public void testOvals() {
        ShapeMakerPanel panel = new ShapeMakerPanel();
        showInFrame(panel);
        click(getComponent(JPanel.class, "currentColor"));
        selectColorInChooser(Color.blue);
        selectItem(getComponent(JComboBox.class, "shapeChoice"), "Ovals");

        //not filled shapes
        mousePress(panel, 100, 100);
        mouseMove(panel, 500, 400);
        mouseRelease();

        assertEquals(Color.blue, panel.getShapes().get(0).getColor());

        //--------------------------------------------
        //filled shapes
        click(getComponent(JCheckBox.class, "filled"));

        mousePress(panel, 500, 300);
        mouseMove(panel, 700, 400);
        mouseRelease();

        for ( int i = 0; i < panel.getShapes().size(); i++)
        {
            assertTrue(panel.getShapes().get(i) instanceof Ovals );
        }
    }

 // ----------------------------------------------------------
    /**
     * test drawing lines on the panel.
     */
    public void testRectangles() {
        ShapeMakerPanel panel = new ShapeMakerPanel();
        showInFrame(panel);
        click(getComponent(JPanel.class, "currentColor"));
        selectColorInChooser(Color.green);
        selectItem(getComponent(JComboBox.class, "shapeChoice"), "Rectangles");

        //not filled shapes
        mousePress(panel, 100, 100);
        mouseMove(panel, 500, 400);
        mouseRelease();

        assertEquals(Color.green, panel.getShapes().get(0).getColor());

        //--------------------------------------------
        //filled shapes
        click(getComponent(JCheckBox.class, "filled"));

        mousePress(panel, 500, 300);
        mouseMove(panel, 700, 400);
        mouseRelease();

        for ( int i = 0; i < panel.getShapes().size(); i++)
        {
            assertTrue(panel.getShapes().get(i) instanceof Rectangles );
        }
    }

 // ----------------------------------------------------------
    /**
     * test drawing lines on the panel.
     */
    public void testSquares() {
        ShapeMakerPanel panel = new ShapeMakerPanel();
        showInFrame(panel);
        click(getComponent(JPanel.class, "currentColor"));
        selectColorInChooser(Color.red);
        selectItem(getComponent(JComboBox.class, "shapeChoice"), "Squares");

        //not filled shapes
        mousePress(panel, 100, 100);
        mouseMove(panel, 300, 300);
        mouseRelease();

        mousePress(panel, 600, 100);
        mouseMove(panel, 500, 300);
        mouseRelease();

        mousePress(panel, 100, 500);
        mouseMove(panel, 400, 400);
        mouseRelease();

        mousePress(panel, 650, 550);
        mouseMove(panel, 500, 400);
        mouseRelease();

        assertEquals(Color.red, panel.getShapes().get(0).getColor());

        //--------------------------------------------
        //filled shapes
        click(getComponent(JCheckBox.class, "filled"));

        mousePress(panel, 150, 150);
        mouseMove(panel, 200, 300);
        mouseRelease();

        mousePress(panel, 700, 200);
        mouseMove(panel, 300, 400);
        mouseRelease();

        mousePress(panel, 200, 400);
        mouseMove(panel, 400, 300);
        mouseRelease();

        mousePress(panel, 700, 500);
        mouseMove(panel, 400, 350);
        mouseRelease();

        for ( int i = 0; i < panel.getShapes().size(); i++)
        {
            assertTrue(panel.getShapes().get(i) instanceof Squares );
        }
    }
    // ----------------------------------------------------------
    /**
     * the the other methods within ShapeMakerPanel
     */
    public void testListeners()
    {
        ShapeMakerPanel panel = new ShapeMakerPanel();
        showInFrame(panel);

        click(getComponent(JButton.class, "undo"));
        click(getComponent(JButton.class, "clear"));

        mousePress(panel, 100, 100);
        mouseMove(panel, 300, 300);
        mouseRelease();

        mousePress(panel, 600, 100);
        mouseMove(panel, 400, 300);
        mouseRelease();

        mousePress(panel, 600, 100);
        mouseMove(panel, 1000, 1000);
        mouseRelease();


        click(getComponent(JButton.class, "undo"));
        assertEquals(1, panel.getShapes().size());

        click(getComponent(JButton.class, "clear"));
        assertEquals(0, panel.getShapes().size());

    }
}