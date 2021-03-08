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
                if (checkUserBlockCanMove(userBlockPositionX, userBlockPositionY-1)){
                    userBlockPositionY--
                }
            }
            InputCommand.RIGHT -> {
                if (checkUserBlockCanMove(userBlockPositionX, userBlockPositionY+1)){
                    userBlockPositionY++
                }
            }
            else -> {
            }
        }
    }

    private fun sealUserBlock(){
        if (userBlockPositionX == 0){
            throw GameOverException()
        }
        board.setLocation(userBlockPositionX, userBlockPositionY, Block(BlockType.POINT))
    }

    private fun drawUserBlock(){
        board.setLocation(userBlockPositionX, userBlockPositionY, Block(BlockType.POINT))
    }

    private fun unDrawUserBlock(){
        board.setLocation(userBlockPositionX, userBlockPositionY, Block(BlockType.EMPTY))
    }


    private fun moveUserBlockDown(){
        if (!checkUserBlockCanMove(userBlockPositionX+1, userBlockPositionY)){
            sealUserBlock()
            userBlockPositionX = 0
            userBlockPositionY = boardSizeY/2
        }
        else{
            userBlockPositionX++
        }
    }

    private fun checkUserBlockCanMove(targetX: Int, targetY: Int): Boolean{
        val block = board.getLocation(targetX, targetY)
        if (block != null) {
            if (block.blockType == BlockType.EMPTY){
                return true
            }
        }
        return false
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