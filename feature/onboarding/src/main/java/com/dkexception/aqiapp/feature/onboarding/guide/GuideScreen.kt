@file:OptIn(ExperimentalFoundationApi::class)

package com.dkexception.aqiapp.feature.onboarding.guide

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.dkexception.aqiapp.feature.onboarding.R
import com.dkexception.ui.buttons.DXPrimaryButton
import com.dkexception.ui.buttons.DXTextButton
import com.dkexception.ui.scaffold.DXScaffold
import com.dkexception.ui.theme.DXColors
import com.dkexception.ui.theme.DXPaddings
import com.dkexception.ui.theme.headline1
import com.dkexception.ui.theme.regular
import com.dkexception.ui.utils.getImageBitmapFromVector
import com.dkexception.ui.utils.pxToDp
import kotlin.math.abs

@Composable
fun GuideScreen(
    onEvent: (GuideEvent) -> Unit
) = GuideScreenContent(onEvent = onEvent)

@Composable
private fun GuideScreenContent(
    initialPage: Int = 0,
    onEvent: (GuideEvent) -> Unit
) = DXScaffold(modifier = Modifier.fillMaxSize()) {

    val context = LocalContext.current
    val localDensity = LocalDensity.current

    val dataToShow = remember {
        listOf(
            "Breath Better" to "Understand the air around you, wherever you go with the largest coverage of trusted data.",
            "Track Pollution" to "Discover your personal exposure during your daily routine and take action to reduce it",
            "Control Exposure" to "During your daily routine, discover your personal exposure and take action"
        )
    }

    val illustrationImage: ImageBitmap = remember {
        context.getImageBitmapFromVector(R.drawable.ill_onboarding_bg)
    }

    val pagerState = rememberPagerState(initialPage) { dataToShow.size }

    var parallaxOffset by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPageOffsetFraction }.collect {
            val fraction = pagerState.getOffsetFractionForPage(0)
            parallaxOffset = fraction * (illustrationImage.width / dataToShow.size)
        }
    }

    var illustrationHeight by remember {
        mutableStateOf(0.dp)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(context.pxToDp(illustrationImage.height))
                .onGloballyPositioned {
                    illustrationHeight = with(localDensity) { it.size.height.toDp() }
                },
        ) {

            val canvasWidth = size.width.toInt()
            val canvasHeight = size.height.toInt()

            val imageHeight = illustrationImage.height
            val imageWidth = illustrationImage.width

            drawImage(
                image = illustrationImage,
                srcOffset = IntOffset(
                    parallaxOffset.toInt().coerceAtMost(abs(canvasWidth - imageWidth)),
                    0
                ),
                dstOffset = IntOffset(0, abs(imageHeight - canvasHeight) / 2)
            )
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(DXPaddings.xLarge)
                    .background(Color.Transparent)
            ) {

                Spacer(modifier = Modifier.height(illustrationHeight))

                Spacer(modifier = Modifier.height(80.dp))

                Spacer(modifier = Modifier.height(DXPaddings.xLarge))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = dataToShow[it].first,
                        style = headline1(),
                        color = DXColors.text.dark
                    )

                    Spacer(modifier = Modifier.height(DXPaddings.default))

                    Text(
                        text = dataToShow[it].second,
                        style = regular(),
                        color = DXColors.text.light,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = DXPaddings.large),
            horizontalArrangement = Arrangement.spacedBy(DXPaddings.small)
        ) {
            repeat(dataToShow.size) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(
                            if (it == pagerState.currentPage) {
                                DXColors.primary.default
                            } else {
                                DXColors.text.light
                            }
                        )
                )
            }
        }

        Column(
            Modifier
                .fillMaxSize()
                .padding(DXPaddings.xLarge)
        ) {

            Spacer(modifier = Modifier.weight(1f))

            DXPrimaryButton(text = "Get Started", Modifier.fillMaxWidth()) {
                onEvent(GuideEvent.OnGetStartedClicked)
            }

            Spacer(modifier = Modifier.height(DXPaddings.default))
        }

        DXTextButton(
            text = "Skip",
            modifier = Modifier
                .padding(end = DXPaddings.xSmall)
                .align(Alignment.TopEnd)
        ) {
            onEvent(GuideEvent.OnSkipClicked)
        }
    }
}

@PreviewLightDark
@Composable
private fun GuideScreenPreview(
    @PreviewParameter(InitialPagePPP::class)
    initialPage: Int
) = GuideScreenContent(initialPage) {}

private class InitialPagePPP(
    override val values: Sequence<Int> = sequenceOf(0, 1, 2)
) : PreviewParameterProvider<Int>
