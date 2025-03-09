package view;

import controller.CardGameController;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.CardFaceManager;
import model.CardManager;
import model.PlayingCard;

/**
 * The CardGameView class represents the view of the card game application.
 * The class is implemented using JavaFX,
 * and it provides a graphical user interface for the card game.
 * The cards are PNG images, and the card images are stored in the resources folder.
 *
 * @author Johannes Nupen Theigen
 * @version 0.0.3
 * @since 03.09.2025
 */
public class CardGameView extends Application {

  private CardGameController controller; // The controller of the card game application
  private CardManager cardManager; // The card manager of the card game application
  private CardFaceManager cardFaceManager; // The card face manager of the card game application
  private Logger logger; // The logger of the card game application
  private Label sumLabel; // The sum of the face values of the playing cards in the hand
  private Label heartsLabel; // The number of hearts in the hand
  private Label flushLabel; // The flush status of the hand
  private Label queenLabel; // The queen of spades status of the hand
  private HBox cardPane; // The pane for displaying the playing cards in the hand

  /**
   * The main method of the CardGameView class used to launch the graphical user interface.
   *
   * @param args The command-line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * The start method of the CardGameView class which is used to set up the
   * graphical user interface. The method creates a border pane layout with a card pane,
   * an information pane, and a button pane. The method also creates a scene with the layout
   * and sets the primary stage of the application.
   *
   * @param primaryStage The primary stage of the application
   */
  @Override
  public void start(Stage primaryStage) {
    try {
      cardManager = new CardManager();
      controller = new CardGameController(cardManager, this);
      cardFaceManager = new CardFaceManager();
      logger = Logger.getLogger(CardGameView.class.getName());

      BorderPane borderPane = new BorderPane();

      Image backgroundImage = new Image(Objects.requireNonNull(getClass()
          .getResource("/application-background.jpg")).toExternalForm()); // Background image

      BackgroundImage background = new BackgroundImage(
          backgroundImage,
          BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
          BackgroundPosition.CENTER,
          new BackgroundSize(100, 100, true, true, false, true)
      );

      borderPane.setBackground(new Background(background));
      borderPane.setMaxWidth(300);
      borderPane.setPrefWidth(100);

      VBox leftBox = new VBox(10, createCardPane(), createInfoPane());
      leftBox.setPadding(new Insets(20));
      borderPane.setLeft(leftBox);

      VBox rightBox = new VBox(createButtonPane());
      rightBox.setPadding(new Insets(50, 20, 0, -50));
      borderPane.setRight(rightBox);

      Scene scene = new Scene(borderPane, 800, 600);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Card Game");
      primaryStage.show();
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Unexpected error in start(): ", e);
    }
  }

  /*
   * The createCardPane method is used to create a pane
   * for displaying the playing cards in the hand.
   */
  private HBox createCardPane() {
    cardPane = new HBox(10);
    cardPane.setAlignment(Pos.CENTER);
    cardPane.setPrefSize(500, 200);
    return cardPane;
  }

  /*
   * The createButtonPane method is used to create a pane for displaying
   * the buttons for dealing a hand and checking the hand.
   */
  private VBox createButtonPane() {
    VBox buttonPane = new VBox(20);
    buttonPane.setPrefSize(300, 250);
    buttonPane.setAlignment(Pos.CENTER);
    buttonPane.setPadding(new Insets(100, 50, 0, 0));

    Button dealHandButton = createStyledButton("Deal Hand");
    dealHandButton.setOnAction(e -> controller.dealHand());

    Button checkHandButton = createStyledButton("Check Hand");
    checkHandButton.setOnAction(e -> controller.checkHand());


    buttonPane.getChildren().addAll(dealHandButton, checkHandButton);
    return buttonPane;
  }

  /*
   * The createStyledButton method is used to create a button with a specific style.
   */
  private Button createStyledButton(String text) {
    Button button = new Button(text);
    button.setPrefSize(150, 50);
    button.setStyle("-fx-font-size: 20px; -fx-font-family: 'Garamond';"
        + " -fx-background-color: #2d6a4f; -fx-text-fill: black;");
    return button;
  }

  /*
   * The createInfoPane method is used to create a pane for displaying information about the hand.
   */
  private GridPane createInfoPane() {
    GridPane infoPane = new GridPane();
    infoPane.setPadding(new Insets(15));
    infoPane.setHgap(40);
    infoPane.setVgap(15);

    sumLabel = new Label("0"); // Default value for the sum of the face values
    heartsLabel = new Label("No"); // Default value for the number of hearts
    flushLabel = new Label("No"); // Default value for the flush status
    queenLabel = new Label("No"); // Default value for the queen of spades status

    HBox sumPane = createInfoRow("Sum:", sumLabel);
    HBox heartsPane = createInfoRow("Hearts:", heartsLabel);
    HBox flushPane = createInfoRow("Flush:", flushLabel);
    HBox queenPane = createInfoRow("Queen of Spades:", queenLabel);

    infoPane.add(sumPane, 0, 0);
    infoPane.add(heartsPane, 1, 0);
    infoPane.add(flushPane, 0, 1);
    infoPane.add(queenPane, 1, 1);

    return infoPane;
  }

  /**
   * The createInfoRow method is used to create a row with a label and a value label.
   * The method creates an HBox layout with a label and a value label, and returns the layout.
   *
   * @param labelText  The text of the label
   * @param valueLabel The value label
   * @return The info row layout
   */
  private HBox createInfoRow(String labelText, Label valueLabel) {
    HBox row = new HBox(10);
    row.setAlignment(Pos.CENTER_LEFT);
    row.setPadding(new Insets(5, 10, 5, 10));

    Text label = new Text(labelText);
    label.setStyle("-fx-font-size: 25px; -fx-font-family:"
        + " 'Poppins'; -fx-fill: white;");

    valueLabel.setPrefSize(140, 50);
    valueLabel.setAlignment(Pos.CENTER);
    valueLabel.setStyle("-fx-font-size: 20px; -fx-font-family: 'Garamond'; "
        + " -fx-background-color: #2d6a4f; -fx-text-fill: white; -fx-border-color: black;");

    row.getChildren().addAll(label, valueLabel);
    return row;
  }

  /**
   * The updateInfoPane method is used to update the information
   * pane with the sum of the face values,
   * the number of hearts, the flush status, and the queen of spades status of the hand.
   *
   * @param sum              the sum of the face values
   * @param hearts           the number of hearts
   * @param hasFlush         the flush status
   * @param hasQueenOfSpades the queen of spades status
   */
  public void updateInfoPane(int sum, List<String> hearts,
                             boolean hasFlush, boolean hasQueenOfSpades) {
    sumLabel.setText(String.valueOf(sum));
    heartsLabel.setText(hearts.isEmpty() ? "No" : String.join(", ", hearts));
    flushLabel.setText(hasFlush ? "Yes" : "No");
    queenLabel.setText(hasQueenOfSpades ? "Yes" : "No");
  }

  /**
   * The updateCardPane method is used to update the card pane with the playing cards in the hand.
   * The method clears the card pane and adds image views of the playing cards to the pane by
   * interacting with the card manager and the card face manager.
   */
  public void updateCardPane() {
    try {
      cardPane.getChildren().clear();

      for (Iterator<PlayingCard> it = cardManager.getHand().getCardsOnHand(); it.hasNext(); ) {
        PlayingCard card = it.next();
        Image image = cardFaceManager.getCardImage(card);
        if (image != null) {
          cardPane.getChildren().add(createCardImageView(image));
        }
      }
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Unexpected error in updateCardPane(): ", e);
    }
  }

  /*
   * The createCardImageView method is used to create an image view of a playing card.
   */
  private ImageView createCardImageView(Image image) {
    ImageView imageView = new ImageView(image);
    imageView.setFitWidth(100);
    imageView.setFitHeight(150);
    return imageView;
  }
}