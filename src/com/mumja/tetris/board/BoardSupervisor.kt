package com.mumja.tetris.board

import com.mumja.tetris.InputCommand

class BoardSupervisor {
    private var board = Board(12,10)

    init {
        board.setLocation(1,2,Block(BlockType.POINT))
    }

    fun nextFrame(input: InputCommand): Board{
        return board;
    }
}