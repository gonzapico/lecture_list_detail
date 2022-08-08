package xyz.gonzapico.imaginaformacion_test

import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import xyz.gonzapico.imaginaformacion_test.databinding.RowElementBinding


class ElementsAdapter(private val dataSet: Array<Persona>) :
    RecyclerView.Adapter<ElementsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView = view.findViewById(R.id.textView)
        val textViewsexo: TextView = view.findViewById(R.id.textViewsexo)

        init {

        }
    }
    // Para crear nuevas vistas
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Crea una nueva vista inflando el layout que le pasemos
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_element, viewGroup, false)

        return ViewHolder(view)
    }

    // Reemplaza el contenido de la vista (invocada por el LayoutManager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Obtenemos el elemento de UI y reemplzamos el
        // contenido de la vista con esos valores
        viewHolder.textView.text = dataSet[position].nombre+" "+dataSet[position].apellidos
        if(dataSet[position].sexo=='M') {
            viewHolder.textView.setBackgroundColor(Color.BLUE)
            viewHolder.textViewsexo.setBackgroundColor(Color.BLUE)
            viewHolder.textViewsexo.text="Hombre"
        }
        else {
            viewHolder.textView.setBackgroundColor(Color.RED)
            viewHolder.textViewsexo.setBackgroundColor(Color.RED)
            viewHolder.textViewsexo.text="Mujer"
        }
    }

    // Tamaño de la lista de elementos (invocado por el LayoutManager)
    override fun getItemCount() = dataSet.size

}
