package com.vinodhn.android.compose.tictactoe

import com.vinodhn.android.compose.tictactoe.game.Engine
import com.vinodhn.android.compose.tictactoe.game.Player
import org.junit.Test

import org.junit.Assert.*

class EngineTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    var engine = Engine(Player.X, Player.O)

    // No Winner Boards

    @Test
    fun noWinnerEmptyBoard_False() {
        var emptyBoardData = listOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ')
        assertEquals(false, engine.isGameOver(emptyBoardData))
    }

    @Test
    fun noWinnerFullBoard_False() {
        var fullBoardData = listOf('X', 'O', 'X', 'X', 'O', 'X', 'O', 'X', 'O')
        assertEquals(false, engine.isGameOver(fullBoardData))
    }

    @Test
    fun noWinnerInProgressX_False() {
        var inProgressXBoardData = listOf('X', 'O', 'X', 'O', 'X', ' ', ' ', ' ', ' ')
        assertEquals(false, engine.isGameOver(inProgressXBoardData))
    }

    @Test
    fun noWinnerInProgressO_False() {
        var inProgressOBoardData = listOf('O', 'X', 'O', 'X', 'O', ' ', ' ', ' ', ' ')
        assertEquals(false, engine.isGameOver(inProgressOBoardData))
    }

    // X Winner Boards

    @Test
    fun xWinsColumns_True() {
        var xWinsColOne = listOf('X', 'O', 'O', 'X', 'X', 'O', 'X', 'O', 'X')
        assertEquals(true, engine.isGameOver(xWinsColOne))

        var xWinsColTwo = listOf('O', 'X', 'O', 'X', 'X', 'O', 'O', 'X', 'X')
        assertEquals(true, engine.isGameOver(xWinsColTwo))

        var xWinsColThree = listOf('O', 'O', 'X', 'X', 'O', 'X', 'O', 'X', 'X')
        assertEquals(true, engine.isGameOver(xWinsColThree))
    }

    @Test
    fun xWinsRows_True() {
        var xWinsRowOne = listOf('X', 'X', 'X', 'O', 'O', 'X', 'X', 'O', 'O')
        assertEquals(true, engine.isGameOver(xWinsRowOne))

        var xWinsRowTwo = listOf('O', 'O', 'X', 'X', 'X', 'X', 'O', 'X', 'O')
        assertEquals(true, engine.isGameOver(xWinsRowTwo))

        var xWinsRowThree = listOf('O', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X')
        assertEquals(true, engine.isGameOver(xWinsRowThree))
    }

    @Test
    fun xWinsDiags_True() {
        var xWinsLeftDiag = listOf('X', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'X')
        assertEquals(true, engine.isGameOver(xWinsLeftDiag))

        var xWinsRightDiag = listOf('O', 'O', 'X', 'X', 'X', 'X', 'X', 'O', 'O')
        assertEquals(true, engine.isGameOver(xWinsRightDiag))
    }

    // O Winner Boards

    @Test
    fun oWinsColumns_True() {
        var oWinsColOne = listOf('X', 'O', 'O', 'X', 'X', 'O', 'X', 'O', 'X')
        assertEquals(true, engine.isGameOver(oWinsColOne))

        var oWinsColTwo = listOf('O', 'X', 'O', 'X', 'X', 'O', 'O', 'X', 'X')
        assertEquals(true, engine.isGameOver(oWinsColTwo))

        var oWinsColThree = listOf('O', 'O', 'X', 'X', 'O', 'X', 'O', 'X', 'X')
        assertEquals(true, engine.isGameOver(oWinsColThree))
    }

    @Test
    fun oWinsRows_True() {
        var oWinsRowOne = listOf('O', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'X')
        assertEquals(true, engine.isGameOver(oWinsRowOne))

        var oWinsRowTwo = listOf('X', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'X')
        assertEquals(true, engine.isGameOver(oWinsRowTwo))

        var oWinsRowThree = listOf('X', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'O')
        assertEquals(true, engine.isGameOver(oWinsRowThree))
    }

    @Test
    fun oWinsDiags_True() {
        var oWinsLeftDiag = listOf('O', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'O')
        assertEquals(true, engine.isGameOver(oWinsLeftDiag))

        var oWinsRightDiag = listOf('X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X')
        assertEquals(true, engine.isGameOver(oWinsRightDiag))
    }
}