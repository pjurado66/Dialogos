package com.pjurado.dialogos.ComunicaActivity

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.pjurado.dialogos.R


class MiDialogAlertComunica(val myView: View): DialogFragment() {
    private lateinit var listener: OnMiDialogAlertListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Dialogo de alerta")
                .setMessage("Este dialogo se ha creado con un alert dialog")
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("Ok", DialogInterface.OnClickListener { dialogInterface, i ->
                    listener.onPossitiveButtonClick()
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
                    listener.onNegativeButtonClick()
                })
            builder.create()
        } ?: throw IllegalStateException("Actividad nula")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMiDialogAlertListener) {
            listener = context
        }
    }
}