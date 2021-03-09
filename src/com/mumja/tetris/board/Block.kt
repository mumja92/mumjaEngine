package com.mumja.tetris.board

class Block (
    var blockType: BlockType,
    rotation: Int = 0,
){
    var blockRotation = rotation
        private set

    init {
        if (blockRotation < 0){
            blockRotation = 0
        }
        if (blockRotation > 3){
            blockRotation = 3
        }
    }
    fun rotate(){
        if (blockRotation < 3){
            blockRotation++
        }
        else{
            blockRotation = 0
        }
    }
}