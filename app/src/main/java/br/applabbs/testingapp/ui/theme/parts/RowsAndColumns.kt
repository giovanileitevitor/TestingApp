package br.applabbs.testingapp.ui.theme.parts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShowRows(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Surface(color = Color.Red, modifier = Modifier
            .width(40.dp)
            .height(40.dp)){ }

        Surface(color = Color.Blue, modifier = Modifier
            .width(40.dp)
            .height(40.dp)){ }

        Surface(color = Color.Green, modifier = Modifier
            .width(40.dp)
            .height(40.dp)){ }
    }
}

@Composable
fun ShowColumns(){
    Column(
        modifier = Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Surface(color = Color.Red, modifier = Modifier
            .width(40.dp)
            .height(40.dp)){ }

        Surface(color = Color.Blue, modifier = Modifier
            .width(40.dp)
            .height(40.dp)){ }

        Surface(color = Color.Green, modifier = Modifier
            .width(40.dp)
            .height(40.dp)){ }
    }
}

@Preview
@Composable
fun PreviewRows(){
    ShowRows()
}

@Preview
@Composable
fun PreviewColumns(){
    ShowColumns()
}