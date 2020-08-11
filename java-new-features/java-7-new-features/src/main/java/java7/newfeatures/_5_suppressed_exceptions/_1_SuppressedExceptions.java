package java7.newfeatures._5_suppressed_exceptions;

import java.io.FileInputStream;
import java.io.IOException;

public class _1_SuppressedExceptions {
  public void beforeJava7(String filename) {
    FileInputStream input = null;
    IOException readException = null;
    try {
      input = new FileInputStream(filename);
    } catch (IOException ex) {
      readException = ex; // 保存原始异常
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (IOException ex) {
          if (readException == null) {
            readException = ex;
          }
        }
      }
      if (readException != null) {
        throw new RuntimeException(readException);
      }
    }
  }

  public void atJava7(String filename) throws IOException {
    FileInputStream input = null;
    IOException readException = null;
    try {
      input = new FileInputStream(filename);
    } catch (IOException ex) {
      readException = ex;
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (IOException ex) {
          if (readException != null) { // 此处的区别, 记录被抑制的异常
            readException.addSuppressed(ex);
          } else {
            readException = ex;
          }
        }
      }
      if (readException != null) {
        throw readException;
      }
    }
  }
}
