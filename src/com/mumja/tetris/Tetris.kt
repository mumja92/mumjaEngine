package com.mumja.tetris

import com.mumja.tetris.board.Board
import com.mumja.tetris.board.drawers.BoardDrawerCli
import com.mumja.tetris.board.BoardSupervisor
import com.mumja.tetris.board.drawers.BoardDrawerSwing
import com.mumja.tetris.board.drawers.IBoardDrawer

class Tetris {
    private val boardSupervisor = BoardSupervisor()
    private val boardDrawer : IBoardDrawer
    private val inputParser = InputParser()
    private val timer = Timer()

    init{
        boardDrawer = BoardDrawerSwing()
    }

    fun play(){
        var board: Board
        var input: InputCommand
        var nextTick = true
        boardDrawer.draw(boardSupervisor.nextFrame(InputCommand.NONE, false))
        while(true){
            try {
                input = inputParser.getAWTInput()
                if (input == InputCommand.EXIT){
                    callExit()
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

    private fun callExit(){
        callGameOver()
    }

    private fun callGameOver()
    {
        boardDrawer.gameOver()
    }
}