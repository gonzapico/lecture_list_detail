package xyz.gonzapico.imaginaformacion_test

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*
import java.util.Calendar.YEAR

class DatePickerFragment :
    DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val picker = DatePickerDialog(activity as Context,
            R.style.DatePickerTheme,
            { view, year, month, dayOfMonth ->
                Log.d("DatePickerFragment",
                    "Día seleccionado: $dayOfMonth/$month/$year") },
            year, month, day)
        // Sólo podemos cambiar el año hasta 18 años antes
        c.add(YEAR, -118)
        picker.datePicker.minDate = c.timeInMillis
        // El máximo día para elegir es el día de hoy del año actual
        c.add(YEAR, 100)
        picker.datePicker.maxDate = c.timeInMillis
        return picker
    }
}