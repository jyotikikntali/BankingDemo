package com.Automation.genericLibrary;

import java.util.Random;

public class JavaUtilities {
	public int getRandomNum(int range) {
		Random r=new Random();
		int num=r.nextInt(range);
		return num;
	}
}
