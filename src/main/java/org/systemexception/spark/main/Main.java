package org.systemexception.spark.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.systemexception.spark.freemarker.FreeMarkerEngine;
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

	private final static Logger LOGGER = LogManager.getLogger(Main.class);

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
		LOGGER.info("Generate date");
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
		return localDateTime.format(dateTimeFormatter);
	}

	private static List<String> getRandomStrings() {
		LOGGER.info("Generate random string list");
		List<String> stringList = new ArrayList<>();
		Random random = new Random(System.currentTimeMillis());
		final int listSize = random.nextInt(10);
		for (int i = 0; i < listSize; i++) {
			stringList.add(String.valueOf(random.nextLong()));
		}
		return stringList;
	}
}
