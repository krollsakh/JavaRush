package My_Examples.SerializationJSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class SerializationJSON {

    public static void main(String[] args) throws IOException {
        // Создание объекта для сериализации в JSON
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;

        // Результат сериализации пишем во Writer
        StringWriter writer = new StringWriter();

        //это объект Jackson, который выполняет сериализацию
        ObjectMapper mapper = new ObjectMapper();

        // Сериализация (куда, что) -
        mapper.writeValue(writer, cat);

        //преобразовываем все записанное во StringWriter в строку
        String result = writer.toString();
        System.out.println(result);

        //*******************
        // Десериализация

        StringReader reader = new StringReader(result);
        ObjectMapper mapper1 = new ObjectMapper();

        Cat cat1 = mapper1.readValue(reader, Cat.class);

    }
}
