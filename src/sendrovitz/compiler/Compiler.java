package sendrovitz.compiler;

import java.util.ArrayList;
import java.util.Scanner;

public class Compiler {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);

		String input;
		ArrayList<String> commands = new ArrayList<String>();
		String[] memory = new String[256];
		do {
			input = keyboard.nextLine();
			if (input.charAt(0) != '/') {
				for (int j = 0; j < input.length(); j++) {
					if (input.charAt(j) == '/') {
						input = input.substring(0, j - 1);
						input.trim();
						break;
					}
				}

				commands.add(input.toUpperCase());
			}
		} while (keyboard.hasNext());

		Boolean error = false;
		String[] line = null;
		String command;
		String location = null;
		String hex;
		String value;
		int memoryCounter = 0;
		for (int i = 0; i < commands.size(); i++) {
			if (error == true) {
				break;
			}
			input = commands.get(i);
			if (input.length() == 3) {
				command = input;
			} else {
				line = input.split(" ");
				command = line[0].toUpperCase();
				location = line[1];

			}
			switch (command) {

			case "LD":
				memory[memoryCounter++] = "0";
				hex = Integer.toHexString(Integer.parseInt(location));
				if (hex.length() == 1) {
					memory[memoryCounter++] = "0";
					memory[memoryCounter++] = hex;
				} else {
					memory[memoryCounter++] = hex.substring(0, 1);
					memory[memoryCounter++] = hex.substring(1, 2);
				}
				break;
			case "ST":
				memory[memoryCounter++] = "1";
				hex = Integer.toHexString(Integer.parseInt(location));
				if (hex.length() == 1) {
					memory[memoryCounter++] = "0";
					memory[memoryCounter++] = hex;
				} else {
					memory[memoryCounter++] = hex.substring(0, 1);
					memory[memoryCounter++] = hex.substring(1, 2);
				}
				break;
			case "SWP":
				memory[memoryCounter++] = "2";
				break;
			case "ADD":
				memory[memoryCounter++] = "3";
				break;
			case "INC":
				memory[memoryCounter++] = "4";
				break;
			case "DEC":
				memory[memoryCounter++] = "5";
				break;
			case "BZ":
				memory[memoryCounter++] = "6";
				hex = Integer.toHexString(Integer.parseInt(location));
				if (hex.length() == 1) {
					memory[memoryCounter++] = "0";
					memory[memoryCounter++] = hex;
				} else {
					memory[memoryCounter++] = hex.substring(0, 1);
					memory[memoryCounter++] = hex.substring(1, 2);
				}
				break;
			case "BR":
				memory[memoryCounter++] = "7";
				hex = Integer.toHexString(Integer.parseInt(location));
				if (hex.length() == 1) {
					memory[memoryCounter++] = "0";
					memory[memoryCounter++] = hex;
				} else {
					memory[memoryCounter++] = hex.substring(0, 1);
					memory[memoryCounter++] = hex.substring(1, 2);
				}
				break;
			case "STP":
				memory[memoryCounter++] = "8";
				break;
			case "DATA":
				value = line[2];
				memory[Integer.parseInt(location)] = Integer.toHexString(Integer.parseInt(value));
				break;
			default:
				error = true;
				break;
			}
		}
		if (error == true) {
			System.out.println("Cannot compile due to error.");
		} else {
			for (int i = 0; i < memory.length; i++) {
				if (memory[i] == null) {
					memory[i] = "0";
				}
				System.out.print(memory[i].toUpperCase());
			}
		}

		System.out.print("\n");
	}
}
