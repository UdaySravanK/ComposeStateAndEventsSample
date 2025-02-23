package com.usk.composestateandevents.screens.itemslist.events

sealed interface ItemsListEventSideEffects: ItemsListEvents {
  data class NavigateToItemDetails(val itemId: String) : ItemsListEventSideEffects
}