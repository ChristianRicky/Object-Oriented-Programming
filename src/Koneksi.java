import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Koneksi extends Application {

    @Override
    public void start(Stage stage) {
        TableView<Peminjam> tableView = new TableView<Peminjam>();

        TableColumn<Peminjam, String> columnid_buku = new TableColumn<>("Id buku");
        columnid_buku.setCellValueFactory(new PropertyValueFactory<>("Id_buku"));

        TableColumn<Peminjam, String> columnnama_staff = new TableColumn<>("Nama Staff");
        columnnama_staff.setCellValueFactory(new PropertyValueFactory<>("Nama_staff"));

        TableColumn<Peminjam, String> columnnama_peminjam = new TableColumn<>("Nama Peminjam");
        columnnama_peminjam.setCellValueFactory(new PropertyValueFactory<>("Nama_peminjam"));

        TableColumn<Peminjam, String> columnnama_buku = new TableColumn<>("Nama buku");
        columnnama_buku.setCellValueFactory(new PropertyValueFactory<>("Nama_buku"));

        TableColumn<Peminjam, String> columntanggal_pengembalian = new TableColumn<>("Tanggal pengembalian");
        columntanggal_pengembalian.setCellValueFactory(new PropertyValueFactory<>("Tanggal_pengembalian"));

        tableView.getColumns().add(columnid_buku);
        tableView.getColumns().add(columnnama_staff);
        tableView.getColumns().add(columnnama_peminjam);
        tableView.getColumns().add(columnnama_buku);
        tableView.getColumns().add(columntanggal_pengembalian);

        tableView.getItems().add(new Peminjam(1000051, "John", "Ryan", "Java News", "5-7-2022"));
        tableView.getItems().add(new Peminjam(1000043, "John", "Yanto", "How to Success", "9-8-2022"));
        tableView.getItems().add(new Peminjam(1000055, "jennifer", "Rendy", "How to Basic", "17-5-2022"));
        tableView.getItems().add(new Peminjam(1000032, "Jenniefer", "Pramana", "Why learn English", "22-1-2022"));
        tableView.getItems().add(new Peminjam(1000021, "john", "Dinda", "Marketing Strategy", "28-3-2022"));

        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mysql";
        String user = "root";
        String pass = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            ResultSet record = stmt.executeQuery("select*from perpustakaan");

            while (record.next()) {
                System.out.println(record.getInt("1"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("koneksi berhenti");
        }
    }

}