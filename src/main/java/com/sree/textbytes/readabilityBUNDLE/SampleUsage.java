package com.sree.textbytes.readabilityBUNDLE;

import java.io.BufferedReader;
import java.io.FileReader;

import com.sree.textbytes.network.HtmlFetcher;


public class SampleUsage {
	public static void main(String[] args) throws Exception {
		Article article = new Article();
		ContentExtractor ce = new ContentExtractor();
		HtmlFetcher htmlFetcher = new HtmlFetcher();
		String html = htmlFetcher.getHtml("https://github.com/auvmacintosh/readabilityBUNDLE", 1000);
		
		//System.out.println("Html : "+html);
		String cp = SampleUsage.class.getResource("/").getPath();
		
		article = ce.extractContent(readFileAsString(cp + "bwcx.html"), "ReadabilityGoose");
		
		System.out.println("Content : "+article.getCleanedArticleText());
		
		
	}

	public static String readFileAsString(String filePath) throws java.io.IOException {
		StringBuilder fileData = new StringBuilder(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
		reader.close();
		return fileData.toString();
	}
}
