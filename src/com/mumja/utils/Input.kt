package com.mumja.utils

import java.awt.AWTEvent
import java.awt.Toolkit
import java.awt.event.AWTEventListener
import java.awt.event.KeyEvent
import java.lang.Exception
import kotlin.concurrent.thread

class Input {
    private var asyncInput : String? = null
    private var asyncThread : Thread? = null
    private var awtInitialized = false

    fun getInput() : String{
        return readLine().toString()
    }

    fun getAsyncInput(permanent: Boolean = true) : String?{
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

    fun getAWTInput() : String?{
        if(!awtInitialized){
            initializeAWT()
        }
        if (asyncInput != null){
            val returnValue = asyncInput
            asyncInput = null
            return returnValue
        }
        return null
    }

    private fun initializeAWT(){
        val listener = AWTEventListener { event ->
            try {
                val evt = event as KeyEvent
                if (evt.id == KeyEvent.KEY_PRESSED && evt.keyCode == KeyEvent.VK_LEFT) {
                    if (asyncInput == null){
                        asyncInput = "a"
                    }
                }
                if (evt.id == KeyEvent.KEY_PRESSED && evt.keyCode == KeyEvent.VK_RIGHT) {
                    if (asyncInput == null){
                        asyncInput = "d"
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        Toolkit.getDefaultToolkit().addAWTEventListener(listener, AWTEvent.KEY_EVENT_MASK)
        awtInitialized = true
    }
    private fun startGetInputAsyncThread(){
        asyncThread = thread {
            asyncInput = readLine().toString()
        }
    }
}