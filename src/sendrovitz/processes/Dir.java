package sendrovitz.processes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dir {
	public static void main(String args[]) {
		try {
			String line;
			// child process that runs dir and gives back the results

			// print current working directory
			// Process p = Runtime.getRuntime().exec("cmd /c echo %cd%");

			// changes the class path to be the bin folder
			
			Process serverProcess = Runtime.getRuntime().exec("java -cp ./bin sendrovitz.processes.Server");
			Process clientProcess= Runtime.getRuntime().exec("java -cp ./bin sendrovitz.processes.Client");
			BufferedReader input = new BufferedReader(new InputStreamReader(serverProcess.getInputStream()));
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
