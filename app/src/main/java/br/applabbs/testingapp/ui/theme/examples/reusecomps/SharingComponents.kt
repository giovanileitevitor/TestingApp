package br.applabbs.testingapp.ui.theme.examples.reusecomps

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(text: String, modifier: Modifier, onClick: () -> Unit){
    Button(
        onClick = onClick,
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 20.dp,
            pressedElevation = 5.dp,
            disabledElevation = 0.dp,
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2196F3),
            contentColor = Color.White
        ),

        modifier = modifier
    ){
        Text(
            text = text
        )
    }
}

@Preview
@Composable
fun PreviewCustomButton(){
    CustomButton(
        text = "Compartilhar",
        modifier = Modifier,
        onClick = { }
    )
}