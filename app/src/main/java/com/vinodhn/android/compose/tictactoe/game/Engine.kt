package com.vinodhn.android.compose.tictactoe.game

class Engine(val playerX: Player, val playerO: Player, var currentPlayer: Player = playerX, var moves: Int = 0) {

    // Switches the current player at the end of each move
    private fun switchPlayer() {
        currentPlayer = if(currentPlayer == playerX) playerO else playerX;
    }

    // Advance the move counter
    fun nextMove() {
        moves++
        switchPlayer()
    }

    // Check if the game has ended
    val gameEnded get() = moves >= 8

    // Check the 3 rows
    private fun checkRows(board: List<Char>) : Boolean {
        if (board[0] == board[1] && board[0] == board[2] && board[0] != ' ') {
            return true
        }
        if (board[3] == board[4] && board[3] == board[5] && board[3] != ' ') {
            return true
        }
        if (board[6] == board[7] && board[6] == board[8] && board[6] != ' ') {
            return true
        }
        return false
    }

    // Check the 3 cols
    private fun checkCols(board: List<Char>) : Boolean {
        if (board[0] == board[3] && board[0] == board[6] && board[0] != ' ') {
            return true
        }
        if (board[1] == board[4] && board[1] == board[7] && board[1] != ' ') {
            return true
        }
        if (board[2] == board[5] && board[2] == board[8] && board[2] != ' ') {
            return true
        }
        return false
    }

    // Check the diagonals
    private fun checkDiags(board: List<Char>) : Boolean {
        if (board[0] == board[4] && board[0] == board[8] && board[0] != ' ') {
            return true
        }
        if (board[2] == board[4] && board[2] == board[6] && board[2] != ' ') {
            return true
        }
        return false
    }

    // Check if any row/col has won
    fun isGameOver(board: List<Char>) : Boolean {
        return checkRows(board) || checkCols(board) || checkDiags(board)
    }



}