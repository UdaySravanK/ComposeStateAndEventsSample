package com.usk.composestateandevents.screens.itemslist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.usk.composestateandevents.screens.itemslist.events.ItemsListEvents
import com.usk.composestateandevents.screens.itemslist.events.LocalItemsListEventsManagerProvider

@Composable
fun ItemsListLoadMoreButton(modifier: Modifier = Modifier) {
  val eventsManager = LocalItemsListEventsManagerProvider.current
  TextButton(
    modifier = modifier.padding(4.dp).background(Color.White, shape = RoundedCornerShape(8.dp)),
    onClick = {
      eventsManager.sendEvent(ItemsListEvents.LoadMoreItems)
    }
  ) {
    Text(
      modifier = Modifier.padding(8.dp),
      text = "Load more items",
      fontSize = 24.sp,
    )
  }
}