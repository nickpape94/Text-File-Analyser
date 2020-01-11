package com.nick.synalogik.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.reflect.Method;

public class FileReading {

	public static void main(String[] args) throws IOException {
		BufferedReader fileIn = new BufferedReader(new FileReader("C:\\Users\\Nick-\\Java-Projects\\test.txt"));
		// TODO Auto-generated method stub
		new FileReading().wordCount();
		new FileReading().averageWordLength();
		new FileReading().numWordsOfLength();
		//new FileReading().numWordsOfLength2();

	}

	public void wordCount() throws FileNotFoundException {
		BufferedReader fileIn = new BufferedReader(new FileReader("C:\\Users\\Nick-\\Java-Projects\\test.txt"));

		String line;
		// Word count of text file
		try {
			while ((line = fileIn.readLine()) != null) {
				int word_count = 0;
				int lengthString = line.length();
				String[] wordsInFile = line.split("\\s");
				word_count = word_count + wordsInFile.length;
				System.out.println("Word count: " + word_count);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void averageWordLength() throws FileNotFoundException {
		BufferedReader fileIn = new BufferedReader(new FileReader("C:\\Users\\Nick-\\Java-Projects\\test.txt"));
		String line;
		// Word count of text file
		try {
			while ((line = fileIn.readLine()) != null) {
				int word_count = 0;
				int letter_count = -1;
				double average = word_count / (double) letter_count;
				String[] wordsInFile = line.split("\\s+");
				word_count = word_count + wordsInFile.length;
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) != ' ')
						letter_count++;
				}
				// System.out.println("Word count:" + " " + word_count);
				// double word_count2 = Math.round((double)word_count * 100.0) /100.0;
				System.out.println("Average word length: " + letter_count / (double) word_count);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void numWordsOfLength() throws FileNotFoundException {
		BufferedReader fileIn = new BufferedReader(new FileReader("C:\\Users\\Nick-\\Java-Projects\\test.txt"));
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
				List<ArrayList> allTheLists;
				//List<String> wordLen0 = new ArrayList<>();
				List<String> wordLen1 = new ArrayList<String>();
				//Stream<String> stream = Arrays.stream(wordLen1);
				List<String> wordLen2 = new ArrayList<>();
				List<String> wordLen3 = new ArrayList<>();
				List<String> wordLen4 = new ArrayList<>();
				List<String> wordLen5 = new ArrayList<>();
				List<String> wordLen7 = new ArrayList<>();
				List<String> wordLen10 = new ArrayList<>();
				List<String> wordLengthsMax = new ArrayList<>();
				List<List<String>> wordLengths = new ArrayList<List<String>>();
				
				

				int lengthString = line.length();
				String[] wordsInFile = line.split("[\\s\\.]+");

				for (String word : wordsInFile) {
					if (word.length() == 1) {
						numWordsOfLength_1++;
						wordLen1.add(word);
						wordLengths.add(Arrays.asList(word));
					}
					if (word.length() == 2) {
						numWordsOfLength_2++;
						wordLen1.add(word);
						wordLengths.add(Arrays.asList(word));
					}
					if (word.length() == 3) {
						numWordsOfLength_3++;
						wordLen1.add(word);
						wordLengths.add(Arrays.asList(word));
					}
					if (word.length() == 4) {
						numWordsOfLength_4++;
						wordLen1.add(word);
						wordLengths.add(Arrays.asList(word));
					}
					if (word.length() == 5) {
						numWordsOfLength_5++;
						wordLen1.add(word);
						wordLengths.add(Arrays.asList(word));
					}
					if (word.length() == 7) {
						numWordsOfLength_7++;
						wordLen1.add(word);
						wordLengths.add(Arrays.asList(word));
					}
					if (word.length() == 10) {
						numWordsOfLength_10++;
						wordLen1.add(word);
						wordLengths.add(Arrays.asList(word));
					}
				}
				
				
				
				
				List<Integer> numWords0fLength = Arrays.asList(
						numWordsOfLength_1, 
						numWordsOfLength_2, 
						numWordsOfLength_3,
						numWordsOfLength_4, 
						numWordsOfLength_5, 
						numWordsOfLength_7,
						numWordsOfLength_10
						);
				
				String[] test = wordLen1.toArray(new String[0]);
				

				
				int y = Collections.max(numWords0fLength);
				

				
//			Collections.sort(wordLengths)
//				wordLengths.sort(Comparator.comparing(String::length));
				
				List<Integer> maxRepeatingSizes =
					    Arrays.stream(test)
					            .collect(Collectors.groupingBy(
					                String::length,
					                Collectors.counting()
					            )).entrySet()
					            .stream()
					            .collect(
					                    Collectors.groupingBy(
					                            Map.Entry::getValue,
					                            Collectors.mapping(
					                                Map.Entry::getKey,
					                                Collectors.toList()
					                            )
					                    )
					            ).entrySet()
					            .stream()
					            .max(
					                    Map.Entry.comparingByKey()
					            ).get()
					            .getValue();
				

				System.out.println(test);
				System.out.println(wordLen1);
				
				System.out.println("Number of words of length 1: " + numWordsOfLength_1);
				System.out.println("Number of words of length 2: " + numWordsOfLength_2);
				System.out.println("Number of words of length 3: " + numWordsOfLength_3);
				System.out.println("Number of words of length 4: " + numWordsOfLength_4);
				System.out.println("Number of words of length 5: " + numWordsOfLength_5);
				System.out.println("Number of words of length 7: " + numWordsOfLength_7);
				System.out.println("Number of words of length 10: " + numWordsOfLength_10);
				System.out.println("The most frequently occurring word length is "+ y + maxRepeatingSizes);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
//	public void numWordsOfLength2() {
//		// Hello world & good morning. The date is 18/05/2016
//		String[] arr = new String[]{
//		        "Hello",
//		        "world",
//		        "&",
//		        "good",
//		        "morning",
//		        "the",
//		        "date",
//		        "is",
//		        "01/10/2020"
//		};
//
//		List<Integer> maxRepeatingSizes =
//		    Arrays.stream(arr)
//		            .collect(Collectors.groupingBy(
//		                String::length,
//		                Collectors.counting()
//		            )).entrySet()
//		            .stream()
//		            .collect(
//		                    Collectors.groupingBy(
//		                            Map.Entry::getValue,
//		                            Collectors.mapping(
//		                                Map.Entry::getKey,
//		                                Collectors.toList()
//		                            )
//		                    )
//		            ).entrySet()
//		            .stream()
//		            .max(
//		                    Map.Entry.comparingByKey()
//		            ).get()
//		            .getValue();
//		System.out.println(arr.toString());
//		System.out.println(maxRepeatingSizes);
//	}

}
