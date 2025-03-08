package view;

import java.util.Objects;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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

/**
 * The CardGameView class represents the view of the card game application.
 * The class is implemented using JavaFX,
 * and it provides a graphical user interface for the card game.
 *
 * @author Johannes Nupen Theigen
 * @version 0.0.1
 * @since 03.07.2025
 */
public class CardGameView extends Application {

  private Label sumLabel; // The sum of the face values of the playing cards in the hand
  private Label heartsLabel; // The number of hearts in the hand
  private Label flushLabel; // The flush status of the hand
  private Label queenLabel; // The queen of spades status of the hand

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
   * graphical user interface.

   * @param primaryStage The primary stage of the application
   */
  @Override
  public void start(Stage primaryStage) {
    BorderPane borderPane = new BorderPane();

    Image backgroundImage = new Image(Objects.requireNonNull(getClass()
        .getResource("/application-background.jpg")).toExternalForm());

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
  }

  /**
   * The createCardPane method is used to create a pane
   * for displaying the playing cards in the hand.

   * @return The card pane layout
   */
  private HBox createCardPane() {
    HBox cardPane = new HBox(10);
    cardPane.setAlignment(Pos.CENTER);
    cardPane.setPrefSize(500, 500);
    cardPane.setStyle("-fx-border-color: black; "
        + "-fx-border-width: 3px; -fx-background-color: transparent;");
    return cardPane;
  }

  /**
   * The createButtonPane method is used to create a pane for
   * displaying buttons for dealing a hand, checking the hand, and shuffling the deck.

   * @return The button pane layout
   */
  private VBox createButtonPane() {
    VBox buttonPane = new VBox(20);
    buttonPane.setPrefSize(300, 250);
    buttonPane.setAlignment(Pos.CENTER);
    buttonPane.setPadding(new Insets(100, 50, 0, 0));

    Button dealHandButton = createStyledButton("Deal Hand");
    Button checkHandButton = createStyledButton("Check Hand");
    Button shuffleDeckButton = createStyledButton("Shuffle Deck");

    buttonPane.getChildren().addAll(dealHandButton, checkHandButton, shuffleDeckButton);
    return buttonPane;
  }

  /**
   * The createStyledButton method is used to create a button with a specific style.

   * @param text The text of the button
   * @return The styled button
   */
  private Button createStyledButton(String text) {
    Button button = new Button(text);
    button.setPrefSize(150, 50);
    button.setStyle("-fx-font-size: 20px; -fx-font-family: 'Garamond';"
        + " -fx-background-color: #2d6a4f; -fx-text-fill: black;");
    return button;
  }

  /**
   * The createInfoPane method is used to create a pane for displaying information about the hand.

   * @return The info pane layout
   */
  private GridPane createInfoPane() {
    GridPane infoPane = new GridPane();
    infoPane.setPadding(new Insets(15));
    infoPane.setHgap(40);
    infoPane.setVgap(15);

    sumLabel = new Label("0");
    heartsLabel = new Label("0");
    flushLabel = new Label("No");
    queenLabel = new Label("No");

    HBox sumPane = createInfoRow("Sum of cards:", sumLabel);
    HBox heartsPane = createInfoRow("Number of hearts:", heartsLabel);
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

   * @param labelText The text of the label
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

    valueLabel.setPrefSize(60, 40);
    valueLabel.setAlignment(Pos.CENTER);
    valueLabel.setStyle("-fx-font-size: 20px; -fx-font-family: 'Garamond'; "
        + " -fx-background-color: #2d6a4f; -fx-text-fill: white; -fx-border-color: black;");

    row.getChildren().addAll(label, valueLabel);
    return row;
  }
}