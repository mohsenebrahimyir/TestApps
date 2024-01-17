package ir.mohsenebrahimy.composeapplication

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                var text by remember {
                    mutableStateOf(TextFieldValue())
                }

                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    placeholder = {
                        Text(
                            text = "محسن",
                            modifier = Modifier.fillMaxWidth(),
                            style = TextStyle(
                                color = Color.Magenta,
                                textDirection = TextDirection.Rtl
                            )
                        )
                    },
                    label = {
                        Text(
                            text = "محسن",
                            modifier = Modifier.fillMaxWidth(),
                            style = TextStyle(
                                color = Color.Magenta,
                                textDirection = TextDirection.Rtl
                            )
                        )
                    },
                    textStyle = TextStyle(
                        color = Color.Magenta,
                        textDirection = TextDirection.Rtl
                    ),
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_call),
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .width(300.dp)
                        .padding(25.dp)
                )
            }
//            SetUi(this)
        }
    }


    @Preview(
        showBackground = true,
        name = "Test",
        widthDp = 410,
        heightDp = 500,
        showSystemUi = true,
        device = Devices.PIXEL_2
    )
    @Composable
    fun SetUi(context: Context?) {
        Card(
            modifier = Modifier.padding(30.dp),
            elevation = CardDefaults
                .elevatedCardElevation(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.Red)
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                var text by remember {
                    mutableStateOf("Mohsen")
                }
                Text(
                    text = text,
                    modifier = Modifier
                        .padding(
                            bottom = 30.dp,
                            start = 30.dp
                        )
                        .background(
                            colorResource(
                                id = R.color.teal_200
                            )
                        )
                        .padding(20.dp),
                    color = colorResource(
                        id = R.color.purple_200
                    )
                )
                Button(
                    onClick = {
                        text = "Ebrahimi"
                        Toast.makeText(
                            context,
                            "Test Application",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .background(
                            colorResource(
                                id = R.color.purple_200
                            )
                        )
                        .padding(
                            start = 30.dp
                        ),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Cyan
                    )
                ) {
                    Text(
                        text = "Click",
                        color = colorResource(
                            id = R.color.purple_200
                        ),
                        modifier = Modifier
                            .padding(
                                top = 15.dp,
                                bottom = 15.dp
                            )
                    )
                }

                Surface(
                    shape = CircleShape,
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.ic_launcher_background
                        ),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = null,
                        modifier = Modifier
                            .width(200.dp)
                            .height(200.dp)
                    )
                }

                Surface(
                    shape = CircleShape,
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.ic_launcher_background
                        ),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = null,
                        modifier = Modifier
                            .width(200.dp)
                            .height(200.dp)
                    )
                }
                Surface(
                    shape = CircleShape,
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.ic_launcher_background
                        ),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = null,
                        modifier = Modifier
                            .width(200.dp)
                            .height(200.dp)
                    )
                }
            }
        }
    }
}



