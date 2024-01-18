package ir.mohsenebrahimy.composelogin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.mohsenebrahimy.composelogin.ui.theme.ComposeLogInTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetUi()
        }
    }

    private val username = mutableStateOf(TextFieldValue())
    private val password = mutableStateOf(TextFieldValue())
    private val phonenum = mutableStateOf(TextFieldValue())

    private val userError = mutableStateOf(false)
    private val passError = mutableStateOf(false)
    private val phoneError = mutableStateOf(false)

    @Composable
    fun SetUi() {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .background(Color.Black)
                    .padding(top = 50.dp)
                    .width(200.dp)
                    .height(200.dp)
            )

            MyEditText("نام کاربری", username, userError)
            MyEditText("رمز عبور", password, passError)
            MyEditText("شماره همراه", phonenum, phoneError, true)

            Button(
                onClick = {
                    userError.value = username.value.text.isEmpty()
                    passError.value = password.value.text.length < 5
                    phoneError.value = phonenum.value.text.length == 11
                },
                modifier = Modifier
                    .width(280.dp)
                    .padding(top = 20.dp)
            ) {
                Text(
                    text = "click here",
                    fontSize = 22.sp
                )
            }
        }
    }

    @Composable
    fun MyEditText(
        label: String,
        valueText: MutableState<TextFieldValue>,
        valueError: MutableState<Boolean>,
        isNumber: Boolean = false
    ) {

        var text by remember { valueText }
        var error by remember { valueError }
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = {
                    Text(
                        text = label,
                        style = TextStyle(
                            textDirection = TextDirection.Rtl,
                            textAlign = TextAlign.Right
                        )
                    )
                },
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    textDirection = TextDirection.Ltr
                ),
                keyboardOptions = if (isNumber)
                    KeyboardOptions(keyboardType = KeyboardType.Number)
                else
                    KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier
                    .padding(top = 30.dp)
                    .width(288.dp),
                isError = error,
                supportingText = {
                    if (error) {
                        Text(text = "please fill filled")
                    }
                }
            )
        }
    }
}