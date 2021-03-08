package com.mumja.tetris.input

import kotlin.concurrent.thread

class InputParserCli: IInputParser {
    private var asyncInput : String? = null
    private var asyncThread : Thread? = null

    override fun getInput():InputCommand{
        val userInput = getAsyncInput()
        return if (userInput == null){
            InputCommand.NONE
        } else{
            parseInput(userInput)
        }
    }

    private fun getAsyncInput(permanent: Boolean = true) : String?{
        if (asyncThread == null){
            startGetInputAsyncThread()
            return null
        }

        if (asyncInput != null){
            val returnValue = asyncInput
            if (permanent){
                startGetInputAsyncThread()
            }
            else{
                asyncThread = null
            }
            asyncInput = null
            return returnValue
        }
        return null
    }
    private fun startGetInputAsyncThread(){
        asyncThread = thread {
            asyncInput = readLine().toString()
        }
    }
}