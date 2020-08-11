package java6.newfeatures._1_new_utils._5_database;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class _1_Jdbc {
    public static void main(String[] args) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();

        while (drivers.hasMoreElements()) {
            System.out.println(drivers.nextElement());
        }

    }
}
