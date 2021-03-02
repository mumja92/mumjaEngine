package com.mumja.tetris

class InputParser {
    fun getInput(): InputCommand {
        val input = readLine().toString()
        return try{
            when (input[0]) {
                'q' -> InputCommand.EXIT
                'a' -> InputCommand.LEFT
                'd' -> InputCommand.RIGHT
                's' -> InputCommand.SPEED
                'r' -> InputCommand.ROTATE
                else -> {
                    InputCommand.NONE
                }
            }
        } catch (exception: StringIndexOutOfBoundsException){
            InputCommand.NONE
        }
    }
}