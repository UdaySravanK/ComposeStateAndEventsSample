package com.usk.composestateandevents.screens.itemslist.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.usk.composestateandevents.TestEventsManager
import com.usk.composestateandevents.screens.itemslist.events.ItemsListEvents
import com.usk.composestateandevents.testWithEventsManager
import org.junit.Rule
import org.junit.Test

class ItemsListLoadMoreButtonTest {
  @get:Rule
  val composeTestRule = createComposeRule()

  @Test
  fun itemsListLoadMoreButton_ClickEventDispatch() {
    // Setup
    val testManager = TestEventsManager()
    composeTestRule.testWithEventsManager(testManager) {
      ItemsListLoadMoreButton()
    }

    // Execute
    composeTestRule.onNodeWithText("Load more items").performClick()

    // Assert
    testManager.assertEventDispatched(ItemsListEvents.LoadMoreItems)
  }
}