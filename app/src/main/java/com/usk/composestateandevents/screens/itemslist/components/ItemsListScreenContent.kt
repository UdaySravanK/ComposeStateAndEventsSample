package com.usk.composestateandevents.screens.itemslist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.usk.composestateandevents.components.LoadingScreen
import com.usk.composestateandevents.screens.itemdetails.ItemData
import com.usk.composestateandevents.screens.itemslist.events.ItemsListEventSideEffects
import com.usk.composestateandevents.screens.itemslist.events.LocalItemsListEventsManagerProvider

@Composable
fun ItemsListScreenContent(
  modifier: Modifier = Modifier,
  items: List<ItemData> = emptyList(),
  isLoading: Boolean = false,
) {
  val scrollState = rememberLazyListState()
  Column(
    modifier = modifier.fillMaxSize().windowInsetsPadding(WindowInsets.statusBars),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Text(
      modifier = modifier.padding(12.dp).fillMaxWidth(),
      text = "Math books count: ${items.size}",
      fontSize = 24.sp,
      color = Color(0xFF663399),
      fontWeight = FontWeight.ExtraBold,
    )
    Box(modifier = Modifier.fillMaxSize().weight(1f)) {
      LazyColumn(
        state = scrollState,
        modifier = Modifier.fillMaxSize()
          .background(Color(0xFF445566)).padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        items(items.size) { index ->
          val item = items[index]
          ItemRow(item = item)
        }
      }
      if (isLoading) LoadingScreen(
        modifier = Modifier.background(Color(0x66666666))
      )
    }
    ItemsListLoadMoreButton()
  }
}

@Composable
private fun ItemRow(item: ItemData) {
  val eventsManager = LocalItemsListEventsManagerProvider.current
  Button(onClick = {
    eventsManager.sendEvent(ItemsListEventSideEffects.NavigateToItemDetails(item.id))
  }) {
    Text(
      modifier = Modifier.padding(16.dp),
      text = item.name,
      fontSize = 24.sp,
    )
  }
}