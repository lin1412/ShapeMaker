import javax.swing.JFrame;
/**
 * This class makes the frame for the ShapeMaker class.
 *
 * @author Hang Lin lin1412
 * @version 2010.10.10
 */
public class ShapeMaker
{
 // ----------------------------------------------------------
    /**
     * Creates and displays the application frame.
     *
     * @param args Command line arguments are ignored
     */
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("ShapeMaker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new ShapeMakerPanel());

        frame.pack();
        frame.setVisible(true);
    }
}
