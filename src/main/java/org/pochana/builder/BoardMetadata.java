package org.pochana.builder;

import org.pochana.jumpers.CellJumper;

import java.util.List;

public class BoardMetadata {

    private static volatile BoardMetadata boardMetadataInstance;

    private Integer boardSize;
    private List<CellJumper> cellJumpers;
    private List<Player> players;

    private BoardMetadata() {}

    public static BoardMetadata getInstance() {
        if (boardMetadataInstance == null) {
            synchronized (BoardMetadata.class) {
                if (boardMetadataInstance == null) {
                    boardMetadataInstance = new BoardMetadata();
                }
            }
        }
        return boardMetadataInstance;
    }


    public Integer getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(Integer boardSize) {
        this.boardSize = boardSize;
    }

    public List<CellJumper> getCellJumpers() {
        return cellJumpers;
    }

    public void setCellJumpers(List<CellJumper> cellJumpers) {
        this.cellJumpers = cellJumpers;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
