package com.vinodhn.android.compose.tictactoe.game

import androidx.compose.runtime.Immutable

@Immutable
data class Player(val name: String,  val character: Char,) {
    // The character variable will be used to print on the board.
    // The player name is what is used in the result dialog
    companion object {
        val X = Player("X", '❌');
        val O = Player("O", '⭕');
    }
}