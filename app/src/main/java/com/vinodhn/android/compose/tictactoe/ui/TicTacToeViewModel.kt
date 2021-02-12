package com.vinodhn.android.compose.tictactoe.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.vinodhn.android.compose.tictactoe.game.Engine
import com.vinodhn.android.compose.tictactoe.game.Player

class TicTacToeViewModel : ViewModel() {

    var game = Engine(Player.X, Player.O)

    fun emptyBoardData() = mutableStateListOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ')

    var currentBoardState by mutableStateOf(emptyBoardData())

    var isGameOver by mutableStateOf(false)

    var winner by mutableStateOf<Player?>(null)

    fun update() {
        // Check if board is full or game has ended and edit the boolean states as required
        when {
            game.isGameOver(currentBoardState) -> {
                isGameOver = true
                winner = game.currentPlayer
            }
            game.gameEnded -> {
                isGameOver = true
                winner = null
            }
            // Else continue to the next move
            else -> {
                game.nextMove()
            }
        }
    }

    fun onPlayerMove(index: Int) {
        // First make sure the box the player has selected is empty
        if(isGameOver || currentBoardState[index] != ' ') return

        // Then set the character
        currentBoardState[index] = game.currentPlayer.character

        // And update the game
        update()
    }

    fun reset() {
        // Clear the board and then reset the engine
        currentBoardState = emptyBoardData()
        game = Engine(Player.X, Player.O)
        isGameOver = false
    }


}