package no.ntnu.idatx2003.oblig4.cardgame;

import no.ntnu.idatx2003.oblig4.cardgame.card.model.DeckHand;
import no.ntnu.idatx2003.oblig4.cardgame.card.model.PlayingCard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckHandTest {

  DeckHand deckHand;

  /**
   * Sets up the test environment before each test method.
   * Initializes the hand object with an empty hand of playing
   * cards.
   */
  @BeforeEach
  void setUp() {
    deckHand = new DeckHand();
  }

  /**
   * Tears down the test environment after each test method.
   */
  @AfterEach
  void tearDown() {
    deckHand = null;
  }

  /**
   * Positive test case that tests the expected behavior when adding a card to the hand.
   * The expected behavior is that the hand has cards after adding a card.
   */
  @Test
  void addCardExpectedBehaviorTest() {
    deckHand.addCard(new PlayingCard('H', 5));
    assertTrue(deckHand.hasCards(), "Hand should have cards after adding a card");
  }

  /**
   * Negative test case that tests the expected behavior when adding a null card to the hand.
   * The expected behavior is that a NullPointerException is thrown when adding a null card.
   */
  @Test
  void addNullCardTest() {
    assertThrows(NullPointerException.class, () -> deckHand.addCard(null));
  }

  /**
   * Positive test case that tests the expected behavior when clearing the hand.
   * The expected behavior is that the hand does not have cards after clearing the hand.
   */
  @Test
  void clearHandTest() {
    deckHand.addCard(new PlayingCard('H', 5));
    deckHand.clearHand();
    assertFalse(deckHand.hasCards(), "Hand should not have cards after clearing the hand");
  }

  /**
   * Positive test case that tests the expected behavior when calculating the sum of the cards in the hand.
   * The expected behavior is that the sum of the cards is calculated correctly.
   */
  @Test
  void calculateSumOfCardsTest() {
    deckHand.addCard(new PlayingCard('H', 5));
    deckHand.addCard(new PlayingCard('S', 12));
    assertEquals(17, deckHand.calculateSumOfCards(), "Sum of cards should be 17");
  }

  /**
   * Positive test case that tests the expected behavior when checking if the hand has cards.
   * The expected behavior is that the method returns true when the hand has cards.
   */
  @Test
  void isHeartTest() {
    deckHand.addCard(new PlayingCard('H', 5));
    assertTrue(deckHand.isHeart(), "Hand should contain a heart card");
  }

  /**
   * Positive test case that tests the expected behavior when checking if the hand has cards
   * that are hearts. The expected behavior is that the method returns false when the hand
   * does not contain a heart card.
   */
  @Test
  void isNotHeartTest() {
    deckHand.addCard(new PlayingCard('S', 5));
    assertFalse(deckHand.isHeart(), "Hand should not contain a heart card");
  }

  /**
   * Positive test case that tests the expected behavior when checking if the hand contains a spade card with face value 12 (Queen).
   * The expected behavior is that the method returns true when the hand contains a spade card with face value 12 (Queen).
   */
  @Test
  void isSpadeAndQueen() {
    deckHand.addCard(new PlayingCard('S', 12));
    assertTrue(deckHand.isSpadeAndQueen(), "Hand should contain a spade card with face value 12");
  }

  /**
   * Positive test case that tests the expected behavior when checking if the hand contains a spade card with face value 12 (Queen).
   * The expected behavior is that the method returns false when the hand does not contain a spade card with face value 12 (Queen).
   */
  @Test
  void isNotSpadeAndQueen() {
    deckHand.addCard(new PlayingCard('H', 5));
    assertFalse(deckHand.isSpadeAndQueen(), "Hand should not contain a spade card with face value 12");
  }

  /**
   * Positive test case that tests the expected behavior when checking if the hand contains a spade card with face value 12 (Queen).
   * The expected behavior is that the method returns false when the hand contains a spade card with a face value other than 12 (Queen).
   */
  @Test
  void isSpadeButNotQueen() {
    deckHand.addCard(new PlayingCard('S', 5));
    assertFalse(deckHand.isSpadeAndQueen(), "Hand should not contain a spade card with face value 12");
  }

  /**
   * Positive test case that tests the expected behavior when checking if the hand contains a flush.
   * The expected behavior is that the method returns true when the hand contains a flush.
   */
  @Test
  void isFlush() {
    deckHand.addCard(new PlayingCard('H', 5));
    deckHand.addCard(new PlayingCard('H', 12));
    deckHand.addCard(new PlayingCard('H', 1));
    deckHand.addCard(new PlayingCard('H', 10));
    deckHand.addCard(new PlayingCard('H', 3));
    assertTrue(deckHand.isFlush(), "Hand should contain a flush");
  }

  /**
   * Positive test case that tests the expected behavior when checking if the hand contains a flush.
   * The expected behavior is that the method returns false when the hand does not contain a flush.
   */
  @Test
  void isNotFlush() {
    deckHand.addCard(new PlayingCard('H', 5));
    deckHand.addCard(new PlayingCard('H', 12));
    deckHand.addCard(new PlayingCard('H', 1));
    deckHand.addCard(new PlayingCard('H', 10));
    deckHand.addCard(new PlayingCard('S', 3));
    assertFalse(deckHand.isFlush(), "Hand should not contain a flush");
  }

  /**
   * Positive test case that tests the expected behavior when checking if the hand contains a flush.
   * The expected behavior is that the method returns false when the hand does not contain enough cards for a flush.
   */
  @Test
  void isNotFlushAndDoesNotHaveEnoughCardsTest() {
    deckHand.addCard(new PlayingCard('H', 5));
    deckHand.addCard(new PlayingCard('H', 12));
    deckHand.addCard(new PlayingCard('H', 1));
    deckHand.addCard(new PlayingCard('H', 10));
    assertFalse(deckHand.isFlush(), "Hand should not contain a flush");
  }
}