package xyz.gonzapico.imaginaformacion_test

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import xyz.gonzapico.imaginaformacion_test.databinding.RowElementBinding
import kotlin.properties.Delegates


class ElementsAdapter(private val dataSet: Array<Persona>,private val listener :(Persona) -> Unit) :
    RecyclerView.Adapter<ElementsAdapter.ViewHolder>() {

    var items by Delegates.observable(dataSet) { _, _, _ -> notifyDataSetChanged() }

    class ViewHolder(view: View,
                     private val onClick: (Persona) -> Unit) : RecyclerView.ViewHolder(view) {
        private val binding = RowElementBinding.bind(view)

        fun bind(p: Persona) {
            with (binding) {
                textView.text = p.nombre +" "+ p.apellidos+ if(p.sexo=='M') " - Hombre" else "- Mujer"
                if(p.sexo=='M')
                    textView.setBackgroundColor(Color.BLUE)
                else
                    textView.setBackgroundColor(Color.RED)
                // Aquí definiremos el comportamiento del click sobre cada elemento
                root.setOnClickListener {
                    onClick(p)
                }
            }
        }
    }

    // Para crear nuevas vistas
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Crea una nueva vista inflando el layout que le pasemos
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_element, viewGroup, false)

        return ViewHolder(view,listener)
    }

    // Reemplaza el contenido de la vista (invocada por el LayoutManager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Obtenemos el elemento de UI y reemplzamos el
        // contenido de la vista con esos valores

        viewHolder.bind(items[position])
    }

    // Tamaño de la lista de elementos (invocado por el LayoutManager)
    override fun getItemCount() = items.size

}
