package br.applabbs.testingapp.ui.theme.examples.calcimc

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.applabbs.testingapp.R

@Composable
fun ImageAnimated(){
    Text(
        text = "B3",
        modifier = Modifier
            .dashedBorder(
                color = Color.Red,
                strokeLength = 50.dp,
                strokeWidth = 2.dp,
                animate = true
            )
            .padding(8.dp),
        fontSize = 80.sp,
        color = Color.Red
    )

//    Image(
//        imageVector = ImageVector.vectorResource(id = R.drawable.ic_salvar),
//        contentDescription = "icone",
//        modifier = Modifier.dashedBorder(
//            color = Color.Red,
//            strokeLength = 40.dp,
//            strokeWidth = 2.dp,
//            animate = true
//        )
//    )
}

fun Modifier.dashedBorder(
    color: Color,
    strokeWidth: Dp,
    strokeLength: Dp,
    animate: Boolean = true,
) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }
        val strokeLengthPx = density.run { strokeLength.toPx() }
        var lastAnimValue by remember { mutableFloatStateOf(0f) }
        val anim = remember(animate) { Animatable(lastAnimValue) }

        LaunchedEffect(animate) {
            if (animate) {
                anim.animateTo(
                    targetValue = (strokeLengthPx * 2 + lastAnimValue),
                    animationSpec = infiniteRepeatable(
                        animation = tween(1000, easing = LinearEasing),
                        repeatMode = RepeatMode.Restart,
                    )
                ) {
                    lastAnimValue = value // store the anim value
                }
            }
        }

        this.then(
            Modifier.drawWithCache {
                onDrawBehind {
                    val stroke = Stroke(
                        width = strokeWidthPx,
                        pathEffect = PathEffect.dashPathEffect(
                            intervals = floatArrayOf(strokeLengthPx, strokeLengthPx),
                            phase = anim.value
                        )
                    )
                    drawRect(
                        color = color,
                        style = stroke
                    )
                }
            }
        )
    }
)

@Preview
@Composable
fun PreviewElement(){
    ImageAnimated()
}