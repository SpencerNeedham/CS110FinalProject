/**
   Spencer Needham
   CS 110
   The guts of the game of War.
*/
import java.util.ArrayList;

public class War
{
   private Deck deck;//the deck of cards which the game is played from
   public PlayerHand ph1 = new PlayerHand();//player 1's hand
   public PlayerHand ph2 = new PlayerHand();//p2's hand
   public Card c1, c2;//The card player 1 and player 2 remove from the top of the deck
   public ArrayList <Card> warCards = new ArrayList <Card> (1);//Array list that will hold all the cards played in a war
   public int warWinner;//Used in the GUI to indicate who wins the war
   public boolean endGame;//True if the game is over
   public int winner;//Indicates the winner
   
   private final int P1_WIN = 1, P2_WIN = 2;//arbritrary values assigned to a p1 or p2 win
   private final int ARRAYLIST_DEFAULT = 1, NO_CARDS = 0;//default size of warCards and an integer representing no cards 
   
   
   /**
      This constructor creates a deck and shuffles it. Then the cards of the deck
      are distributed evenly between player 1 and player 2.
   */   
   public War()
   {
      deck = new Deck();//create a new deck of cards
      deck.shuffle();//shuffle the deck
      
      
      while (!deck.isEmpty())
      {
         ph1.addCard(deck.dealCard());
         ph2.addCard(deck.dealCard());
      }   
         
   }
   
   /**
      The play method deals a card to player 1 and a card to player 2. If there are
      no cards remaing in either one of the decks, the game stops and the winner
      is displayed.
   */
   public void play()
   {
      if (ph1.getRemaining() != 0 && ph2.getRemaining() != 0)
      {
         c1 = ph1.deal();
         c2 = ph2.deal();
         
      }
      else if (ph2.getRemaining() == 0)
      {
         endGame = true;
         winner = P1_WIN;
      }
      else if (ph1.getRemaining() == 0)
      {
         endGame = true;
         winner = P2_WIN;
      }     
         
   
   }
   
   /**
      The compare method compares the cards and the person who played the 
      card with higher rank wins both cards played. If the cards have the
      same rank, a war is initialized.
      @param c1 Player 1's card
      @param c2 Player 2's card
   */
   public void compare(Card c1, Card c2)
   {
      warWinner = NO_CARDS;
      
      if (c1.getRank() > c2.getRank())
      {
         for (int i = 0; i < warCards.size(); i++)//for each warCard in the array
         {
            ph1.addCard(warCards.get(i));
         }
         
         if (warCards.size() != 0)
         {
            warWinner = P1_WIN;
         }         
         
         ph1.addCard(c1);
         ph1.addCard(c2);
         
         warCards = new ArrayList <Card> (ARRAYLIST_DEFAULT);//set warCards back to an empty array 
      }
      else if (c1.getRank() < c2.getRank())
      {
         for (int i = 0; i < warCards.size();i++)//for each warCard in the array
         {
            ph2.addCard(warCards.get(i));
         }
         
         if (warCards.size() != 0)
         {
            warWinner = P2_WIN;
         }
         
         ph2.addCard(c1);
         ph2.addCard(c2);
         
         warCards = new ArrayList <Card> (ARRAYLIST_DEFAULT);//set warCards back to an empty array
      }
      
      else 
      {
         if (ph1.getRemaining() != 0 && ph2.getRemaining() != 0)
         {  
            war(c1, c2);
         }
         else if (ph2.getRemaining() == 0)
         {
            endGame = true;
            winner = P1_WIN;
         }
         else if (ph1.getRemaining() == 0)
         {
            endGame = true;
            winner = P2_WIN;
         }   
            
      }
   }            
      
   /**
      The war method simulates a "war" in the game.
      @param c1 Player 1's card
      @param c2 Player 2's card
   */
   public void war(Card c1, Card c2)
   {
      //add the cards to the beginning of the warCards array
      warCards.add(0,c1);
      warCards.add(0,c2);
      
      warCards.add(0,ph1.deal());//deal one card face down to p1 and add to the warCards array
      warCards.add(0,ph2.deal());//deal one card face down to p2 and add to the warCards array
      
      c1 = ph1.deal();//
      c2 = ph2.deal();
      compare(c1, c2);
   }
   
      
      
   //tester
   public static void main (String [] args)
   {
      War game = new War();
      System.out.println(game.ph1.getRemaining());
      System.out.println(game.ph2.getRemaining());
      System.out.println("-----------------");
      game.play();
      System.out.println(game.ph1.getRemaining());
      System.out.println(game.ph2.getRemaining());
      System.out.println("-----------------");
      game.play();
      System.out.println(game.ph1.getRemaining());
      System.out.println(game.ph2.getRemaining());
      System.out.println("-----------------");
      game.play();
      System.out.println(game.ph1.getRemaining());
      System.out.println(game.ph2.getRemaining());
      System.out.println("-----------------");
      game.play();
      System.out.println(game.ph1.getRemaining());
      System.out.println(game.ph2.getRemaining());
      System.out.println("-----------------");   
            
   }       
   
   
      
      
}   