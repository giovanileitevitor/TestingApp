package br.applabbs.testingapp.ui.theme.examples.chat

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import br.applabbs.testingapp.R

@Composable
fun UsuarioItem(
    user: Usuario,
    context: Context
){

    val nome = user.nome ?: ""
    val fotoUser = user.foto ?: R.drawable.city

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .clip(CircleShape)
            .clickable {
                Toast.makeText(context, "Usuário: $nome", Toast.LENGTH_SHORT).show()
            }

    ) {
        val (txtNome, foto, msg, line) = createRefs()

        Image(
            painter = painterResource(id = fotoUser),
            contentDescription = "img",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .constrainAs(foto) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                },
            contentScale = ContentScale.Crop
        )

        TextButton(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                backgroundColor = Color.White
            ),
            modifier = Modifier.constrainAs(txtNome){
                start.linkTo(foto.end, margin = 10.dp)
                top.linkTo(parent.top, margin = 10.dp)
                end.linkTo(parent.end, margin = 10.dp)
            }
        ){
            Text(
                text = nome,
                fontSize = 18.sp,
                color = Color.Blue
            )
        }

        Text(
            text = "Mensagem padrão",
            fontSize = 14.sp,
            modifier = Modifier.constrainAs(msg){
                top.linkTo(txtNome.bottom)
                start.linkTo(foto.end, margin = 10.dp)
                end.linkTo(parent.end, margin = 10.dp)
            }
        )

        Row(
            modifier = Modifier
                .background(Color.Gray)
                .width(200.dp)
                .height(1.dp)
                .constrainAs(line){
                    start.linkTo(foto.end, margin = 10.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(foto.bottom, margin = 0.dp)
                }
        ){

        }

    }
}

@Preview
@Composable
fun PreviewUsuarioItem(){
    UsuarioItem(
        user = fakeUser(),
        context = LocalContext.current
    )
}