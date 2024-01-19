package ir.mohsenebrahimy.radiobuttonapp

import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.mohsenebrahimy.radiobuttonapp.ui.theme.RadioButtonAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (
                Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Radio()
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
                Row (
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
}
