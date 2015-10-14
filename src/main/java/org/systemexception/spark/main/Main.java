package org.systemexception.spark.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static spark.Spark.get;

/**
 * @author leo
 * @date 11/10/15 01:21
 */
class Main {

	public static void main(String[] args) {

		get("/hello", (request, response) -> "Hello World" + "<hr>" + getDate());

		get("/time", (request, response) -> getDate());

	}

	private static String getDate() {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
		return localDateTime.format(dateTimeFormatter);
	}
}
