package xyz.gonzapico.imaginaformacion_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import xyz.gonzapico.imaginaformacion_test.databinding.RowElementBinding
import kotlin.properties.Delegates


class ElementsAdapter(
    dataSet: Array<String>,
    private val listener: (String) -> Unit) :
    RecyclerView.Adapter<ElementsAdapter.ViewHolder>() {

    var items by Delegates.observable(dataSet) { _, _, _ -> notifyDataSetChanged() }

    class ViewHolder(view: View,
                    private val onClick: (String) -> Unit) : RecyclerView.ViewHolder(view) {
        private val binding = RowElementBinding.bind(view)

        fun bind(itemId: String) {
            with (binding) {
                textView.text = itemId
                textView.setOnClickListener{
                    onClick
                }
                // Aquí definiremos el comportamiento del click sobre cada elemento
                root.setOnClickListener {
                    onClick
                }
            }
        }
    }

    // Para crear nuevas vistas
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Crea una nueva vista inflando el layout que le pasemos
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_element, viewGroup, false)

        return ViewHolder(view, listener)
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
