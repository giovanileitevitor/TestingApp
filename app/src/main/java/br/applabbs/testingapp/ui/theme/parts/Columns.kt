package br.applabbs.testingapp.ui.theme.parts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun FoodItem(

){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp)
    ) {

        val (imgItem, txtItem, btnItem, containerImg) = createRefs()

        Card(
            modifier = Modifier
                .size(80.dp)
                .padding(10.dp)
                .constrainAs(containerImg) { },
            backgroundColor =  Color.Cyan,
            shape = ShapeDefaults.Medium
        ){

        }
    }
}

@Preview(name = "Food Item List")
@Composable
private fun preview(){
    FoodItem()
}