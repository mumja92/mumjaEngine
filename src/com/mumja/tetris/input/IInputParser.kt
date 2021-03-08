package com.mumja.tetris.input

interface IInputParser {
    fun getInput(): InputCommand

    fun parseInput(userInput : String) : InputCommand {
        return try{
            when (userInput[0]) {
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