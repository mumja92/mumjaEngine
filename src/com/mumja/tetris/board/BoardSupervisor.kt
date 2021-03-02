package com.mumja.tetris.board

import com.mumja.tetris.InputCommand

class BoardSupervisor {
    private val boardSizeX = 12
    private val boardSizeY = 10
    private val board = Board(boardSizeX, boardSizeY)
    private var userBlockPositionX = 0
    private var userBlockPositionY = boardSizeY/2

    fun nextFrame(input: InputCommand): Board{
        unDrawUserBlock()
        moveUserBlock(input)
        drawUserBlock()
        return board;
    }

    private fun moveUserBlock(input: InputCommand){
        userBlockPositionX++
        if (userBlockPositionX >= boardSizeX){
            sealUserBlock()
            userBlockPositionX = 0
            userBlockPositionY = boardSizeY/2
        }
        when(input){
            InputCommand.LEFT -> {
                if (userBlockPositionY > 0) userBlockPositionY--
            }
            InputCommand.RIGHT -> {
                if (userBlockPositionY < boardSizeY - 1) userBlockPositionY++
            }
            else ->{
            }
        }
    }

    private fun sealUserBlock(){
    }

    private fun drawUserBlock(){
        board.setLocation(userBlockPositionX, userBlockPositionY, Block(BlockType.POINT))
    }

    private fun unDrawUserBlock(){
        board.setLocation(userBlockPositionX, userBlockPositionY, Block(BlockType.EMPTY))
    }
}