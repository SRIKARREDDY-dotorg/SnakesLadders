package org.pochana.builder;

public class Player {
    private String playerId;
    private Integer position;

    private Player(String playerId, Integer position) {
        this.playerId = playerId;
        this.position = position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    public String getPlayerId() {
        return playerId;
    }

    public static class Builder {
        private String playerId;
        private Integer position;

        public Builder playerId(String playerId) {
            this.playerId = playerId;
            return this;
        }

        public Builder position(Integer position) {
            this.position = position;
            return this;
        }

        public Player build() {
            return new Player(this.playerId, this.position);
        }
    }

}
