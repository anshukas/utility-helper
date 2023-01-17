package com.noteslookup.common.util;

import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Utility class.
 *   
 * @author BC52363
 *
 */

public class CommonUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);
	
	public static HttpServletRequest getCurrentHttpRequest() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if (requestAttributes instanceof ServletRequestAttributes) {
			HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
			return request;
		}
		LOGGER.debug("Not called in the context of an HTTP request");
		return null;
	}

	public static boolean isRealTimeLogInfoEnabled() {
		HttpServletRequest currentRequest = getCurrentHttpRequest();
		if (currentRequest != null && currentRequest.getParameter("logInfo") != null) {
			return true;
		}
		return false;
	}
	
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
