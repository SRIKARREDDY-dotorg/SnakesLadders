package org.pochana.builder;

public class Jump {
    private Integer fromPosition;
    private Integer toPosition;

    private Jump(Builder builder) {
        this.fromPosition = builder.fromPosition;
        this.toPosition = builder.toPosition;
    }

    public Integer getFromPosition() {
        return fromPosition;
    }

    public Integer getToPosition() {
        return toPosition;
    }

    @Override
    public String toString() {
        return "Jump{" +
                "fromPosition=" + fromPosition +
                ", toPosition=" + toPosition +
                '}';
    }

    public static class Builder {
        private Integer fromPosition;
        private Integer toPosition;

        public Builder fromPosition(Integer fromPosition) {
            this.fromPosition = fromPosition;
            return this;
        }

        public Builder toPosition(Integer toPosition) {
            this.toPosition = toPosition;
            return this;
        }

        public Jump build() {
            return new Jump(this);
        }
    }
}
