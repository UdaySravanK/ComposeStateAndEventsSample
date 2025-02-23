package com.usk.composestateandevents.screens.itemdetails

import androidx.lifecycle.ViewModel
import com.usk.composestateandevents.data.MathBooks
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ItemDetailsViewModel: ViewModel()  {

  private val _state = MutableStateFlow(ItemDetailsScreenState())
  val state = _state.asStateFlow()


  fun getItemDetails(itemId: String) {
    val item = MathBooks().list.first {
      it.id == itemId
    }
    _state.update {
      _state.value.copy(
        item = item
      )
    }
  }
}