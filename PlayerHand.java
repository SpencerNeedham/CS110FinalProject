/**
   Spencer Needham
   CS 110
   The PlayerHand class represnts a players portion of the deck (hand) in a game of war.
*/
import java.util.ArrayList;

public class PlayerHand
{
   private ArrayList <Card> hand;//Array list that will hold the players cards
   private Card card;//A card object 
   private final int STARTING_CARDS = 25;//Number of cards to start with in the array
   /**
      This constructor initializes a deck (hand) of cards for the player.
   */
   public PlayerHand()
   {
      hand = new ArrayList<Card>(STARTING_CARDS);
   }   
   
   /**
      The addCard method adds a card object to the players portion of the deck.
      @param card The card being added to the players portion of the deck
   */
   public void addCard (Card card)
   {
      hand.add(0,card);
   }
   
   /**
      The deal method deals a card from the top of the player's deck.
      @return The card object on top of the deck
   */
   public Card deal ()
   {
      return  hand.remove(hand.size()-1);
   }
   
   /**
      The getRemaining method returns the number of cards left in the player's deck.
      @return The number of cards left in the player's deck (hand)
   */
   public int getRemaining ()
   {
      return hand.size();
   }    
   
}      