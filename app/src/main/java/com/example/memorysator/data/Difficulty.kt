package com.example.memorysator.data

import androidx.compose.ui.res.stringResource
import com.example.memorysator.R

enum class Difficulty (val id : Int, val numberOfCards: Int) {
    EASY(id = R.string.difficulty_easy,6),
    MEDIUM(id = R.string.difficulty_medium,9),
    HARD(id = R.string.difficulty_hard,12),
    EXTREME(id = R.string.difficulty_extreme,24)
}

