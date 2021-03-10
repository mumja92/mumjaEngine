package com.mumja.tetris

import com.mumja.tetris.board.Block
import com.mumja.tetris.board.Board

data class GameStatus(
    var board: Board,
    var nextBlock: Block,
    var score: Int,
)
