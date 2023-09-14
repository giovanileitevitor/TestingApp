package br.applabbs.testingapp.ui.theme.parts

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.applabbs.testingapp.ui.theme.OrangeYellow1
import java.util.*


@Composable
fun CustomCard(text: String, onClick: () -> Unit){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp, 4.dp, 8.dp, 4.dp)
            .clickable(enabled = true, onClick = onClick),
        content = {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(28.dp)
                .background(OrangeYellow1)) {

                val date = SimpleDateFormat("dd-MM-yyyy'")
                val currentDateAndTime = date.format(Date())

                Text(
                    text = "Updated: $currentDateAndTime",
                    textAlign = TextAlign.End,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp, top = 4.dp, start = 8.dp)
                )
            }

            Text(
                text = text,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center
            )
        }
    )
}

@Preview
@Composable
fun PreviewCustomCard(){
    CustomCard(text = "Custom Card", onClick = { } )
}