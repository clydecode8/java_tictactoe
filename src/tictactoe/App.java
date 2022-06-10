package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App extends JFrame implements ActionListener {
    
    int player_turn;
    int error = 0;
    int cont = 0;
    
    JPanel panel;
    JPanel panel2;
    JButton[] button;
    JTextField text;
    
    ImageIcon imgX = new ImageIcon("X.png");
    ImageIcon imgO = new ImageIcon("O.png");
    
    App(){
        
        text = new JTextField("Tic Tac Toe!");
        text.setSize(new Dimension(400,1000));
        text.setHorizontalAlignment(JTextField.CENTER);
        text.setFont(new Font("Times New Roman", Font.BOLD, 50));
        text.setForeground(Color.green);
        text.setBackground(Color.black);
        text.setBorder(null);
        
        panel2 = new JPanel();
        panel2.add(text);
        panel2.setBackground(Color.black);
        panel2.setOpaque(true);
        
        button = new JButton[9];
        panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));
        
        for (int i=0; i<button.length; i++){
            
            button[i] = new JButton();
            button[i].addActionListener(this);
            button[i].setEnabled(false);
            button[i].setBackground(Color.black);
            button[i].setFont(new Font("Times New Roman",Font.BOLD, 50));
            panel.add(button[i]);
            
        }
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(1000,1000);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.add(panel2, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        
        turn();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (JButton button1 : button){
            
            check(); //Check Wins
            
            if(e.getSource() == button1){
                
                if(player_turn == 1){
                    
                    if(error == 0){
                        
                        button1.setIcon(imgX);
                        button1.setText("X");
                        button1.setEnabled(false);
                        button1.setBackground(new Color(51, 107, 135));
                        player_turn = 0;
                        text.setText("O turn!"); 
                    }
                        
                }else{
                        
                    if(error == 0){

                        button1.setIcon(imgO);
                        button1.setText("O");
                        button1.setEnabled(false);
                        button1.setBackground(new Color(144, 175, 197));
                        player_turn = 1;
                        text.setText("X turn!");
                    }
                    
                }
            }
        }
    }
    
    public void turn(){
        
        Random rand = new Random();
        
        int player_random = rand.nextInt(2); //Range from 0 to 1
        
        try{
            Thread.sleep(5000);           
        }catch(InterruptedException ex){
            System.out.println("Error");
        }
        
        if(player_random == 0){
            
            player_turn = 1;
            text.setText("X turn first!");
            
        }else{
            
            player_turn = 0;
            text.setText("O turn first!");            
        }
        
        for (JButton buttonEnable : button){
            
            buttonEnable.setEnabled(true);
            buttonEnable.setBackground(Color.gray);
        }
        
    }
    
    public void check(){
        
    //X Wins---------------------------------        
          
        if((button[0].getText() == "X") && (button[1].getText() == "X") && (button[2].getText() == "X")){
        
            xWins(0, 1, 2);
        
        }
        
        if((button[3].getText() == "X") && (button[4].getText() == "X") && (button[5].getText() == "X")){
            
            xWins(3, 4, 5);
        }
        
        if((button[6].getText() == "X") && (button[7].getText() == "X") && (button[8].getText() == "X")){
            
            xWins(6, 7, 8);
        }
        
        if((button[0].getText() == "X") && (button[3].getText() == "X") && (button[6].getText() == "X")){
            
            xWins(0, 3, 6);
        }     
        
        if((button[1].getText() == "X") && (button[4].getText() == "X") && (button[7].getText() == "X")){
            
            xWins(1, 4, 7);
        }
        
        if((button[2].getText() == "X") && (button[4].getText() == "X") && (button[8].getText() == "X")){
            
            xWins(2, 4, 8);
        } 
        
        if((button[0].getText() == "X") && (button[4].getText() == "X") && (button[8].getText() == "X")){
            
            xWins(0, 4, 8);
        } 
        
        if((button[2].getText() == "X") && (button[4].getText() == "X") && (button[6].getText() == "X")){
            
            xWins(2, 4, 6);
        }
        
    // O Wins --------------------------------------------------------------       
        
        
        if((button[0].getText() == "O") && (button[1].getText() == "O") && (button[2].getText() == "O")){
        
            oWins(0, 1, 2);
        
        }
        
        if((button[3].getText() == "O") && (button[4].getText() == "O") && (button[5].getText() == "O")){
            
            oWins(3, 4, 5);
        }
        
        if((button[6].getText() == "O") && (button[7].getText() == "O") && (button[8].getText() == "O")){
            
            oWins(6, 7, 8);
        }
        
        if((button[0].getText() == "O") && (button[3].getText() == "O") && (button[6].getText() == "O")){
            
            oWins(0, 3, 6);
        }     
        
        if((button[1].getText() == "O") && (button[4].getText() == "O") && (button[7].getText() == "O")){
            
            oWins(1, 4, 7);
        }
        
        if((button[2].getText() == "O") && (button[4].getText() == "O") && (button[8].getText() == "O")){
            
            oWins(2, 4, 8);
        } 
        
        if((button[0].getText() == "O") && (button[4].getText() == "O") && (button[8].getText() == "O")){
            
            oWins(0, 4, 8);
        } 
        
        if((button[2].getText() == "O") && (button[4].getText() == "O") && (button[6].getText() == "O")){
            
            oWins(2, 4, 6);
        }     
    }
    
    public void xWins(int a, int b, int c) {
        
        for(int k = 0; k<9 ; k++){
            
            button[k].setEnabled(false);
            button[k].setBackground(Color.gray);
      
        }
        
        text.setText("X WON!!!");
        button[a].setBackground(new Color(124, 223, 124));
        button[b].setBackground(new Color(124, 223, 124));
        button[c].setBackground(new Color(124, 223, 124));
        
    }
    
    public void oWins(int a, int b, int c){
        
        for(int k = 0; k<9 ; k++){
            
            button[k].setEnabled(false);
            button[k].setBackground(Color.gray);
      
        }
        
        text.setText("O WON!!!");      
        button[a].setBackground(new Color(124, 223, 124));
        button[b].setBackground(new Color(124, 223, 124));
        button[c].setBackground(new Color(124, 223, 124));
        
    }        
        
}
