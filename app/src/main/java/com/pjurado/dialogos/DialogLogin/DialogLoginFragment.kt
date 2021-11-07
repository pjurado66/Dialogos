package com.pjurado.dialogos.DialogLogin

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar
import com.pjurado.dialogos.R
import com.pjurado.dialogos.databinding.DialogLoginBinding


class DialogLoginFragment(val myView: View): DialogFragment() {
    private lateinit var binding: DialogLoginBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater;
            val binding = DialogLoginBinding.inflate(inflater, myView as ViewGroup, false)

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(binding.root)
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("Ok", DialogInterface.OnClickListener { dialogInterface, i ->
                    Snackbar.make(myView, "Usuario ${binding.username.text}", Snackbar.LENGTH_SHORT)
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