package br.applabbs.testingapp.ui.theme.examples.calcimc

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.applabbs.testingapp.R

class CalculaImcActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraImc()
        }
    }
}

@Composable
fun CalculadoraImc(){

    val activity = LocalContext.current as ComponentActivity
    val localContext = LocalContext.current
    val calcularImc = CalcularImc()
    var peso by remember { mutableStateOf("")}
    var altura by remember { mutableStateOf("")}
    var resultado by remember { mutableStateOf("")}

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Calculadora de IMC",
                        fontSize = 22.sp,
                        color = Color.White
                    )
                },
                backgroundColor = Color.Blue,
                actions = {
                    IconButton(
                        onClick = {
                            peso = ""
                            altura = ""
                            resultado = ""
                        }
                    ){
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_reload),
                            contentDescription = "refresh"
                        )
                    }
                },
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
        },
        content = { paddingValues ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),

                content = {
                    Text(
                        text = "Calculadora de IMC",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue,
                        modifier = Modifier.padding(20.dp)
                    )

                    OutlinedTextField(
                        value = peso,
                        onValueChange = {
                            peso = it
                        },
                        label = {
                            Text(text = "Peso (KG)")
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            cursorColor = Color.Blue,
                            focusedBorderColor = Color.Blue,
                            unfocusedBorderColor = Color.Gray
                        ),
                        textStyle = TextStyle(Color.Blue, 18.sp),
                        maxLines = 1,
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp, 0.dp, 20.dp, 0.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        )
                    )

                    OutlinedTextField(
                        value = altura,
                        onValueChange = {
                            altura = it
                        },
                        label = {
                            Text(text = "Altura (cm)")
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            cursorColor = Color.Blue,
                            focusedBorderColor = Color.Blue,
                            unfocusedBorderColor = Color.Gray
                        ),
                        textStyle = TextStyle(Color.Blue, 18.sp),
                        maxLines = 1,
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp, 0.dp, 20.dp, 0.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        )
                    )
                    Button(
                        onClick = {
                             if(peso.isEmpty() || altura.isEmpty()){
                                 Toast.makeText(localContext, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                             }else{
                                 calcularImc.calcularImc(peso = peso, altura = altura)
                                resultado = calcularImc.resultadoImc()
                             }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Blue,
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Calcular IMC", color = Color.White)
                    }

                    Text(
                        text = resultado,
                        fontSize = 18.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold
                    )
                    ImageAnimated()
                }
            )
        }
    )
}

@Preview
@Composable
fun PreviewCalculadora(){
    CalculadoraImc()
}