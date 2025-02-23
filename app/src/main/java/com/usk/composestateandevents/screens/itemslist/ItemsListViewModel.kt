package com.usk.composestateandevents.screens.itemslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.usk.composestateandevents.repositories.ItemsListRepository
import com.usk.composestateandevents.screens.itemslist.events.ItemsListEventSideEffects
import com.usk.composestateandevents.screens.itemslist.events.ItemsListEvents
import com.usk.composestateandevents.screens.itemslist.events.ItemsListEventsManager
import com.usk.composestateandevents.screens.itemslist.events.RealItemsListEventsManager
import com.usk.composestateandevents.screens.itemslist.state.ItemsListScreenState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ItemsListViewModel(
  // For testing purposes only since not configured DI yet
  testEventsManager: ItemsListEventsManager? = null
) : ViewModel() {
  private val currentPage = 1

  private val itemsListRepository = ItemsListRepository()
  val eventsManager: ItemsListEventsManager = testEventsManager ?: RealItemsListEventsManager(viewModelScope)
  private val _state = MutableStateFlow(ItemsListScreenState())
  val state = _state.asStateFlow()

  private val _sideEffects = MutableSharedFlow<ItemsListEventSideEffects>(replay = 1)
  val sideEffects = _sideEffects.asSharedFlow()

  init {
    viewModelScope.launch {
      eventsManager.events.collect { event ->
        handleEvents(event)
      }
    }
  }

  private fun handleEvents(event: ItemsListEvents) {
    when (event) {
      is ItemsListEventSideEffects -> {
        delegateSideEffect(event)
      }

      is ItemsListEvents.LoadMoreItems -> {
        loadMoreItems()
      }
    }
  }

  private fun delegateSideEffect(sideEffects: ItemsListEventSideEffects) {
    _sideEffects.tryEmit(sideEffects)
  }

  private fun updateItemsListScreenState() {
    _state.update {
      _state.value.copy(
        isLoading = false,
        errorMessage = null,
        items = itemsListRepository.items
      )
    }
  }

  fun loadInitialContent() {
    viewModelScope.launch {
      val items = itemsListRepository.fetchItems()
      if (items.isNotEmpty()) {
        updateItemsListScreenState()
      }
    }
  }

  private fun loadMoreItems() {
    updateLoadingIndicatorState(true)
    currentPage+1
    viewModelScope.launch {
      val items = itemsListRepository.fetchItems(currentPage)
      if (items.isNotEmpty()) {
        updateItemsListScreenState()
      } else {
        updateLoadingIndicatorState(false)
      }
    }
  }

  private fun updateLoadingIndicatorState(show: Boolean) {
    _state.update {
      _state.value.copy(
        isLoading = show
      )
    }
  }
}