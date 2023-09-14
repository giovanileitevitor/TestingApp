package br.applabbs.testingapp.ui.theme

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import br.applabbs.testingapp.ui.theme.examples.agenda.AgendaActivity
import br.applabbs.testingapp.ui.theme.examples.calcimc.CalculaImcActivity
import br.applabbs.testingapp.ui.theme.examples.chat.ChatActivity
import br.applabbs.testingapp.ui.theme.examples.notes.NotesActivity
import br.applabbs.testingapp.ui.theme.examples.reusecomps.ReusingComponentActivity


class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Home()
        }
    }

}


@Composable
fun Home(){

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Collections of codes using Compose",
                        textAlign = TextAlign.Justify,
                        color = Color.White,
                        maxLines = 1
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .testTag("toolbar"),
                backgroundColor = OrangeYellow1
            )
        }
    ){ paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = OrangeYellow1,
                    contentColor = Color.White
                ),

                onClick = {
                        context.startActivity(Intent(context, AgendaActivity::class.java))
                }
            ){
                Text(text = "Agenda (using Room DB) ")
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = OrangeYellow1,
                    contentColor = Color.White
                ),

                onClick = {
                    context.startActivity(Intent(context, CalculaImcActivity::class.java))
                }
            ){
                Text(text = "Calculadora de IMC ")
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = OrangeYellow1,
                    contentColor = Color.White
                ),

                onClick = {
                    context.startActivity(Intent(context, ChatActivity::class.java))
                }
            ){
                Text(text = "Chat (Lista)")
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = OrangeYellow1,
                    contentColor = Color.White
                ),

                onClick = {
                    context.startActivity(Intent(context, NotesActivity::class.java))
                }
            ){
                Text(text = "Bloco de Notas (with DataStore)")
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = OrangeYellow1,
                    contentColor = Color.White
                ),

                onClick = {
                    context.startActivity(Intent(context, ReusingComponentActivity::class.java))
                }
            ){
                Text(text = "Reuso de componentes")
            }
        }
    }

}

@Preview
@Composable
fun PreviewHome(){
    Home()
}

