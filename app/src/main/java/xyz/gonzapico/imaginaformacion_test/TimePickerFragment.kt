package xyz.gonzapico.imaginaformacion_test

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*
import java.util.Calendar.YEAR

class TimePickerFragment :
    DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        return TimePickerDialog(
            activity as Context,
            { _, hourOfDay, minute ->
                Log.d(
                    "TimePickerFragment",
                    "hora $hourOfDay minuto $minute"
                )
            }, hour, minute, false
        )
    }
}