package com.gauravdubey.androidapplication.widgets.ui.action

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyActionButton(title: String = "Default Text", modifier: Modifier = Modifier, onClick: () -> Unit){
    Button(onClick = onClick, modifier = modifier) {
        Text(text = title)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyActionButton(){
    MyActionButton {

    }
}