package sendrovitz.microprocessor;

import java.util.Scanner;

public class Microprocessor {

	public static void main(String args[]) {
		Microprocessor m = new Microprocessor();
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.next();
		Character accA = null;
		Character accB = null;

		Character[] memory = new Character[256];
		for (int i = 0; i < memory.length; i++) {
			memory[i] = input.charAt(i);
		}

		for (int i = 0; i < memory.length; i++) {
			Character c = memory[i];
			if (c.compareTo('8') == 0) {
				break;
			} else {
				switch (c) {

				case '0':
					Character add1 = memory[++i];
					Integer a = Integer.parseInt(add1.toString(), 16);
					Integer z = a * 16;
					Character add2 = memory[++i];
					Integer b = Integer.parseInt(add2.toString(), 16);
					accA = memory[z + b];
					break;
				case '1':
					add1 = memory[++i];
					a = Integer.parseInt(add1.toString(), 16);
					z = a * 16;
					add2 = memory[++i];
					b = Integer.parseInt(add2.toString(), 16);
					memory[z + b] = accA;
					break;
				case '2':
					Character temp = accA;
					accA = accB;
					accB = temp;
					break;
				case '3':
					Integer sum = Integer.parseInt(accA.toString(), 16) + Integer.parseInt(accB.toString(), 16);
					String hex = Integer.toHexString(sum).toUpperCase();
					Character first;
					Character second;
					if (hex.length() == 1) {
						first = '0';
						second = hex.charAt(0);
					} else {
						first = hex.charAt(0);
						second = hex.charAt(1);
					}

					accB = first;
					accA = second;
					break;
				case '4':
					Integer plusOne = Integer.parseInt(accA.toString(), 16) + 1;
					if (plusOne == 16) {
						plusOne = 0;
					}
					hex = Integer.toHexString(plusOne).toUpperCase();
					accA = hex.charAt(0);
					break;
				case '5':
					Integer minusOne = Integer.parseInt(accA.toString(), 16) - 1;
					if (minusOne == -1) {
						minusOne = 15;
					}
					hex = Integer.toHexString(minusOne).toUpperCase();
					accA = hex.charAt(0);
					break;
				case '6':

					if (Integer.parseInt(accA.toString(), 16) == 0) {
						add1 = memory[++i];
						a = Integer.parseInt(add1.toString(), 16);
						z = a * 16;
						add2 = memory[++i];
						b = Integer.parseInt(add2.toString(), 16);
						i = (z + b) - 1;
						break;
					} else {
						i += 2;
					}
					break;
				case '7':
					add1 = memory[++i];
					a = Integer.parseInt(add1.toString(), 16);
					z = a * 16;
					add2 = memory[++i];
					b = Integer.parseInt(add2.toString(), 16);
					i = (z + b) - 1;
					break;
				}
			}

		}
		for (int i = 0; i < memory.length; i++) {
			System.out.print(memory[i]);
		}

		System.out.print("\n");
	}
}
