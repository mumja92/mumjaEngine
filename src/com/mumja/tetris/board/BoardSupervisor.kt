package com.mumja.tetris.board

class BoardSupervisor {
    private var board = Board(3,5)

    init {
        board.setLocation(1,2,Block(BlockType.POINT))
    }

    fun nextFrame(): Board{
        return board;
    }
}