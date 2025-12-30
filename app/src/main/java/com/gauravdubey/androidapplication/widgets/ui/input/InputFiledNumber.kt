package com.gauravdubey.androidapplication.widgets.ui.input

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyInputFiledNumber(modifier: Modifier = Modifier, onValueChange: (String) -> Unit) {
    var inputText : Int by remember { mutableIntStateOf(0) }

    TextField(value = inputText.toString(), modifier = modifier.padding(5.dp), onValueChange = { value ->
        onValueChange(value)
        inputText = value.toInt()
    }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
}

@Preview(showBackground = true)
@Composable
fun PreviewMyInputFieldNumber() {
    MyInputFiledNumber {

    }
}