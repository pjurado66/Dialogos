package com.pjurado.dialogos.DialogRadioButtons

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar


class MiDialogRadioButtons(val myView: View): DialogFragment() {
    private val nombres = arrayOf("Antonio", "Juan", "Pepillo", "Juanillo")
    private var selectedItem = nombres[0]
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Dialogo de Radio Buttons")
                .setSingleChoiceItems(nombres, 0,
                    DialogInterface.OnClickListener { dialogInterface, i ->
                        selectedItem = nombres[i]
                    })
                .setPositiveButton("Ok", DialogInterface.OnClickListener { dialogInterface, i ->
                    Snackbar.make(myView, "Ha seleccionado $selectedItem", Snackbar.LENGTH_SHORT)
                        .setBackgroundTint(Color.BLUE)
                        .show()
                    })
            builder.create()
        } ?: throw IllegalStateException("Actividad nula")
    }

}