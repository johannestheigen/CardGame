package no.ntnu.idatx2003.oblig4.cardgame;

import no.ntnu.idatx2003.oblig4.cardgame.card.DeckOfCards;
import no.ntnu.idatx2003.oblig4.cardgame.card.PlayingCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DeckOfCardsTest contains test cases for the DeckOfCards class. The test cases
 * are used to test the expected behavior when creating a DeckOfCards object, and
 * when calling its methods generateDeck, shuffle, drawCard, and getCardCount.
 * The test cases are structured using the Arrange, Act and Assert (AAA)
 * pattern to structure the test methods. The setDeck, getCards, and clearDeck
 * methods are not tested as they are used when testing the other methods.
 */
class DeckOfCardsTest {

  DeckOfCards deck;

  /**
   * Sets up the test environment before each test method.
   * Initializes the deck object with 52 playing Cards.
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

  /**
   * Positive test case for the shuffle method.
   * The expected behavior is that the deck is shuffled.
   * Test case generated with the help of ChatGPT.
   */
  @Test
  void ShuffleExpectedBehaviorTest() {
    List<PlayingCard> originalOrder = deck.getCards();
    deck.shuffle();
    List<PlayingCard> shuffledOrder = deck.getCards();
    assertNotEquals(originalOrder, shuffledOrder, "Deck should be shuffled");
  }

  /**
   * Negative test case for the shuffle method. The expected behavior is that
   * the method throws a null pointer exception because the deck is null.
   */
  @Test
  void shuffleNullCardsTest() {
    deck.setDeck(null);
    assertThrows(NullPointerException.class, () -> deck.shuffle(), "Should throw IllegalStateException when deck is null");
  }

  /**
   * Negative test case for the shuffle method. The expected behavior is that
   * the method throws an illegal state exception because the deck is empty.
   */
  @Test
  void shuffleEmptyDeckTest() {
    deck.clearDeck();
    assertThrows(IllegalStateException.class, () -> deck.shuffle(), "Should throw IllegalStateException when deck is empty");
  }

  /**
   * Positive test case for the drawCard method. The expected behavior is that
   * the method draws a card from the deck and that the deck has one less card.
   */
  @Test
  void drawCardExpectedBehaviorTest() {
    PlayingCard card = deck.drawCard();
    assertNotNull(card, "Should return a card");
    assertEquals(51, deck.getCards().size(), "Deck should have one less card after drawing");
  }

  /**
   * Negative test case for the drawCard method. The expected behavior is that
   * the method throws an illegal state exception because the deck is empty.
   */
  @Test
  void drawCardEmptyDeckTest() {
    deck.clearDeck();
    assertThrows(IllegalStateException.class, () -> deck.drawCard(), "Should throw IllegalStateException when deck is empty");
  }

  /**
   * Positive test case for the getCardCount method. The expected behavior is that
   * the method returns the number of cards in the deck.
   */
  @Test
  void getCardCountTest() {
    assertEquals(52, deck.getCardCount(), "Deck should have 52 cards");
  }
}