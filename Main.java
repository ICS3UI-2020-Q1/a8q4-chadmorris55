import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JLabel nLabel;
  JLabel factorialLabel;

  JTextField inputNumber;
  JTextField outputNumber;

  JButton startButton;

  JPanel mainPanel;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,200);
    // shows the window
    frame.setVisible(true);
    //initialize main panel with no layout
    mainPanel = new JPanel();
    mainPanel.setLayout(null);

    //initialize and set bounds of the labels
    nLabel = new JLabel("n");
    factorialLabel = new JLabel("factorial(n)");
    nLabel.setBounds(100,20,20,20);
    factorialLabel.setBounds(350,20,200,20);

    //initialize and set bounds of text fields, make second one uneditable
    inputNumber = new JTextField();
    outputNumber = new JTextField();
    inputNumber.setBounds(125,20,200,20);
    outputNumber.setBounds(500,20,200,20);
    outputNumber.setEnabled(false);

    //initialize and set bounds od the button
    startButton = new JButton("CALC");
    startButton.setBounds(700,20,75,20);
    //adds action listener and sets acion command
    startButton.setActionCommand("start");
    startButton.addActionListener(this);

    //add everything to the main panel then add main panel to the screen
    mainPanel.add(nLabel);
    mainPanel.add(factorialLabel);
    mainPanel.add(inputNumber);
    mainPanel.add(outputNumber);
    mainPanel.add(startButton);
    frame.add(mainPanel);
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if (command.equals("start")){   
    //gets text and converts it into an integer
    String nText = inputNumber.getText();
    int nNumber = Integer.parseInt(nText);
    //variables to create so the loop goes until it reaches the goal which is the inputted number and theres an accumulator which totals all the numbers
    int goal = nNumber;
    int total = 1;
    //loop that repeats until the count reaches the number inputted, and each time it loops it multiplies itself by the count
      for(int count = 1; count <= goal; count++){
        total = total * count;
      }
      //sets text of the factorial box to whatever the total was at the end of the loop
      outputNumber.setText("" + total);
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
