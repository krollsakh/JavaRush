package My_Examples;

/*
Работа с zip
 */

import java.io.*;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipAchiever {
    public static void main(String[] args) throws IOException {

        ZipAchiever zip = new ZipAchiever();
//        zip.zipFile("/Users/sergey/Downloads/hello.txt", "/Users/sergey/Downloads/hello.zip");

//        zip.unZipIS("/Users/sergey/Downloads/hello.zip");

        zip.unZipFile("/Users/sergey/Downloads/hello.zip");

    }

    /*
     упаковка 1 файла в архив (версия через FileInputStream)
     */
    public void zipFileInputStream(String fileName, String fileArchieve) throws IOException {
        //создаем архив
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(fileArchieve));
        ZipEntry entry = new ZipEntry(fileName);

        //помещаем в архив архивный объект
        zos.putNextEntry(entry);

        //читаем в потоке содержимое файла
        FileInputStream fis = new FileInputStream(fileName);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);

        // записываем прочтенное в архив
        zos.write(buffer);

        //закрываем объекты
        fis.close();
        zos.close();

    }

    /*
    упаковка 1 файла в архив (версия через File)
     */
    public void zipFile(String fileName, String fileArchieve) throws IOException {
        //создаем архив
        FileOutputStream zipFile = new FileOutputStream(fileArchieve);
        ZipOutputStream zip = new ZipOutputStream(zipFile);

        //помещаем в архив архивный объект
        zip.putNextEntry(new ZipEntry(fileName));

        //копируем файл в архив
        File file = new File(fileName);
        Files.copy(file.toPath(), zip);

        //закрываем потоки
        zipFile.close();
        zip.close();
    }

    /*
    Распаковка через ZipInputStream/FileOutputStream
     */
    private void unZipIS(String fileNameArchieve) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(fileNameArchieve));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ZipEntry entry;
        String name;
        long size;
        while ((entry = zipInputStream.getNextEntry()) != null) {

            byteArrayOutputStream.writeBytes(zipInputStream.readAllBytes());

            size = entry.getSize(); // размер файла до упаковки
            name = entry.getName(); // имя файла
            System.out.printf("File name: %s \t File size: %d \n", name, size);

            FileOutputStream fileOutputStream = new FileOutputStream(name);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();

        }

        // закрываем поток
        byteArrayOutputStream.close();
        zipInputStream.close();
    }

    /*
    распаковка с использованием ZipFile
     */
    private void unZipFile(String fileNameArchieve) throws IOException {
        ZipFile zipFile = new ZipFile(fileNameArchieve);
        Enumeration zipEnum = zipFile.entries();
        while (zipEnum.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) zipEnum.nextElement();
            System.out.println(zipEntry.getName());

            System.out.println("Не закончено");
        }
    }

    /*
    Добавление файла в архив без распаковки
    */
    public static class Solution2 {
        public static void main(String[] args) throws IOException {
            Map<String, String> env = new HashMap<>();
            env.put("create", "true");
            Path path = Paths.get(args[1]); // путь к архиву .zip
            URI uri = URI.create("jar:" + path.toUri());
            try (FileSystem fs = FileSystems.newFileSystem(uri, env)) {
                Files.createDirectory(fs.getPath("/new"));
                Path newFileInArchive = fs.getPath("/new/" + Paths.get(args[0]).getFileName());// путь к файлу
                Files.copy(Paths.get(args[0]), newFileInArchive);
            }
        }
    }
}
