import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class mainWindow extends JFrame{

	    public JLabel label; // To reference a label	 
	    public JButton button; // To reference a text field
	    public JButton button2; // To reference a text field
	    private JPanel panel; //To reference a panel

	    final int WINDOW_WIDTH = 330; // Window width in pixels
	    final int WINDOW_HEIGHT = 100; // Window height in pixels
	    
	    public mainWindow() //constructor
            {
	        //define frame properties
	        setTitle("Main Window");
	        // Set the size of this window.
	        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	        // Specify what happens when the close button is clicked.
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        // Center the frame
	        setLocationRelativeTo(null);
	        //initialization the components
	        label = new JLabel("");
	  
	        panel = new JPanel();//container that contains components
	        //set label properties
	        label.setFont(new Font("serif", Font.BOLD, 22));
	        label.setForeground(Color.BLUE);

	        button = new JButton("Patient");
	        button.setFont(new Font("serif", Font.BOLD, 18));
	        button.setForeground(Color.BLUE);
                
	        button.addActionListener(new ButtonListener());
	        
	        button2 = new JButton("Dentist");
	        button2.setFont(new Font("serif", Font.BOLD, 18));
	        button2.setForeground(Color.BLUE);

	        button2.addActionListener(new ButtonListener());

	        //add the components to panel container 
	        panel.add(label);
	        panel.add(button);
	        panel.add(button2);

	        //set the background color of the panel
	        panel.setBackground(Color.LIGHT_GRAY);
	        //add panel to the frame
	        add(panel);
	        // Display the window.
	        setVisible(true);
	    }
            
            private class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) 
                        {
                            if (e.getSource() == button) {
                                new patientLogin();
			    }
                            if(e.getSource() == button2) {
                                new dentistLogin();
			    }
			}
            }
            
            public static void main(String[] args) {
                new mainWindow();
            }
}