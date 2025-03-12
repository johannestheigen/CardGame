package controller;

import java.util.stream.Stream;

import model.CardManager;
import view.CardGameView;

/**
 * The CardGameController class represents the controller of the card game application.
 * It for interacting with the CardManager and CardGameView classes to connect
 * logic and view together.
 *
 * @author Johannes Nupen Theigen
 * @version 0.0.3
 * @since 03.12.2025
 */
public class CardGameController {
  private final CardManager cardManager;
  private final CardGameView cardGameView;

  /**
   * Creates an instance of a CardGameController object with a card manager and a card game view.

   * @param cardManager The card manager of the card game application which
   *                    is used to manage the deck of playing cards and the hand of playing cards
   * @param cardGameView The card game view of the card game application
   *                     which is used to display the graphical user interface
   */
  public CardGameController(CardManager cardManager, CardGameView cardGameView) {
    this.cardManager = cardManager;
    this.cardGameView = cardGameView;
  }

  /**
   * Draws a hand of playing cards from the deck of playing
   * cards and adds them to the hand of playing cards,
   * and updates the card pane in the card game view.
   */
  public void dealHand()  {
    cardManager.drawCards(5);
    cardGameView.updateCardPane();
  }

  /**
   * Checks the hand of playing cards for the following:
   * - The sum of the face values of the playing cards in the hand
   * - The number of hearts in the hand
   * - The flush status of the hand
   * - The queen of spades status of the hand.
   */
  public void checkHand() {
    int sum = cardManager.calculateSumOfCardsOnHand();
    Stream<String> hearts = cardManager.checkIfHandContainsHearts();
    boolean hasFlush = cardManager.checkIfHandContainsFlush();
    boolean hasQueenOfSpades = cardManager.checkIfHandContainsSpadeAndQueen();
    cardGameView.updateInfoPane(sum, hearts, hasFlush, hasQueenOfSpades);
  }
}