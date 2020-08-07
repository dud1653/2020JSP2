package com.lee.board.common;

public class Utils {
	public static int parseStringToInt(String str, int num) {
		try {
			return Integer.parseInt(str);
		} catch(NumberFormatException e) {
			return num;
		}
	}
}
