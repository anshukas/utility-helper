package com.noteslookup.common.util;

import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Utility class.
 * @author anshukas
 *
 */

public class CommonUtils {
	
	public static LocalDateTime convertStrDateToDate(String input, String format) {
		DateTimeFormatter inputFormatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern(format)
                .toFormatter();
	    return LocalDateTime.parse(input, inputFormatter);
	}
	
	/**
	 * Checks if is not null and not empty.
	 *
	 * @param jsonNode
	 *            the json node
	 * @return true, if is not null and not empty
	 */
	public static boolean isNotNullAndNotEmpty(JsonNode jsonNode) {
		return ((null != jsonNode) && !jsonNode.isNull() && StringUtils.isNotBlank(jsonNode.asText()));
	}
	/**
	 * Checks if is not null.
	 *
	 * @param jsonNode
	 *            the json node
	 * @return true, if is not null
	 */
	public static boolean isNotNull(JsonNode jsonNode) {
		return ((null != jsonNode) && !jsonNode.isNull());
	}

	public static boolean isNetworkError(Throwable e) {
		Throwable t = ExceptionUtils.getRootCause(e);
		return (t != null) && (t instanceof SocketException);
	}
}
