package com.usk.composestateandevents.data

import com.usk.composestateandevents.screens.itemdetails.ItemData

data class MathBooks(
  val list: List<ItemData> = listOf(
    ItemData(
      id = "100",
      name = "Algebra",
      description = "Learn algebra"
    ),
    ItemData(
      id = "101",
      name = "Geometry",
      description = "Learn geometry"
    ),
    ItemData(
      id = "102",
      name = "Trigonometry",
      description = "Learn trigonometry"
      ),
    ItemData(
      id = "103",
      name = "Calculus",
      description = "Learn calculus"
    ),
    ItemData(
      id = "104",
      name = "Statistics",
      description = "Learn statistics"
    ),
    ItemData(
      id = "105",
      name = "Probability",
      description = "Learn probability"
    ),
    ItemData(
      id = "106",
      name = "Number Theory",
      description = "Learn number theory"
    ),
    ItemData(
      id = "107",
      name = "Linear Algebra",
      description = "Learn linear algebra"
    ),
    ItemData(
      id = "108",
      name = "Differential Equations",
      description = "Learn differential equations"
    ),
    ItemData(
      id = "109",
      name = "Complex Analysis",
      description = "Learn complex analysis"
    )
  )
)
