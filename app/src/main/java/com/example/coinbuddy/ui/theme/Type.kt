package com.example.coinbuddy.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.coinbuddy.R

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = FontFamily(
        Font(R.font.raleway_regular),
        Font(R.font.raleway_bold, weight = FontWeight.Bold)
    )
)
