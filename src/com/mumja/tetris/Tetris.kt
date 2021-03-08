package com.mumja.tetris

import com.mumja.tetris.board.Board
import com.mumja.tetris.board.BoardSupervisor
import com.mumja.tetris.board.drawers.BoardDrawerCli
import com.mumja.tetris.board.drawers.BoardDrawerSwing
import com.mumja.tetris.board.drawers.IBoardDrawer
import com.mumja.tetris.input.*

class Tetris {
    private val boardSupervisor = BoardSupervisor()
    private var boardDrawer : IBoardDrawer = BoardDrawerCli()
    private var inputParser : IInputParser = InputParserCli()
    private var timer = Timer(1000, 1000)

    fun playCli(){
        play()
    }

    fun playSwing(){
        timer.refreshMs=10
        boardDrawer = BoardDrawerSwing()
        inputParser = InputParserAWT()
        play()
    }

    private fun play(){
        var board: Board
        var input: InputCommand
        var nextTick = true
        boardDrawer.draw(boardSupervisor.nextFrame(InputCommand.NONE, false))
        while(true){
            try {
                input = inputParser.getInput()
                if (input == InputCommand.EXIT){
                    callGameOver()
                    break
                }
                board = boardSupervisor.nextFrame(input, nextTick)
                boardDrawer.draw(board)
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
        boardDrawer.gameOver()
    }
}