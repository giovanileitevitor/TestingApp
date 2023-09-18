package br.applabbs.testingapp.ui.theme.examples.appcitizen

import android.content.Context
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.RoundedCorner
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.applabbs.testingapp.R


class CitizenActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCitizen(context = this)
        }
    }
}

@Composable
fun AppCitizen(context: Context){
    //val activity = LocalContext.current as ComponentActivity
    //val context = LocalContext.current
    val viewModel : CitizenViewModel = viewModel()
    //val count by viewModel.count.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.city),
                contentScale = ContentScale.FillHeight
            )
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_hamburguer),
                contentDescription = "empty",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .clickable {
                        (context as ComponentActivity).finish()
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "empty",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .clickable {
                        Toast
                            .makeText(context, "botao search", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCitizen(){
    AppCitizen(context = LocalContext.current)
}