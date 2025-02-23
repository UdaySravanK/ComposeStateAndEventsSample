package com.usk.composestateandevents.screens.itemslist.state

import com.usk.composestateandevents.screens.itemdetails.ItemData

data class ItemsListScreenState(
  val items: List<ItemData> = emptyList(),
  val isLoading: Boolean = true,
  val errorMessage: String? = null,
)
