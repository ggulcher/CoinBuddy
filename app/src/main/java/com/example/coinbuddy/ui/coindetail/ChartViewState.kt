package com.example.coinbuddy.ui.coindetail

import android.content.Context
import com.example.coinbuddy.R
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet

class ChartViewState {

    fun getLineDataSet(
        context: Context,
        lineData: List<Entry>,
        label: String,
        change: Double
    ) =
        LineDataSet(lineData, label).apply {
            mode = LineDataSet.Mode.CUBIC_BEZIER
            color = getColorStatus(context, change)
            highLightColor = getColorStatus(context, change)
            fillDrawable = getBackground(context, change)
            lineWidth = 2f
            setDrawFilled(true)
            setDrawCircles(false)
        }

    private fun getColorStatus(
        context: Context,
        change: Double
    ) = if (change < 0) {
        context.getColor(R.color.red)
    } else context.getColor(R.color.green)

    private fun getBackground(
        context: Context,
        oneDayChange: Double
    ) = if (oneDayChange < 0) {
        context.getDrawable(R.drawable.red_graph_gradient)
    } else context.getDrawable(R.drawable.green_graph_gradient)
}
