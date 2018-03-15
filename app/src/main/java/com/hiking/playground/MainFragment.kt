package com.hiking.playground

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_main, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context!!)
            adapter = MainAdapter(context!!)
            registerForContextMenu(this)
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu, view: View,
                                     menuInfo: ContextMenu.ContextMenuInfo?) {
        menu.setHeaderTitle(R.string.menu_title)
        activity!!.menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as ContextMenuRecyclerView.ContextMenuInfo
        val position = info.position
        val data = info.itemView.tag
        val message = getString(R.string.clicked_format, item.title, position, data)
        AlertDialog.Builder(context!!).setMessage(message).show()
        return true
    }
}
