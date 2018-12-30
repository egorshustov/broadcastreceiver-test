package com.egorshustov.broadcastreceivertest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ExampleBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if ("com.egorshustov.broadcastreceivertest.EXAMPLE_ACTION" == intent?.action) {
            val receivedText : String = intent.getStringExtra("com.egorshustov.broadcastreceivertest.EXAMPLE_TEXT")
            Toast.makeText(context, receivedText, Toast.LENGTH_LONG).show()
        }
    }
}