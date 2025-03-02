package com.usk.composestateandevents

import com.usk.composestateandevents.screens.itemslist.events.ItemsListEvents
import com.usk.composestateandevents.screens.itemslist.events.ItemsListEventsManager
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import org.junit.Assert.fail

class TestEventsManager : ItemsListEventsManager {
  private val eventsRegister = mutableListOf<ItemsListEvents>()
  override val events: SharedFlow<ItemsListEvents> = MutableSharedFlow()
  override fun sendEvent(event: ItemsListEvents) {
    eventsRegister.add(event)
  }

  fun assertEventDispatched(event: ItemsListEvents) {
    if (eventsRegister.contains(event)) {
      eventsRegister.remove(event)
    } else {
      fail("$event not dispatched")
    }
  }
}