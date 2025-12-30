package com.gauravdubey.androidapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gauravdubey.androidapplication.ui.theme.MyAndroidApplicationTheme
import com.gauravdubey.androidapplication.widgets.ui.action.MyActionButton
import com.gauravdubey.androidapplication.widgets.ui.input.MyInputFiledNumber
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    var inputNumber = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAndroidApplicationTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()
                Scaffold(modifier = Modifier.fillMaxSize(), snackbarHost = { SnackbarHost(hostState = snackbarHostState) }) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    Column(modifier = Modifier.fillMaxSize()) {
                        MyInputFiledNumber(Modifier.fillMaxWidth()) {
                            inputNumber = it.toInt()
                        }
                        MyActionButton("Submit", Modifier.fillMaxWidth()) {
                            scope.launch {
                                snackbarHostState.showSnackbar("Input number is $inputNumber")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAndroidApplicationTheme {
        Greeting("Android")
    }
}