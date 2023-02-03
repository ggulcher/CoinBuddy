package com.example.coinbuddy.ui.coindetail.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.coinbuddy.ui.coindetail.ChartViewState
import com.example.coinbuddy.ui.coindetail.CoinDetailViewModel
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

@Composable
fun CoinChart(
    state: CoinDetailViewModel.CoinDetailState,
    change: Double
) {
    val data = mutableListOf<Entry>()
    val context = LocalContext.current

    state.chart?.let { chartsValue ->
        chartsValue.map { value ->
            for (i in value) {
                data.add(Entry(value[0], value[1]))
            }
        }
    }

    AndroidView(
        factory = { contextFactory ->
            LineChart(contextFactory)
        },
        update = { lineChart ->

            val dataSet =
                ChartViewState().getLineDataSet(
                    context = context,
                    lineData = data,
                    change = change,
                    label = "change chart"
                )

            lineChart.apply {
                description.isEnabled = false
                isDragEnabled = false
                xAxis.isEnabled = false
                axisLeft.setDrawAxisLine(false)
                axisLeft.textColor = Color.Black.toArgb()
                axisRight.isEnabled = false
                legend.isEnabled = false
                setTouchEnabled(false)
                setScaleEnabled(false)
                setDrawGridBackground(false)
                setDrawBorders(false)
                drawLineData(dataSet)
                invalidate()
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(300.dp)
    )
}

fun LineChart.drawLineData(
    lineDataSet: LineDataSet? = null,
) {
    if (lineDataSet != null) {
        clear()
        data = LineData(lineDataSet).apply {
            setDrawValues(false)
        }
    }
}
