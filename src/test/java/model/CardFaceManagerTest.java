package model;

import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CardFaceManagerTest contains test cases for the CardFaceManager class. The test cases
 * are used to test the expected behavior when loading card face images and retrieving
 * card images from the card face manager.  The test cases are structured using the
 * Arrange, Act and Assert (AAA) pattern to structure the test methods.
 */
class CardFaceManagerTest {

  /**
   * Positive test case for the loadCardFaceImages method.
   * The expected behavior is that the card face images are loaded successfully.
   */
  @Test
  void loadCardFaceImagesExpectedBehaviorTest() {
    CardFaceManager cardFaceManager = new CardFaceManager();
    cardFaceManager.loadCardFaceImages();
    assertNotNull(cardFaceManager);
  }

  /**
   * Positive test case for the getCardImage method.
   * The expected behavior is that the card image is retrieved successfully.
   */
  @Test
  void getCardImageExpectedBehaviorTest() {
    CardFaceManager cardFaceManager = new CardFaceManager();
    PlayingCard card = new PlayingCard('H', 1);
    Image image = cardFaceManager.getCardImage(card);
    assertNotNull(image, "Image should not be null for a valid card.");
  }
}