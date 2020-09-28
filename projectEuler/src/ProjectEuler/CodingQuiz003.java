package ProjectEuler;
// https://euler.synap.co.kr/quiz=3

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodingQuiz003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] square = new boolean[1920][1080];
		String squareStrArr[] = new String[4];
		int squareArr[] = new int[4];
		int area = 0;
		try {
			File file = new File(".\\file\\q003_boxes.txt");
			BufferedReader bufReader = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = bufReader.readLine()) != "\r\n") {
				if (line == null) {
					break;
				}
//				System.out.println(line);
				squareStrArr = line.split(" ");
				for (int i = 0; i < squareStrArr.length; i++) {
//					System.out.println(squareStrArr[i]);
					squareArr[i] = Integer.parseInt(squareStrArr[i]);
				}
				for (int i = squareArr[0]; i < squareArr[2]; i++) {
					for (int j = squareArr[1]; j < squareArr[3]; j++) {
						square[i][j] = true;
					}
				}
			}

			bufReader.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

		for (int i = 0; i < 1920; i++) {
			for (int j = 0; j < 1080; j++) {
				if (square[i][j] == true) {
//					System.out.printf("%d, %d\n", i, j);
					
					area++;
				}
			}
		}

		System.out.println(area);
	}
}
