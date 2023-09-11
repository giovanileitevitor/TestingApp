package br.applabbs.testingapp.ui.theme.parts


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun AppConstraint(){
    ConstraintLayout(modifier = Modifier.size(200.dp)) {
        val (blueBox, redBox, yellowBox, greenBox, text) = createRefs()

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Red)
            .constrainAs(redBox) {})

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
            .constrainAs(blueBox) {
                top.linkTo(redBox.bottom)
                start.linkTo(redBox.end)
            })

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(yellowBox) {
                top.linkTo(blueBox.bottom)
                start.linkTo(blueBox.end)
            })

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Green)
            .constrainAs(greenBox) {
                top.linkTo(yellowBox.bottom)
                start.linkTo(yellowBox.end)
            })

        Text("Hello World", modifier = Modifier.constrainAs(text) {
            top.linkTo(parent.top)
            start.linkTo(yellowBox.start)
        })

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewAppConstraint(){
    AppConstraint()
}