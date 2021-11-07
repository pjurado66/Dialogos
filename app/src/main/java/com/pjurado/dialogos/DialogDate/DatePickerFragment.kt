package com.pjurado.dialogos.DialogDate

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar
import com.pjurado.dialogos.R
import java.util.*


class DatePickerFragment(val funciondelmain: (day: Int, month: Int, year: Int) -> Unit)
    : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val picker = DatePickerDialog(activity as Context, this, year, month, day)
        return picker
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
        funciondelmain(day, month+1, year)
    }


}