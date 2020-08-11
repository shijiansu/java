package java7.newfeatures._3_try_with_resources;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class _1_TryWithResources {
  public String read(String filename) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      StringBuilder builder = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        builder.append(line);
        builder.append(String.format("%n"));
      }
      return builder.toString();
    }
  }

  public void copyFile(String fromPath, String toPath) throws IOException {
    try (InputStream input = new FileInputStream(fromPath);
        OutputStream output = new FileOutputStream(toPath)) {
      byte[] buffer = new byte[8192];
      int len = -1;
      while ((len = input.read(buffer)) != -1) {
        output.write(buffer, 0, len);
      }
    }
  }
}
