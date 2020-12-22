package com.mumja.engine.board

class BoardSupervisor {
    private var boardDrawer = BoardDrawer()
    private var board = Board(4,4)

    fun draw(){
        boardDrawer.draw(board.getBoard())
    }

    fun frame(){
        // blocks move every frame
    }
}