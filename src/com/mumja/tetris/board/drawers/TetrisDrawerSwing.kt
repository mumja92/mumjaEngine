package com.mumja.tetris.board.drawers

import com.mumja.tetris.GameStatus
import com.mumja.tetris.board.Board
import com.mumja.tetris.board.drawers.swing.TetrisBoardComponent
import javax.swing.JFrame
import java.awt.Dimension
import javax.swing.JOptionPane


class TetrisDrawerSwing: ITetrisDrawer {
    private val frame = JFrame("Mumjotetris")
    private val tetrisBoardComponent = TetrisBoardComponent()

    init{
        frame.minimumSize = Dimension(800, 1000)
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.isVisible = true;
        frame.add(tetrisBoardComponent)
    }

    override fun draw(gameStatus: GameStatus) {
        tetrisBoardComponent.setStatus(gameStatus)
        frame.repaint()
    }

    override fun gameOver(gameStatus: GameStatus) {
        JOptionPane.showMessageDialog(null, "Score: ${gameStatus.score}", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose()
    }

}