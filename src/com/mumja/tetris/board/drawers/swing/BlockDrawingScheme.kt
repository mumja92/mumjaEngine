package com.mumja.tetris.board.drawers.swing

import java.awt.Color
import java.awt.Graphics

class BlockDrawingScheme {
    companion object{
        fun drawRectangle (graphics: Graphics, color: Color, posX: Int, posY: Int, width: Int, height: Int){
            graphics.color = color
            graphics.fillRect(posX, posY, width, height)
            graphics.color = Color.BLACK
            graphics.drawRect(posX, posY, width, height)
        }
    }
}