

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import jdk.nashorn.internal.runtime.arrays.ContinuousArrayData;

public class Shortest_Distance {
	private static int lengthOfRoad;
	private static int count = 1;
	private static int i = 0, j = 0;
	private static String road;
	private static String[][] wholeRoad;
	static String[] parsing;
	static Scanner scanner = new Scanner(System.in);
	static BufferedReader buffered = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		Shortest_Distance cd최단거리구하기 = new Shortest_Distance();
		System.out.println("최단거리 구하기 문제");
		System.out.println("1 은 갈 수 있는 길, 0은 갈 수 없는 길");

		// N x N 길 크기 지정
		System.out.print("길의 크기를 설정하세요 : ");
		setLenghtOfRoad();

		// 길의 크기 할당
		setWholeRoad();
		setParsing();

		System.out.println("입력 예시 : 1 1 0 1 0 ... 숫자 사이 띄어쓰기!");

		// 길 만들기
		makingWay();

		// 최단거리 출력하기
		System.out.println(cd최단거리구하기.getShortestDistance(wholeRoad));
	}

	public static void setLenghtOfRoad() {
		lengthOfRoad = scanner.nextInt();
	}

	private static void setParsing() {
		parsing = new String[lengthOfRoad];
	}

	public static void setWholeRoad() {
		wholeRoad = new String[lengthOfRoad][lengthOfRoad];
	}

	// 1과 0을 넣어 길을 만든다
	public static void makingWay() throws IOException {
		for (i = 0; i < lengthOfRoad; i++) {
			road = buffered.readLine().toString();
			parsing = road.trim().split(" ");
			for (j = 0; j < lengthOfRoad; j++) {
				wholeRoad[i][j] = parsing[j];
			}
		}
		// String asdString = new String();
		// 래퍼 클래스 int 오토 박싱, 언박싱
	}

	public int getShortestDistance(String[][] wholeRoad) {
		asdasd: // 라벨 반복문을 감싸준다. break할 때
		for (i = 0; i < wholeRoad.length; i++) {
			for (j = 0; j < wholeRoad.length; j++) {
				// 아래로 갈 수 있는 경우
				if ("1".equals(wholeRoad[i][j]) && (i < wholeRoad.length - 1)) {
					if ("1".equals(wholeRoad[i + 1][j])) {
						moveToUnder();
						continue;
					}
				}

				// 아래는 갈 수 없고 오른쪽으로 갈 수 있는 경우
				if (j < (wholeRoad.length - 1) && "1".equals(wholeRoad[i][j])) {
					if ("1".equals(wholeRoad[i][j + 1])) {
						moveToRight();
						continue;
					}
				}

				// 아래는 갈 수 없고 왼쪽으로만 갈 수 있는 경우
				if (!"1".equals(wholeRoad[wholeRoad.length - 1][wholeRoad.length - 1]) && "1".equals(wholeRoad[i][j])) {
					if ("1".equals(wholeRoad[i][j - 1])) {
						moveToLeft();
						continue;
					}
				}

				// 목적지에 도착했을 때
				if ("1".equals(wholeRoad[wholeRoad.length - 1][wholeRoad.length - 1])) {
					continue;
				}

				// 막다른 길이 나와서 프로그램 종료
				else {
					System.out.println("길이 없으므로 프로그램을 종료합니다. 이동한 거리는 총 " + count + " 입니다");
					break asdasd;
				}
			}
		}
		return count;
	}

	public static void moveToUnder() {
		i++;
		j--;
		count++;
	}

	public static void moveToRight() {
		count++;
	}

	public static void moveToLeft() {
		j = -2;
		count++;
	}
}
