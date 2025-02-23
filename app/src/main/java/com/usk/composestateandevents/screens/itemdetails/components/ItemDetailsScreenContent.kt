package com.usk.composestateandevents.screens.itemdetails.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.usk.composestateandevents.screens.itemdetails.ItemData

@Composable
fun ItemDetailsScreenContent(
  modifier: Modifier = Modifier,
  item: ItemData,
) {
  Column(
    modifier = modifier.fillMaxSize().background(Color.Green).padding(32.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(16.dp),
  ) {
    Text(
      fontSize = 72.sp,
      text = item.name,
    )
    Text(
      fontSize = 52.sp,
      text = item.description
    )
  }
}