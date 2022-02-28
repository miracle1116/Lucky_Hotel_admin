package com.example.javafx;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.*;
import java.io.File;
import java.util.ResourceBundle;
import java.net.URL;

public class LoginController implements Initializable{
    @FXML
    private Button cancel;
    @FXML
    private Button registerButton;
    @FXML
    private Button LoginButton;
    @FXML
    private Label LoginLabel1;
    @FXML
    private ImageView imageHotel;
    @FXML
    private ImageView lockImage;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button adminLogin;



    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile= new File("Downloads/Hotel.jpg");
        Image brandingImage= new Image(brandingFile.toURI().toString());
        imageHotel.setImage(brandingImage);

        File lockFile= new File("Downloads/images.png");
        Image lockImage1= new Image(lockFile.toURI().toString());
        lockImage.setImage(lockImage1);
    }

    public void cancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    public static boolean checkValidEmailPassword(String email, String password){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false","root","11162002abc");

            String query = "SELECT * FROM register_table WHERE email=? AND password=?";

            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, email);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();
            return rs.next();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            return false;
        }
    }
    public boolean checkidUser(String email, String password){
        boolean check=false;
        try
        {
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/user?useSSL=false";//"user" can change
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "11162002abc");//password can change
            String query = "SELECT* FROM register_table WHERE email = "+"'"+ email +"'";//re3gister table is the name of table in dataset
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

    public void LoginButtonAction(ActionEvent event){
        if(checkidUser(emailTextField.getText(),passwordTextField.getText())==true){
            LoginLabel1.setText("Login successful");
        }else
            LoginLabel1.setText("Please try Again");

    }

    public void userAdd() throws IOException {//function to next page
        Stage stage =(Stage) registerButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("registerPage.fxml"));
        primaryStage.setTitle("User Register");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }

    //public void LoginButtonAction(ActionEvent event){

    //}
    public void AdminLog() throws IOException {//function to next page
        Stage stage =(Stage) adminLogin.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("adminLoginPage.fxml"));
        primaryStage.setTitle("Admin Login Phrase");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }

    }



