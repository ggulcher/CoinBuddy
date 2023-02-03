package com.example.coinbuddy.ui.coinlist.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.coinbuddy.R

@Composable
fun SearchBar(
    hint: String,
    modifier: Modifier = Modifier,
    state: MutableState<TextFieldValue>
) {

    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .border(
                border = ButtonDefaults.outlinedBorder,
                shape = RoundedCornerShape(35.dp)
            )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.Gray,
            modifier = Modifier
                .size(35.dp)
                .padding(start = 12.dp),
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            BasicTextField(
                value = state.value,
                onValueChange = {
                    state.value = it
                },
                maxLines = 1,
                singleLine = true,
                textStyle = TextStyle(color = Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged {
                        isHintDisplayed = !it.isFocused
                    }
            )

            if (isHintDisplayed) {
                Text(
                    text = hint,
                    color = Color.Gray,
                    modifier = Modifier
                )
            }

        }
    }
}