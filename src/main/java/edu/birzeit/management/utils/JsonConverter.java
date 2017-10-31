package edu.birzeit.management.utils;

import com.google.gson.Gson;

/**
 * @author arouri
 *
 */
public class JsonConverter {

	/**
	 * To json
	 * @param object
	 * @return
	 */
	public static String convertToJson(Object object) {

		String json = new Gson().toJson(object);
		return json;
	}

	/**
	 * From json
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T convertToObject(String json, Class<T> clazz) {

		Gson gson = new Gson();
		T result = gson.fromJson(json, clazz);
		return result;

	}
}
