package com.mumja.tetris.board.drawers.swing

import com.mumja.tetris.board.BlockType
import com.mumja.tetris.board.Board
import java.awt.Graphics
import java.awt.Color
import javax.swing.JComponent
import java.awt.Font

import java.awt.Graphics2D





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
                    var color = Color.BLUE
                    if (block!!.blockType != BlockType.EMPTY) {
                        color = Color.RED;
                    }
                    BlockDrawingScheme.drawRectangle(g, color, y*sizeY, x*sizeX, sizeY, sizeX)
                }
            }
            drawStatus(g,board!!.sizeY*sizeY)
        }
    }

    private fun drawStatus(g: Graphics, shift: Int){
        g.drawString("Move: Left/Right", shift + 10, 20)
        g.drawString("Speed: Down", shift + 10, 40)
        g.drawString("Rotate: R", shift + 10, 60)
        g.drawString("Exit: ESC", shift + 10, 80)
    }
}