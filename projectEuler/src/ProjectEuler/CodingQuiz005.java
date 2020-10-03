package ProjectEuler;
// https://euler.synap.co.kr/quiz=5

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class CodingQuiz005 {

	public static void main(String[] args) {
		String stringNum[] = new String[10];
		int cnt = 0;
		try {
			File file = new File(".\\file\\q005_boxes.txt");
			BufferedReader bufReader = new BufferedReader(new FileReader(file));
			String line = "";
//			line = bufReader.readLine();
//			System.out.println(line);
			while ((line = bufReader.readLine()) != null) {
				boolean sw = true;
				String a = "", b = "";
//				System.out.println(line);
				stringNum = line.split(", ");
				int strLength = stringNum.length;
				Arrays.sort(stringNum);
				for (String n : stringNum) {
					System.out.printf("%s, ", n);
				}
				System.out.println();
				for (int i = 0; i < strLength; i++) {
					if (!stringNum[i].equals("0")) {
						cnt = i;
						break;
					}
				}
				a = stringNum[cnt];
				stringNum[cnt] = null;
				if (++cnt < strLength) {
					b = stringNum[cnt];
					stringNum[cnt] = null;
				}
				for (int i = 0; i < strLength; i++) {
					System.out.printf("a = %s, b = %s \n", a, b);
//					System.out.println(sw);
					if (stringNum[i] != null) {
						if (sw) {
							a += stringNum[i];
							stringNum[i] = null;
							sw = false;
						} else {
							b += stringNum[i];
							stringNum[i] = null;
							sw = true;
						}
					}
				}
				System.out.printf("a = %s, b = %s \n", a, b);
				if (!a.equals("0") && !b.equals("0")) {
					System.out.println(Integer.parseInt(a) + Integer.parseInt(b));
				}else {
					System.out.println(-1);
				}
				System.out.println();
			}

			bufReader.close();
		} catch (

		FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
}
