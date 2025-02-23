package com.usk.composestateandevents.repositories

import com.usk.composestateandevents.data.MathBooks
import com.usk.composestateandevents.screens.itemdetails.ItemData
import kotlinx.coroutines.delay

const val PAGE_SIZE = 5
class ItemsListRepository {

  private var fetchedItems: MutableList<ItemData> = mutableListOf()
  val items: List<ItemData> = fetchedItems

  suspend fun fetchItems(page: Int = 1): List<ItemData> {
    delay(2000)
    val pageItems = MathBooks().list.subList((page - 1) * PAGE_SIZE, page * PAGE_SIZE)
    if (pageItems.isNotEmpty()) {
      fetchedItems.addAll(pageItems)
    }
    return pageItems
  }
}

