package com.vinodhn.android.compose.tictactoe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vinodhn.android.compose.tictactoe.game.Board
import com.vinodhn.android.compose.tictactoe.ui.theme.TicTacToeTheme

// Represents the main UI of the game. Contains the game board and then the help and reset buttons.

private var helpDialogVisible = mutableStateOf(false)

@Composable
fun BoardScreen(modifier: Modifier = Modifier, board : List<Char>, onPlayerMove: (Int) -> Unit = {}, onReset: () -> Unit = {}) {
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Board(cells = board, onItemClick = onPlayerMove)
        Row {
            Button(onClick = onReset, modifier = Modifier.padding(16.dp)) {
                Text(text = "Reset Game")
            }
            Button(onClick = { helpDialogVisible.value = true }, modifier = Modifier.padding(16.dp)) {
                Text(text = "Help")
            }
        }
        showHelpDialog()
    }
}

@Composable
fun showHelpDialog() {
    // Only show the dialog if the state is true
    if(helpDialogVisible.value) {
        AlertDialog(
            onDismissRequest = {
                helpDialogVisible.value = false
            },
            title = {
                Text(text = "Help")
            },
            text = {
                Text(
                    "Just tap on any one of the squares to place down a character. The first" +
                            "player to go will always be X and then the second player will be O."
                )
            },
            confirmButton = {
                Button(onClick = {
                    // Reset the value to false, which will make the dialog go away
                    helpDialogVisible.value = false
                }) {
                    Text(stringResource(id = android.R.string.ok))
                }

            }
        )
    }
}

@Preview
@Composable
private fun LightBoardPreview() {
    val boardData = listOf('X','X','X', 'O', ' ', ' ', ' ', 'O', 'O')
    TicTacToeTheme(false) {
        Surface {
            BoardScreen(board = boardData)
        }
    }
}

@Preview
@Composable
private fun DarkBoardPreview() {
    val boardData = listOf('X','X','X', 'O', ' ', ' ', ' ', 'O', 'O')
    TicTacToeTheme(true) {
        Surface {
            BoardScreen(board = boardData)
        }
    }
}