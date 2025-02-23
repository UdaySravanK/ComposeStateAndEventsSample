package com.usk.composestateandevents.screens.itemslist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.usk.composestateandevents.components.ErrorScreen
import com.usk.composestateandevents.components.LoadingScreen
import com.usk.composestateandevents.screens.itemslist.components.ItemsListScreenContent
import com.usk.composestateandevents.screens.itemslist.state.ItemsListScreenState

@Composable
fun ItemsListScreen(
  state: ItemsListScreenState,
  modifier: Modifier = Modifier,
) {
  when {
    state.isLoading && state.items.isEmpty() -> LoadingScreen(modifier = modifier)
    state.errorMessage != null -> ErrorScreen(modifier = modifier, message = state.errorMessage)
    else -> ItemsListScreenContent(modifier = modifier, items = state.items, isLoading = state.isLoading)
  }
}

