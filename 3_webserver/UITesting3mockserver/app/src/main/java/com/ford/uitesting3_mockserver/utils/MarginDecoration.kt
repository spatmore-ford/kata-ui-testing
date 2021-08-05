package com.ford.uitesting3_mockserver.utils

import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

internal class MarginDecoration(
    @DimenRes
    private val margin: Int,
    private val span: Int,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        val marginInPx = parent.resources.getDimension(margin).toInt()
        val adapterPosition = parent.getChildAdapterPosition(view)

        with(outRect) {
            if (adapterPosition < span) {
                top = marginInPx
            }
            if (span == 1 || adapterPosition % span != span - 1) {
                left = marginInPx
            }
            if (span == 1 || adapterPosition % span != 0) {
                right = marginInPx
            }
            bottom = marginInPx
        }
    }
} 