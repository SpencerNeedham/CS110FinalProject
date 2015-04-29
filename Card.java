/**
 Spencer Needham
 CS 110
 This Card class simulates a single playing card from a 52 card deck.
*/

public class Card
{
   //create constant variables for each card suit
   public final static int SPADES = 1;
   public final static int CLUBS = 2;
   public final static int HEARTS = 3;
   public final static int DIAMONDS = 4;
   
   //create constant variables for each card rank
   public final static int ACE = 1;
   public final static int JACK = 11;
   public final static int QUEEN = 12;
   public final static int KING = 13;
   
   
   private int rank;//the rank of the card
   private int suit;//the suit of the card
   private String suitName;//holds the name of the suit
   private String rankName;//holds the description of the rank
   
   public String imageName;//The name of the jpg card image
   
   /**
      This constructor sets the suit of the card and the rank of the card to the values 
      passed in as arguments.
      @param suit The card suit
      @param rank The card's rank
   */
   
   public Card (int suit, int rank)
   {
      this.suit = suit;
      this.rank = rank;
      setImage(suit, rank);
   }   
   
   /**
      The getSuit method returns the value of the suit of the card
      @return suit The card's suit
   */
   
   public  int getSuit ()
   {
      return suit;
   }
   
   /**
      The getRank method returns the value of the rank of the card
      @return rank The card's rank
   */
   
   public  int getRank ()
   {
      return rank;
   } 
   
   /**
      This toString method converts the suit from a number to an appropriate string and
      does the same for the rank.
      @return suitName The name of the cards suit
   */
   
   public String toString()
   {  
     switch (suit)//assign an appropriate string to suitName depending on the value of suit
     {
         case SPADES:
            suitName = "Spades";
            break;
         case CLUBS:
            suitName = "Clubs";
            break;
         case HEARTS:
            suitName = "Hearts";
            break;
         case DIAMONDS:
            suitName = "Diamonds";
            break;
         default: 
            suitName = null;
            break;
               
                
     }

     
     switch (rank)//assign an appropriate string to rankName depending on the value of rank
     {
         case ACE:
            rankName = "Ace";
            break;
         case 2:
            rankName = "Two";
            break;
         case 3:
            rankName = "Three";
            break;
         case 4:
            rankName = "Four";
            break;
         case 5:
            rankName = "Five";
            break;
         case 6:
            rankName = "Six";
            break;
         case 7:
            rankName = "Seven";
            break;
         case 8:
            rankName = "Eight";
            break;
         case 9:
            rankName = "Nine";
            break;
         case 10:
            rankName = "Ten";
            break;
         case JACK:
            rankName = "Jack";
            break;
         case QUEEN:
            rankName = "Queen";
            break; 
         case KING:
            rankName = "King";
            break;     
         default: 
            rankName = null;
            break;
                
     }
   
   return rankName + " of " + suitName + ".";
   
   }
   
   /**
      This equals method checks to see if two cards are equal, meaning 
      they have the same rank.
      @return status The status of whether the cards have the same rank 
   */
  
   public Card c1;
     
   public boolean equals(Card c2)
   {
      boolean status;
      
      if (c1.getRank()==c2.getRank())
         status = true;
      else
         status = false; 
         
      return status;     
   }
   
   /**
      This setImage method sets the image that corresponds with a certain card.
      @param s The suit as an integer
      @param r The rank as an integer 
   */
   
   public void setImage(int s, int r)
   {
      
      if (s == Card.SPADES)
      {  
         
         if (r == Card.ACE)
         {
            this.imageName = "cardpics/aces.jpg";
         }
         
         else if (r == Card.JACK)
         {
            this.imageName = "cardpics/jacks.jpg";
         }
         
         else if (r == Card.QUEEN)
         {
            this.imageName = "cardpics/queens.jpg";
         }
         
         else if (r == Card.KING)
         {
            this.imageName = "cardpics/kings.jpg";
         }
         
         else 
         {
            this.imageName = "cardpics/" + r + "s.jpg";
         }
         
      }
      
      else if (s == Card.CLUBS)
      {  
         
         if (r == Card.ACE)
         {
            this.imageName = "cardpics/acec.jpg";
         }
         
         else if (r == Card.JACK)
         {
            this.imageName = "cardpics/jackc.jpg";
         }
         
         else if (r == Card.QUEEN)
         {
            this.imageName = "cardpics/queenc.jpg";
         }
         
         else if (r == Card.KING)
         {
            this.imageName = "cardpics/kingc.jpg";
         }
         
         else 
         {
            this.imageName = "cardpics/" + r + "c.jpg";
         }
         
      }
      
      else if (s == Card.HEARTS)
      {  
         
         if (r == Card.ACE)
         {
            this.imageName = "cardpics/aceh.jpg";
         }
         
         else if (r == Card.JACK)
         {
            this.imageName = "cardpics/jackh.jpg";
         }
         
         else if (r == Card.QUEEN)
         {
            this.imageName = "cardpics/queenh.jpg";
         }
         
         else if (r == Card.KING)
         {
            this.imageName = "cardpics/kingh.jpg";
         }
         
         else 
         {
            this.imageName = "cardpics/" + r + "h.jpg";
         }
         
      }
      
      else if (s == Card.DIAMONDS)
      {  
         
         if (r == Card.ACE)
         {
            this.imageName = "cardpics/aced.jpg";
         }
         
         else if (r == Card.JACK)
         {
            this.imageName = "cardpics/jackd.jpg";
         }
         
         else if (r == Card.QUEEN)
         {
            this.imageName = "cardpics/queend.jpg";
         }
         
         else if (r == Card.KING)
         {
            this.imageName = "cardpics/kingd.jpg";
         }
         
         else 
         {
            this.imageName = "cardpics/" + r + "d.jpg";
         }
         
      }
   
   }        
        
   
}         
         
        
   