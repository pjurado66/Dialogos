package com.pjurado.dialogos.Lista

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class MiDialogLista(): DialogFragment() {
    private lateinit var listener: OnMiDialogListatListener
    private val nombres = arrayOf("Antonio", "Juan", "Pepillo", "Juanillo")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Dialogo de lista")
                .setItems(nombres, DialogInterface.OnClickListener { dialogInterface, i ->
                    listener.onItemClick(nombres[i])
                })
            builder.create()
        } ?: throw IllegalStateException("Actividad nula")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMiDialogListatListener) {
            listener = context
        }
    }
}