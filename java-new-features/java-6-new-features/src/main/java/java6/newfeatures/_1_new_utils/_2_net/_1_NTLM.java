package java6.newfeatures._1_new_utils._2_net;

import java.io.InputStream;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;

public class _1_NTLM {
  static class DefaultAuthenticator extends Authenticator {
    public PasswordAuthentication getPasswordAuthentication () {
      return new PasswordAuthentication ("USER", "PASSWORD".toCharArray());
    }
  }

  public static void main(String[] args) throws Exception {
        // Authentication 提供了关于认证发起者的足够多的信息，让继承类根据这些信息进行判断，在 getPasswordAuthentication 方法中给出了不同的认证信息
        Authenticator.setDefault (new DefaultAuthenticator());

        URL url = new URL("http://PROTECTED.com");
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();
        byte[] data = new byte[1024];
        while(in.read(data)>0)
        {
            //do something for data
        }
        in.close();
    }
}
