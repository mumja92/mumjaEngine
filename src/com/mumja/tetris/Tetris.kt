package com.mumja.tetris

import com.mumja.tetris.board.Block
import com.mumja.tetris.board.BlockType
import com.mumja.tetris.board.Board
import com.mumja.tetris.board.BoardSupervisor
import com.mumja.tetris.board.drawers.TetrisDrawerCli
import com.mumja.tetris.board.drawers.TetrisDrawerSwing
import com.mumja.tetris.board.drawers.ITetrisDrawer
import com.mumja.tetris.input.*

class Tetris {
    private val boardSupervisor = BoardSupervisor()
    private var tetrisDrawer : ITetrisDrawer? = null
    private var inputParser : IInputParser? = null
    private var timer = Timer(1000)
    private var gameStatus = GameStatus(Board(0,0), Block(BlockType.EMPTY), 0)

    // Deprecated
    fun playCli(){
        timer.refreshMs=1000
        tetrisDrawer = TetrisDrawerCli()
        inputParser = InputParserCli()
        play()
    }

    fun playSwing(){
        timer.refreshMs=10
        tetrisDrawer = TetrisDrawerSwing()
        inputParser = InputParserAWT()
        play()
    }

    private fun play(){
        var input: InputCommand
        var nextTick = true
        while(true){
            try {
                input = inputParser!!.getInput()
                boardSupervisor.nextFrame(input, nextTick)
                fillGameStatus()
                tetrisDrawer!!.draw(gameStatus)
                nextTick = timer.handleTime()
            }
            catch (e: GameOverException){
                callGameOver()
                break
            }
        }
    }

    private fun callGameOver()
    {
        tetrisDrawer!!.gameOver()
    }

    private fun fillGameStatus(){
        gameStatus.board = boardSupervisor.getBoard()
        gameStatus.nextBlock = boardSupervisor.getNextBlock()
        gameStatus.score = boardSupervisor.getScore()
    }
}