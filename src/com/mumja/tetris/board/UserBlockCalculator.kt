package com.mumja.tetris.board

class UserBlockCalculator {
    fun getBlocks(block: Block):ArrayList<Pair<Int,Int>>{
        return when(block.blockType){
            BlockType.I ->{
                getBlockI(block.blockRotation)
            }
            else ->{
                getBlockEMPTY(block.blockRotation)
            }
        }
    }

    private fun getBlockI(rotation: Int): ArrayList<Pair<Int,Int>>{
        val blockList = ArrayList<Pair<Int, Int>>()
        when(rotation){
            0 -> {
                blockList.add(Pair(0,-1))
                blockList.add(Pair(0,0))
                blockList.add(Pair(0,1))
                blockList.add(Pair(0,2))
            }
            1 -> {
                blockList.add(Pair(-1,1))
                blockList.add(Pair(0,1))
                blockList.add(Pair(1,1))
                blockList.add(Pair(2,1))
            }
            2 -> {
                blockList.add(Pair(1,-1))
                blockList.add(Pair(1,0))
                blockList.add(Pair(1,1))
                blockList.add(Pair(1,2))
            }
            3 -> {
                blockList.add(Pair(-1,0))
                blockList.add(Pair(0,0))
                blockList.add(Pair(1,0))
                blockList.add(Pair(2,0))
            }
            else -> {

            }
        }
        return blockList
    }

    private fun getBlockEMPTY(rotation: Int): ArrayList<Pair<Int,Int>>{
        return ArrayList()
    }
}