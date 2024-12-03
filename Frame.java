package setelahuts;

/**
 *
 * @author master.rohim
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Frame extends JFrame {

    public Frame() {
        // Set title of the frame
        setTitle("Simple Frame Example");
        
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set size of the frame
        setSize(400, 300);
        
        // Set the frame to the center of the screen
        setLocationRelativeTo(null);
        
        // Add a simple label
        JLabel label = new JLabel("Hello, welcome to your first frame!", JLabel.CENTER);
        add(label);
    }

       public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread using anonymous class
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create and display the frame
                SimpleFrame frame = new SimpleFrame();
                frame.setVisible(true);
            }
        });
    }
}