package com.davecon.navigationbarapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.davecon.navigationbarapp.ui.navigation.BottomNavItem

@Composable
fun ScaryScreen(
    scaryAnimation: BottomNavItem,
    modifier: Modifier
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(scaryAnimation.lottieAnimationId))
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LottieAnimation(
            modifier = modifier.aspectRatio(4.0f),
            composition = composition,
            contentScale = ContentScale.FillWidth,
            iterations = LottieConstants.IterateForever,
        )
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, device = "id:pixel_5")
fun ScaryScreenPreview() {
    ScaryScreen(scaryAnimation = BottomNavItem.Home, modifier = Modifier)
}