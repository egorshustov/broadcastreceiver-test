package com.egorshustov.broadcastreceivertest

import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val orderedReceiver1 = OrderedReceiver1()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentFilter = IntentFilter("com.egorshustov.EXAMPLE_ACTION").apply {
            priority = 1
        }
        registerReceiver(orderedReceiver1, intentFilter, android.Manifest.permission.VIBRATE, null)
    }

    override fun onDestroy() {
        unregisterReceiver(orderedReceiver1)
        super.onDestroy()
    }

    companion object {
        const val STRING_EXTRA_KEY = "stringExtra"
    }
}
