/* GUIs!!!

JLabel 

Border Layout 

<	North		  >
<West><Center<East>
<	South		  >

January 7th, 2015
Alex Rupp-Coppi

*/ 

import java.awt.*; 
import javax.swing.*;
import java.util.ArrayList; 
import java.awt.event.*; 


public class CelsiusFahrenheit implements ActionListener { // actionlistener is an interface - need to implement it
	
	private JButton buttonToF;
	private JButton buttonToC; 
	private JLabel  labelCelsius;
	private JLabel  labelFahrenheit; 
	private JTextField fieldCelsius; 
	private JTextField fieldFahrenheit; 
	private BackgroundPanel panelLogo; 
	private GridLayout appLayout; 
	private JPanel buttonStack; 

	private ArrayList<JComponent> componentList; // buttons and text fields are children of components 

	public static void main(String[] args) {
		new CelsiusFahrenheit(); 
	}

	/*public void addComponents(Container container) { // can't control layout using this method, so don't use it
		for (int i = 0; i < componentList.size(); i++) {
			container.add(componentList.get(i));
		}
	}*/ // <-- Scratch this, not practical for this project -->

	public void actionPerformed(ActionEvent e) {
		double i;
		int j;
		
		if (e.getSource() == buttonToC) { 
			i = (double) Integer.parseInt(fieldFahrenheit.getText()); 
			j = (int) (0.55556*(i-32)); // 5/9 = c. 0.55556
			fieldCelsius.setText(""+j);  
		}
		else if (e.getSource() == buttonToF) { 
			i = (double) Integer.parseInt(fieldCelsius.getText()); 
			j = (int) ((1.8*i)+32); // 9/5 = 1.8; converting fractions to decimals solved problem - maybe I screwed up PEMDAS? 
			fieldFahrenheit.setText(""+j); 
		}

	}

	// constructor
	public CelsiusFahrenheit() {
		
		componentList = new ArrayList<JComponent>(); 
		appLayout = new GridLayout(2,3); 

		labelCelsius = new JLabel("Celsius");
		labelFahrenheit = new JLabel("Fahrenheit"); 
		
		fieldCelsius = new JTextField("0");

		buttonToC = new JButton("<--"); // Layout: C <-> F 
		buttonToF = new JButton("-->");
		buttonStack = new JPanel(); 
		
		fieldFahrenheit = new JTextField("32"); 

		panelLogo = new BackgroundPanel("tempconverter.png");

		buttonToC.addActionListener(this);
		buttonToF.addActionListener(this);

		JFrame frame = new JFrame("Celsius to Fahrenheit Converter"); // each JFrame is its own window 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(340,240));
		Container contents = frame.getContentPane(); // add all the buttons to the pane
		
		buttonStack.setLayout(new BorderLayout());
		buttonStack.add(buttonToF, BorderLayout.NORTH);
		buttonStack.add(buttonToC, BorderLayout.SOUTH);


		// add to panels first
		//panelNorth.add(labelCelsius);
		//panelNorth.add(labelFahrenheit);

		//panelSouth.add();

		contents.setLayout(appLayout);

		// row 1
		contents.add(labelCelsius);
		contents.add(panelLogo); 
		contents.add(labelFahrenheit);

		// row 2
		contents.add(fieldCelsius);
		contents.add(buttonStack);
		contents.add(fieldFahrenheit);

		frame.pack(); // automatically resize all elements to look good
		frame.setVisible(true);// by default, frame isn't visible

	}
}
