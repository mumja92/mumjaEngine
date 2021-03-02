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
        moveUserBlockDown()
        when (input) {
            InputCommand.LEFT -> {
                if (userBlockPositionY > 0) userBlockPositionY--
            }
            InputCommand.RIGHT -> {
                if (userBlockPositionY < boardSizeY - 1) userBlockPositionY++
            }
            else -> {
            }
        }
    }

    private fun sealUserBlock(){
        board.setLocation(userBlockPositionX, userBlockPositionY, Block(BlockType.POINT))
    }

    private fun drawUserBlock(){
        board.setLocation(userBlockPositionX, userBlockPositionY, Block(BlockType.POINT))
    }

    private fun unDrawUserBlock(){
        board.setLocation(userBlockPositionX, userBlockPositionY, Block(BlockType.EMPTY))
    }

    private fun checkUserBlockCanMoveDown(): Boolean{
        val block = board.getLocation(userBlockPositionX+1, userBlockPositionY)
        if (block != null) {
            if (block.blockType == BlockType.EMPTY){
                return true
            }
        }
        return false
    }

    private fun moveUserBlockDown(){
        if (!checkUserBlockCanMoveDown()){
            sealUserBlock()
            userBlockPositionX = 0
            userBlockPositionY = boardSizeY/2
        }
        else{
            userBlockPositionX++
        }
    }
}