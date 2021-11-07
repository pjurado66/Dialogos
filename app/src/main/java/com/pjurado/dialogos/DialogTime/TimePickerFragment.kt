package com.pjurado.dialogos.DialogTime

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar
import com.pjurado.dialogos.R
import java.sql.Time
import java.util.*


class TimePickerFragment(val listener: (String) -> Unit)
    : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        val picker = TimePickerDialog(activity as Context, this, hour, minute, true)
        return picker
    }



    override fun onTimeSet(view: TimePicker?, hour: Int, minute: Int) {
        listener("$hour:$minute")
    }


}