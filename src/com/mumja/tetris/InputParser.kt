package com.mumja.tetris

import com.mumja.utils.Input

class InputParser {
    private val input = Input()

    fun getInput(): InputCommand {
        return parseInput(input.getInput())
    }

    fun getAsyncInput() : InputCommand{
        val userInput = input.getAsyncInput()
        return if (userInput == null){
            InputCommand.NONE
        } else{
            parseInput(userInput)
        }
    }

    fun getAWTInput() : InputCommand{
        val userInput = input.getAWTInput()
        return if (userInput == null){
            InputCommand.NONE
        } else{
            parseInput(userInput)
        }
    }

    private fun parseInput(userInput : String) : InputCommand{
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