package it.dikbudsit.stb.myapplication.ui.main

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    private val disconnectTimeOut: Long  = 1 * 60 * 1000
    private val disconnectHandler = Handler(Looper.getMainLooper())
    private val disconnectCallback = Runnable {
        // Perform any required operation on disconnect
        doSignOut()
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        Log.d("Al__","isUserInteraction")
        resetDisconnectTimer()
    }

    override fun onResume() {
        super.onResume()
        resetDisconnectTimer()
    }

    override fun onStop() {
        super.onStop()
        stopDisconnectTimer()
    }

    private fun resetDisconnectTimer() {
        disconnectHandler.removeCallbacks(disconnectCallback)
        disconnectHandler.postDelayed(disconnectCallback, disconnectTimeOut)
    }

    private fun stopDisconnectTimer() {
        disconnectHandler.removeCallbacks(disconnectCallback)
        Log.d("Al__","Remove Timer")
    }
    private fun doSignOut() {
        Log.d("Al__","SignOut")
        finish()
    }
}