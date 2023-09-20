package br.applabbs.testingapp.ui.theme.examples.agenda.views

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import br.applabbs.testingapp.R
import br.applabbs.testingapp.ui.theme.examples.agenda.Contato

@Composable
fun ContatoItem(
    navController: NavController,
    position: Int,
    listContatos: MutableList<Contato>,
    context: Context
){
    Card(
        backgroundColor = Color.White,
        contentColor = Color.White,
        elevation = 8.dp,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 20.dp, 10.dp, 10.dp)
    ){
        ConstraintLayout(
            modifier = Modifier.padding(10.dp)
        ) {
            val (txtNome, txtSobrenome, txtIdade, txtCelular, btAtualizar, btDeletar) = createRefs()

            Text(
                text = "Contato: Giovani Leite Vitor",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(txtNome){
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = "Idade: 19",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(txtIdade){
                    top.linkTo(txtNome.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = "Celular: 11-975313142",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(txtCelular){
                    top.linkTo(txtIdade.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Button(
                onClick = {

                },
                modifier = Modifier.constrainAs(btAtualizar){
                    start.linkTo(txtCelular.end, margin = 30.dp)
                    top.linkTo(parent.top, margin = 50.dp)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                ),
                elevation = ButtonDefaults.elevation(
                    disabledElevation = 0.dp,
                    defaultElevation = 0.dp
                )
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_edit),
                    contentDescription = "Icone Atualizar"
                )
            }

            Button(
                onClick = {
                    navController.navigate("atualizarContato")
                },
                modifier = Modifier.constrainAs(btDeletar){
                    start.linkTo(btAtualizar.end, margin = 10.dp)
                    top.linkTo(parent.top, margin = 50.dp)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                ),
                elevation = ButtonDefaults.elevation(
                    disabledElevation = 0.dp,
                    defaultElevation = 0.dp
                )
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete),
                    contentDescription = "Icone Deletar"
                )
            }
        }

    }
}

@Preview
@Composable
fun PreviewCard(){
    ContatoItem(
        navController = NavController(),
        position = 1,
        listContatos = mutableListOf<Contato>(),
        context = LocalContext.current
    )
}