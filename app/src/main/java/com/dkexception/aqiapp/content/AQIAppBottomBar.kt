package com.dkexception.aqiapp.content

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dkexception.aqiapp.R
import com.dkexception.core.navigation.NavRoute
import com.dkexception.ui.theme.DXColors

@Composable
fun AQIAppBottomBar(
    isBottomBarVisible: Boolean,
    isTabSelected: @Composable (String) -> Boolean,
    onTabClicked: (String) -> Unit
) = AnimatedVisibility(visible = isBottomBarVisible) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        NavigationBar(
            modifier = Modifier.fillMaxWidth(),
            containerColor = DXColors.card.white,
            tonalElevation = 1.dp
        ) {

            listOf(
                Triple("Home", NavRoute.HOME.ROOT, R.drawable.ic_home),
                Triple("Data Bank", NavRoute.DATABANK.MAIN, R.drawable.ic_databank),
                Triple("More", NavRoute.MORE.LIST, R.drawable.ic_more),
            ).forEach { dataTriple ->

                val isSelected = isTabSelected(dataTriple.second)

                AQIAppBottomBarItem(
                    displayName = dataTriple.first,
                    icon = dataTriple.third,
                    isSelected = isSelected,
                    onClicked = {
                        onTabClicked(dataTriple.second)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun AQIAppBottomBarPreviewHome() = AQIAppBottomBar(
    isBottomBarVisible = true,
    isTabSelected = {
        it == NavRoute.HOME.ROOT
    }
) {}

@Preview
@Composable
private fun AQIAppBottomBarPreviewDataBank() = AQIAppBottomBar(
    isBottomBarVisible = true,
    isTabSelected = {
        it == NavRoute.DATABANK.MAIN
    }
) {}

@Preview
@Composable
private fun AQIAppBottomBarPreviewMore() = AQIAppBottomBar(
    isBottomBarVisible = true,
    isTabSelected = {
        it == NavRoute.MORE.LIST
    }
) {}
