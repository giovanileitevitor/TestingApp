package br.applabbs.testingapp.ui.theme.parts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxComponent(){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Surface(color = Color.Red, modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)){ }

        Surface(color = Color.Blue, modifier = Modifier
            .width(200.dp)
            .height(200.dp)){ }

        Surface(color = Color.Green, modifier = Modifier
            .width(100.dp)
            .height(100.dp)){ }
    }
}

@Preview
@Composable
private fun ShowBox(){
    BoxComponent()
}