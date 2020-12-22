package com.mumja.engine

import com.mumja.engine.board.BoardSupervisor

class Engine {
    private var boardSupervisor = BoardSupervisor()
    fun play(){
        var input: String
        boardSupervisor.draw()
        while(true){
            input = readLine().toString()
            boardSupervisor.frame()
            when (input[0]){
                'q' -> break
                's' -> break
                else ->{
                    boardSupervisor.draw()
                }
            }
        }
    }
}