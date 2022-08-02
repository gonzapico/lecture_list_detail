package xyz.gonzapico.imaginaformacion_test

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ElementsAdapter(private val dataSet: ArrayList<MainActivity.User>) :
    RecyclerView.Adapter<ElementsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contenedorDatos: FrameLayout = view.findViewById(R.id.contenedorDatos)
        val tvNombre: TextView = view.findViewById(R.id.tvNombre)
        val tvApellidos: TextView = view.findViewById(R.id.tvApellidos)
        val tvSexo: TextView = view.findViewById(R.id.tvSexo)

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
        viewHolder.tvNombre.text = dataSet[position].nombre
        viewHolder.tvApellidos.text = dataSet[position].apellidos
        viewHolder.tvSexo.text = dataSet[position].sexo

        if(dataSet[position].sexo.equals("Varón")) {
            viewHolder.contenedorDatos.setBackgroundColor(Color.GREEN)
        }
    }

    // Tamaño de la lista de elementos (invocado por el LayoutManager)
    override fun getItemCount() = dataSet.size

}
