package com.laoves.mylittleapp.common.helpers

import androidx.compose.ui.graphics.Color
import com.laoves.mylittleapp.presentation.ui.theme.bugColor
import com.laoves.mylittleapp.presentation.ui.theme.darkColor
import com.laoves.mylittleapp.presentation.ui.theme.dragonColor
import com.laoves.mylittleapp.presentation.ui.theme.electricColor
import com.laoves.mylittleapp.presentation.ui.theme.fairyColor
import com.laoves.mylittleapp.presentation.ui.theme.fightingColor
import com.laoves.mylittleapp.presentation.ui.theme.fireColor
import com.laoves.mylittleapp.presentation.ui.theme.flyingColor
import com.laoves.mylittleapp.presentation.ui.theme.ghostColor
import com.laoves.mylittleapp.presentation.ui.theme.grassColor
import com.laoves.mylittleapp.presentation.ui.theme.groundColor
import com.laoves.mylittleapp.presentation.ui.theme.iceColor
import com.laoves.mylittleapp.presentation.ui.theme.normalColor
import com.laoves.mylittleapp.presentation.ui.theme.poisonColor
import com.laoves.mylittleapp.presentation.ui.theme.psychicColor
import com.laoves.mylittleapp.presentation.ui.theme.rockColor
import com.laoves.mylittleapp.presentation.ui.theme.steelColor
import com.laoves.mylittleapp.presentation.ui.theme.waterColor

fun getColorFromType(typeName: String): Color {
    return typeToColorMap[typeName] ?: Color.White
}

val typeToColorMap = mapOf(
    "bug" to bugColor,
    "dark" to darkColor,
    "dragon" to dragonColor,
    "electric" to electricColor,
    "fairy" to fairyColor,
    "fighting" to fightingColor,
    "fire" to fireColor,
    "flying" to flyingColor,
    "ghost" to ghostColor,
    "grass" to grassColor,
    "ground" to groundColor,
    "ice" to iceColor,
    "normal" to normalColor,
    "poison" to poisonColor,
    "psychic" to psychicColor,
    "rock" to rockColor,
    "steel" to steelColor,
    "water" to waterColor
)