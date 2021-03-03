package com.mumja.tetris.board.drawers

import com.mumja.tetris.board.Board

interface IBoardDrawer {
    fun draw(board: Board)
    fun gameOver()
}