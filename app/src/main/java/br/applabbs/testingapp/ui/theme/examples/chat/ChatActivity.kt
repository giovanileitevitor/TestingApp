package br.applabbs.testingapp.ui.theme.examples.chat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.applabbs.testingapp.R
import br.applabbs.testingapp.ui.theme.ButtonBlue
import br.applabbs.testingapp.ui.theme.MainActivity
import coil.compose.AsyncImagePainter.State.Empty.painter
import kotlinx.coroutines.launch

class ChatActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Chat()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    fun onBack(){
        super.onBackPressed()
        finish()
    }
}

@Composable
fun Chat(){
    val context = LocalContext.current
    val activity = LocalContext.current as ComponentActivity

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = ButtonBlue,
                title = {
                    Text(text = "Chat App")
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
        ListUsuarios(context = context, paddingValues = paddingValues)
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