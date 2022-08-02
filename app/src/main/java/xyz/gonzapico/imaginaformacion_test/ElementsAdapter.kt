package xyz.gonzapico.imaginaformacion_test

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ElementsAdapter(private val dataSet: Array<MainActivity.Persona>) :
    RecyclerView.Adapter<ElementsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fila: LinearLayout = view.findViewById(R.id.fila)
        val textView: TextView = view.findViewById(R.id.textView)
        val textView2: TextView = view.findViewById(R.id.textView2)
        val textView3: TextView = view.findViewById(R.id.textView3)


        init {
            // Aquí definiremos el comportamiento del click sobre cada elemento
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
        viewHolder.textView.text = dataSet[position].nombre
        viewHolder.textView2.text = dataSet[position].apellido
        viewHolder.textView3.text = dataSet[position].sexo.toString()

        viewHolder.fila.setBackgroundColor(
            when(dataSet[position].sexo){
                MainActivity.Sexo.MASCULINO -> Color.CYAN
                MainActivity.Sexo.FEMENINO -> Color.MAGENTA
            }
        )
    }

    // Tamaño de la lista de elementos (invocado por el LayoutManager)
    override fun getItemCount() = dataSet.size

}
