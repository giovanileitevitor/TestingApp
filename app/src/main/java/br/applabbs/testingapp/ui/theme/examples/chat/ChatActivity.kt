package br.applabbs.testingapp.ui.theme.examples.chat

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import br.applabbs.testingapp.R
import br.applabbs.testingapp.ui.theme.ButtonBlue

class ChatActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Chat()
        }
    }
}

@Composable
fun Chat(){
    val localContext = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = ButtonBlue,
                title = {
                    Text(text = "Chat App")
                },
                contentColor = Color.White
            )
        }
    ) { paddingValues ->
        ListUsuarios(context = localContext, paddingValues = paddingValues)
    }
}

@Composable
fun ListUsuarios(context: Context, paddingValues: PaddingValues){
    val listaUsuarios: MutableList<Usuario> = mutableListOf(
        Usuario(nome = "Joao Jose Jesus", foto = R.drawable.city),
        Usuario(nome = "Joao Jose Jesus", foto = R.drawable.city),
        Usuario(nome = "Joao Jose Jesus", foto = R.drawable.city),
        Usuario(nome = "Joao Jose Jesus", foto = R.drawable.city),
        Usuario(nome = "Joao Jose Jesus", foto = R.drawable.city),
        Usuario(nome = "Joao Jose Jesus", foto = R.drawable.city),
        Usuario(nome = "Joao Jose Jesus", foto = R.drawable.city),
        Usuario(nome = "Joao Jose Jesus", foto = R.drawable.city),
        Usuario(nome = "Joao Jose Jesus", foto = R.drawable.city),
    )

    LazyColumn(modifier = Modifier.padding(paddingValues)){
        itemsIndexed(listaUsuarios){ position, _ ->
            UsuarioItem(users =  listaUsuarios, position = position, context = context)
        }
    }

}

@Preview
@Composable
fun PreviewChat(){
    Chat()
}