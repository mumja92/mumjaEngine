package com.mumja.tetris

class Timer(periodMs: Int = 2000) {
    private var period = periodMs
    private var startTime: Long = System.currentTimeMillis()
    fun handleTime() : Boolean{
        Thread.sleep(10)
        val currentTime = System.currentTimeMillis()
        if (currentTime - startTime > period){
            startTime = System.currentTimeMillis()
            return true
        }
        return false
    }
}