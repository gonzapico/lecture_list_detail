package xyz.gonzapico.imaginaformacion_test

import android.R
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*


class TimePickerFragment :
    DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        val picker = TimePickerDialog(activity as Context,
            object: TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {

                    var am_pm = ""

                    val datetime = Calendar.getInstance()
                    datetime[Calendar.HOUR_OF_DAY] = hourOfDay
                    datetime[Calendar.MINUTE] = minute

                    if (datetime[Calendar.AM_PM] === Calendar.AM) am_pm =
                        "AM" else if (datetime[Calendar.AM_PM] === Calendar.PM) am_pm = "PM"

                    val strHrsToShow =
                        if (datetime[Calendar.HOUR] === 0) "12" else datetime[Calendar.HOUR].toString() + ""

                    (activity!!.findViewById<View>(R.id.btnEventStartTime) as Button).setText(
                        strHrsToShow + ":" + datetime[Calendar.MINUTE] + " " + am_pm
                    )


                    Log.d("TimePickerFragment", "hora $hourOfDay minuto $minute")
                }
        }, hour, minute, true)
        return picker
    }
}