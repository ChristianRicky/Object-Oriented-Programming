
public class Peminjam {
    private int id_buku;
    private String nama_staff = null;
    private String nama_peminjam = null;
    private String nama_buku = null;
    private String tanggal_pengembalian = null;

    public Peminjam(int id_buku, String nama_staff, String nama_peminjam, String nama_buku,
            String tanggal_pengembalian) {
        this.id_buku = id_buku;
        this.nama_staff = nama_staff;
        this.nama_peminjam = nama_peminjam;
        this.nama_buku = nama_buku;
        this.tanggal_pengembalian = tanggal_pengembalian;

    }

    public int getId_buku() {
        return id_buku;
    }

    public String getNama_staff() {
        return nama_staff;
    }

    public String getNama_peminjam() {
        return nama_peminjam;
    }

    public String getNama_buku() {
        return nama_buku;
    }

    public String getTanggal_pengembalian() {
        return tanggal_pengembalian;
    }
}
