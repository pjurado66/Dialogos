package com.pjurado.dialogos.DialogFragment

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar
import com.pjurado.dialogos.R


class MiDialogAlert(val myView: View): DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Dialogo de alerta")
                .setMessage("Este dialogo se ha creado con un alert dialog")
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("Ok", DialogInterface.OnClickListener { dialogInterface, i ->
                    Snackbar.make(myView, "Ha seleccionado Ok", Snackbar.LENGTH_SHORT)
                        .setBackgroundTint(Color.BLUE)
                        .show()

                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
                    Snackbar.make(myView, "Ha seleccionado Cancel", Snackbar.LENGTH_SHORT)
                        .setBackgroundTint(Color.MAGENTA)
                        .show()
                })
            builder.create()
        } ?: throw IllegalStateException("Actividad nula")
    }


}