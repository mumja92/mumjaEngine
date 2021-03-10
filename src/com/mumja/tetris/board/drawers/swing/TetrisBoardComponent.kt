package com.mumja.tetris.board.drawers.swing

import com.mumja.tetris.GameStatus
import com.mumja.tetris.board.UserBlockCalculator
import java.awt.Graphics
import javax.swing.JComponent


internal class TetrisBoardComponent : JComponent() {
    private var gameStatus: GameStatus? = null
    private val sizeX = 40
    private val sizeY = 40
    private val userBlockCalculator = UserBlockCalculator()

    fun setStatus(status: GameStatus){
        gameStatus = status
    }
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        if (gameStatus != null) {
            for (x in 0 until gameStatus!!.board.sizeX) {
                for (y in 0 until gameStatus!!.board.sizeY) {
                    val block = gameStatus!!.board.getLocation(x, y)
                    BlockDrawingScheme.drawRectangle(g, block!!.blockColor, y*sizeY, x*sizeX, sizeY, sizeX)
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

        val secondShift = 300
        val xShift = shift + sizeX*3
        g.drawString("Score: ${gameStatus!!.score}", shift + 10, secondShift - sizeY * 2)
        g.drawString("Next Block:", shift + 10, secondShift)
        for (point in userBlockCalculator.getBlocks(gameStatus!!.nextUserBlock)){
            BlockDrawingScheme.drawRectangle(g, gameStatus!!.nextUserBlock.blockColor, xShift + point.second*sizeY, secondShift + point.first * sizeX, sizeY, sizeX)
        }
    }
}