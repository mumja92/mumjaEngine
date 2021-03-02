package com.mumja.tetris

import com.mumja.tetris.board.Board
import com.mumja.tetris.board.BoardDrawerCli
import com.mumja.tetris.board.BoardSupervisor
import java.sql.Time

class Tetris {
    private val boardSupervisor = BoardSupervisor()
    private val boardDrawerCli = BoardDrawerCli()
    private val inputParser = InputParser()
    private val timer = Timer()
    fun play(){
        var board: Board
        var input: InputCommand
        boardDrawerCli.draw(boardSupervisor.nextFrame(InputCommand.NONE))
        while(true){
            input = inputParser.getInput()
            if (input == InputCommand.EXIT){
                callExit()
                break
            }
            board = boardSupervisor.nextFrame(input)
            boardDrawerCli.draw(board)
            timer.handleTime()
        }
    }

    private fun callExit(){
    }
}