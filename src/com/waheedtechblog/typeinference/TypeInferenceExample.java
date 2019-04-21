package com.waheedtechblog.typeinference;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class TypeInferenceExample {

	static {
		// static block variable
		var staticVaribale = "var in static block";
		Consumer<String> displayOnConsole = msg -> {
			System.out.println(msg);
		};
		displayOnConsole.accept(staticVaribale);

	}

	public static void main(String[] args) {

		TypeInferenceExample inferenceExample = new TypeInferenceExample();

		BiConsumer<String, String> displayOnConsole = (str, msg) -> {
			System.out.println(str + msg);
		};

		// Before Java 10
		String message = "Welcome to Waheedtechblog.com";
		displayOnConsole.accept("Before JDK 10: ", message);

		// Using JDK 10, Local Variable
		var message10 = "Welcome to Waheedtechblog.com";
		displayOnConsole.accept("With JDK 10: ", message);

		// local variable declaration in enhanced loops
		String[] countryName = { "India", "Japan", "UAE", "USA", "UK" };
		displayOnConsole.accept("", "List of Country using enhanced loop");
		for (var country : countryName) {
			displayOnConsole.accept("", country);
		}

		// basic for loop
		displayOnConsole.accept("", "List of Country using basic loop");
		for (var i = 0; i < countryName.length; i++) {
			displayOnConsole.accept("", countryName[i]);
		}

		displayOnConsole.accept("Length of string '" + message10 + "' is: ",
				String.valueOf(inferenceExample.getLenth(message10)));

		String var = "var is not keyword";
		displayOnConsole.accept("", var);
	}

	// can return var type as well
	private int getLenth(String msg) {
		var length = msg.length();
		return length;
	}

}
