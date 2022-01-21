import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Andrey Fabricio
 * Github: https://github.com/AndreyFabricio
 * LinkedIn: https://www.linkedin.com/in/andrey-fabricio/
 * 
 * This project generates the Fibonacci sequence to a number or to the closest Nth number in the sequence
 * Fibonacci sequence: https://en.wikipedia.org/wiki/Fibonacci_number
 * 
 * Last update: 21/01/2022
 */

public class FibonacciFinder extends JFrame implements ActionListener {
	
		// Labels creation
		Container container=getContentPane();
	    JLabel N = new JLabel("You want to generate the Fibonacci sequence up to what number?");
	    JLabel error = new JLabel("");
	    JLabel fbnLabel = new JLabel("");
	    JTextField userTextField = new JTextField();
	    JTextArea fbnTextField = new JTextArea();
	    JButton btn = new JButton("Generate");
		
	    FibonacciFinder()
	    {
			// Adding to container
			setLayoutManager();
			setLocationAndSize();
			addComponentsToContainer();
			addActionEvent();
			addKeyEvent();
	    }
	 
		public void setLayoutManager()
		{
			
			// Container creation
			container.setLayout(null);
		}
		
		public void setLocationAndSize()
		{
			// Bounding the location and size of the objects in the container
			N.setBounds(60,10,400,40);
		    userTextField.setBounds(170,41,60,20);
		    fbnTextField.setBounds(65,100,360,80);
		    fbnTextField.setLineWrap(true);
		    fbnLabel.setBounds(60,70,400,40);
		    btn.setBounds(230,40,90,20);
		    error.setBounds(60,50,260,40);
		    // Setting the color of the error label
		    error.setForeground(new java.awt.Color(255,0,0));
		    fbnTextField.setVisible(false);
		    fbnTextField.setEditable(false);
		}
		
		public void addComponentsToContainer()
		{
			
			// Puts the objects in the container
			container.add(N);
		    container.add(userTextField);
		    container.add(fbnTextField);
		    container.add(btn);
		    container.add(error);
		    container.add(fbnLabel);
		    
		}
		
		public void addActionEvent()
		{
			// Creates the button listener
			btn.addActionListener(this); 
		}
		
		public void addKeyEvent()
		{
			// Creates the enter key listener
			userTextField.addActionListener(this); 
		}
		
	    @Override
	    public void actionPerformed(ActionEvent e) 
	    {
	    	// If the btn is clicked resets "Calculated PI" and "PI to the Nth decimal" and the error labels
	    	// and calls createPI function
	    	if (e.getSource() == btn || e.getSource() == userTextField) {
	        	error.setText("");
	        	fbnTextField.setVisible(false);
	        	fbnLabel.setText(""); // Resets the label
	        	createFibonacci();
	        	userTextField.setText(""); // Resets the text field
	        }
	    	
	    }
	
	    private void createFibonacci() {

	    	int N, sec, last, next;
	    	boolean validInput = true;
	    	
	    	N = sec = next = 0;
	    	last = 1;
			
	    	String fbnSequence = "0, 1";
	    	
	        try {
	            N = Integer.parseInt(userTextField.getText());
	        } catch(NumberFormatException nfe) {        	
	        	error.setText("The value \"" + userTextField.getText() +"\" is not a valid integer");
	        	validInput = false;
	        }
	        
	        if (N < 0) {
	        	error.setText("The value \"" + userTextField.getText() +"\" "
	        			+ "is not a valid positive integer");
	        	validInput = false;
	        }
	        
	        if (validInput) {
	        	fbnLabel.setText("The Fibonacci sequence up to " + N + " (or closest to):");
	        	fbnTextField.setVisible(true);
	        	
	        	if (N == 0) {
	        		fbnSequence = "0";
	        	}
	        	else {
	        		
	        		while (last + sec <= N) {
	        			// TODO: proximidade (Ex: 12 deve imprimir até 13, mas 10 deve imprimir até 8)
	        			next = last + sec;
	        			sec = last;
	        			last = next;
	        			fbnSequence += ", " + next;	        			
	        			
	        		}
	        		
	        		fbnTextField.setText(fbnSequence);
	        		
	        	}
	        	
	        }	        
	        
		}

	    public static void main(String[] args) {
		
		FibonacciFinder frame=new FibonacciFinder(); // Creates a new frame
        frame.setTitle("NthPI"); // Sets the title
        frame.setVisible(true); // Makes the frame visible
        frame.setBounds(10,10,500,250); // Defines the bounds of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programs closes when exits
        frame.setResizable(false); // And the program its not resizable

	}

}
