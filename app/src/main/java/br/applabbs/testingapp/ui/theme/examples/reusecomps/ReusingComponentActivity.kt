package br.applabbs.testingapp.ui.theme.examples.reusecomps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import br.applabbs.testingapp.ui.theme.parts.CustomButton

class ReusingComponentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReusingComponents()
        }
    }
}

@Composable
fun ReusingComponents(){
    Column(
        modifier = Modifier.fillMaxSize(),
    ){
        CustomButton(
            text = "Compartilhar",
            modifier = Modifier.fillMaxWidth().testTag("BtnCompartilhar"),
            onClick = { println("Compartilhar") }
        )

        CustomButton(
            text = "Salvar",
            modifier = Modifier.fillMaxWidth(),
            onClick = { println("Salvar")}
        )

        CustomButton(
            text = "Excluir",
            modifier = Modifier.fillMaxWidth(),
            onClick = {println("Excluir") }
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
   ReusingComponents()
}