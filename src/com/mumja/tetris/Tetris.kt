package com.mumja.tetris

import com.mumja.tetris.board.Board
import com.mumja.tetris.board.drawers.BoardDrawerCli
import com.mumja.tetris.board.BoardSupervisor
import com.mumja.tetris.board.drawers.IBoardDrawer

class Tetris {
    private val boardSupervisor = BoardSupervisor()
    private val boardDrawer : IBoardDrawer
    private val inputParser = InputParser()
    private val timer = Timer()

    init{
        boardDrawer = BoardDrawerCli()
    }

    fun play(){
        var board: Board
        var input: InputCommand
        boardDrawer.draw(boardSupervisor.nextFrame(InputCommand.NONE))
        while(true){
            input = inputParser.getInput()
            if (input == InputCommand.EXIT){
                callExit()
                break
            }
            try {
                board = boardSupervisor.nextFrame(input)
                boardDrawer.draw(board)
                timer.handleTime()
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