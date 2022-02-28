package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;


public class addRoomController {
    @FXML
    private TextField typeField;
    @FXML
    private TextField noField;
    @FXML
    private Button confirmButton;
    @FXML
    private Button backButton;
    @FXML
    private Label confirmLabel;

    public void addNewRoom(String roomType, String roomNo) {
        Connection conn = null;
        String Type = "", RoomNo = "", descrip = "", Status = "";
        int guest = 0, bed = 0;
        double pricePerN = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/room?useSSL=false", "root", "11162002abc");
            String query = "SELECT distinct * FROM room2 WHERE Type= " + "'" + roomType + "' limit 1;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Type = rs.getString("Type");
                RoomNo = rs.getString("RoomNo");
                descrip = rs.getString("Description");
                guest = rs.getInt("Guest");
                bed = rs.getInt("Bed");
                pricePerN = rs.getDouble("PricePerNight");
                Status = rs.getString("Status");
            }
            try {
                if(Type.equals("")){
                    try {
                        String sql = "not valid";
                        st.executeUpdate(sql);
                    }catch(Exception e){
                        confirmLabel.setText("Please Try Again");
                    }
                }else {
                    String sql = " INSERT INTO room2 " +
                            " VALUES " + "(" + "'" + Type + "'" + ", " + "'" + roomNo + "'" + "," + "'" + descrip + "'" + ", " + guest + ", " + bed + ", " + pricePerN + ", 'Available')";
                    st.executeUpdate(sql);
                    confirmLabel.setText("Room No: "+roomNo+" Successfully created!! ");
                }


            } catch (SQLIntegrityConstraintViolationException e) {
                confirmLabel.setText("Room No: " + roomNo + " already exists");
            }

            } catch (SQLException se) {
                se.printStackTrace();
                confirmLabel.setText("Please Try Again");
            } catch (Exception e) {
                e.printStackTrace();
                confirmLabel.setText("Please Try Again");
            }

    }
    public void confirmAddRoom() throws IOException {
        addNewRoom(typeField.getText(),noField.getText());
    }

    public void back() throws IOException {
        Stage stage =(Stage) backButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
        primaryStage.setTitle("Admin Management Page");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();}
    }



