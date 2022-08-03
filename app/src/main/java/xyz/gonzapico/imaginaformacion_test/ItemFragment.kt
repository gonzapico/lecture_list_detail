package xyz.gonzapico.imaginaformacion_test

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import xyz.gonzapico.imaginaformacion_test.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment(), MyItemRecyclerViewAdapter.OnItemClickListener {

    private var columnCount = 1
    private var dualPane: Boolean = true
    private var curCheckPosition = 0

    private fun showDetails(index: Int) {
        curCheckPosition = index

        if (dualPane) {
            // We can display everything in-place with fragments, so update
            // the list to highlight the selected item and show the data.
            // listView.setItemChecked(index, true)

            // Check what fragment is currently shown, replace if needed.
            var details = parentFragmentManager.findFragmentById(R.id.details) as? DetailsFragment
            if (details?.getShownIndex() != index) {
                // Make new fragment to show this selection.
                details = DetailsFragment.newInstance(index)

                // Execute a transaction, replacing any existing fragment
                // with this one inside the frame.
                parentFragmentManager.beginTransaction().apply {
                    if (index == 0) {
                        replace(R.id.details, details)
                    }
                    setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    commit()
                }
            }

        } else {
            // Otherwise we need to launch a new activity to display
            // the dialog fragment with selected text.
            val intent = Intent().apply {
                activity?.let { setClass(it, DetailActivity::class.java) }
                putExtra(DetailActivity.INDEX, index)
            }
            startActivity(intent);
            activity?.overridePendingTransition(R.anim.translate_left_side, R.anim.exit_left_side);

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyItemRecyclerViewAdapter(PlaceholderContent.ITEMS){
                    Log.d("test", it.id + " y " + it.content)
                    showDetails(it.id.toInt())
                }
            }
        }

        // Check to see if we have a frame in which to embed the details
        // fragment directly in the containing UI.
        val detailsFrame: View? = activity?.findViewById(R.id.details)
        dualPane =  detailsFrame?.visibility == View.VISIBLE

        curCheckPosition = savedInstanceState?.getInt("curChoice", 0) ?: 0

        if (dualPane) {
            // In dual-pane mode, the list view highlights the selected item.
            // listView.choiceMode = ListView.CHOICE_MODE_SINGLE
            // Make sure our UI is in the correct state.
            showDetails(curCheckPosition)
        }

        return view
    }

    override fun onClickElement(item: PlaceholderContent.PlaceholderItem) {
        showDetails(item.id.toInt())
    }
}