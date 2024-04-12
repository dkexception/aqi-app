package com.dkexception.ui.images

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter

@Composable
fun DXNetworkImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    @DrawableRes optionalPlaceholder: Int? = null,
    @DrawableRes optionalErrorPlaceholder: Int? = null,
    optionalContentScale: ContentScale = ContentScale.Fit,
    optionalContentDescription: String? = null
) = AsyncImage(
    modifier = modifier,
    model = imageUrl,
    contentScale = optionalContentScale,
    placeholder = optionalPlaceholder?.let {
        rememberAsyncImagePainter(it)
    },
    error = optionalErrorPlaceholder?.let {
        rememberAsyncImagePainter(it)
    },
    contentDescription = optionalContentDescription
)
