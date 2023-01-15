package com.noteslookup.cookie.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * The Class CookieUtils.
 */
public class CookieUtils {

  /**
   * Gets the cookie.
   *
   * @param request the request
   * @param name the name
   * @return the cookie
   */
  public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}
		return null;
	}
  
  /**
   * Gets the cookie value from cookie map.
   *
   * @param pCookieName the cookie name
   * @param pCookieMap the cookie map
   * @return the cookie value from cookie map
   */
  public static String getCookieValueFromCookieMap(String pCookieName, Map<String,Cookie> pCookieMap) {
	  if(pCookieMap != null) {
		  Cookie lCookie=pCookieMap.get(pCookieName);
		  if(lCookie != null) {
			 return lCookie.getValue();
		  }
	  }
	return null;
	  
  }
  
  /**
   * Gets the cookie.
   *
   * @param request the request
   * @return the cookie
   */
  public static Map<String,Cookie> getCookieMap(HttpServletRequest request) {
	  Map<String,Cookie> lCookieMap = new HashMap<>();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				lCookieMap.put(cookie.getName(), cookie);
			}
		}
		return lCookieMap;
	}
	
}
