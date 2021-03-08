package com.mumja.tetris.board.drawers.swing

import com.mumja.tetris.board.BlockType
import com.mumja.tetris.board.Board
import java.awt.Graphics
import java.awt.Color
import javax.swing.JComponent


internal class TetrisBoardComponent : JComponent() {
    private var board: Board? = null
    private val sizeX = 40
    private val sizeY = 40

    fun setBoard(boardToDraw: Board){
        board = boardToDraw
    }
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        if (board != null) {
            for (x in 0 until board!!.sizeX) {
                for (y in 0 until board!!.sizeY) {
                    val block = board!!.getLocation(x, y)
                    g.color = Color.BLUE
                    if (block!!.blockType != BlockType.EMPTY) {
                        g.color = Color.RED;
                    }
                    g.fillRect(y*sizeY, x*sizeX, sizeY, sizeX);
                }
            }
        }
    }
}