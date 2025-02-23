package com.usk.composestateandevents.screens.itemdetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.usk.composestateandevents.components.ErrorScreen
import com.usk.composestateandevents.components.LoadingScreen
import com.usk.composestateandevents.screens.itemdetails.components.ItemDetailsScreenContent

@Composable
fun ItemDetailsScreen(
  state: ItemDetailsScreenState,
  modifier: Modifier = Modifier,
) {
  when {
    state.isLoading -> LoadingScreen(modifier = modifier)
    state.errorMessage != null -> ErrorScreen(modifier = modifier, message = state.errorMessage)
    state.item != null -> ItemDetailsScreenContent(modifier = modifier, item = state.item)
  }
}