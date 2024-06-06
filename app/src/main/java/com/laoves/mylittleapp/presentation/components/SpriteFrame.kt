package com.laoves.mylittleapp.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.laoves.mylittleapp.presentation.ui.theme.goldColorBrush

@Composable
fun SpriteFrame(
    model: String,
    size: Dp = 200.dp,
    borderWith: Int = 32,
    duration: Int = 1250,
    frameBrush: Brush = goldColorBrush,
    backgroundColors: List<Color> = listOf(Color.White)
) {
    val infiniteTransition = rememberInfiniteTransition(label = "sprite_frame")
    val rotationAnimation = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(duration, easing = LinearEasing)),
        label = "sprite_frame"
    )
    val backgroundColorBrush = Brush.horizontalGradient(backgroundColors)

    AsyncImage(
        model = model,
        contentDescription = null,
        modifier = Modifier
            .drawBehind {
                rotate(rotationAnimation.value) {
                    drawCircle(frameBrush, style = Stroke(borderWith.toFloat()))
                }
            }
            .size(size)
            .clip(CircleShape)
            .background(backgroundColorBrush)
            .padding(borderWith.dp)
    )
}