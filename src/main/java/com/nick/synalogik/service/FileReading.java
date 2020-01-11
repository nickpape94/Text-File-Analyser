package com.nick.synalogik.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileReading {

	String fileInput = "C:\\Users\\Nick-\\Java-Projects\\test.txt";

	public BufferedReader readFile() throws FileNotFoundException {
		BufferedReader fileIn = new BufferedReader(new FileReader(fileInput));
		return fileIn;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new FileReading().wordCount_andAverageWordLength();
		new FileReading().numWordsOfLength();

	}

	public void wordCount_andAverageWordLength() throws FileNotFoundException {
		BufferedReader fileIn = readFile();
		String line;

		// Word count of text file
		try {
			while ((line = fileIn.readLine()) != null) {
				int word_count = 0;
				int letter_count = -1;

				String[] wordsInFile = line.split("\\s+");
				word_count = word_count + wordsInFile.length;
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) != ' ')
						letter_count++;
				}

				double average = letter_count / (double) word_count;
				average = Math.floor(average * 1000) / 1000;

				System.out.println("Word count: " + word_count);
				System.out.println("Average word length: " + average);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void numWordsOfLength() throws FileNotFoundException {
		BufferedReader fileIn = readFile();
		String line;

		try {
			while ((line = fileIn.readLine()) != null) {
				int numWordsOfLength_1 = 0;
				int numWordsOfLength_2 = 0;
				int numWordsOfLength_3 = 0;
				int numWordsOfLength_4 = 0;
				int numWordsOfLength_5 = 0;
				int numWordsOfLength_7 = 0;
				int numWordsOfLength_10 = 0;

				List<String> wordsSorted = new ArrayList<String>();

				String[] wordsInFile = line.split("[\\s\\.]+");

				for (String word : wordsInFile) {
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

				List<Integer> numWords0fLength = Arrays.asList(numWordsOfLength_1, numWordsOfLength_2,
						numWordsOfLength_3, numWordsOfLength_4, numWordsOfLength_5, numWordsOfLength_7,
						numWordsOfLength_10);

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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
