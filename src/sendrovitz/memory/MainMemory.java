package sendrovitz.memory;

import java.util.Scanner;

public class MainMemory {
	private int totalBytes;
	private int numRows;
	private char[][] memory;

	public MainMemory(int totalBytes) {
		this.totalBytes = totalBytes;
		this.numRows = totalBytes / 128;
		this.memory = new char[numRows][128];
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				memory[i][j] = '-';
			}
		}
	}

	public boolean allocate(Integer processID, int numBytes) {
		if(numBytes>totalBytes){
			return false;
		}
		int numBytesLeft = numBytes;
		int tempArray[][] = new int[totalBytes][2];
		int tempI = 0;
		boolean allocated =false;

		outerloop:
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				if (memory[i][j] == '-') {
					tempArray[tempI][0] = i;
					tempArray[tempI++][1] =j;
					numBytesLeft--;
				}
				if (numBytesLeft == 0) {
					allocated = true;
					break outerloop;
				}
			}
		}
		if(allocated){
			for(int i =0; i<tempArray.length; i++){
				memory[tempArray[i][0]][tempArray[i][1]] = processID.toString().charAt(0);
			}
			return true;
		}
		else{
		return false;
		}
	}

	public void free(Integer processID) {
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				if (memory[i][j] == processID.toString().charAt(0)) {
					memory[i][j] = '-';
				}
			}
		}
	}

	public void print() {
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				System.out.print(memory[i][j]);
			}
			System.out.println("\n");
		}
	}

	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		int total = 0;
		do {
			System.out.println("enter the total number of bytes your system has (must be a multiple 128)");
			total = keyboard.nextInt();
		} while (total % 128 != 0);

		MainMemory main = new MainMemory(total);

		char choice = ' ';
		do {
			System.out.println("Enter 'a' to allocate memory, 'f' to free or 'p' to print. press 0 to exit");
			choice = keyboard.next().charAt(0);

			switch (choice) {

			case 'a':
			case 'A':

				int pid = -1;
				do {
					System.out.println("Enter the process ID (0-9) to allocate memory");
					pid = keyboard.nextInt();
				} while (pid < 0 || pid > 9);

				System.out.println("Enter the number of bytes to allocate to memory");
				int numBytes = keyboard.nextInt();

				if (main.allocate(pid, numBytes) == false) {
					System.out.println("unable to allocate memory");
				}
				break;
			case 'f':
			case 'F':
				do {
					System.out.println("Enter the process ID (0-9) that you'd like to free");
					pid = keyboard.nextInt();
				} while (pid < 0 || pid > 9);

				main.free(pid);

				break;

			case 'p':
			case 'P':
				main.print();
				break;

			case '0':
				System.out.println("Exitting");
				break;
			default:
				System.out.println("invalid choice");
			}
		} while (choice != '0');

	}

}
