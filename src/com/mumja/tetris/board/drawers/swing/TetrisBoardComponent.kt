package com.mumja.tetris.board.drawers.swing

import com.mumja.tetris.GameStatus
import com.mumja.tetris.board.BlockType
import java.awt.Graphics
import java.awt.Color
import javax.swing.JComponent


internal class TetrisBoardComponent : JComponent() {
    private var gameStatus: GameStatus? = null
    private val sizeX = 40
    private val sizeY = 40

    fun setStatus(status: GameStatus){
        gameStatus = status
    }
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        if (gameStatus != null) {
            for (x in 0 until gameStatus!!.board.sizeX) {
                for (y in 0 until gameStatus!!.board.sizeY) {
                    val block = gameStatus!!.board.getLocation(x, y)
                    var color = Color.BLUE
                    if (block!!.blockType != BlockType.EMPTY) {
                        color = Color.RED;
                    }
                    BlockDrawingScheme.drawRectangle(g, color, y*sizeY, x*sizeX, sizeY, sizeX)
                }
            }
            drawStatus(g,gameStatus!!.board.sizeY*sizeY)
        }
    }

    private fun drawStatus(g: Graphics, shift: Int){
        g.drawString("Move: ←/→", shift + 10, 20)
        g.drawString("Speed: ↓", shift + 10, 40)
        g.drawString("Move down: ↑", shift + 10, 60)
        g.drawString("Rotate: R", shift + 10, 80)
        g.drawString("Exit: ESC", shift + 10, 100)

        g.drawString("Score: ${gameStatus!!.score}", shift + 10, 180)
        g.drawString("Next block: ${gameStatus!!.nextBlock.blockType}", shift + 10, 200)
    }
}