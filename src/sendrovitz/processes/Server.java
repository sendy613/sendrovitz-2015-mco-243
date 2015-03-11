package sendrovitz.processes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	// cannot run two servers at once - bind error bec both using the same port
	public static void main(String args[]) {
		ServerSocket serverSocket;
		try {

			serverSocket = new ServerSocket(3761);

			// this will keep on checking for new clients. each loop will go
			// until the socket gets closed by the client
			// need a thread for everything in the while() except for the
			// socket.accept()
			// makes a new thread every time it accepts another client
			while (true) {
				// waits for a response
				Socket socket = serverSocket.accept();
				// InputStream reads in bytes
				InputStream in = socket.getInputStream();
				// wrap input stream in reader so can read String instead of
				// bytes
				// (can also wrap it in Scanner)
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				// read in a whole text. not just one line
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}