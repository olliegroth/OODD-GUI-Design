import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun nameEntryApp() {
    var name by remember { mutableStateOf("") }
    var greeting by remember { mutableStateOf("") }

    MaterialTheme {
        Column {
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Enter your name") }
            )
            Button(onClick = { greeting = "Hello $name!" }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {
                Text("Enter", color = Color.Red)
            }
            Text(greeting)
        }
    }
}

@Composable
@Preview
fun counterApp() {
    var counter by remember { mutableStateOf(0) }

    MaterialTheme {
        Column {
            Button(
                onClick = { counter++ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(counter.toString(), color = Color.Red)
            }
        }
    }
}

@Composable
@Preview
fun conversionApp() {
    var feet by remember { mutableStateOf("") }
    var meters by remember { mutableStateOf(0.0) }

    MaterialTheme {
        Column {
            TextField(
                value = feet,
                onValueChange = { feet = it },
                label = { Text("Enter feet: ") }
            )
            Button(onClick = { meters = feet.toDoubleOrNull()?.times(0.305) ?: 0.0 },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {
                Text("Convert to meters", color = Color.Red)
            }
            Text("Meters: $meters")
        }
    }
}

@Composable
@Preview
fun metersToFeetApp() {
    var meters by remember { mutableStateOf("") }
    var feet by remember { mutableStateOf(0.0) }

    MaterialTheme {
        Column {
            TextField(
                value = meters,
                onValueChange = { meters = it },
                label = { Text("Enter meters: ") }
            )
            Button(onClick = { feet = meters.toDoubleOrNull()?.div(0.305) ?: 0.0 },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {
                Text("Convert to feet", color = Color.Red)
            }
            Text("Feet: $feet")
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        Column {
            nameEntryApp()
            counterApp()
            conversionApp()
            metersToFeetApp()
        }
    }
}