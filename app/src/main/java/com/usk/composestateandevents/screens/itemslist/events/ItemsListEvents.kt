package com.usk.composestateandevents.screens.itemslist.events

sealed interface ItemsListEvents {
  data object LoadMoreItems : ItemsListEvents
}