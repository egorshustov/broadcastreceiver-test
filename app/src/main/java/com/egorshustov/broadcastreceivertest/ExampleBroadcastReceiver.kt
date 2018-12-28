package com.egorshustov.broadcastreceivertest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ExampleBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (Intent.ACTION_BOOT_COMPLETED == intent?.action) {
            Toast.makeText(context, "Boot completed", Toast.LENGTH_SHORT).show()
        }

        if (Intent.ACTION_AIRPLANE_MODE_CHANGED == intent?.action) {
            Toast.makeText(context, "Airplane mode changed", Toast.LENGTH_SHORT).show()
        }
    }
}