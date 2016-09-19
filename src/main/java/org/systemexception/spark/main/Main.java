package org.systemexception.spark.main;

import spark.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static spark.Spark.get;

/**
 * @author leo
 * @date 11/10/15 01:21
 */
class Main {

	public static void main(String[] args) {

		get("/hello", (request, response) -> "Hello World" + "<hr>" + getDate());

		get("/time", (request, response) -> getDate());

		get("/hello_message", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("message", "Hello World!");
			attributes.put("stringList", getRandomStrings());
			attributes.put("date", getDate());
			return new ModelAndView(attributes, "hello.ftl");
		}, new FreeMarkerEngine());

	}

	private static String getDate() {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
		return localDateTime.format(dateTimeFormatter);
	}

	private static List<String> getRandomStrings() {
		final int listSize = 5;
		List<String> stringList = new ArrayList<>();
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < listSize; i++) {
			stringList.add(String.valueOf(random.nextLong()));
		}
		return stringList;
	}
}
