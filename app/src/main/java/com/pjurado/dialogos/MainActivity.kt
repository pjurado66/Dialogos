package com.pjurado.dialogos

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.pjurado.dialogos.ComunicaActivity.OnMiDialogAlertListener
import com.pjurado.dialogos.DialogCasillasdeVerificacion.MiDialogCasillasVerificacion
import com.pjurado.dialogos.DialogCasillasdeVerificacion.OnMiDialogCasillasVerificacion
import com.pjurado.dialogos.DialogDate.DatePickerFragment
import com.pjurado.dialogos.DialogFragment.MiDialogAlert
import com.pjurado.dialogos.DialogLogin.DialogLoginFragment
import com.pjurado.dialogos.DialogRadioButtons.MiDialogRadioButtons
import com.pjurado.dialogos.DialogTime.TimePickerFragment
import com.pjurado.dialogos.Lista.MiDialogLista
import com.pjurado.dialogos.Lista.OnMiDialogListatListener
import com.pjurado.dialogos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnMiDialogAlertListener, OnMiDialogListatListener, OnMiDialogCasillasVerificacion {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btAlertDialog.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Dialogo de alerta")
                .setMessage("Este dialogo se ha creado con un alert dialog")
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("Ok", DialogInterface.OnClickListener { dialogInterface, i ->
                    Snackbar.make(binding.root, "Ha seleccionado Ok", Snackbar.LENGTH_SHORT)
                        .setBackgroundTint(Color.BLUE)
                        .show()
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
                    Snackbar.make(binding.root, "Ha seleccionado Cancel", Snackbar.LENGTH_SHORT)
                        .setBackgroundTint(Color.MAGENTA)
                        .show()
                })
            val dialog = builder.create()
            dialog.show()
        }

        binding.btClaseFragmenttDialog.setOnClickListener {
            MiDialogAlert(binding.root).show(supportFragmentManager, "MiDialog")
        }

        binding.btFragmentDialogAActivity.setOnClickListener {
            MiDialogAlert(binding.root).show(supportFragmentManager, "MiDialog")
        }

        binding.btListaDialog.setOnClickListener {
            MiDialogLista().show(supportFragmentManager, "MiDialogLista")
        }

        binding.btMultiChoice.setOnClickListener {
            MiDialogCasillasVerificacion().show(supportFragmentManager, "MultiChoiceDialog")
        }

        binding.btDialogRadioButton.setOnClickListener {
            MiDialogRadioButtons(binding.root).show(supportFragmentManager, "RadioButtonDialog")
        }

        binding.btDateDialog.setOnClickListener {
            val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
            datePicker.show(supportFragmentManager, "datePicker")
        }

        binding.btTimeDialog.setOnClickListener {
            val timePicker = TimePickerFragment { onTimeSelected(it) }
            timePicker.show(supportFragmentManager, "timePicker")
        }

        binding.btLogin.setOnClickListener {
            DialogLoginFragment(binding.root).show(supportFragmentManager, "login")
        }
    }

    private fun onTimeSelected(it: String) {
        Snackbar.make(binding.root, "La hora es $it", Snackbar.LENGTH_SHORT)
            .setBackgroundTint(Color.BLUE)
            .show()
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        Snackbar.make(binding.root, "La fecha seleccionada es $day/$month/$year", Snackbar.LENGTH_SHORT)
            .setBackgroundTint(Color.MAGENTA)
            .show()
    }

    override fun onPossitiveButtonClick() {
        Snackbar.make(binding.root, "Ha seleccionado Ok", Snackbar.LENGTH_SHORT)
            .setBackgroundTint(Color.BLUE)
            .show()
    }

    override fun onNegativeButtonClick() {
        Snackbar.make(binding.root, "Ha seleccionado Cancel", Snackbar.LENGTH_SHORT)
            .setBackgroundTint(Color.MAGENTA)
            .show()
    }

    override fun onItemClick(nombre: String) {
        Snackbar.make(binding.root, "Ha seleccionado $nombre", Snackbar.LENGTH_SHORT)
            .setBackgroundTint(Color.MAGENTA)
            .show()
    }

    override fun onItemsSeleted(nombre: ArrayList<String>) {
        var cad = ""
        for (n in nombre){
            cad = cad + "  $n"
        }
        Snackbar.make(binding.root, "Ha seleccionado $cad", Snackbar.LENGTH_SHORT)
            .setBackgroundTint(Color.MAGENTA)
            .show()
    }

    override fun onClickCancel() {
        Snackbar.make(binding.root, "Se ha anulado la selección", Snackbar.LENGTH_SHORT)
            .setBackgroundTint(Color.CYAN)
            .show()
    }
}