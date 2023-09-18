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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import br.applabbs.testingapp.ui.theme.examples.agenda.AgendaActivity
import br.applabbs.testingapp.ui.theme.examples.appcitizen.CitizenActivity
import br.applabbs.testingapp.ui.theme.examples.calcimc.CalculaImcActivity
import br.applabbs.testingapp.ui.theme.examples.chat.ChatActivity
import br.applabbs.testingapp.ui.theme.examples.notes.NotesActivity
import br.applabbs.testingapp.ui.theme.examples.reusecomps.ReusingComponentActivity
import br.applabbs.testingapp.ui.theme.examples.windows.WindowsActivity
import br.applabbs.testingapp.ui.theme.parts.CustomCard


class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Home()
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(){

    val context = LocalContext.current
    val scrollBehavier = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavier.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Collections of codes using Compose",
                        textAlign = TextAlign.Justify,
                        fontSize = 18.sp,
                        color = Color.Black,
                        maxLines = 1
                    )
                },
                scrollBehavior = scrollBehavier,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .testTag("toolbar"),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = OrangeYellow1
                )

            )
        }
    ){ paddingValues ->

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
        ) {

            CustomCard(text = "Calculadora de IMC") {
                context.startActivity(Intent(context, CalculaImcActivity::class.java))
            }

            CustomCard(text = "Chat (Lista)") {
                context.startActivity(Intent(context, ChatActivity::class.java))
            }

            CustomCard(text = "Bloco de Notas (with DataStore)") {
                context.startActivity(Intent(context, NotesActivity::class.java))
            }

            CustomCard(text = "Reuso de componentes") {
                context.startActivity(Intent(context, ReusingComponentActivity::class.java))
            }

            CustomCard(text = "Agenda (using Room DB) - under development") {
                context.startActivity(Intent(context, AgendaActivity::class.java))
            }

            CustomCard(text = "Menu tipo Windows - under development") {
                context.startActivity(Intent(context, WindowsActivity::class.java))
            }

            CustomCard(text = "App Citizen - under development") {
                context.startActivity(Intent(context, CitizenActivity::class.java))
            }

        }
    }

}

@Preview
@Composable
fun PreviewHome(){
    Home()
}

data class Element(
    val title: String,
    val className: Intent
)

