package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    /*
     Рандом "типа" каждого байта
      0 - цифра
      1 - прописная
      2 - заглавная
    байты 48-57 цифры
     97-122 прописные буквы
     65-90 заглавные буквы
     */
    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        //если вдруг рандомайзер не выдаст какой-то тип, то сначала сгенерим 6, а оставшиеся 2 - с недостающим типом
        boolean hasDigital = false;
        boolean hasUpper = false;
        boolean hasLower = false;

        for (int i = 0; i < 8; i++) {
            int type = (int) (Math.random() * 3);
            switch (type) {
                case 0:
                    //нужна цифра (байт 48-57)
                    bos.write(((int) (Math.random() * 10)) + 48);
                    hasDigital = true;
                    break;
                case 1:
                    //нужна заглавная (байт 97-122)
                    bos.write(((int) (Math.random() * 26)) + 97);
                    hasUpper = true;
                    break;
                case 2:
                    //нужна прописная (байт 65-90)
                    bos.write(((int) (Math.random() * 26)) + 65);
                    hasLower = true;
            }

            if (i == 6) {
                if (!hasDigital) {
                    bos.write(((int) (Math.random() * 10)) + 48);
                    hasDigital = true;
                    i++;
                }
                if (!hasUpper) {
                    bos.write(((int) (Math.random() * 26)) + 97);
                    hasUpper = true;
                    i++;
                }
                if (!hasLower) {
                    bos.write(((int) (Math.random() * 26)) + 65);
                    hasLower = true;
                    i++;
                }

            }
        }

        return bos;
    }
}