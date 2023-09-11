package br.applabbs.testingapp.ui.theme.parts

import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.applabbs.testingapp.ui.theme.ButtonBlue
import br.applabbs.testingapp.ui.theme.DarkerButtonBlue
import br.applabbs.testingapp.ui.theme.TextWhite

@Composable
fun ButtonsWithSelector(){
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ){
        Column {
            ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression", "Soft", "Loving"))
        }
    }
}

@Composable
private fun ChipSection(
    chips: List<String>
){
    var selectedChipIndex by remember { mutableStateOf(0) }
    val context = LocalContext.current.applicationContext

    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp, end = 5.dp)
                    .clickable {
                        selectedChipIndex = it
                        Toast.makeText(context, "Clicked:" + "${chips[it]}", Toast.LENGTH_SHORT).show()
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(10.dp)
                    .height(60.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}


@Preview(showSystemUi = false, uiMode = UI_MODE_TYPE_NORMAL)
@Composable
fun PreviewButtons(){
    ButtonsWithSelector()
}