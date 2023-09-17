package br.applabbs.testingapp.ui.theme.examples.windows

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.BottomAppBar
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.applabbs.testingapp.R
import br.applabbs.testingapp.ui.theme.Blue1
import br.applabbs.testingapp.ui.theme.Blue2
import br.applabbs.testingapp.ui.theme.OrangeYellow1
import br.applabbs.testingapp.ui.theme.OrangeYellow2

class WindowsActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuWindows()
        }
    }
}

@Composable
fun MenuWindows(){
    var searchText by remember { mutableStateOf("") }
    var isMenuExpanded by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {

            val brush = Brush.horizontalGradient(
                colors = listOf(Blue1, Blue2),
                startX = 100f,
                endX = 200f
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(brush = brush)
            ) {
                Image(
                    painter =  painterResource(R.drawable.ic_windows_3),
                    contentDescription = "image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
                        .align(Alignment.CenterVertically)
                        .background(brush = brush)
                )


            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)

        ){
            Text(text = "conteudo principal", color = Color.Black)
        }
    }


}


@Preview(showSystemUi = true)
@Composable
fun PreviewMenuWindows(){
    MenuWindows()
}