package ProjectEuler;
// https://euler.synap.co.kr/quiz=5

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class CodingQuiz009 {

	public static void main(String[] args) {
		String stringNum[] = new String[10];
		int cnt = 0;
		try {
			File file = new File(".\\file\\q009_boxes.txt");
			BufferedReader bufReader = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				line = line.replace(" ","");
				String alphabetLine = line.replaceAll("\\+|\\-|\\*|\\/|\\=", "");
//				System.out.println("line : "+line);
//				System.out.println("alphabetLine : "+alphabetLine);
				
				stringNum = line.split("\\+|\\-|\\*|\\/|\\=");
				for (int i = 0; i < stringNum.length; i++) {
					System.out.println(stringNum[i]);
				}
			}

			bufReader.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
}
