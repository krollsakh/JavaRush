package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("test", null);
            OutputStream outputStream = new FileOutputStream(yourFile);

            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("John");
            user.setLastName("Doo");
            DateFormat df = new SimpleDateFormat("dd MM yyyy");
            user.setBirthDate(df.parse("14 08 1970"));
            user.setMale(true);
            user.setCountry(User.Country.OTHER);
            javaRush.users.add(user);

            User user2 = new User();
            user2.setFirstName("John2");
            user2.setLastName("Doo2");
            user2.setBirthDate(df.parse("15 08 1970"));
            user2.setMale(false);
            user2.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            if (users.isEmpty()) {
                writer.println("No");
            } else {
                writer.println("Yes");
                for (User user : users) {
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());
                    // записываем дату в формате dd.MM.yyyy
                    writer.println(String.valueOf(user.getBirthDate().getTime()));
                    writer.println(user.isMale());
                    writer.println(user.getCountry());
                }
            }

            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            if (line.equals("No") || line == null) {
                return;
            }
            while ((line = reader.readLine()) != null) {

                User user = new User();

                user.setFirstName(line);
                user.setLastName(reader.readLine());
                user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                user.setCountry(User.Country.valueOf(reader.readLine()));

                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
