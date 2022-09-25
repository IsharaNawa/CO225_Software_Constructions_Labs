//E/17/219
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener{

	//interface related attributes
	private JButton [] myButtonSet = new JButton[9];
	private JLabel myLabel = new JLabel();
	
	//logic related attributes
	private int [][] myBoard = new int[3][3];
	private int nextPlayer=1;
	private int buttonFilled=0;
	
	//instantiating the GUI(GameBoard)
	public MyFrame (){
		
		this.setTitle("Tic Tac Toe");	//title of the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//closing operation
		this.setLocation(500, 400);	//open the frame in the middle of the screen
		this.setLayout(null);	//set the layout manager to be null
		this.setSize(210,240);//set the size of the frame
		this.setVisible(true);		//set the visibility of the frame to true
		
		//viewing+adding action listener for the button set
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				
				myButtonSet[3*row+col] = new JButton();		//new java button
				myButtonSet[3*row+col].setBounds(10+col*60, 10+60*row, 50, 50);		//setting bounds for the button
				this.add(myButtonSet[3*row+col]);		//including the button in the frame
				myButtonSet[3*row+col].addActionListener(this);		//adding action listener to handle events
				myButtonSet[3*row+col].setBackground(new Color(245, 66, 66));	//setting the button color
				myButtonSet[3*row+col].setBorder(BorderFactory.createBevelBorder(0));
			}
		}
	}
	
	//handling the event
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {	
			
			if(e.getSource()==myButtonSet[i]) {
				
				myButtonSet[i].setText(String.valueOf(nextPlayer));		//setting the number of the player on the button
				
				//printing the button
				myButtonSet[i].setFont(new Font(null,Font.BOLD,25));
				myButtonSet[i].setFocusable(false);
				myButtonSet[i].setEnabled(false);
				
				myBoard[i/3][i%3]=nextPlayer;		//adding the corresponding value to the array
				
				if(isWon()==1 || isWon()==2) {	//when there is a win situation
					
					this.Results(isWon());		//print the result
					break;		//break out from the loop
				}
				
				//after checking for the win,check for the draw
				if(buttonFilled==8) {	//if there is a draw,
					this.Results(0);	//print the result
					break;		//break out from the loop
				}
				
				buttonFilled++;//increment the buttonfilled variable
				
				//deciding what the next player is
				if(nextPlayer==1) {nextPlayer=2;}
				else {nextPlayer=1;}
				
			}
		}
	}
	
	//deciding if there is a win
	//if player1 won,1 is returned
	//if player2 won,2 is returned
	//otherwise 0 is returned
	public int isWon() {
		
		int output;
		
		//wining situations
		if(myBoard[0][0]*myBoard[0][1]*myBoard[0][2]==1) { output=1;return output;}
		else if(myBoard[1][0]*myBoard[1][1]*myBoard[1][2]==1) { output=1;return output;}
		else if(myBoard[2][0]*myBoard[2][1]*myBoard[2][2]==1) { output=1;return output;}
		
		else if(myBoard[0][0]*myBoard[1][0]*myBoard[2][0]==1) { output=1;return output;}
		else if(myBoard[0][1]*myBoard[1][1]*myBoard[2][1]==1) { output=1;return output;}
		else if(myBoard[0][2]*myBoard[1][2]*myBoard[2][2]==1) { output=1;return output;}
		
		else if(myBoard[0][0]*myBoard[1][1]*myBoard[2][2]==1) { output=1;return output;}
		else if(myBoard[0][2]*myBoard[1][1]*myBoard[2][0]==1) { output=1;return output;}
		
		 if(myBoard[0][0]*myBoard[0][1]*myBoard[0][2]==8) { output=2;return output;}
		else if(myBoard[1][0]*myBoard[1][1]*myBoard[1][2]==8) { output=2;return output;}
		else if(myBoard[2][0]*myBoard[2][1]*myBoard[2][2]==8) { output=2;return output;}
			
		else if(myBoard[0][0]*myBoard[1][0]*myBoard[2][0]==8) { output=2;return output;}
		else if(myBoard[0][1]*myBoard[1][1]*myBoard[2][1]==8) { output=2;return output;}
		else if(myBoard[0][2]*myBoard[1][2]*myBoard[2][2]==8) { output=2;return output;}
			
		else if(myBoard[0][0]*myBoard[1][1]*myBoard[2][2]==8) { output=2;return output;}
		else if(myBoard[0][2]*myBoard[1][1]*myBoard[2][0]==8) { output=2;return output;}
		
		//there is a draw
		else {return 0;}
		
	}
	
	//printing the wining results
	public void Results(int x) {
		
		JFrame result = new  JFrame();	//open a new frame
		result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//exit operation
		result.setLocation(700, 400);		//opening location of the screen
		result.setSize(450,250);	//setting the size of the frame
		result.setTitle("Results");		//setting the title of the frame
		
		//deciding if there is a win or not
		if(x==1||x==2) {this.myLabel.setText("Player "+x+ " won the match!Congragulations!");}
		else {this.myLabel.setText("The game is a Draw!");}
		
		//customizing the label
		myLabel.setHorizontalTextPosition(JLabel.CENTER);
		myLabel.setVerticalTextPosition(JLabel.CENTER);
		myLabel.setFont(new Font("Arial",Font.BOLD,20));
		myLabel.setForeground(new Color(11, 3, 252));
		
		result.add(myLabel);	//adding the label to the frame 
		result.setVisible(true);	//setting the frame to be visible
	}
	
	
}
