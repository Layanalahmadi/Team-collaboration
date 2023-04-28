import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.*;


public class patientLogin extends JFrame
{
		    public JLabel label; // To reference a label
		    public JLabel label2; // To reference a label
		    public JTextField textName; // To reference a text field
		    public JTextField textPassword; // To reference a text field
		    public JButton button; // To reference a text field
		    public JButton button2; // To reference a text field
		    private JPanel panel; //To reference a panel
		   
		    final int WINDOW_WIDTH = 350; // Window width in pixels
                    final int WINDOW_HEIGHT = 180; // Window height in pixels
		    
		    public patientLogin()
                    {
		        //define frame properties
		        setTitle("Login Window");
		        // Set the size of this window.
		        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		        // Specify what happens when the close button is clicked.
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        // Center the frame
		        setLocationRelativeTo(null);
		        //initialization the components
		        label = new JLabel("USERNAME: ");
                        textName = new JTextField(15);

                        label2 = new JLabel("PASSWORD: ");
                        textPassword = new JTextField(15);
                        
                        panel = new JPanel();//container that contains components
                        //set label properties
                        label.setFont(new Font("serif", Font.BOLD, 22));
                        label.setForeground(Color.BLUE);
        
                        label2.setFont(new Font("serif", Font.BOLD, 22));
                        label2.setForeground(Color.BLUE);
        
                        button = new JButton("Registration");
                        button.setFont(new Font("serif", Font.BOLD, 18));
                        button.setForeground(Color.BLACK);
                        button.addActionListener(new ButtonListener());
        
                        button2 = new JButton("Login");
                        button2.setFont(new Font("serif", Font.BOLD, 18));
                        button2.setForeground(Color.BLACK);
                        button2.addActionListener(new ButtonListener());

		        //add the components to panel container 
		        panel.add(label);
		        panel.add(textName);
		        panel.add(label2);
		        panel.add(textPassword);
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
                                    if(e.getSource() == button)
                                    {
                                        new patientRegister();
                                    }
                                    if (e.getSource() == button2) 
                                    {
                                        String username = textName.getText();
				        String password = textPassword.getText();
				
					try {
                                            
                                            File file = new File("patient.txt");
					    Scanner scan =  new Scanner(file);

                                            scan.useDelimiter("[,\n]");
                                            
                                            while (scan.hasNext()) {
                                                
                                                String name = scan.next();
						String pass = scan.next();
							
						if (username.equals(name.trim()) && password.equals(pass.trim()))
                                                {
                                                    JOptionPane.showMessageDialog(null, "Successful login");
						}
                                            }	
                                        
                                        } catch (Exception e1) {}
                                    }
                                }
                    }
                    public static void main(String[] args) {
                        new patientLogin();
                    }	
}