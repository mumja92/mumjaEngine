package com.mumja.tetris.board

import com.mumja.tetris.GameOverException
import com.mumja.tetris.InputCommand

class BoardSupervisor {
    private val boardSizeX = 4
    private val boardSizeY = 3
    private val board = Board(boardSizeX, boardSizeY)
    private var userBlockPositionX = 0
    private var userBlockPositionY = boardSizeY/2

    fun nextFrame(input: InputCommand, nextTick: Boolean = true): Board{
        unDrawUserBlock()
        removeFullLines()
        moveUserBlock(input, nextTick)
        drawUserBlock()
        return board;
    }

    private fun moveUserBlock(input: InputCommand, nextTick:Boolean){
        if (nextTick){
            moveUserBlockDown()
        }
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
            if (board.getLocation(userBlockPositionX, userBlockPositionY)!!.blockType != BlockType.EMPTY){
                throw GameOverException()
            }
        }
        else{
            userBlockPositionX++
        }
    }

    private fun removeFullLines(){
        while (true){
            if (lastLineIsFull()){
                moveBoardOneLineDown()
            }
            else{
                break
            }
        }
    }

    private fun lastLineIsFull(): Boolean{
        for (i in 0 until boardSizeY){
            if (board.getLocation(boardSizeX-1, i)!!.blockType == BlockType.EMPTY){
                return false
            }
        }
        return true
    }

    private fun moveBoardOneLineDown(){
        for (i in boardSizeX - 2 downTo 0){
            for (j in 0 until boardSizeY){
                board.setLocation(i+1, j, board.getLocation(i, j)!!)
            }
        }
    }
}