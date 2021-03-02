package com.mumja.tetris

class InputParser {
    fun getInput(): InputCommand {
        val input = readLine().toString()
        return when (input[0]) {
            'q' -> InputCommand.EXIT
            'a' -> InputCommand.LEFT
            'd' -> InputCommand.RIGHT
            's' -> InputCommand.SPEED
            else -> {
                InputCommand.NONE
            }
        }
    }
}