package no.ntnu.idatx2003.oblig4.cardgame.card.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The DeckHand class represents a hand of playing cards.
 * The class is implemented using the List and
 * ArrayList libraries.

 * @author Johannes Nupen Theigen
 * @version 0.0.3
 * @since 03.07.2025
 */
public class DeckHand {

  private final List<PlayingCard> hand; // The hand of playing cards

  /**
   * Creates an instance of a DeckHand object with an empty hand of playing cards.
   */
  public DeckHand() {
    hand = new ArrayList<>();
  }

  /**
   * Adds a playing card to the hand. (e.g. H5)

   * @param card the playing card to add to the hand
   * @throws NullPointerException if the playing card is null
   */
  public void addCard(PlayingCard card) {
    if (card == null) {
      throw new NullPointerException("Playing card cannot be null");
    }
    hand.add(card);
  }

  /**
   * Removes all playing cards from the hand.
   */
  public void clearHand() {
    hand.clear();
  }

  /**
   * Calculates the sum of the face values of the playing cards in the hand.

   * @return the sum of the face values of the playing cards in the hand
   */
  public int calculateSumOfCards() {
    int sum = 0;
    for (PlayingCard card : hand) {
      sum += card.getFace();
    }
    return sum;
  }

  /**
   * Checks if the hand contains any playing cards.

   * @return true if the hand contains playing cards, false otherwise
   */
  public boolean hasCards() {
    return !hand.isEmpty();
  }

  /**
   * Checks if the hand contains a playing card with hearts as the suit.

   * @return true if the hand contains a playing card with hearts as the suit, false otherwise
   */
  public boolean isHeart() {
    return hand.stream().anyMatch(card -> card.getSuit() == 'H');
  }

  /**
   * Checks if the hand contains a playing card with spades as the suit and a face value of 12.

   * @return true if the hand contains a playing card
   *     with spades as the suit and a face value of 12, false otherwise
   */
  public boolean isSpadeAndQueen() {
    return hand.stream().anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
  }

  /**
   * Checks if the hand contains cards with the same suit. (e.g. all hearts)

   * @return true if the hand contains cards with the same suit, false otherwise
   */
  public boolean isFlush() {
    if (hand.size() < 5) {
      return false;
    }
    return hand.stream().allMatch(card -> card.getSuit() == hand.getFirst().getSuit());
  }
}