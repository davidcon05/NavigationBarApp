package com.davecon.navigationbarapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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

    LottieAnimation(
        modifier = modifier,
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )

}

@Composable
@Preview
fun ScaryScreenPreview() {
    ScaryScreen(scaryAnimation = BottomNavItem.Home, modifier = Modifier)
}