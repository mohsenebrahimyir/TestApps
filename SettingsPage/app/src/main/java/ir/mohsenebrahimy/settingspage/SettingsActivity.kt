package ir.mohsenebrahimy.settingspage

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val pref = getSharedPreferences("Pref", MODE_PRIVATE)
            val selectedTheme = remember {
                mutableStateOf(pref.getString("selectedTheme", "Auto"))
            }
            val stateComic = remember {
                mutableStateOf(pref.getBoolean("stateComic",false))
            }
            val stateSocial = remember {
                mutableStateOf(pref.getBoolean("stateSocial",false))
            }
            val stateAnimation = remember {
                mutableStateOf(pref.getBoolean("stateAnimation",false))
            }
            val stateAds = remember {
                mutableStateOf(pref.getBoolean("stateAds",false))
            }
            val stateFont = remember {
                mutableFloatStateOf(pref.getFloat("stateFont", 0.12f))
            }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
            ) {
                Text(
                    getString(R.string.app_settings),
                    fontWeight = FontWeight.Black,
                    fontSize = 28.sp,
                )

                Spacer(modifier = Modifier.height(20.dp))
                ColorTheme(selectedTheme)
                Spacer(modifier = Modifier.height(20.dp))
                Topic(stateComic, stateSocial, stateAnimation)
                Spacer(modifier = Modifier.height(20.dp))
                Ads(stateAds)
                Spacer(modifier = Modifier.height(20.dp))
                FontSize(stateFont)
                Spacer(modifier = Modifier.height(40.dp))

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button({
                        val edit = pref.edit()
                        edit.putString("selectedTheme", selectedTheme.value)
                        edit.putBoolean("stateComic", stateComic.value)
                        edit.putBoolean("stateSocial", stateSocial.value)
                        edit.putBoolean("stateAnimation", stateAnimation.value)
                        edit.putBoolean("stateAds", stateAds.value)
                        edit.putFloat("stateFont", stateFont.floatValue)
                        edit.apply()

                        Toast.makeText(
                            this@SettingsActivity,
                            "Save successful!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Text("Save")
                    }
                }
            }

        }
    }

    @Composable
    fun ColorTheme(selectedItem: MutableState<String?>) {

        val radiosButtons = mutableListOf("Auto", "Dark", "Light")

        Row {
            radiosButtons.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (selectedItem.value == item),
                        onClick = {
                            selectedItem.value = item
                        },
                        colors = RadioButtonDefaults.colors()
                    )

                    Text(
                        text = item,
//                        fontSize = 10.sp
                    )
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
    fun Topic(
        checkStateComic: MutableState<Boolean>,
        checkStateSocial: MutableState<Boolean>,
        checkStateAnimation: MutableState<Boolean>
    ) {

        Row {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkStateComic.value,
                    onCheckedChange = { state ->
                        checkStateComic.value = state
                    },
                    colors = CheckboxDefaults.colors()
                )

                Text("Comic")
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkStateSocial.value,
                    onCheckedChange = { state ->
                        checkStateSocial.value = state
                    },
                    colors = CheckboxDefaults.colors()
                )

                Text("Social")
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkStateAnimation.value,
                    onCheckedChange = { state ->
                        checkStateAnimation.value = state
                    },
                    colors = CheckboxDefaults.colors()
                )

                Text("Animation")
            }
        }
    }

    @Composable
    fun Ads(stateAds: MutableState<Boolean>) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Advertising")

            Switch(
                checked = stateAds.value,
                onCheckedChange = { state ->
                    stateAds.value = state
                },
                modifier = Modifier.scale(0.7f)
            )
        }
    }

    @Composable
    fun FontSize(stateFont: MutableState<Float>) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text("Font Size")

            Slider(
                value = stateFont.value,
                onValueChange = {
                    stateFont.value = it
                },
                colors = SliderDefaults.colors(
                    activeTrackColor = Color.Blue,
                    inactiveTrackColor = Color.Red,
                    thumbColor = Color.Magenta
                ),
                modifier = Modifier
                    .width(250.dp)
            )

            Text(getFont(stateFont.value).toString())
        }

        Text(
            text = "This is sample text",
            fontSize = getFont(stateFont.value).sp
        )
    }

    private fun getFont(size: Float): Int {
        val fs = "%.2f".format(size)
        return fs.replace(".", "").toInt()
    }

}
