package com.vinodhn.android.compose.tictactoe.game

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vinodhn.android.compose.tictactoe.ui.theme.TicTacToeTheme

// Represents a single cell of the board
@Composable
private fun Cell(modifier: Modifier = Modifier, state: Char, onClick: () -> Unit = {}) {
    OutlinedButton(modifier = modifier, onClick = onClick, enabled = state.isWhitespace()) {
        Text(
            style = MaterialTheme.typography.h3,
            text = state.toString())
    }
}

// Creates a 3x3 grid of Cells to represent a board
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Board(modifier: Modifier = Modifier, cells: List<Char>, onItemClick: (Int) -> Unit) {
    LazyVerticalGrid(modifier = modifier, cells = GridCells.Fixed(3)) {
        itemsIndexed(cells) { index, cell -> Cell(
            Modifier
                .padding(4.dp)
                .aspectRatio(1.0f),
        state = cell, onClick = { onItemClick(index)})}
    }
}

@Preview
@Composable
private fun BoardPreview() {
    val boardData = listOf('X','X','X', 'O', ' ', ' ', ' ', 'O', 'O')
    TicTacToeTheme {
        Surface {
            Board(cells = boardData){}
        }
    }
}