package com.usk.composestateandevents.screens.itemslist

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.usk.composestateandevents.R
import com.usk.composestateandevents.screens.itemdetails.ItemDetailsFragment

import com.usk.composestateandevents.screens.itemslist.events.ItemsListEventSideEffects
import com.usk.composestateandevents.screens.itemslist.events.LocalItemsListEventsManagerProvider
import kotlinx.coroutines.launch

class ItemsListFragment : Fragment() {

  companion object {
    fun newInstance() = ItemsListFragment()
  }

  private val viewModel: ItemsListViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    lifecycleScope.launch {
      lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
        viewModel.sideEffects.collect { sideEffect ->
          handleSideEffects(sideEffect)
        }
      }
    }
  }


  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return ComposeView(requireContext()).apply {
      setContent {
        CompositionLocalProvider(
          LocalItemsListEventsManagerProvider provides viewModel.eventsManager
        ) {
          ItemsListScreen(
            state = viewModel.state.collectAsStateWithLifecycle().value,
          )
        }
      }
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    // We can load initial content early but just to delay calling it here
    viewModel.loadInitialContent()
  }

  private fun handleSideEffects(sideEffect: ItemsListEventSideEffects) {
    when (sideEffect) {
      is ItemsListEventSideEffects.NavigateToItemDetails -> {
        // Navigate to item details screen
        val fragment = ItemDetailsFragment.newInstance(sideEffect.itemId)
        parentFragmentManager
          .beginTransaction()
          .add(R.id.container, fragment, "Details")
          .addToBackStack(null)
          .commit()
      }
    }
  }
}