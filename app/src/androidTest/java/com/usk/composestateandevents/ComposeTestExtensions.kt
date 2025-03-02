package com.usk.composestateandevents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import com.usk.composestateandevents.screens.itemslist.events.ItemsListEventsManager
import com.usk.composestateandevents.screens.itemslist.events.LocalItemsListEventsManagerProvider

fun ComposeContentTestRule.testWithEventsManager(
  manager: ItemsListEventsManager,
  block: @Composable () -> Unit
) {
  setContent {
    CompositionLocalProvider(
      LocalItemsListEventsManagerProvider provides manager,
    ) {
      block()
    }
  }
}