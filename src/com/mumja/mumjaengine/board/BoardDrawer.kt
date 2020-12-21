package com.mumja.mumjaengine.board

import java.awt.BorderLayout
import javax.swing.JScrollPane
import javax.swing.JTextArea

class BoardDrawer {
    fun draw(){
        val textArea = JTextArea("test")
        val scrollPane = JScrollPane(textArea)

        val frame = BoardFrame("Tetris")
        frame.contentPane.add(scrollPane, BorderLayout.CENTER)
    }
}