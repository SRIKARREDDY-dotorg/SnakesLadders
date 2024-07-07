package org.pochana;

import org.pochana.builder.BoardMetadata;
import org.pochana.builder.Jump;
import org.pochana.builder.Player;
import org.pochana.jumpers.CellJumper;
import org.pochana.jumpers.Ladder;
import org.pochana.jumpers.Snake;

import org.apache.commons.lang3.tuple.Pair;
import org.pochana.manager.BoardManager;

import java.util.ArrayList;
import java.util.List;

public class GameSimulator {

    private static BoardManager boardManager = BoardManager.getInstance();
    private static BoardMetadata boardMetadata = BoardMetadata.getInstance();
    public void simulate() {
        Integer boardSize = 100;
        List<CellJumper> cellJumpers = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        boardMetadata.setBoardSize(boardSize);
        List<Pair<Integer, Integer>> snakePairs = List.of(Pair.of(62, 5),
                                                    Pair.of(33, 6),
                                                    Pair.of(49, 9),
                                                    Pair.of(88, 16),
                                                    Pair.of(41, 20),
                                                    Pair.of(56, 53),
                                                    Pair.of(98, 64),
                                                    Pair.of(93, 73),
                                                    Pair.of(95, 75));
        snakePairs.stream().map(pair -> new Jump.Builder().fromPosition(pair.getLeft()).toPosition(pair.getRight()).build()).map(Snake::new).forEach(cellJumper -> {
            cellJumper.validateJump();
            cellJumpers.add(cellJumper);
        });

        List<Pair<Integer, Integer>> ladderPairs = List.of(Pair.of(2, 37),
                Pair.of(27, 46),
                Pair.of(10, 32),
                Pair.of(51, 68),
                Pair.of(61, 79),
                Pair.of(65, 84),
                Pair.of(71, 91),
                Pair.of(81, 100));

        ladderPairs.stream().map(pair -> new Jump.Builder().fromPosition(pair.getLeft()).toPosition(pair.getRight()).build()).map(Ladder::new).forEach(cellJumper -> {
            cellJumper.validateJump();
            cellJumpers.add(cellJumper);
        });

        boardMetadata.setCellJumpers(cellJumpers);

        Player player1 = new Player.Builder().playerId("Gaurav").position(0).build();
        Player player2 = new Player.Builder().playerId("Amit").position(0).build();
        Player player3 = new Player.Builder().playerId("Rahul").position(0).build();
        Player player4 = new Player.Builder().playerId("Ravi").position(0).build();
//        Player player5 = new Player.Builder().playerId("Rohit").position(0).build();
//        Player player6 = new Player.Builder().playerId("Raj").position(0).build();

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
//        players.add(player5);
//        players.add(player6);

        boardMetadata.setPlayers(players);
        System.out.println(boardMetadata);
        boardManager.playGame();
    }
}
