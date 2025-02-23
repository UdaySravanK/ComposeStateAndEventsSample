package com.usk.composestateandevents.screens.itemdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle

class ItemDetailsFragment: Fragment() {
  companion object {
    fun newInstance(itemId: String) = ItemDetailsFragment().apply {
      arguments = Bundle().apply {
        putString("itemId", itemId)
      }
    }
  }

  private val viewModel: ItemDetailsViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    return ComposeView(requireContext()).apply {
      setContent {
        ItemDetailsScreen(state = viewModel.state.collectAsStateWithLifecycle().value)
      }
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val itemId = arguments?.getString("itemId") ?: ""
    viewModel.getItemDetails(itemId)
  }
}