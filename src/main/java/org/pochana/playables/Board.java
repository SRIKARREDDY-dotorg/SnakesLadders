package org.pochana.playables;

import org.pochana.builder.BoardMetadata;
import org.pochana.builder.Jump;
import org.pochana.builder.Player;
import org.pochana.jumpers.CellJumper;

import java.util.List;
import java.util.Optional;

public class Board {
    private static volatile Board instance;

    private static BoardMetadata boardMetadata = BoardMetadata.getInstance();

    private Integer playerNumber = 0;

    private Board() {
    }

    public static Board getInstance() {
        if (instance == null) {
            synchronized (Board.class) {
                if (instance == null) {
                    instance = new Board();
                }
            }
        }
        return instance;
    }

    public Optional<Jump> getCellJumper(Integer position) {
        List<CellJumper> cellJumpers = boardMetadata.getCellJumpers();
        for (CellJumper cellJumper : cellJumpers) {
            if (cellJumper.getJump().getFromPosition().equals(position)) {
                return Optional.ofNullable(cellJumper.getJump());
            }
        }
        System.out.println("Jump not found for position: " + position);
        return Optional.empty();
    }

    public Player getCurrentPlayer() {
        List<Player> players = boardMetadata.getPlayers();
        playerNumber += 1;
        return players.get((playerNumber) % players.size());
    }

    public BoardMetadata getBoardMetadata() {
        return boardMetadata;
    }
}
