package tarena.day23_socket;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import tarena.day22_io.Student;

public class TestObjectRecive {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(10222);
        while (true) {
            try {
                Socket s = ss.accept();
                Thread t = new ReciveObjectThread(s);
                t.start();
            } catch (Exception e) {
                ss.close();
            }
        }
    }
}

class ReciveObjectThread extends Thread {
    private Socket s;

    public ReciveObjectThread(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            InputStream is = s.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            Object o = ois.readObject();
            Student s = (Student) o;
            s.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}