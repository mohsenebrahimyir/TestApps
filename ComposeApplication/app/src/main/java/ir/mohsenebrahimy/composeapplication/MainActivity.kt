package ir.mohsenebrahimy.composeapplication

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetUi(this)
        }
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
    Column {
        Text(
            text = "Mohsen",
            modifier = Modifier
                .fillMaxWidth()
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
                // TODO: add action something
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
            shape = CircleShape
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


