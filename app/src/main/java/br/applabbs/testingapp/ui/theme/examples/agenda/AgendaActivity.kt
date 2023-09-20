package br.applabbs.testingapp.ui.theme.examples.agenda

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.applabbs.testingapp.R
import br.applabbs.testingapp.ui.theme.examples.agenda.views.ContatoItem

class AgendaActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //val navController = rememberNavController(navigators = )
            Agenda()
        }

    }
}

@Composable
fun Agenda(){

    //val activity = LocalContext.current as ComponentActivity
    val localContext = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Red,
                title = {
                    Text(text = "Agenda with Room DB")
                },
                contentColor = Color.White,
                navigationIcon = {
                    IconButton(
                        onClick = {
                            //activity.finish()
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        ListaContatos(paddingValues = paddingValues, navController = navController)
    }
}

@Composable
fun ListaContatos(paddingValues: PaddingValues, navController: NavController){
    val listaContatos : MutableList<Contato> = mutableListOf()

    LazyColumn(modifier = Modifier.padding(paddingValues = paddingValues)){
        itemsIndexed(listaContatos){ position, item ->
            ContatoItem(
                navController = navController,
                position = position,
                listContatos = listaContatos,
                context = LocalContext.current
            )
        }
    }
}

@Preview
@Composable
fun PreviewAgenda(){
    Agenda()
}