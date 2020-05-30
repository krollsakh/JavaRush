package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "hack");
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        // инициализация переменной возврата
        List<Word> wordList = new ArrayList<>();

        // всего 8 направлений
        // описание направлений, например, вправо по горизонтали - это x=1, y=0
        // в описании пойдем от 12 часов по часовой
        int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};

        // параметры матрицы-кроссворда - это количество строк (Rows) и столбцов (Columns)
        int R  = crossword.length;
        int C = crossword[0].length;

        // для каждого слова
        for (String word : words) {
            //длина слова
            int len = word.length();

            for (int row = 0; row < R; row++) {
                for (int col = 0; col < C; col++) {
                    // первый символ должен совпадать
                    if (crossword[row][col] == word.charAt(0)) {

                        //по каждому из направлений;
                        for (int dir = 0; dir < 8; dir++) {

                            //координаты начала поиска
                            int y = row + dirY[dir];
                            int x = col + dirX[dir];

                            //проверка каждого символа строки с учетом того что первый уже проверили
                            int i;
                            for (i = 1; i < len ; i++) {
                                // если индекс вне размерности или не равен
                                if (y >= R || y < 0 || x >= C || x < 0 || crossword[y][x] != word.charAt(i)) {
                                    break; //ищем в другом направлении
                                }
                                // двигаемся дальше
                                y += dirY[dir];
                                x += dirX[dir];
                            }
                            if (i==len) {
                                //если прошли все буквы - найдено
                                Word wordFound = new Word(word);
                                wordFound.setStartPoint(col, row);
                                wordFound.setEndPoint(col + dirX[dir] * (len - 1), row + dirY[dir] * (len - 1));
                                wordList.add(wordFound);
                                break;
                            }
                        }

                    }
                }
            }
        }

        return wordList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
