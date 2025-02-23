package com.usk.composestateandevents.screens.itemslist.events

import androidx.compose.runtime.staticCompositionLocalOf

val LocalItemsListEventsManagerProvider = staticCompositionLocalOf<ItemsListEventsManager> {
  NoOpItemsListEventsManager()
}