package no.ntnu.idatx2003.oblig4.cardgame;

import no.ntnu.idatx2003.oblig4.cardgame.card.model.PlayingCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PlayingCardTest contains test cases for the PlayingCard class. The test cases
 * are used to test the expected behavior when creating a PlayingCard object, and
 * when calling the methods getAsString, getSuit, getFace, equals and hashCode.
 * The test cases are structured using the Arrange, Act and Assert (AAA)
 * pattern to structure the test methods.
 */
class PlayingCardTest {

  /**
   * Positive test case when creating PlayingCard objects with valid suit and face values.
   * The expected behavior is that no exceptions are thrown.
   */
  @Test
  void initializePlayingCardValidTest() {
    assertDoesNotThrow(() -> new PlayingCard('H', 1));
    assertDoesNotThrow(() -> new PlayingCard('D', 7));
    assertDoesNotThrow(() -> new PlayingCard('C', 13));
    assertDoesNotThrow(() -> new PlayingCard('S', 10));
  }

  /**
   * Negative test case when creating PlayingCard objects with invalid suits.
   * The expected behavior is that an IllegalArgumentException is thrown.
   */
  @Test
  void initializePlayingCardInvalidSuitTest() {
    assertThrows(IllegalArgumentException.class, () -> new PlayingCard('R',1));
    assertThrows(IllegalArgumentException.class, () -> new PlayingCard('L', 2));
    assertThrows(IllegalArgumentException.class, () -> new PlayingCard('Z', 3));
    assertThrows(IllegalArgumentException.class, () -> new PlayingCard('P', 4));
  }

  /**
   * Negative test case when creating PlayingCard objects with invalid face values.
   * The expected behavior is that an IllegalArgumentException is thrown.
   */
  @Test
  void initializePlayingCardInvalidFaceTest() {
    assertThrows(IllegalArgumentException.class, () -> new PlayingCard('H',0));
    assertThrows(IllegalArgumentException.class, () -> new PlayingCard('D', 14));
  }

  /**
   * Positive test case for the getAsString method. The expected behavior is that
   * the method returns a string with the suit and face of the card.
   */
  @Test
  void getAsStringExpectedBehaviorTest() {
    PlayingCard playingCard = new PlayingCard('H', 4);
    assertEquals("H4", playingCard.getAsString());
  }

  /**
   * Positive test case for the getSuit methods. The expected behavior is that
   * the methods return the suit of the card.
   */
  @Test
  void getSuitExpectedBehaviorTest() {
    PlayingCard playingCard = new PlayingCard('H', 4);
    assertEquals('H', playingCard.getSuit());
  }

  /**
   * Positive test case for the getFace methods The expected behavior is that
   * the methods return the face of the card.
   */
  @Test
  void getFaceExpectedBehaviorTest() {
    PlayingCard playingCard = new PlayingCard('H', 4);
    assertEquals(4, playingCard.getFace());
  }

  /**
   * Positive test case for the equals method. The expected behavior is that
   * the method returns true when comparing two PlayingCard objects with the same
   * suit and face values.
   */
  @Test
  void testEqualsExpectedBehaviorTest() {
    PlayingCard card1 = new PlayingCard('H', 4);
    PlayingCard card2 = new PlayingCard('H', 4);
    assertEquals(card1, card2);
  }

  /**
   * Positive test case for the equals method. The expected behavior is that
   * the method return true when comparing the same PlayingCard object.
   */
  @Test
  void testEqualsSameObject() {
    PlayingCard card = new PlayingCard('H', 4);
    assertEquals(card, card);
  }

  /**
   * Positive test case for the equals method. The expected behavior is that
   * the method returns false when comparing a PlayingCard object with another
   * object type.
   */
  @Test
  void testEqualsDifferentObject() {
    PlayingCard card = new PlayingCard('H', 4);
    assertNotEquals(card, new Object());
  }

  /**
   * Positive test case for the equals method. The expected behavior is that
   * the method returns false when comparing a PlayingCard object with a
   * PlayingCard object that is initialized as
   */
  @Test
  void testEqualsNullObject() {
    PlayingCard card1 = new PlayingCard('H', 4);
    PlayingCard card2 = null;
    assertNotEquals(card1, card2);
  }

  /**
   * Positive test case for the equals method. The expected behavior is that
   * the method returns false when comparing two PlayingCard objects with
   * different suit values.
   */
  @Test
  void testEqualsOtherSuit() {
    PlayingCard card1 = new PlayingCard('H', 4);
    PlayingCard card2 = new PlayingCard('S', 4);
    assertNotEquals(card1, card2);
  }

  /**
   * Positive test case for the equals method. The expected behavior is that
   * the method returns false when comparing two PlayingCard objects with
   * different face values.
   */
  @Test
  void testEqualsOtherFace() {
    PlayingCard card1 = new PlayingCard('H', 4);
    PlayingCard card2 = new PlayingCard('H', 5);
    assertNotEquals(card1, card2);
  }

  /**
   * Positive test case for the hashCode method. The expected behavior is that
   * the method returns the same hash code for two PlayingCard objects with the
   * same suit and face values.
   */
  @Test
  void testHashCode() {
    PlayingCard card1 = new PlayingCard('H', 4);
    PlayingCard card2 = new PlayingCard('H', 4);
    assertEquals(card1.hashCode(), card2.hashCode());
  }
}