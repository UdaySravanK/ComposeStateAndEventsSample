package com.usk.composestateandevents.screens.itemslist.events

import kotlinx.coroutines.flow.SharedFlow

interface ItemsListEventsManager {
  val events: SharedFlow<ItemsListEvents>
  fun sendEvent(event: ItemsListEvents)
}