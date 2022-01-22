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
 * Last update: 22/01/2022
 */

public class FibonacciFinder extends JFrame implements ActionListener {
	
		// Labels creation
		Container container=getContentPane();
	    JLabel N = new JLabel("You want to generate the Fibonacci sequence up to what number?");
	    JLabel error = new JLabel("");
	    JLabel limit = new JLabel("Max value: 7540113804746346429");
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
			limit.setBounds(150,30,200,40);
		    userTextField.setBounds(130,61,140,20);
		    fbnTextField.setBounds(65,90,360,430);
		    fbnTextField.setLineWrap(true);
		    fbnTextField.setVisible(false);
		    fbnTextField.setEditable(false);
		    btn.setBounds(270,60,90,20);
		    error.setBounds(60,70,400,40);
		    // Setting the color of the error label
		    error.setForeground(new java.awt.Color(255,0,0));
		}
		
		public void addComponentsToContainer()
		{
			
			// Puts the objects in the container
			container.add(N);
		    container.add(userTextField);
		    container.add(fbnTextField);
		    container.add(btn);
		    container.add(error);
		    container.add(limit);
		    
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
	        	createFibonacci();
	        	userTextField.setText(""); // Resets the text field
	        }
	    	
	    }
	
	    private void createFibonacci() {
    		
    		int pos = 2;
	    	long N, sec, last, next;
	    	boolean validInput = true;
	    	
	    	N = sec = next = 0;
	    	last = 1;
			
	    	String tempFbn = "0, 1";
	    	String fbnSequence = "";
	    	
	        try {
	            N = Long.parseLong(userTextField.getText());
	        } catch(NumberFormatException nfe) {        	
	        	error.setText("The value \"" + userTextField.getText() +"\" is not valid");
	        	validInput = false;
	        }
	        
	        if (N < 0) {
	        	error.setText("The value \"" + userTextField.getText() +"\" "
	        			+ "is not a valid positive number");
	        	validInput = false;
	        }
	        
	        if (validInput) {
	        	fbnTextField.setVisible(true);
	        	
	        	if (N == 0) {
	        		
	        		fbnSequence = ("0 is in the Fibonacci sequence\n"
		    	    		+ "0 it's in position 1 of the Fibonacci sequence\n\n"
		    	    		+ "The Fibonacci sequence up to " + N + " (or closest to):\n");
	        		
	        		fbnSequence += "0";
	        	}
	        	
	        	else if (N == 1) {
	        		
	        		fbnSequence = ("1 is in the Fibonacci sequence\n"
		    	    		+ "1 it's in position 2 and 3 of the Fibonacci sequence\n\n"
		    	    		+ "The Fibonacci sequence up to " + N + " (or closest to):\n");
	        		
	        		fbnSequence += "0, 1, 1";
	        		
	        	}
	        	
	        	else {
	        		
	        		while (last + sec <= N && last + sec < 7540113804746346429L) {
	        			next = last + sec;
	        			sec = last;
	        			last = next;
	        			tempFbn += ", " + next;	  
	        			pos++;	        			
	        		}	      
	        		
	        		if ((last + sec) - N < N - last && N != 7540113804746346429L) {
	        			
	        			tempFbn += ", " + (last + sec);
	        			
	        			fbnSequence = (N + " is not in the Fibonacci sequence\n\n"
			    	    		+ "The Fibonacci sequence up to the value closest to " + N + ":\n\n");
	        			
	        		}	        		
	        		else if (last == N) {
	        		
	        			fbnSequence = (N + " is in the Fibonacci sequence\n"
			    	    		+ N + " it's in position " + pos + " of the Fibonacci sequence\n\n"
			    	    		+ "The Fibonacci sequence up to " + N + ":\n\n");	
	        			
	        		}
	        		else if (N == 7540113804746346429L) {
	        			tempFbn += ", " + (last + sec);
	        			fbnSequence = (N + " is in the Fibonacci sequence\n"
			    	    		+ N + " it's in position " + (pos+1) + " of the Fibonacci sequence\n\n"
			    	    		+ "The Fibonacci sequence up to " + N + ":\n\n");
	        		}
	        		else {
	        			fbnSequence = (N + " is not in the Fibonacci sequence\n\n"
			    	    		+ "The Fibonacci sequence up to the value closest to " + N + ":\n\n");
	        		}
	        		
	        		fbnSequence += tempFbn;
	        		
	        	}
	        	        		
        		fbnTextField.setText(fbnSequence);
	        	
	        }	        
	        
		}

	    public static void main(String[] args) {
		
		FibonacciFinder frame=new FibonacciFinder(); // Creates a new frame
        frame.setTitle("NthPI"); // Sets the title
        frame.setVisible(true); // Makes the frame visible
        frame.setBounds(10,10,500,600); // Defines the bounds of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programs closes when exits
        frame.setResizable(false); // And the program its not resizable

	}

}
