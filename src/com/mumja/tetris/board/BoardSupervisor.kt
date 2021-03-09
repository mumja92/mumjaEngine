package com.mumja.tetris.board

import com.mumja.tetris.GameOverException
import com.mumja.tetris.input.InputCommand

class BoardSupervisor {
    private val boardSizeX = 15
    private val boardSizeY = 10
    private val board = Board(boardSizeX, boardSizeY)
    private var userBlock = Block(BlockType.EMPTY)
    private var userBlockPositionX = 0
    private var userBlockPositionY = 0
    private val userBlockCalculator = UserBlockCalculator()

    init {
        generateNewUserBlock()
    }

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
            InputCommand.SPEED -> {
                moveUserBlockDown()
            }
            InputCommand.ROTATE -> {
                if (isRotatePossible()){
                    userBlock.rotate()
                }
            }
            InputCommand.EXIT -> {
                throw GameOverException()
            }
            else -> {
            }
        }
    }

    private fun sealUserBlock(){
        if (userBlockPositionX == 0){
            throw GameOverException()
        }
        for (point in userBlockCalculator.getBlocks(userBlock)){
            board.setLocation(userBlockPositionX + point.first, userBlockPositionY + point.second, Block(BlockType.POINT))
        }
    }

    private fun drawUserBlock(){
        val points = userBlockCalculator.getBlocks(userBlock)
        for (point in points){
            board.setLocation(userBlockPositionX + point.first, userBlockPositionY + point.second, Block(BlockType.POINT))
        }
    }

    private fun unDrawUserBlock(){
        for (point in userBlockCalculator.getBlocks(userBlock)){
            board.setLocation(userBlockPositionX + point.first, userBlockPositionY + point.second, Block(BlockType.EMPTY))
        }
    }


    private fun moveUserBlockDown(){
        if (!checkUserBlockCanMove(userBlockPositionX+1, userBlockPositionY)){
            sealUserBlock()
            generateNewUserBlock()
        }
        else{
            userBlockPositionX++
        }
    }

    private fun checkUserBlockCanMove(targetX: Int, targetY: Int): Boolean{
        for (point in userBlockCalculator.getBlocks(userBlock)){
            val block = board.getLocation(targetX + point.first, targetY + point.second)
            if (block == null){
                return false
            }
            else {
                if (block.blockType != BlockType.EMPTY){
                    return false
                }
            }
        }
        return true
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

    private fun generateNewUserBlock(){
        userBlock = Block(BlockType.I, 0)
        userBlockPositionX = 0
        userBlockPositionY = boardSizeY/2
    }

    private fun isRotatePossible(): Boolean{
        val rotatedBlock = Block(userBlock.blockType, userBlock.blockRotation)
        rotatedBlock.rotate()
        for (point in userBlockCalculator.getBlocks(rotatedBlock)){
            val block = board.getLocation(userBlockPositionX + point.first, userBlockPositionY + point.second) ?: return false
            if (block.blockType != BlockType.EMPTY){
                return false
            }
        }
        return true
    }
}