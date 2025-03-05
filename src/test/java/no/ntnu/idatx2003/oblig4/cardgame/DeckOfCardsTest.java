package no.ntnu.idatx2003.oblig4.cardgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DeckOfCardsTest {

  DeckOfCards deck;

  /**
   * Sets up the test environment before each test method.
   * Initializes the deck object with 52 playing cards.
   */

  @BeforeEach
  void setUp() {
    deck = new DeckOfCards();
  }

  /**
   * Positive test case for the generateDeck method. The expected behavior is that
   * the method returns false because the deck should already be generated in the constructor.
   */
  @Test
  void GenerateDeckFirstTimeTest() {
    DeckOfCards freshDeck = new DeckOfCards();
    assertFalse(freshDeck.generateDeck(), "Deck should already be generated in constructor");
  }

  /**
   * Positive test case for the generateDeck method. The expected behavior is that
   * the method returns false because the deck is already generated.
   */
  @Test
  void GenerateDeckMultipleTimesTest() {
    assertFalse(deck.generateDeck(), "Should return false when trying to generate deck again");
  }
}