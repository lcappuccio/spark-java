package org.systemexception.spark.main;

import static spark.Spark.get;

/**
 * @author leo
 * @date 11/10/15 01:21
 */
public class Main {

	public static void main(String[] args) {
		get("/hello", (req, res) -> "Hello World");
	}
}