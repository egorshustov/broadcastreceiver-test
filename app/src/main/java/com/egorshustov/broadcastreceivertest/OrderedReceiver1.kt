package com.egorshustov.broadcastreceivertest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.egorshustov.broadcastreceivertest.MainActivity.Companion.STRING_EXTRA_KEY

class OrderedReceiver1 : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        var resultCode = resultCode
        var resultData = resultData
        val resultExtras = getResultExtras(true)
        var stringExtra = resultExtras?.getString(STRING_EXTRA_KEY)

        ++resultCode
        stringExtra += "->OR1"

        val toastText = "OR1\n" +
                "thread: ${Thread.currentThread().name}\n" +
                "resultCode: $resultCode\n" +
                "resultData: $resultData\n" +
                "stringExtra: $stringExtra"

        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()

        resultData = "OR1"
        resultExtras.putString(STRING_EXTRA_KEY, stringExtra)

        setResult(resultCode, resultData, resultExtras)
    }
}