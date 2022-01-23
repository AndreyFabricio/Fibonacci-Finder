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
	    JButton btn = new JButton("Generate");
	    JTextField userTextField = new JTextField();
	    JTextArea fbnTextField = new JTextArea();
		
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
		    fbnTextField.setLineWrap(true); // Allows auto line breaks inside fbnTextField
		    fbnTextField.setVisible(false); // To be visible later
		    fbnTextField.setEditable(false); // User can copy but cannot edit the content
		    btn.setBounds(270,60,90,20);
		    error.setBounds(60,70,400,40);
		    error.setForeground(new java.awt.Color(255,0,0)); // Sets the color of the error label
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
	    	// If the btn is clicked resets "error" and "userTextField"
	    	// and calls createFibonacci function
	    	if (e.getSource() == btn || e.getSource() == userTextField) {
	        	error.setText("");
	        	fbnTextField.setVisible(false);
	        	createFibonacci();
	        	userTextField.setText(""); // Resets the text field
	        }
	    	
	    }
	
	    private void createFibonacci() {
    		
    		int pos = 2; // Stores the position in the Fibonacci sequence
    		
    		// Fibonacci calculation: Fn = F(n-1) + F(n-2)
    		// N -> User input
    		// sec -> First term in Fibonacci calculation "F(n-1)"
    		// last -> Second term in Fibonacci calculation "F(n-2)"
    		// next -> Third (next) term in Fibonacci calculation "Fn"
    		// and so on...
	    	long N, sec, last, next;
	    	
	    	boolean validInput = true; // User input is valid as default
	    	
	    	N = sec = next = 0;
	    	last = 1;
			
	    	String tempFbn = "0, 1"; // Stores the generated Fibonacci sequence
	    	String fbnSequence = ""; // Stores the final text with the Fibonacci sequence
	    	
	        try {
	            N = Long.parseLong(userTextField.getText()); // Pass user input to Long
	        } catch(NumberFormatException nfe) {        	
	        	error.setText("The value \"" + userTextField.getText() +"\" is not valid");
	        	validInput = false; // Error makes input invalid
	        }
	        
	        if (N < 0) {
	        	error.setText("The value \"" + userTextField.getText() +"\" "
	        			+ "is not a valid positive number");
	        	validInput = false; // Error makes input invalid
	        }
	        
	        if (validInput) {
	        	
	        	// The text box is visible only if the user input is valid
	        	fbnTextField.setVisible(true);
	        	
	        	if (N == 0) {
	        		// This is an exception that the program handles
	        		// If the user puts 0 as input the program can skip to the end
	        		fbnSequence = ("0 is in the Fibonacci sequence\n"
		    	    		+ "0 it's in position 1 of the Fibonacci sequence\n\n"
		    	    		+ "The Fibonacci sequence up to " + N + " (or closest to):\n");
	        		
	        		fbnSequence += "0";
	        	}
	        	
	        	else if (N == 1) {
	        		// This is another exception that the program handles
	        		// If the user puts 1 as input the program can skip to the end
	        		fbnSequence = ("1 is in the Fibonacci sequence\n"
		    	    		+ "1 it's in position 2 and 3 of the Fibonacci sequence\n\n"
		    	    		+ "The Fibonacci sequence up to " + N + " (or closest to):\n");
	        		
	        		fbnSequence += "0, 1, 1";
	        		
	        	}
	        	
	        	else {	
	        		// 7540113804746346429L is the max value that the program can handle with longs
	        		// and will be treated later on the program
	        		// The while runs until reachs the value chosen by the user
	        		while (last + sec <= N && last + sec < 7540113804746346429L) {
	        			// Basic Fibonacci algorithm
	        			next = last + sec;
	        			sec = last;
	        			last = next;
	        			tempFbn += ", " + next; // Stores the Fibonacci sequence 
	        			pos++; // Stores the position	        			
	        		}	      
	        		
	        		if ((last + sec) - N < N - last && N != 7540113804746346429L) {
	        			// If the value chosen by the user is closer to the next value
	        			// of the Fibonacci sequence, the next value is stored
	        			tempFbn += ", " + (last + sec);
	        			// Stores the text indicating that the value is not in the Fibonnaci sequence
	        			fbnSequence = (N + " is not in the Fibonacci sequence\n\n"
			    	    		+ "The Fibonacci sequence up to the value closest to " + N + ":\n\n");
	        			
	        		}	        		
	        		else if (last == N) {
	        			// Stores the text indicating that the value is in the Fibonnaci sequence
	        			fbnSequence = (N + " is in the Fibonacci sequence\n"
			    	    		+ N + " it's in position " + pos + " of the Fibonacci sequence\n\n"
			    	    		+ "The Fibonacci sequence up to " + N + ":\n\n");	
	        			
	        		}
	        		else if (N == 7540113804746346429L) {
	        			// Adds 7540113804746346429 to the sequence
	        			// This stores the last possible value with longs
	        			// ands prevents bugs (negatives numbers in the sequence, strange numbers, and so on)
	        			tempFbn += ", " + (last + sec);
	        			// Stores the text indicating that 7540113804746346429 is in the Fibonnaci sequence
	        			fbnSequence = (N + " is in the Fibonacci sequence\n"
			    	    		+ N + " it's in position " + (pos+1) + " of the Fibonacci sequence\n\n"
			    	    		+ "The Fibonacci sequence up to " + N + ":\n\n");
	        		}
	        		else {
	        			// Stores the text indicating that the value is not in the Fibonnaci sequence
	        			fbnSequence = (N + " is not in the Fibonacci sequence\n\n"
			    	    		+ "The Fibonacci sequence up to the value closest to " + N + ":\n\n");
	        		}
	        		
	        		fbnSequence += tempFbn;
	        		
	        	}
	        	        		
        		fbnTextField.setText(fbnSequence); // Puts the text in the text box for the user
	        	
	        }	        
	        
		}

	    public static void main(String[] args) {
		
		FibonacciFinder frame=new FibonacciFinder(); // Creates a new frame
        frame.setTitle("Fibonacci Finder"); // Sets the title
        frame.setVisible(true); // Makes the frame visible
        frame.setBounds(10,10,500,600); // Defines the bounds of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programs closes when exits
        frame.setResizable(false); // And the program its not resizable

	}

}
