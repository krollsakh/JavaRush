package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private int countClosedTiles = SIDE * SIDE;
    private int score;
    private boolean isGameStopped;


    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");
            }
        }
        countFlags = countMinesOnField;
        countMineNeighbors();
    }

    //Список соседей
    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    /*
    для каждой ячейки "не мины" из матрицы gameField подсчитать количество соседних ячеек "мин" и установить
    это значение в поле countMineNeighbors.
    */
    private void countMineNeighbors() {
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                if (! gameField[y][x].isMine ) {
                    for (GameObject neighborn : getNeighbors(gameField[y][x])) {
                        gameField[y][x].countMineNeighbors += (neighborn.isMine) ? 1 : 0;
                    }
                }
            }

        }
    }

    private void openTile(int x, int y) {
        GameObject gameObject = gameField[y][x];
        if (gameObject.isOpen || gameObject.isFlag || isGameStopped) return;

        gameObject.isOpen = true;
        countClosedTiles--;

        if (gameObject.isMine) {
            //setCellValue(x, y, MINE);
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
            return;
        } else {
            score += 5;
            setScore(score);

            setCellNumber(x, y, gameObject.countMineNeighbors);
            if (gameObject.countMineNeighbors == 0) {
                setCellValue(x, y, "");
                setCellColor(x, y, Color.BLACK);
                getNeighbors(gameObject).forEach(neighbor -> openTile(neighbor.x, neighbor.y));
            }
            if (countClosedTiles == countMinesOnField) win();
        }
        setCellColor(x, y, Color.GREEN);
    }

    private void markTile(int x, int y) {
        if (isGameStopped) return;
        GameObject gameObject = gameField[y][x];
        if (gameObject.isOpen) return;
        if (countFlags == 0 && gameObject.isFlag == false) return;

        if (!gameObject.isFlag) {
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);

            gameObject.isFlag = true;
            countFlags--;
        } else {
            setCellValue(x, y, "");
            setCellColor(x,y, Color.ORANGE);
            gameObject.isFlag = false;
            countFlags++;
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "Вы проиграли!", Color.BLACK, 16);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.DARKOLIVEGREEN, "Вы выиграли!", Color.BLACK, 18);
    }

    private void restart() {
        isGameStopped = false;
        score = 0;
        setScore(0);
        countClosedTiles = SIDE * SIDE;
        countMinesOnField = 0;
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart();
        } else {
            openTile(x, y);
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }
}