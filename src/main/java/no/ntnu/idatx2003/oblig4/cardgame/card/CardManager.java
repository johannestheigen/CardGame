package no.ntnu.idatx2003.oblig4.cardgame.card;

/**
 * The CardManager class represents a manager for a deck of playing cards and a hand of playing
 * cards. The class is implemented using the DeckOfCards and DeckHand classes and it enables
 * the two classes to interact with each other. The class provides methods for dealing a hand of
 * playing cards, shuffling the deck of playing cards, calculating the sum of the face values of the
 * playing cards in the hand, checking if the hand contains a heart, checking if the hand contains a
 * spade and a queen, and checking if the hand contains a flush.

 * @author Johannes Nupen Theigen
 * @version 0.0.1
 * @since 03.07.2025
 */
public class CardManager {

  private final DeckOfCards deck;
  private final DeckHand hand;

  /**
   * Initializes a new CardManager object with a deck of playing cards and an empty hand of playing
   * cards.
   */
  public CardManager() {
    deck = new DeckOfCards(); // The deck of playing cards
    hand = new DeckHand(); // The hand of playing cards
  }

  /**
   * Draws playing cards from the deck and adds them to the hand. The number of playing cards to

   * @param n the number of playing cards to draw (e.g. 5)
   * @throws IllegalArgumentException if there are not enough playing cards in the deck
   */
  public void drawCards(int n) {

    if (deck.getCardCount() < n) {
      throw new IllegalArgumentException("Not enough cards in the deck");
    }
    hand.clearHand();
    for (int i = 0; i < n; i++) {
      hand.addCard(deck.drawCard());
    }
  }

  /**
   * Shuffles the deck of playing cards in a
   * random sequence. (e.g. S12, H5, D9, C3 ...)
   */
  public void shuffleDeck() {
    deck.shuffle();
  }

  /**

   * Calculates the sum of the face values of the playing cards in the hand. (e.g. H5, S12 = 17)

   * @return the sum of the face values of the playing cards in the hand
   */
  public int calculateSumOfCardsOnHand() {
    return hand.calculateSumOfCards();
  }


  /**
   * Checks if the hand contains a heart card. (e.g. H5)

   * @return true if the hand contains a heart card, false otherwise
   */
  public boolean checkIfHandContainsHearth() {
    return hand.isHeart();
  }


  /**
   * Checks if the hand contains a spade card with face value 12 (Queen).

   * @return true if the hand contains a spade card with face value 12 (Queen), false otherwise
   */
  public boolean checkIfHandContainsSpadeAndQueen() {
    return hand.isSpadeAndQueen();
  }


  /**
   * Checks if the hand contains a flush. A flush is when all the playing cards in the hand
   * have the same suit (e.g. H5, H12, H3, H7, H9).

   * @return true if the hand contains a flush, false otherwise
   */
  public boolean checkIfHandContainsFlush() {
    return hand.isFlush();
  }
}