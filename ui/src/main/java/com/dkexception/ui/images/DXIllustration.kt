package com.dkexception.ui.images

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

/**
 * One common place to render all the illustrations throughout this app
 *
 * @param illustration Drawable ID integer for the illustration to load
 * @param modifier Modifier to change the UI appearance
 */
@Composable
fun DXIllustration(
    @DrawableRes illustration: Int,
    modifier: Modifier = Modifier,
    optionalContentScale: ContentScale = ContentScale.Fit,
    optionalContentDescription: String? = null
) = Image(
    painter = painterResource(id = illustration),
    contentDescription = optionalContentDescription,
    modifier = modifier,
    contentScale = optionalContentScale
)
