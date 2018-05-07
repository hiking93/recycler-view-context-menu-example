package com.hiking.example.recyclerviewcontextmenu

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.ContextMenu
import android.view.View

/**
 * Recycler view with context menu implemented.
 *
 * @author Created by hiking on 2018/3/14.
 */
class ContextMenuRecyclerView : RecyclerView {

    private var contextMenuInfo: ContextMenuInfo? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun getContextMenuInfo() = contextMenuInfo

    override fun showContextMenuForChild(originalView: View): Boolean {
        saveContextMenuInfo(originalView)
        return super.showContextMenuForChild(originalView)
    }

    override fun showContextMenuForChild(originalView: View, x: Float, y: Float): Boolean {
        saveContextMenuInfo(originalView)
        return super.showContextMenuForChild(originalView, x, y)
    }

    private fun saveContextMenuInfo(originalView: View) {
        val position = getChildAdapterPosition(originalView)
        val longId = getChildItemId(originalView)
        contextMenuInfo = ContextMenuInfo(this, originalView, position, longId)
    }

    class ContextMenuInfo(
            val recyclerView: RecyclerView,
            val itemView: View,
            val position: Int,
            val id: Long
    ) : ContextMenu.ContextMenuInfo
}