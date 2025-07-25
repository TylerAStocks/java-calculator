package userinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField display;
	private String operand1;
	private String operator;
	protected String operand2;
	protected double result;
	
	boolean resultVisible = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		display = new JTextField();
		display.setFont(new Font("Rockwell", Font.PLAIN, 24));
		display.setColumns(10);
		
		JPanel buttonPanel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 426, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(display, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(display, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
					.addGap(16)
					.addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
		);
		buttonPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit( e.getActionCommand());
			}
		});
		buttonPanel.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit( e.getActionCommand());
			}
		});
		buttonPanel.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit( e.getActionCommand());
			}
		});
		buttonPanel.add(btn9);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperator( e.getActionCommand());
			}
		});
		buttonPanel.add(btnDiv);
		
		JButton btnErase = new JButton("Del");
		btnErase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// remove last character on display:
				String tmp = display.getText();
				if (tmp.length()>1) // if there is more than 1 character
				    display.setText( tmp.substring(0, tmp.length()-1) );
				else // otherwise just make display empty
				    display.setText("");
			}
		});
		buttonPanel.add(btnErase);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit( e.getActionCommand());
			}
		});
		buttonPanel.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit( e.getActionCommand());
			}
		});
		buttonPanel.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit( e.getActionCommand());
			}
		});
		buttonPanel.add(btn6);
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperator( e.getActionCommand());
			}
		});
		buttonPanel.add(btnMul);
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				setOperator( e.getActionCommand());
			}
		});
		buttonPanel.add(btnClear);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit( e.getActionCommand());
			}
		});
		buttonPanel.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit( e.getActionCommand());
			}
		});
		buttonPanel.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit( e.getActionCommand());
			}
		});
		buttonPanel.add(btn3);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperator( e.getActionCommand());
			}
		});
		buttonPanel.add(btnPlus);
		
		JButton btnNewButton_13 = new JButton("");
		buttonPanel.add(btnNewButton_13);
		
		JButton btnPlusMin = new JButton("+/-");
		btnPlusMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get first character of the text on display
				String tmp = display.getText();
				char first = tmp.charAt(0);
				//if first character is a minus sign, remove that
				if (first == '-') display.setText(tmp.substring(1, tmp.length()));
				//else, add a minus sign
				else display.setText("-"+tmp);
			}
		});
		buttonPanel.add(btnPlusMin);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit( e.getActionCommand());
			}
		});
		buttonPanel.add(btn0);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n = display.getText(); // get the text on the display
				if (n.contains(".")) return; // if it already contains a "." skip rest of this method
				processDigit( e.getActionCommand());
			}
		});
		buttonPanel.add(btnDot);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperator( e.getActionCommand());
			}
		});
		buttonPanel.add(btnMinus);
		
		JButton btnEq = new JButton("=");
		btnEq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operand2 = display.getText();
				double o1 = Double.parseDouble(operand1);
				double o2 = Double.parseDouble(operand2);
				
				if (operator == "+") result = o1 + o2;
				else if (operator == "-") result = o1 - o2;
				else if (operator == "*") result = o1 * o2;
				else if (operator == "/") result = o1 / o2;
				display.setText(""+result);
				clear();
				resultVisible = true;
			}
		});
		buttonPanel.add(btnEq);
		contentPane.setLayout(gl_contentPane);

	}

	protected void setOperator(String actionCommand) {
		operand1 = display.getText(); //store the first number entered in a variable
		operator = actionCommand;
		display.setText("");
		
	}

	protected void processDigit(String actionCommand) {
		if (resultVisible == true) {
		    //clear the display
			display.setText(actionCommand);
		    //set resultVisible to false
			resultVisible = false;
		} else {
			display.setText( display.getText() + actionCommand );
		}
		
	}
	
	protected void clear() {
		operand1 = "";
		operand2 = "";
		operator = "";
	}
	
}
