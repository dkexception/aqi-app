@file:OptIn(ExperimentalMaterialApi::class)

package com.dkexception.ui.indicators

import androidx.compose.foundation.layout.Box
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dkexception.ui.theme.DXColors

@Composable
fun DXPullToRefreshContainer(
    modifier: Modifier = Modifier,
    isRefreshing: Boolean,
    onPulled: () -> Unit,
    content: @Composable () -> Unit
) {

    val state = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = onPulled
    )

    Box(modifier.pullRefresh(state, true)) {

        content()

        PullRefreshIndicator(
            refreshing = isRefreshing,
            state = state,
            modifier = Modifier.align(Alignment.TopCenter),
            backgroundColor = DXColors.card.white,
            contentColor = DXColors.primary.default,
            scale = true
        )
    }
}
