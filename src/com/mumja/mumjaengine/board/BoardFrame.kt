package com.mumja.mumjaengine.board

import java.awt.Dimension
import javax.swing.JFrame

class BoardFrame(title: String?) : JFrame(title) {
    init{
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        size = Dimension(1024, 768)
        setLocationRelativeTo(null)
        isVisible = true
    }

}