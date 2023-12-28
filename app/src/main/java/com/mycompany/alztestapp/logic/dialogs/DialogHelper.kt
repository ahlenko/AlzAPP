package com.mycompany.alztestapp.logic.dialogs

import android.app.AlertDialog
import android.content.Context

class DialogHelper {
    companion object {
        fun showInformationDialog(context: Context, message: String, buttonText: String) {
            val builder = AlertDialog.Builder(context)

            builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(buttonText) { dialog, _ ->
                    dialog.dismiss()
                }

            val alert = builder.create()
            alert.show()
        }
    }
}