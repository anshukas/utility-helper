package com.noteslookup.json.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class JSONUtils {

	/**
	 * Checks if is not null and empty array.
	 *
	 * @param arrayNode
	 *            the array node
	 * @return true, if is not null and empty array
	 */
	public static boolean isNotNullAndNotEmptyArray(ArrayNode arrayNode) {
		return !isNullOREmptyArray(arrayNode);
	}
	
	/**
	 * Checks if is not null and empty array.
	 *
	 * @param arrayNode
	 *            the array node
	 * @return true, if is not null and empty array
	 */
	public static boolean isNotNullAndNotEmptyArray(JsonNode jsonNode) {
		return !isNullOREmptyArray(jsonNode);
	}
	
	/**
	 * Checks if is not null and empty array.
	 *
	 * @param arrayNode
	 *            the array node
	 * @return true, if is not null and empty array
	 */
	public static boolean isNullOREmptyArray(ArrayNode arrayNode) {
		return ((null == arrayNode) || arrayNode.isNull() || arrayNode.size() < 1) ? true : false;
	}

	/**
	 * Checks if is not null and not empty arraynode for the given jsonnode.
	 *
	 * @param jsonNode
	 * @return true, if is not null and nor empty arraynode
	 */
	public static boolean isNullOREmptyArray(JsonNode jsonNode) {
		return ((null == jsonNode) || jsonNode.isNull() || !jsonNode.isArray() || jsonNode.size() < 1 );
	}

	
	/**
	 * Checks if is not null and not empty.
	 *
	 * @param jsonNode
	 *            the json node
	 * @return true, if is not null and not empty
	 */
	public static boolean isNotNullAndNotEmpty(JsonNode jsonNode) {
		if(jsonNode instanceof ArrayNode) {
			ArrayNode lArrayNode=(ArrayNode) jsonNode;
			return !isNullOREmptyArray(lArrayNode);
		}else {
			return !isNullOREmpty(jsonNode);
		}
		
	}

	/**
	 * Checks if is not null.
	 *
	 * @param jsonNode
	 *            the json node
	 * @return true, if is not null
	 */
	public static boolean isNullOREmpty(JsonNode jsonNode) {
		return ((null == jsonNode) || jsonNode.isNull() || jsonNode.isMissingNode() || jsonNode.isEmpty());
	}
	
	/**
	 * Checks if is not null.
	 *
	 * @param jsonNode
	 *            the json node
	 * @return true, if is not null
	 */
	public boolean isNotNull(JsonNode jsonNode) {
		return ((null != jsonNode) && !jsonNode.isNull());
	}

	/**
	 * Checks if is not null and is not Empty.
	 *
	 * @param jsonNode
	 *            the json node
	 * @return true, if is not null
	 */
	public boolean isNotEmpty(JsonNode jsonNode) {
		return ((null != jsonNode) && !jsonNode.isNull() && !jsonNode.isMissingNode());
	}


	
}
