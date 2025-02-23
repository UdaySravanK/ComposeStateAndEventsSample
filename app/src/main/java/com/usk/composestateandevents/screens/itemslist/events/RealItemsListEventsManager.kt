package com.usk.composestateandevents.screens.itemslist.events

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class RealItemsListEventsManager(
  private val coroutineScope: CoroutineScope
): ItemsListEventsManager {
  private val _events = MutableSharedFlow<ItemsListEvents>()
  override val events = _events.asSharedFlow()

  override fun sendEvent(event: ItemsListEvents) {
    coroutineScope.launch {
      _events.emit(event)
    }
  }
}