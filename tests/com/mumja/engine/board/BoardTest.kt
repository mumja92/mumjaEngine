package com.mumja.engine.board

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BoardTest {

    @Test
    fun readInRangeOk() {
        val board = Board(3,3)

        assertNotNull(board.getLocation(0,0))
        assertNotNull(board.getLocation(2,2))
    }

    @Test
    fun readOutOfRangeNoOk() {
        val board = Board(3,3)

        assertNull(board.getLocation(-1,0))
        assertNull(board.getLocation(0,-1))
        assertNull(board.getLocation(2,3))
        assertNull(board.getLocation(3,2))
    }

    @Test
    fun writeInRangeOk() {
        val board = Board(3,3)
        assertTrue(board.setLocation(0,0, Block(BlockType.J)))
        assertTrue(board.setLocation(1,1, Block(BlockType.J)))
        assertTrue(board.setLocation(2,2, Block(BlockType.J)))
    }

    @Test
    fun writeOutOfRangeNoOk() {
        val board = Board(3,3)
        assertFalse(board.setLocation(-1,0, Block(BlockType.J)))
        assertFalse(board.setLocation(0,3, Block(BlockType.J)))
    }

    @Test
    fun writeAndReadValueInRangeOk() {
        val board = Board(2,10)
        assertTrue(board.getLocation(0,5)?.blockType != BlockType.I)
        board.setLocation(0,5, Block(BlockType.I))
        assertTrue(board.getLocation(0,5)?.blockType == BlockType.I)
    }

    @Test
    fun getSizeWithNegativeValuesInConstructorOk() {
        val board = Board(0,-1)
        assertTrue(board.sizeX > 0)
        assertTrue(board.sizeY > 0)
    }
}