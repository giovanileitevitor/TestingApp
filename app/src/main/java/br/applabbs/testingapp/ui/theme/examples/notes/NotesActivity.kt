package br.applabbs.testingapp.ui.theme.examples.notes

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.applabbs.testingapp.R
import br.applabbs.testingapp.ui.theme.Black
import br.applabbs.testingapp.ui.theme.Gold
import br.applabbs.testingapp.ui.theme.White
import kotlinx.coroutines.launch

class NotesActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Notepad()
        }
    }
}

@Composable
fun Notepad(){

    val activity = LocalContext.current as ComponentActivity
    val context = LocalContext.current
    var anotacao by remember { mutableStateOf("")}
    val storeNotes = StoreNotes(context = context)
    val scope = rememberCoroutineScope()
    val notesSaved = storeNotes.getNote.collectAsState(initial = "")

    anotacao = notesSaved.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Bloco de Notas",
                        fontSize = 22.sp,
                        color = Color.Black
                    )
                },
                backgroundColor = Gold,
                navigationIcon = {
                    IconButton(
                        onClick = { activity.finish() }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        storeNotes.saveNote(note = anotacao)
                        Toast.makeText(context, "Note saved with success !!", Toast.LENGTH_SHORT).show()
                    }
                },
                backgroundColor = Gold,
                elevation = FloatingActionButtonDefaults.elevation(8.dp)
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_salvar),
                    contentDescription = "icone"
                )
            }
        },
        modifier = Modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            TextField(
                value = anotacao,
                onValueChange = {
                    anotacao = it
                },
                label = {
                    Text(
                        text = "Digite a sua anotação..."
                        )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                textStyle = TextStyle(
                    fontSize = 28.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = White,
                    cursorColor = Gold,
                    focusedLabelColor = Gold
                )
            )
        }
    }
}

@Preview
@Composable
fun previewNotepad(){
    Notepad()
}