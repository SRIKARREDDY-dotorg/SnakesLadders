package org.pochana.manager;

import org.pochana.builder.BoardMetadata;
import org.pochana.builder.Player;
import org.pochana.playables.Board;
import org.pochana.playables.Dice;

public class BoardManager {
    private static volatile BoardManager boardManagerInstace;

    private static Board board = Board.getInstance();
    private static Dice dice = Dice.getInstance();

    private Player player;

    private BoardManager() {}

    public static BoardManager getInstance() {
        if (boardManagerInstace == null) {
            synchronized (BoardManager.class) {
                if (boardManagerInstace == null) {
                    boardManagerInstace = new BoardManager();
                }
            }
        }
        return boardManagerInstace;
    }

    public void playGame() {
        Player currentPlayer = null;
        while (!untilWinner()) {
            Integer diceValue = dice.rollDice();
            currentPlayer = board.getCurrentPlayer();
            player = currentPlayer;
            Integer currentPlayerPosition = currentPlayer.getPosition();
            Integer updatedPosition = currentPlayerPosition + diceValue;
            while(board.getCellJumper(updatedPosition).isPresent()) {
                updatedPosition = board.getCellJumper(updatedPosition).get().getToPosition();
            }
            if(updatedPosition > board.getBoardMetadata().getBoardSize()) {
                updatedPosition = currentPlayerPosition;
            }
            currentPlayer.setPosition(updatedPosition);
            System.out.println("Player " + currentPlayer.getPlayerId()+ " rolled a " + diceValue+ " and moved from " +
                    currentPlayerPosition + " to " + updatedPosition);
        }
        System.out.println("Player " + currentPlayer.getPlayerId()+ " has won");
    }

    private boolean untilWinner() {
        if(player == null) return false;
        System.out.println("Current "+ player.getPlayerId()+ " position: " + player.getPosition());

        return player.getPosition() == board.getBoardMetadata().getBoardSize();
    }
}
