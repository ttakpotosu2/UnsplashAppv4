package com.example.unsplashappv4.presentation

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedShimmer(
    shimmerItemsCount: Int = 1
) {
    val shimmerColors = listOf(
        Color.LightGray.copy(.2f),
        Color.LightGray.copy(.9f),
        Color.LightGray.copy(.2f)
    )

    val animation = rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = animation.value, y = animation.value)
    )

    Column(
//        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        repeat(shimmerItemsCount){
            ShimmerItems(brush = brush)
        }
    }
}

@Composable
fun ShimmerItems(brush: Brush) {
    Spacer(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
            .background(brush)
    )
}