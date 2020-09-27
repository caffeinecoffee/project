package synapsoft;

public class synapsoft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long happyNum = 0;
		long happyCnt = 0;
		long unhappyNum = 0;
		long unhappyCnt = 0;
		long calNum = 0;
		long newNum[] = new long[17];
		for (long value = 1; value <= 9999; value++) {
			newNum[0] = value;
			for (int i = 0; i < 16; i++) {
				while (newNum[i] / 10 != 0 || newNum[i] % 10 != 0) {
					calNum += (newNum[i] % 10) * (newNum[i] % 10);
					newNum[i] /= 10;
				}
				newNum[i + 1] = calNum;
				if (calNum == 1) {
					happyNum += value;
					happyCnt++;
					calNum = 0;
					break;
				} else if (calNum == 4) {
					unhappyNum += value;
					calNum = 0;
					break;
				}
				calNum = 0;
			}
		}
		System.out.println("1 ~ 9999 범위의 행복 수는 " + happyCnt + "개이고 총합은 " + happyNum + "입니다.");

//		for (long value = 1; value < 10000000; value++) {
//			newNum[0] = value;
//			for (int i = 0; i < 16; i++) {
//				while (newNum[i] / 10 != 0 || newNum[i] % 10 != 0) {
//					calNum += (newNum[i] % 10) * (newNum[i] % 10);
//					newNum[i] /= 10;
//				}
//				newNum[i + 1] = calNum;
//				if (calNum == 1) {
//					happyNum += value;
//					happyCnt++;
//					calNum = 0;
//					break;
//				} else if (calNum == 4) {
//					unhappyNum += value;
//					unhappyCnt++;
//					calNum = 0;
//					break;
//				}
//				calNum = 0;
//			}
//		}
//		System.out.println("1 ~ 9999 범위의 행복 수는 " + unhappyCnt + "개이고 총합은 " + unhappyNum + "입니다.");
	}
}