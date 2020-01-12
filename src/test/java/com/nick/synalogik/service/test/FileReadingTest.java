package com.nick.synalogik.service.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nick.synalogik.service.FileReading;


public class FileReadingTest {
	private String fileInput = FileReading.fileInput;
	public String splitDeliminator = "[,*;:.@?!_'\\s]+";
	//private FileReading fileReading;
	
	
	@Test
	public void readFile() throws FileNotFoundException {
		Scanner in = new Scanner(new File(fileInput));
		FileReading fileReading = new FileReading();
		
		Assert.assertEquals(in.toString(), fileReading.readFile().toString());
	}
	
	@Test
	public void wordCount() throws FileNotFoundException {
		Scanner in = new Scanner(new File(fileInput));
		FileReading fileReading = new FileReading();
		
		List<String> listwords = new ArrayList<>();
		while (in.hasNext()) {
			listwords.addAll(Arrays.asList(in.next().split(splitDeliminator)));
		}
		Assert.assertEquals(listwords.size(), fileReading.wordCount());
	}
	
//	@SuppressWarnings("deprecation")
	@Test
	public void averageWordCount() throws FileNotFoundException {
		Scanner in = new Scanner(new File(fileInput));
		FileReading fileReading = new FileReading();
		int letter_count = 0;
		List<String> listwords = new ArrayList<>();
		
		while (in.hasNext()) {
			listwords.addAll(Arrays.asList(in.next().split(splitDeliminator)));
		}
		
		for (String word : listwords) {
			letter_count += word.length();
		}

		double average = letter_count / (double) listwords.size();
		average = Math.floor(average * 1000) / 1000;
		Assert.assertEquals(average, fileReading.averageWordLength(), 0.001);
	}
	



}
