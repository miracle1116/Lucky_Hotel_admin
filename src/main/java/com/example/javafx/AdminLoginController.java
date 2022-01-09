package com.example.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminLoginController {
    @FXML
    private TextField adminID;
    @FXML
    private TextField passwordField;
    @FXML
    private Button backButton;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginLabel;

    public boolean checkidAdmin(String adminID, String password){
        boolean check=false;
        try
        {
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/admin?useSSL=false";//"user" can change
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "11162002abc");//password can change
            String query = "SELECT* FROM admin_table WHERE adminID = "+"'"+ adminID +"'";//re3gister table is the name of table in dataset
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);


            while(rs.next()){
                String pass = rs.getString("Password");
                if(pass.equals(password)){
                    check=true;
                }
            }

            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());

        }
        return check;
    }

    public void adminLogin() throws IOException {//function to next page
        if(checkidAdmin(adminID.getText(),passwordField.getText())==true){
        Stage stage =(Stage) loginButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
        primaryStage.setTitle("Admin Management Page");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();}
        else
            loginLabel.setText("Please try Again");

}
    public void back() throws IOException {//function to next page
        Stage stage =(Stage) backButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));//Maybe not login Page
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }

}
