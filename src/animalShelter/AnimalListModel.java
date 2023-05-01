package animalShelter;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AnimalListModel extends AbstractListModel {
    private JDBC db = new JDBC();
    private Connection connection;
    public static ArrayList<Animal> animalList = new ArrayList<Animal>();
    public AnimalListModel() throws SQLException {
        try {
            connection = db.getCon();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        String sql = "SELECT * FROM animal";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            Animal animal = new Animal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
            animalList.add(animal);
        }
    }
    @Override
    public int getSize() {
        //return values.length;
        return animalList.size();
    }
    public Object getElementAt(int index) {
        return animalList.get(index).getName();
    }
}
