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
import androidx.navigation.compose.rememberNavController
import br.applabbs.testingapp.R

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

    val activity = LocalContext.current as ComponentActivity

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
                            activity.finish()
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
        ListaContatos(context = localContext, paddingValues = paddingValues)
    }
}

@Composable
fun ListaContatos(context: Context, paddingValues: PaddingValues){
    val listaContatos : MutableList<Contato> = mutableListOf(

    )

    LazyColumn(modifier = Modifier.padding(paddingValues = paddingValues)){
        itemsIndexed(listaContatos){ position, _ ->

        }
    }
}

@Preview
@Composable
fun PreviewAgenda(){
    Agenda()
}