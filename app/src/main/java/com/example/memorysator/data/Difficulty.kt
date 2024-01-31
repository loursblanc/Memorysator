package com.example.memorysator.data

import androidx.compose.ui.res.stringResource
import com.example.memorysator.R

enum class Difficulty (val id : Int) {
    EASY(id = R.string.difficulty_easy),
    MEDIUM(id = R.string.difficulty_medium),
    HARD(id = R.string.difficulty_hard),
    EXTREME(id = R.string.difficulty_extreme)
}

