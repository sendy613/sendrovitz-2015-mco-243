package sendrovitz.processes;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
	public static void main(String args[]) {

		// loop back ip address: 127.0.0.7
		// get your ip address
		// local host

		Socket socket = null;
		try {
			socket = new Socket("localhost", 3761);
			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			writer.println("hello");

			// actually sends the data
			writer.flush();
			// waits 10 seconds. in the server readline() will block but if
			// there is nothing to read it will break out of the loop. (it knows
			// there is nothing left to read when socket closes)
			Thread.sleep(10 * 1000);
			writer.println("Esti");
			writer.flush();
			Thread.sleep(10 * 1000);

			// if close here then if there is an IOExcep before this then it
			// wont close it.
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		// will always execute no matter is the try worked or it threw an
		// exception
		finally {
			// if dont close then resource leak
			
			  try { socket.close(); } catch (IOException e) {
			  e.printStackTrace(); }
			 
			//IOUtils.closeQuietly(socket);
		}
	}
}
