import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

//GUI designed by Wishy Parikh.
//Netid: wparik2



/*----------------------------------HEADER-------------------------------------------------- 
*		 GUI contains two parts. Upper Part as Input and lower part as Output.

		Input: For input, there are 7 buttons and one textfield area.
    	User must type the commands like "North", "Brass key".etc in textfield
    	corresponding to that button. 
    	For example for input 'GO NORTH', type 'NORTH in textfield area and then
    	pressed GO. By doing this, the result is updated in output screen.
    	
    	For look, inventory and exit, just clicked on either of the buttons.

		Output: For output, there is one big textboxarea. It contains intial current information,
     prompt message for making move, and lastly the result output after move.
    

		Designs: Frame is GridLayout Design implemented by use of buttons,panels,labels etc.
		
		Note: Please don't try to do multiple inputs for one single move because it won't work properly after that. Be very precise in
		       doing the input. For example, typing beside the GET button, and pressing on USE button, then it will be messed up.
		

* 
*----------------------------------THANK YOU--------------------------------------------------*/



public class GUI_2  implements ActionListener, UserInterface
{
	

	 private String getData;   
    // private static textfield= new ArrayList < JTextField > (4);   // Four textfields for four different commands.
	 private static JTextArea area;
	 private int Flag;
	 private JFrame myFrame;
	 private static String buttonText;
	 JTextField temp = new  JTextField();
	 
	

	
	// Default constructor creates the GUI.
	public GUI_2() 
	{
		Flag = 0;	
		getData= "temp";
		buttonText= "null";
		
		JButton option1 = new JButton("LOOK");
        JButton option2 = new JButton("INVENTORY");
        JButton option3 = new JButton("EXIT");
        
        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        
        JRadioButton selectedButton = null;

    
        
		String [] buttonLabels = { "GET", "GO", "USE", "DROP"};

		myFrame = new JFrame ();              
		
		Panel p1,p2, p3;
		p1= new Panel ( new GridLayout ( 5,2, 5,5));
		p2 = new Panel  ( new FlowLayout ( FlowLayout.LEFT, 5,5));
	
		myFrame.setLayout ( new GridLayout (1,1));
		

		
		JLabel in, io;
		JButton b;
		
//		in= new JLabel ("Input");
//		in.setFont(new Font("Serif", Font.CENTER_BASELINE, 26));
//		in.setForeground(Color.RED);
//	      // create a line border with the specified color and width
//		 Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
//		 in.setBorder(border);
//		
//		myFrame.add((in));
		myFrame.add((p1));
		
		 Font bigFont = temp.getFont().deriveFont(Font.CENTER_BASELINE, 42);
         temp.setFont(bigFont);
		p1.add(temp);
		
		ButtonGroup group1 = new ButtonGroup();
		p3 = new Panel  ( new FlowLayout ( FlowLayout.LEFT, 5,5));
		for ( int i= 0; i<4 ; i++)
		{
			b= new JButton ( buttonLabels[i]);
			//JTextField temp = new  JTextField();
			
			
			//textfield.add( temp);

			b.addActionListener(this);		
			
			//b.setSize(2,1);
			group1.add(b);
			p3.add(b);
			//p1.add(textfield.get(i));	
		}
		
		
		
		
		p1.add(p3);
	
		
		
		p3.add (option1 );
		p3.add (option2 );
		p3.add (option3 );
		
		
		io= new JLabel ("Output");
		io.setFont(new Font("TimesRoman", Font.CENTER_BASELINE, 26));
//		io.setForeground(Color.cyan);
//	     // create a line border with the specified color and width
//		Border border2 = BorderFactory.createLineBorder(Color.red, 3);
//		io.setBorder(border2);
		
		 area= new JTextArea(20, 60);
		p2.add(area);
		
	
		
		p2.add((io));
		myFrame.add((p2));
		



		
		myFrame.setSize (400, 640);
		myFrame.setVisible (true);
		myFrame.setTitle ("Player");
		
	
		
	
		
		myFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
				
			}
		});
		
		
	}
	

    


	// Updates the output in GUI.
	public void display(String output) 
	{
	
		area.append(output);

	
		
	}

	// Takes the input action done in GUI.
	public String getLine()
	{
	   
	    

		
		while(true)
		{
			System.out.print("");
			
			if(Flag == 1)
			{
				System.out.println(" ");
				Flag = 0;
				//System.out.println();
				return getData;
			}
		
		}

		// TODO Auto-generated method stub

	}





	@Override
	public void actionPerformed(ActionEvent ae) 
	{

		
		// TODO Auto-generated method stub
		String button=ae.getActionCommand();

		
		
//		System.out.println("Name of button: " + button);
//		
//		for ( int i=0; i < textfield.size(); i++)
//		{
//			  if(!(textfield.get(i).getText().isEmpty()))
//			  {
//				  
//					//System.out.println("TextSSSS is  "+  textfield.get(i).getText());
//					getData = button + " " + textfield.get(i).getText();
//					textfield.get(i).setText("");
//					break;
//			  }
//			  else
//			  {
//				//	System.out.println("Text is  "+  buttonText);
//				    getData = button;
//				//    System.out.println("Text is  "+   button);
//			  }
//		}

		getData = button + " " + temp.getText();
		
		Flag =1;
	
		
	}
	
	
	public void playerName ( Character me)
	{
		myFrame.setTitle(me.getName());
	}
	
	public void cleartext()
	{
		area.setText("");
	}

}
