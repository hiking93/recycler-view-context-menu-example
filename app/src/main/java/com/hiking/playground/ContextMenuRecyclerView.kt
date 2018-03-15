package com.hiking.playground

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

    override fun showContextMenuForChild(originalView: View, x: Float, y: Float): Boolean {
        val position = getChildAdapterPosition(originalView)
        val longId = getChildItemId(originalView)
        contextMenuInfo = ContextMenuInfo(this, originalView, position, longId)
        return super.showContextMenuForChild(originalView, x, y)
    }

    class ContextMenuInfo(
            val recyclerView: RecyclerView,
            val itemView: View,
            val position: Int,
            val id: Long
    ) : ContextMenu.ContextMenuInfo
}