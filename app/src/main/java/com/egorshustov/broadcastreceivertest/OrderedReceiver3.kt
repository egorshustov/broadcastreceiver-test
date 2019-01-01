package com.egorshustov.broadcastreceivertest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class OrderedReceiver3 : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var resultCode = resultCode
        var resultData = resultData
        val resultExtras = getResultExtras(true)
        var stringExtra = resultExtras?.getString("stringExtra")

        ++resultCode
        stringExtra += "->OR3"

        val toastText = "OR3\n" +
                "resultCode: " + resultCode + "\n" +
                "resultData: " + resultData + "\n" +
                "stringExtra: " + stringExtra

        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()

        resultData = "OR3"
        resultExtras.putString("stringExtra", stringExtra)

        setResult(resultCode, resultData, resultExtras)
    }
}