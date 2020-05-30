package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Хуан Хуанович
*/

public class Solution {
	public static final List<Person> PEOPLE = new ArrayList<Person>();

	public static void main(String[] args) throws IOException, ParseException {
		System.out.println(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		String line;
		while ((line = reader.readLine()) != null) {
			Matcher matcher = Pattern.compile("(^[^\\d]*) ([\\d ]*$)").matcher(line);

			if (matcher.find()) {

				DateFormat df = new SimpleDateFormat("dd MM yyyy");
				Date birthDate = df.parse(matcher.group(2));
				PEOPLE.add(new Person(matcher.group(1), df.parse(matcher.group(2))));
				System.out.println(matcher.group(2));
			}
		}
		reader.close();
	}
}
