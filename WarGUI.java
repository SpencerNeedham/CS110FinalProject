/**
   Spencer Needham
   CS 110
   GUI for War
*/

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;

public class WarGUI extends JFrame
{
   private War game;//The guts of the game
   private JPanel player1Cards, centerPlay, player2Cards;//break up into regions
   private JButton playButton;//grid of buttons
   private ImageIcon back, back2;//image of the back of a card
   private String card1File, card2File;//the .jpg name of the file that holds the image of each card
   private ImageIcon card1Image, card2Image;//the image of each of the players' cards
   private JLabel label, label2, label3,label4;//JLabel for holding card image
   private JLabel textLabel, textLabel2;//JLabel for displaying amount of cards remaining
   private JLabel winLabel;//for displaying winner of the round
   private JLabel warWinLabel;//for displaying winner of each war
   private int ROWS = 1;//number of rows for GridLayout
   private int COLUMNS = 4;//number of columns for GridLayout
   
   
   /**
      This constuctor builds the GUI for the game of war
   */
   public WarGUI()
   {
      //set the title
      setTitle("Game of War");
      
      //set the layout of the GUI
      setLayout(new GridLayout(ROWS,COLUMNS));
      
      //create an instance of the game
      game = new War();
      
      //Create panels
      player1Cards = new JPanel();
      player1Cards.setBackground(Color.GREEN);
      centerPlay = new JPanel();
      centerPlay.setLayout(new BorderLayout());
      centerPlay.setBackground(Color.BLUE);
      player2Cards = new JPanel();
      player2Cards.setBackground(Color.GREEN);
      
      
      
      
      //add panels to frame
      add(player1Cards);
      add(centerPlay);
      add(player2Cards); 
      
      
      //add a play button
      playButton = new JButton("Play");
      centerPlay.add(playButton,BorderLayout.NORTH);
      playButton.addActionListener(new ButtonListener()); 
      
      //add image icon of back of card to p1's panel
      back = new ImageIcon("cardpics/back.jpg");
      label = new JLabel(back);
      player1Cards.add(label);
      
      //add image icon of back of card to p2's panel
      back2 = new ImageIcon("cardpics/back.jpg");
      label2 = new JLabel(back2);
      player2Cards.add(label2);
      
      //Display cards remaining on player1's panel
      textLabel = new JLabel("Cards remaining in deck: " +game.ph1.getRemaining());//create label
      player1Cards.add(textLabel);//add to player1's panel
      //initialCardFlag = true;
      
      //Display cards remaining on player2's panel
      textLabel2 = new JLabel("Cards remaining in deck: " +game.ph2.getRemaining());//create label
      player2Cards.add(textLabel2);//add to player2's panel
      
      
       
   } 
   
   /**
      This ButtonListener class handles button events.
   */
   private class ButtonListener implements ActionListener
   {
      private boolean cardFlag1 = false;//true if there is a JLabel card (facing up) picture
      private boolean cardFlag2 = false;//true if there is a JLabel card (facing up) picture 
      private boolean winFlag = false;//true if there is a JLabel indicating the winner
      private boolean warWinFlag = false;//true if there is a JLabel indicating the war winner

      
       
      public void actionPerformed(ActionEvent e)
      {
         
         
         
            
         
         //if there is already a face up card for player 1, remove it
         if (cardFlag1 == true)
            player1Cards.remove(label3);
         
         //if there is already a face up card for player 2, remove it
         if (cardFlag2 == true)
            player2Cards.remove(label4);
            
         //Remove the displayed amount of cards from player1's panel
         player1Cards.remove(textLabel);
         
         //Remove the displayed amount of cards from player2's panel
         player2Cards.remove(textLabel2);  
         
         //remove the winlabel if there is already one there
         if (winFlag == true)
            centerPlay.remove(winLabel);
            
         //remove the warWinlabel if there is already one there
         if (warWinFlag == true)
         {
            centerPlay.remove(warWinLabel);
            warWinFlag = false;
         }      
            
            
          
         
         game.play();//deal a card to player 1 and player 2
         
         //the name of the imagefiles
         card1File = game.c1.imageName;
         card2File = game.c2.imageName;
         
         //add image of the card player 1 plays
         card1Image = new ImageIcon(card1File);//create new ImageIcon
         label3 = new JLabel(card1Image);//create label
         player1Cards.add(label3);//add to player1's panel
         cardFlag1 = true;//there IS a JLabel with card facing up
         
         //add image of the card player 2 plays
         card2Image = new ImageIcon(card2File);//create new ImageIcon
         label4 = new JLabel(card2Image);//create label
         player2Cards.add(label4);//add to player2's panel 
         cardFlag2 = true;//there IS a JLabel with card facing up
         
         //System.out.println(game.c1.getRank());
         //System.out.println(game.c2.getRank());
         
         //display who won the round on the center panel
         if (game.c1.getRank() > game.c2.getRank())
         {
            winLabel = new JLabel("Player 1 wins the round!");
            centerPlay.add(winLabel,BorderLayout.CENTER);
            winFlag = true;
         }
         else if (game.c1.getRank() < game.c2.getRank())
         {
            winLabel = new JLabel("Player 2 wins the round!");
            centerPlay.add(winLabel,BorderLayout.CENTER);
            winFlag = true;
         }
         else// if (game.c1.getRank() == game.c2.getRank())
         {
            winLabel = new JLabel("We have a tie. War!");
            centerPlay.add(winLabel,BorderLayout.CENTER);
            winFlag = true;
         }
         
         
         
         //compare the cards and see who wins
         game.compare(game.c1, game.c2);
         
         
         //If the game is over, display who won
         if (game.endGame == true)
         {
            if (game.winner == 1)
            {
               winLabel.setText("Player 1 wins!!!!!");
            }
            else if (game.winner == 2)
            {
               winLabel.setText("Player 2 wins!!!!!");
            }
         }   
               
         
         
         //Display cards remaining on player1's panel
         textLabel = new JLabel("Cards remaining in player 1's deck: " +game.ph1.getRemaining());//create label
         player1Cards.add(textLabel);//add to player1's panel
         
         //Display cards remaining on player2's panel
         textLabel2 = new JLabel("Cards remaining in player 2's deck: " +game.ph2.getRemaining());//create label
         player2Cards.add(textLabel2);//add to player2's panel
         
         
         //Display who won the war on the center panel
         if (game.warWinner == 1)
         {
            warWinLabel = new JLabel("Player 1 wins the war!");
            centerPlay.add(warWinLabel,BorderLayout.SOUTH);
            warWinFlag = true;
         }
         
         else if (game.warWinner == 2)
         {
            warWinLabel = new JLabel("Player 2 wins the war!");
            centerPlay.add(warWinLabel,BorderLayout.SOUTH);
            warWinFlag = true;
         }
         
         
         
         setVisible(true);
               
      }
      
   }      
   
   
   //main method (tester)
   public static void main(String [] args) 
   {
      JFrame frame = new WarGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frame.pack();
      frame.setVisible(true);
   }
}      
     