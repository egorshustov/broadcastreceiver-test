package com.egorshustov.broadcastreceivertest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.widget.Toast
import com.egorshustov.broadcastreceivertest.MainActivity.Companion.STRING_EXTRA_KEY

class OrderedReceiver2 : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val handler = Handler()

        val pendingResult = goAsync()

        Thread(Runnable {
            Thread.sleep(10000)

            var resultCode = pendingResult.resultCode
            var resultData = pendingResult.resultData
            val resultExtras = pendingResult.getResultExtras(true)
            var stringExtra = resultExtras?.getString(STRING_EXTRA_KEY)

            ++resultCode
            stringExtra += "->OR2"

            val toastText = "OR2\n" +
                    "thread: ${Thread.currentThread().name}\n" +
                    "resultCode: $resultCode\n" +
                    "resultData: $resultData\n" +
                    "stringExtra: $stringExtra"

            handler.post {
                Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()
            }

            resultData = "OR2"
            resultExtras.putString(STRING_EXTRA_KEY, stringExtra)

            pendingResult.setResult(resultCode, resultData, resultExtras)
            pendingResult.finish()
            //pendingResult.abortBroadcast()
        }).start()
    }
}