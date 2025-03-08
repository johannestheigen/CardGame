package model;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;

/**
 * The CardFaceManager class represents a manager for the card face
 * images of a deck of playing cards.
 * It stores the images associated with the card faces in a map and
 * provides a method for retrieving the image of a specific card face.
 * The class is implemented using the HashMap and Image libraries.
 *
 * @author Johannes Nupen Theigen
 * @version 0.0.1
 * @since 03.08.2025
 */
public class CardFaceManager {

  private final Map<String, Image> cardFaceImages;

  /**
   * Creates an instance of a CardFaceManager loaded with 52 unique
   * face images of a deck of playing cards by invoking the loadCardFaceImages method.
   */
  public CardFaceManager() {
    cardFaceImages = new HashMap<>(); // Stores the card face images
    loadCardFaceImages();
  }

  /**
   * Loads the card face images of a deck of playing cards into the cardFaceImages map.
   * The card face images are stored in the resources folder of the project.
   * The card face images are named according to the following convention: "suit" + "rank" + ".png".
   */
  public void loadCardFaceImages() {
    for (String suit : new String[]{"H", "D", "S", "C"}) {
      for (int i = 1; i <= 13; i++) {
        String cardName = suit + i;
        String path = "/cards/" + cardName + ".png";
        Image image = loadImage(path);
        cardFaceImages.put(cardName, image);
      }
    }
  }

  /**
   * Loads an image from a given path.

   * @param path the path to the image to be loaded.
   * @return the image loaded from the given path.
   * @throws IllegalArgumentException if the image could not be loaded from the given path.
   */
  private Image loadImage(String path) {
    InputStream stream = getClass().getResourceAsStream(path);
    if (stream == null) {
      throw new IllegalArgumentException("Error: Could not load image from path: " + path);
    }
    return new Image(stream);
  }

  /**
   * Returns the image of a specific card face.

   * @param card the card whose image is to be retrieved.
   * @return the image of the card face.
   */
  public Image getCardImage(PlayingCard card) {
    return cardFaceImages.get(card.getAsString());
  }
}