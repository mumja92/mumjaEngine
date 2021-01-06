package com.mumja.tetris

import com.mumja.tetris.board.Board
import com.mumja.tetris.board.BoardDrawerCli
import com.mumja.tetris.board.BoardSupervisor

class Tetris {
    private var boardSupervisor = BoardSupervisor()
    fun play(){
        var input: String
        var board: Board
        val boardDrawerCli = BoardDrawerCli()
        boardDrawerCli.draw(boardSupervisor.nextFrame())
        while(true){
            input = readLine().toString()
            board = boardSupervisor.nextFrame()
            when (input[0]){
                'q' -> break
                's' -> break
                else ->{
                    boardDrawerCli.draw(board)
                }
            }
        }
    }
}