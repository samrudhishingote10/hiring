package tictactoe;

import java.util.Scanner;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class tictactoe {
	static ArrayList<Integer> Player1Pos = new ArrayList<Integer>();
	static ArrayList<Integer> Player2Pos = new ArrayList<Integer>();
	static String P1Name;
	static String P2Name;

	public static void main(String[] args) {
		char[][] Board = { { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' },
				{ ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' },
				{ ' ', '|', ' ', '|', ' ' } };

		

		printGameBoard(Board);

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 1st Player Name:");
		P1Name = sc.nextLine();
		System.out.print("Enter 2nd Player Name:");
		P2Name = sc.nextLine();
		
		

		while (true) {
			

			System.out.println(P1Name + " Enter the No (1-9):");
			int pos1 = sc.nextInt();
			while (Player1Pos.contains(pos1) || Player2Pos.contains(pos1)){
			System.out.println("Position Taken ! Enter Correct Position");
			 pos1 = sc.nextInt();
			}
			 
			

			place(Board, pos1,P1Name);
			printGameBoard(Board);
			String result = checkWinner();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}

			System.out.println(P2Name + " Enter the No (1-9):");
			int pos2 = sc.nextInt();
			while (Player1Pos.contains(pos2) || Player2Pos.contains(pos2)){
			System.out.println("Position Taken ! Enter Correct Position");
			 pos2 = sc.nextInt();
			}

			place(Board, pos2, P2Name);
			printGameBoard(Board);

			result = checkWinner();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
			

		}

	}

	public static void printGameBoard(char[][] Board) {
		for (char[] row : Board) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

	public static void place(char[][] Board, int pos, String user) {

		char symbol = ' ';

		if (user.equals(P1Name)) {
			symbol = 'X';
			Player1Pos.add(pos);
		} else if (user.equals(P2Name)) {
			symbol = 'O';
			Player2Pos.add(pos);
		}

		switch (pos) {
		case 1:
			Board[0][0] = symbol;
			break;
		case 2:
			Board[0][2] = symbol;
			break;
		case 3:
			Board[0][4] = symbol;
			break;
		case 4:
			Board[2][0] = symbol;
			break;
		case 5:
			Board[2][2] = symbol;
			break;
		case 6:
			Board[2][4] = symbol;
			break;
		case 7:
			Board[4][0] = symbol;
			break;
		case 8:
			Board[4][2] = symbol;
			break;
		case 9:
			Board[4][4] = symbol;
			break;
		default:
			break;
		}
	}

	public static String checkWinner() {
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);
		List leftcol = Arrays.asList(1, 4, 7);
		List midcol = Arrays.asList(2, 5, 8);
		List rightcol = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(3, 5, 7);

		List<List> winning = new ArrayList<List>();

		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftcol);
		winning.add(midcol);
		winning.add(rightcol);
		winning.add(cross1);
		winning.add(cross2);

		for (List l : winning) {
			if (Player1Pos.containsAll(l)) {
				return P1Name+"Win";
			} else if (Player2Pos.containsAll(l)) {
				return P2Name+" Win";
			} else if (Player1Pos.size() + Player2Pos.size() == 9) {
				return "Tie";
			}
		}
		return "";
	}

}
