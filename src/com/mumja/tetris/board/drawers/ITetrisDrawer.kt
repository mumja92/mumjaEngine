package com.mumja.tetris.board.drawers

import com.mumja.tetris.GameStatus

interface ITetrisDrawer {
    fun draw(gameStatus: GameStatus)
    fun gameOver()
}