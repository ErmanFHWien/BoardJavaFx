package at.ac.fhcampuswien.boardjavafx;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
public class BoardJavaFx {
    private static final int GRID_SIZE = 10;
    private Game game;  // Instance of your Game class
    private Player currentPlayer;  // Current player
    private Button[][] playerButtons = new Button[GRID_SIZE][GRID_SIZE];
    private VBox root;
    private GridPane boardGrid = new GridPane();
    private Label promptLabel = new Label("Player 1's Turn");
    private Stage primaryStage;  // Stage to display the game

    public BoardJavaFx (Stage primaryStage, Game game) {
        this.primaryStage = primaryStage;
        this.game = game;
        this.currentPlayer = game.getPlayerOne();  // Assuming getPlayerOne() method exists in Game
        setupUI();
    }

    private void setupUI() {
        primaryStage.setTitle("Battleship Game");
        initializeGrid();
        root = new VBox(10, promptLabel, boardGrid);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeGrid() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Button button = new Button();
                button.setPrefSize(30, 30);
                playerButtons[row][col] = button;
                boardGrid.add(button, col, row);

                int finalRow = row;
                int finalCol = col;
                button.setOnAction(e -> handleButtonClick(finalRow, finalCol));
            }
        }
    }

    private void handleButtonClick(int row, int col) {
        Coordinate coordinate = new Coordinate(col + 1, (char) ('A' + row));
        currentPlayer.playerTurn(coordinate);  // Assume playerTurn now takes a Coordinate
        switchTurn();
        updateBoardUI();
    }

    private void switchTurn() {
        // Switch the current player
        currentPlayer = currentPlayer.equals(game.getPlayerOne()) ? game.getPlayerTwo() : game.getPlayerOne();
        promptLabel.setText(currentPlayer.getPlayerName() + "'s Turn");
    }

    private void updateBoardUI() {
        // Update the UI based on the game board state
        // Use currentPlayer.getPlayerBoard() and currentPlayer.getOpponentBoard() methods
    }
}
