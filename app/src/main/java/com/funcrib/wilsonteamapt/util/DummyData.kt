package com.funcrib.wilsonteamapt.util

import com.funcrib.wilsonteamapt.R
import com.funcrib.wilsonteamapt.data.Colors

object DummyData {

    val colors = listOf(
        Colors(R.color.violet, R.color.red),
        Colors(R.color.purple_200, R.color.teal_200),
        Colors(R.color.red_200, R.color.violet_200),
        Colors(R.color.purple_700, R.color.teal_700),
        Colors(R.color.purple_500, R.color.text_color),
        Colors(R.color.green_500, R.color.green_200),
    )

    val primaryColors = listOf(
        R.color.violet,
        R.color.purple_200,
        R.color.red_200,
        R.color.purple_700,
        R.color.purple_500,
    )

    val secondaryColors = listOf(
        R.color.red,
        R.color.teal_200,
        R.color.violet_200,
        R.color.teal_700,
        R.color.text_color,
        R.color.teal_500
    )

    val imageList = listOf(
        R.drawable.ic_outline_agriculture_24,
        R.drawable.ic_outline_baby_changing_station_24,
        R.drawable.ic_outline_campaign_24,
        R.drawable.ic_outline_clean_hands_24,
        R.drawable.ic_outline_cruelty_free_24,
        R.drawable.ic_credit_card_24,
        R.drawable.ic_settings_24,
        R.drawable.ic_round_home_24)

    val parentList = listOf(
        "Daddy", "Mommy", "Grandma", "Grandpa", "Uncle", "Aunty", "Big Sis", "Big Bro"
    )

    val useCase = listOf(
        "Pocket Money",
        "Flexing",
        "Drinks",
        "Baby Food",
        "School Fees",
        "Clothing",
        "Feeding",
        "Transportation"
    )
}