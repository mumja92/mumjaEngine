package com.mumja.tetris.board

class BoardDrawerCli {
    fun draw(board: Board){
        clearScreen()
        drawBoard(board)
    }

    private fun clearScreen(){
        for (i in 1..20){
            println()
        }
    }

    private fun drawBoard(board: Board){
        drawFirstLineOfBoard(board.sizeX)
        for (x  in 0 until board.sizeX){
            var line = String()
            for (y in 0 until board.sizeY){
                line += if (board.getLocation(x,y)?.blockType == BlockType.EMPTY){
                    ("o")
                } else{
                    ("*")
                }
            }
            drawMiddleLineOfBoard(line)
        }
        drawLastLineOfBoard(board.sizeX)
    }
    private fun drawFirstLineOfBoard(size: Int){
        for (i in 1..size){
            print("-")
        }
        println(" ")
    }

    private fun drawLastLineOfBoard(size: Int){
        drawFirstLineOfBoard(size)
    }

    private fun drawMiddleLineOfBoard(line: String){
        println("|$line|")
    }
}