import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class patientRegister  extends JFrame {
    
	    public JLabel label; // To reference a label
	    public JLabel label2; // To reference a label
	    public JLabel label3; // To reference a label
	    public JTextField textUserName; // To reference a text field
	    public JTextField textPassword; // To reference a text field
	    public JTextField phone; // To reference a text field
	    public JButton button; 
	    public JButton button2; 
	    private JPanel panel; //To reference a panel
	   
	    final int WINDOW_WIDTH = 400; // Window width in pixels
            final int WINDOW_HEIGHT = 220; // Window height in pixels
	    
	    public  patientRegister() //constructor
            {
	        //define frame properties
	        setTitle("Register Window");
	        // Set the size of this window.
	        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	        // Specify what happens when the close button is clicked.
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        // Center the frame
	        setLocationRelativeTo(null);
	        //initialization the components
	        label = new JLabel("USERNAME: ");
	        textUserName = new JTextField(18);

	        label2 = new JLabel("PASSWORD: ");
	        textPassword = new JTextField(18);
	        
	        label3 = new JLabel("PHONE:        ");
	        phone = new JTextField(18);
	  
	        panel = new JPanel();//container that contains components

	        //set label properties
	        label.setFont(new Font("serif", Font.BOLD, 22));
	        label.setForeground(Color.BLUE);

	        label2.setFont(new Font("serif", Font.BOLD, 22));
	        label2.setForeground(Color.BLUE);
	        
	        label3.setFont(new Font("serif", Font.BOLD, 22));
	        label3.setForeground(Color.BLUE);

	       
	        button = new JButton("Back to Login");
	        button.setFont(new Font("serif", Font.BOLD, 18));
	        button.setForeground(Color.BLACK);
	        button.addActionListener(new ButtonListener());

	        button2 = new JButton("Register");
	        button2.setFont(new Font("serif", Font.BOLD, 18));
	        button2.setForeground(Color.BLACK);
	        button2.addActionListener(new ButtonListener());

	        //add the components to panel container 
	        panel.add(label);
	        panel.add(textUserName);
	        panel.add(label2);
	        panel.add(textPassword);
	        panel.add(label3);
	        panel.add(phone);
	        panel.add(button);
	        panel.add(button2);
	       
	        //set the background color of the panel
	        panel.setBackground(Color.LIGHT_GRAY);
	        //add panel to the frame
	        add(panel);
	        // Display the window.
	        setVisible(true);
	    }
            
            private class ButtonListener implements ActionListener {
                public void actionPerformed(ActionEvent e) 
                {
                    if (e.getSource() == button) {
                        new patientLogin();
		    }
                    if(e.getSource() == button2) {
                        if(textUserName.getText().isEmpty() || textPassword.getText().isEmpty()
					|| phone.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please fill all the fields");
                        }
			else
                            JOptionPane.showMessageDialog(null, "Successful Registration");
                        
                        try {
                            
                            BufferedWriter writer = new BufferedWriter(new FileWriter("patient.txt", true));
                            writer.write(textUserName.getText() + "," + textPassword.getText()
                                    + "," + phone.getText() + ",\n");
                            writer.close();
                        
                        } catch (IOException x) {
                            System.out.println("file not found");
                        }	
                    }
                }
            }
            
            public static void main(String[] args) {
		new patientRegister();
            }
}