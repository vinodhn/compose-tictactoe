package com.vinodhn.android.compose.tictactoe

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vinodhn.android.compose.tictactoe.ui.TicTacToeViewModel
import com.vinodhn.android.compose.tictactoe.ui.theme.TicTacToeTheme

class MainActivity : AppCompatActivity() {

    // Main view model for the game
    private val tictactoeViewModel by viewModels<TicTacToeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(stringResource(id = R.string.app_name)) }
                        )
                    },
                    bodyContent = {
                        Surface(color = MaterialTheme.colors.background) {
                            Row(
                                modifier = Modifier.fillMaxHeight(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                BoardScreen(
                                    board = tictactoeViewModel.currentBoardState,
                                    onPlayerMove = tictactoeViewModel::onPlayerMove,
                                    onReset = tictactoeViewModel::reset,
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                )
                                ResultDialog(tictactoeViewModel)
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ResultDialog(viewModel: TicTacToeViewModel) {
    // First ensure that the game has ended
    if (!viewModel.isGameOver) return

    // If game has ended, show the dialog box
    AlertDialog(
        onDismissRequest = {},
        title = { Text(stringResource(id = R.string.game_over)) },
        text = {
            viewModel.winner
                ?.let { Text(stringResource(id = R.string.congrats_msg, it.name)) }
                ?: Text(stringResource(id = R.string.tie_game))
        },
        confirmButton = {
            Button(onClick = viewModel::reset) {
                Text(stringResource(id = R.string.ok_reset))
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
}