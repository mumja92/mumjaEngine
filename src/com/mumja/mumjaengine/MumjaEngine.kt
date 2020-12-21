package com.mumja.mumjaengine

import com.mumja.mumjaengine.board.BoardDrawer

class MumjaEngine {
    private var boardDrawer = BoardDrawer()
    init{
        boardDrawer.draw()
    }
}