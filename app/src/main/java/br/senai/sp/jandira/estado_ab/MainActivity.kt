package br.senai.sp.jandira.estado_ab

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.estado_ab.ui.theme.EstadoABTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EstadoABTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var nomeState = remember {
        mutableStateOf("")
    }

    var checkState = remember {
        mutableStateOf(false)
    }



    Column {
        OutlinedTextField(
            value = nomeState.value,
            onValueChange = {
                nomeState.value = it
            })
        Text(text = nomeState.value)
        Row {
            Checkbox(checked = checkState.value, onCheckedChange = {
                checkState.value = it
            } )
            Button(onClick = { checkState.value = !checkState.value }) {
                
            }
        }
   }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EstadoABTheme {
        Greeting("Android")
    }
}