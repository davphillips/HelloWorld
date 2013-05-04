package com.davphillips.apps;

public class HelloWorldApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Hello World");
		System.out.println("2 + 2 = " + HelloMath.add(2, 2));
		System.out.println("2 - 2 = " + HelloMath.subtract(2, 2));
		System.out.println("2 * 2 = " + HelloMath.multiply(2, 2));
		System.out.println("2 / 2 = " + HelloMath.divide(2, 2));
	}

}
