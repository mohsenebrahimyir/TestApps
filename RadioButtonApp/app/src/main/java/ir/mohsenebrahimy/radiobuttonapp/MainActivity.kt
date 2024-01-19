package ir.mohsenebrahimy.radiobuttonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Radio()

                Check()

                SwitchButton()
            }
        }
    }

    @Composable
    fun Radio() {


        val radiosButtons = mutableListOf("Auto", "Dark", "Light")
        val selectedItem = remember {
            mutableStateOf(radiosButtons[0])
        }

        Row {
            radiosButtons.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (selectedItem.value == item),
                        onClick = {
                            selectedItem.value = item
                        }
                    )

                    Text(item)
                }
            }

            OutlinedButton(
                onClick = {
                    selectedItem.value = "Auto"
                },
                modifier = Modifier
                    .padding(start = 20.dp)
            ) {
                Text(text = "Reset")
            }
        }
    }

    @Composable
    fun Check() {
        val checkState = remember {
            mutableStateOf(false)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkState.value,
                onCheckedChange = { state ->
                    checkState.value = state
                }
            )

            Text("Mute")
        }
    }

    @Composable
    fun SwitchButton() {
        val checkState = remember {
            mutableStateOf(false)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                checked = checkState.value,
                onCheckedChange = { state ->
                    checkState.value = state
                },
                modifier = Modifier.scale(0.6f),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color.Blue,
                    checkedBorderColor = Color.Black,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color.Red,
                    uncheckedBorderColor = Color.Black
                )
            )
            Text("Mute")
        }
    }
}
