package com.mumja.engine.board

class BoardDrawer {
    fun draw(array: Array<Array<Block>>){
        clearScreen()
        drawBoard(array)
    }

    private fun clearScreen(){
        for (i in 1..20){
            println()
        }
    }

    private fun drawBoard(array: Array<Array<Block>>){
        for (n in array){
            for (m in n){
                if (m.blockType != BlockType.EMPTY){
                    print("O")
                }
                else{
                    print("X")
                }
            }
            println()
        }
    }
}