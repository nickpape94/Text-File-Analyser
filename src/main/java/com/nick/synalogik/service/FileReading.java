package com.nick.synalogik.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileReading {

	String fileInput = "C:\\Users\\Nick-\\Java-Projects\\test5.txt";
	// String splitDeliminator = "[,*.@?!_'\\\\s]+";

	public Scanner readFile() throws FileNotFoundException {
		Scanner in = new Scanner(new File(fileInput));
		return in;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// new FileReading().test();
		// new FileReading().test();
		new FileReading().wordCount_andAverageWordLength();
		new FileReading().numWordsOfLength();

	}

//	public void test() throws FileNotFoundException {
//		Scanner in = readFile();
//		List<String> listwords = new ArrayList<>();
//		while (in.hasNext()) {
//			listwords.addAll(Arrays.asList(in.next().split("\\r?\\n")));
//
//		}
//
//		// System.out.println(listwords);
//	}

	public void wordCount_andAverageWordLength() throws FileNotFoundException {
		Scanner in = readFile();
		int letter_count = 0;
		List<String> listwords = new ArrayList<>();
		while (in.hasNext()) {
			listwords.addAll(Arrays.asList(in.next().split("\\r?\\n")));
		}

		// word_count = word_count + listwords.size();
		for (String word : listwords) {
			letter_count += word.length();
		}

		double average = letter_count / (double) listwords.size();
		average = Math.floor(average * 1000) / 1000;

		System.out.println("Word count: " + listwords.size());
		System.out.println("Average word length: " + average);
		System.out.println(listwords);
	}

	public void numWordsOfLength() throws FileNotFoundException {
		Scanner in = readFile();
		List<String> listwords = new ArrayList<>();
		String[] wordsInFile = in.next().split("\\s+");

		while (in.hasNext()) {
			listwords.addAll(Arrays.asList(in.next().split("\\r?\\n")));
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

			// String[] wordsInFile = line.split("\\s+");

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

			List<Integer> numWords0fLength = Arrays.asList(numWordsOfLength_1, numWordsOfLength_2, numWordsOfLength_3,
					numWordsOfLength_4, numWordsOfLength_5, numWordsOfLength_7, numWordsOfLength_10);

			int mostFrequentWordLength = Collections.max(numWords0fLength);

			String[] test = wordsSorted.toArray(new String[0]);

			List<Integer> maxRepeatingSizes = Arrays.stream(test)
					.collect(Collectors.groupingBy(String::length, Collectors.counting())).entrySet().stream()
					.collect(Collectors.groupingBy(Map.Entry::getValue,
							Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
					.entrySet().stream().max(Map.Entry.comparingByKey()).get().getValue();

			System.out.println("Number of words of length 1: " + numWordsOfLength_1);
			System.out.println("Number of words of length 2: " + numWordsOfLength_2);
			System.out.println("Number of words of length 3: " + numWordsOfLength_3);
			System.out.println("Number of words of length 4: " + numWordsOfLength_4);
			System.out.println("Number of words of length 5: " + numWordsOfLength_5);
			System.out.println("Number of words of length 7: " + numWordsOfLength_7);
			System.out.println("Number of words of length 10: " + numWordsOfLength_10);
			System.out.println("The most frequently occurring word length is " + mostFrequentWordLength
					+ " for word lengths " + maxRepeatingSizes);

		}

	}

}
