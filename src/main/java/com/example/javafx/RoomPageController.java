package com.example.javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class RoomPageController implements Initializable {
        @FXML
        private TableView <TableModel> RoomTable;
        @FXML
        private TableColumn<TableModel,String> RoomCol;
        @FXML
        private TableColumn<TableModel,String> NoCol;
        @FXML
        private TableColumn<TableModel,String> GuestCol;
        @FXML
        private TableColumn<TableModel,String> PriceCol;
        @FXML
        private TableColumn<TableModel,String> BedCol;
        @FXML
        private TableColumn<TableModel,String> DesCol;
        @FXML
        private TableColumn<TableModel,String> StatusCol;
        @FXML
                private TextField search;
        @FXML
                private Button yesbutton;
        @FXML
                private Button Back;


        ObservableList<TableModel> listview = FXCollections.observableArrayList();

        public void initialize(URL url, ResourceBundle rb){
                RoomCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
                NoCol.setCellValueFactory(new PropertyValueFactory<>("no"));
                DesCol.setCellValueFactory(new PropertyValueFactory<>("des"));
                GuestCol.setCellValueFactory(new PropertyValueFactory<>("Guest"));
                BedCol.setCellValueFactory(new PropertyValueFactory<>("Bed"));
                PriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
                StatusCol.setCellValueFactory(new PropertyValueFactory<>("Status"));

                try
                {
                        String myDriver = "org.gjt.mm.mysql.Driver";
                        String myUrl = "jdbc:mysql://localhost/user?useSSL=false";//"user" can change
                        Class.forName(myDriver);
                        Connection conn = DriverManager.getConnection(myUrl, "root", "11162002abc");//password can change
                        String query = "SELECT* FROM room.room2";
                        Statement st = conn.createStatement();
                        ResultSet rs = st.executeQuery(query);

                        while (rs.next()) {
                                listview.add(new TableModel(rs.getString("Type"),
                                        rs.getString("RoomNo"),
                                        rs.getString("Description"),
                                        rs.getString("Guest"),
                                        rs.getString("Bed"),
                                        rs.getString("PricePerNight"),
                                        rs.getString("Status")
                                        ));
                        }
                        RoomTable.setItems(listview);

                }
                catch (Exception e)
                {
                        System.err.println("Got an exception! ");
                        System.err.println(e.getMessage());

                }

        }
        public void back() throws IOException {
                Stage stage =(Stage) Back.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
                primaryStage.setScene(new Scene(root,600,400));
                primaryStage.show();
        }

        public void yes(ActionEvent event) throws IOException {
                RoomTable.getItems().clear();
                RoomCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
                NoCol.setCellValueFactory(new PropertyValueFactory<>("no"));
                DesCol.setCellValueFactory(new PropertyValueFactory<>("des"));
                GuestCol.setCellValueFactory(new PropertyValueFactory<>("Guest"));
                BedCol.setCellValueFactory(new PropertyValueFactory<>("Bed"));
                PriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
                StatusCol.setCellValueFactory(new PropertyValueFactory<>("Status"));

                try
        {
                String myDriver = "org.gjt.mm.mysql.Driver";
                String myUrl = "jdbc:mysql://localhost/user?useSSL=false";//"user" can change
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "11162002abc");//password can change
                String room = search.getText();
                String query = "SELECT* FROM room.room2 WHERE type=?";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, room);
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                        listview.add(new TableModel(rs.getString("Type"),
                                rs.getString("RoomNo"),
                                rs.getString("Description"),
                                rs.getString("Guest"),
                                rs.getString("Bed"),
                                rs.getString("PricePerNight"),
                                rs.getString("Status")
                        ));
                }
                RoomTable.setItems(listview);

        }
                catch (Exception e)
        {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());

        }

}



}
