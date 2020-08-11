package tarena.day23_socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFile {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://192.168.0.23:8080/NetStore.zip");
		URLConnection urlConn = url.openConnection();
		InputStream is = urlConn.getInputStream();
		FileOutputStream fis = new FileOutputStream("down.zip");
		/*
		 * byte[] buf = new byte[1024]; int len = 0;
		 * while((len=is.read(buf))!=-1){ fis.write(buf, 0, len); } is.close();
		 * fis.close();
		 */
		BufferedInputStream bis = new BufferedInputStream(is);
		BufferedOutputStream bos = new BufferedOutputStream(fis);
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = bis.read(buf)) != -1) {
			bos.write(buf, 0, len);
		}
		bis.close();
		bos.close();
	}
}
