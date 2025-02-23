package com.usk.composestateandevents.screens.itemdetails

data class ItemDetailsScreenState(
  val item: ItemData? = null,
  val isLoading: Boolean = false,
  val errorMessage: String? = null,
)
