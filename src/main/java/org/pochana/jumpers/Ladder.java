package org.pochana.jumpers;

import org.pochana.builder.Jump;

public class Ladder implements CellJumper {

    private Jump jump;

    public Ladder(Jump jump) {
        this.jump = jump;
    }

    @Override
    public void validateJump() {
        if(jump.getFromPosition() >=  jump.getToPosition()) {
            throw new IllegalArgumentException("Jump is not valid");
        }
    }

    @Override
    public Jump getJump() {
        return jump;
    }
}
