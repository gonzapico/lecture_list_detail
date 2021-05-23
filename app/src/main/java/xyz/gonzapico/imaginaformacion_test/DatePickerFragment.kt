package xyz.gonzapico.imaginaformacion_test

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment :
    DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(activity as Context,
            { view, year, month, dayOfMonth ->
                Log.d("DatePickerFragment",
                    "Día seleccionado: $dayOfMonth/$month/$year") },
            year,
            month,
            day
        )
    }
}