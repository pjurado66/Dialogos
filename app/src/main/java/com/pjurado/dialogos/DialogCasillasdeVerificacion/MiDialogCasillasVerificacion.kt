package com.pjurado.dialogos.DialogCasillasdeVerificacion

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class MiDialogCasillasVerificacion(): DialogFragment() {
    private lateinit var listener: OnMiDialogCasillasVerificacion
    private val nombres = arrayOf("Antonio", "Juan", "Pepillo", "Juanillo")
    private val selectedItems = ArrayList<String>()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Dialogo de lista")
                .setMultiChoiceItems(nombres,
                    null,
                    DialogInterface.OnMultiChoiceClickListener { dialogInterface, which, isCheked ->
                        if (isCheked){
                            selectedItems.add(nombres[which])
                        }
                        else{
                            selectedItems.remove(nombres[which])
                        }
                    })
                .setPositiveButton("Ok", DialogInterface.OnClickListener { dialogInterface, i ->
                    listener.onItemsSeleted(selectedItems)
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
                    listener.onClickCancel()
                })

            builder.create()
        } ?: throw IllegalStateException("Actividad nula")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMiDialogCasillasVerificacion) {
            listener = context
        }
    }
}