package com.v5ent.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GeneIndexHtml {
	public static void main(String[] args) throws FileNotFoundException {
		readFileByLines("F:\\backend\\v5ent-union-webapp\\src\\main\\java\\com\\v5ent\\rest\\AppRestService.java");
		/*
		 * String s = "1.App商品列表"; if(s.matches("\\\\d{1,2}\\\\Q.\\\\E.+")){
		 * System.out.println("-----"); }
		 */
	}

	public static void readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				if ("".equals(tempString.trim())){
					System.out.println("</pre><pre>");
				}else{
					System.out.println(tempString+"</br>");
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
}
