package com.usk.composestateandevents.screens.itemslist.events

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class NoOpItemsListEventsManager : ItemsListEventsManager {

  override val events: SharedFlow<ItemsListEvents> = MutableSharedFlow()

  override fun sendEvent(event: ItemsListEvents) {

  }
}