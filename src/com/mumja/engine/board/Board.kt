package com.mumja.engine.board

class Board (
    var sizeX: Int,
    var sizeY: Int,
){
    private var matrix: Array<Array<Block>> = Array(sizeX){
        Array(sizeY){
            Block(BlockType.EMPTY)
        }
    }
    init {
        if (sizeX <= 0){
            sizeX = 1
        }
        if (sizeY <= 0){
            sizeY = 1
        }
    }
    fun setLocation(x: Int, y: Int, block: Block): Boolean{
        if (inRange(x,y)){
            matrix[x][y] = block
            return true
        }
        return false
    }

    fun getLocation(x: Int, y: Int): Block?{
        if (inRange(x,y)){
            return matrix[x][y]
        }
        return null
    }

    fun getBoard(): Array<Array<Block>>{
        return matrix
    }
    private fun inRange(x: Int, y: Int): Boolean{
        if (x < 0 || x >= sizeX || y < 0 || y >= sizeY){
            return false
        }
        return true
    }
}
