import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

//GUI designed by Harshil Patel.
//Netid: hpate86


/*----------------------------------HEADER-------------------------------------------------- 
*		 GUI contains two parts. Upper Part as Input and lower part as Output.

		Input: For input, there are four buttons, 3 radio buttons and four textfield areas.
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


public class GUI_3  implements ActionListener, UserInterface
{
	
	 private String getData;   
     private static ArrayList<JTextField >  textfield= new ArrayList < JTextField > (4);   // Four textfields for four different commands.
	 private static JTextArea area;
	 private int Flag;
	 private JFrame myFrame;
	 private static String buttonText;
	 private JTextArea inputArea;

	 
	public GUI_3() 
	{
		Flag = 0;	
		getData= "xxx";
		buttonText= "null";
		Panel p1,p2, p3;
		p1= new Panel ( new GridLayout ( 5,2, 5,5));
		p2 = new Panel  ( new FlowLayout ( FlowLayout.LEFT, 5,5));
		
		myFrame = new JFrame ();   
		myFrame.setSize (600, 600);
		myFrame.getContentPane().setBackground(Color.BLACK);
		myFrame.setVisible ( true);
		myFrame.setTitle ("Player");
		myFrame.setLayout(new GridLayout());
		
		Button option1 = new Button("LOOK");
        Button option2 = new Button("INVENTORY");
        Button option3 = new Button("EXIT");
        
        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        p1.add(option1);
        p1.add(option2);
        p1.add(option3);
        
        JRadioButton selectedButton = null;

    

        
		String [] buttonLabels = { "GO", "GET", "DROP", "USE"};

		       
		
		
	
		//myFrame.setLayout ( new FlowLayout (FlowLayout.CENTER, 5,5));
		

		
		JLabel in, io;
		Button b;
		
		
		/*in= new JLabel ("Input");
		in.setFont(new Font("Kremlin", Font.LAYOUT_LEFT_TO_RIGHT, 26));
		in.setForeground(Color.BLACK);
	      // create a line border with the specified color and width
		 Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
		 in.setBorder(border);*/
		
		//myFrame.add((in));
		
		p3 = new Panel  ( new FlowLayout ( FlowLayout.LEFT, 5,5));
		for ( int i= 0; i<4 ; i++)
		{
			b= new Button ( buttonLabels[i]);
			JTextField temp = new  JTextField();
			
			textfield.add( temp);
			b.addActionListener(this);		
			b.setBackground(Color.blue);
			b.setForeground(Color.black);
			//b.setSize(3,1);
			p1.add( b);
			p1.add(textfield.get(i));
		}
		myFrame.add((p1));
		
		
		p1.add(p3);	
		
		p3.add (option1 );
		p3.add (option2 );
		p3.add (option3 );
		
		
	//	JButton b1= new JButton ( "X");
	//	myFrame.add(b1);
		
		/*io= new JLabel ("Output");
		io.setFont(new Font("Serif", Font.CENTER_BASELINE, 26));
		io.setForeground(Color.RED);
	     // create a line border with the specified color and width
		Border border2 = BorderFactory.createLineBorder(Color.BLUE, 3);
		io.setBorder(border2);*/
		
		 area= new JTextArea(40, 60);
		 //area.setAutoscrolls(true);
		 area.setBackground(Color.cyan);
		 p2.add(area);
		 myFrame.add(p2);
		
	//	p2.add(textfield);
		
		//myFrame.add((io));
		//myFrame.add((p2));
		
/*	    if ( option1 .isSelected()) {
            selectedButton =  option1 ;
        } else if ( option2.isSelected()) {
            selectedButton =  option2;
        } else if ( option3 .isSelected()) {
            selectedButton =  option3 ;
        }

        buttonText = selectedButton.toString();  */
		
	//	buttonText = getSelectedButtonText(group);
		


		
		
		
	
		//inputArea = new JTextArea(10,15);
		//myFrame.add(inputArea);
	
		
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
	//	area.setText( output);
		   
		//area.insert(output, 0);
		area.append(output);

	//	 System.out.println(" Welcome to GUI_1 interface");
		
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

		
		
		System.out.println("Name of button: " + button);
		
		for ( int i=0; i < textfield.size(); i++)
		{
			  if(!(textfield.get(i).getText().isEmpty()))
			  {
				  
					System.out.println("TextSSSS is  "+  textfield.get(i).getText());
					getData = button + " " + textfield.get(i).getText();
					textfield.get(i).setText("");
					break;
			  }
			  else
			  {
				//	System.out.println("Text is  "+  buttonText);
				    getData = button;
				//    System.out.println("Text is  "+   button);
			  }
		}

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
