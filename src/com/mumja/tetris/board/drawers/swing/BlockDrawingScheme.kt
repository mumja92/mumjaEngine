package com.mumja.tetris.board.drawers.swing

import com.mumja.tetris.board.BlockColor
import java.awt.Color
import java.awt.Graphics

class BlockDrawingScheme {
    companion object{
        fun drawRectangle (graphics: Graphics, color: BlockColor, posX: Int, posY: Int, width: Int, height: Int){
            graphics.color = parseBlockColor(color)
            graphics.fillRect(posX, posY, width, height)
            graphics.color = Color.BLACK
            graphics.drawRect(posX, posY, width, height)
        }
        private fun parseBlockColor(color:BlockColor): Color{
            return when(color){
                BlockColor.BLUE -> Color.BLUE
                BlockColor.CYAN -> Color.CYAN
                BlockColor.GREEN -> Color.GREEN
                BlockColor.MAGNETA -> Color.MAGENTA
                BlockColor.ORANGE -> Color.ORANGE
                BlockColor.PINK -> Color.PINK
                BlockColor.RED -> Color.RED
                BlockColor.YELLOW -> Color.YELLOW
                BlockColor.LIGHT_GRAY -> Color.LIGHT_GRAY
            }
        }
    }
}