package sendrovitz.threads;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Thread1 extends Thread {
	private String url;
	private String filename;

	public Thread1(String url, String filename) {
		this.url = url;
		this.filename = filename;
	}

	@Override
	public void run() {
		try {
			URL url2 = new URL(url);
			InputStream is = url2.openStream();
			OutputStream os = new FileOutputStream(new File(filename));
			byte[] b = new byte[2048];
			int length;

			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
