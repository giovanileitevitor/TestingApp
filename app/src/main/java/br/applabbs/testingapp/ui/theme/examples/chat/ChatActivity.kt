package br.applabbs.testingapp.ui.theme.examples.chat

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
    val users = remember{
        fakeUsers(qtd = 50)
    }

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ){
        users.forEachIndexed { index, usuario ->  
            item {
                UsuarioItem(user = usuario, context = context)
            }
        }
    }

}

@Preview
@Composable
fun PreviewChat(){
    Chat()
}