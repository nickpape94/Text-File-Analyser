package com.nick.synalogik.service.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nick.synalogik.service.FileReading;

public class FileReadingTest {
	private String fileInput = FileReading.fileInput;
	public String splitDeliminator = "[,*;:.£$%+|=@?!_'\\s]+";

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

	@Test
	public void numWordsOfLength() throws FileNotFoundException {
		Scanner in = new Scanner(new File(fileInput));
		FileReading fileReading = new FileReading();
		List<String> listwords = new ArrayList<>();
		int[] arr = new int[7];

		while (in.hasNext()) {
			listwords.addAll(Arrays.asList(in.next().split(splitDeliminator)));
		}

		if (in != null) {
			int numWordsOfLength_1 = 0;
			int numWordsOfLength_2 = 0;
			int numWordsOfLength_3 = 0;
			int numWordsOfLength_4 = 0;
			int numWordsOfLength_5 = 0;
			int numWordsOfLength_7 = 0;
			int numWordsOfLength_10 = 0;

			List<String> wordsSorted = new ArrayList<String>();

			for (String word : listwords) {
				if (word.length() == 1) {
					numWordsOfLength_1++;
					wordsSorted.add(word);

				}
				if (word.length() == 2) {
					numWordsOfLength_2++;
					wordsSorted.add(word);

				}
				if (word.length() == 3) {
					numWordsOfLength_3++;
					wordsSorted.add(word);

				}
				if (word.length() == 4) {
					numWordsOfLength_4++;
					wordsSorted.add(word);

				}

				if (word.length() == 5) {
					numWordsOfLength_5++;
					wordsSorted.add(word);

				}
				if (word.length() == 7) {
					numWordsOfLength_7++;
					wordsSorted.add(word);

				}
				if (word.length() == 10) {
					numWordsOfLength_10++;
					wordsSorted.add(word);

				}
			}

			arr[0] = numWordsOfLength_1;
			arr[1] = numWordsOfLength_2;
			arr[2] = numWordsOfLength_3;
			arr[3] = numWordsOfLength_4;
			arr[4] = numWordsOfLength_5;
			arr[5] = numWordsOfLength_7;
			arr[6] = numWordsOfLength_10;

			Assert.assertEquals(arr[0], fileReading.numWordsOfLength()[0]);
			Assert.assertEquals(arr[1], fileReading.numWordsOfLength()[1]);
			Assert.assertEquals(arr[2], fileReading.numWordsOfLength()[2]);
			Assert.assertEquals(arr[3], fileReading.numWordsOfLength()[3]);
			Assert.assertEquals(arr[4], fileReading.numWordsOfLength()[4]);
			Assert.assertEquals(arr[5], fileReading.numWordsOfLength()[5]);
			Assert.assertEquals(arr[6], fileReading.numWordsOfLength()[6]);
		}
	}
	
	@Test
	public void maxRepeatedSizes() throws FileNotFoundException {
		Scanner in = new Scanner(new File(fileInput));
		FileReading fileReading = new FileReading();
		List<String> listwords = new ArrayList<>();
		
		while (in.hasNext()) {
			listwords.addAll(Arrays.asList(in.next().split(splitDeliminator)));
		}
		
		List<String> wordsSorted = new ArrayList<String>();

		for (String word : listwords) {
			if (word.length() == 1 || word.length() == 2 || word.length() == 3 || word.length() == 4 || word.length() == 5 || word.length() == 7 || word.length() == 10) {
				wordsSorted.add(word);
			}
		}

		String[] test = wordsSorted.toArray(new String[0]);

		List<Integer> maxRepeatingSizes = Arrays.stream(test)
				.collect(Collectors.groupingBy(String::length, Collectors.counting())).entrySet().stream()
				.collect(Collectors.groupingBy(Map.Entry::getValue,
						Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
				.entrySet().stream().max(Map.Entry.comparingByKey()).get().getValue();
		
		Assert.assertEquals(maxRepeatingSizes, fileReading.maxRepeatedSizes());
		
	}

}
