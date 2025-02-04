import java.sql.*;
import java.util.Scanner;

public class BarangUAS {
    private static Connection conn = koneksi.getConnection();
    private static Scanner scanner = new Scanner(System.in);

    public static void tambahBarang() {
        System.out.print("Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Kategori: ");
        String kategori = scanner.nextLine();
        System.out.print("Jumlah: ");
        int jumlah = scanner.nextInt();
        System.out.print("Harga: ");
        double harga = scanner.nextDouble();
        scanner.nextLine(); 

        String query = "INSERT INTO barang (nama_barang, kategori, jumlah, harga) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nama);
            stmt.setString(2, kategori);
            stmt.setInt(3, jumlah);
            stmt.setDouble(4, harga);
            stmt.executeUpdate();
            System.out.println("Barang berhasil ditambahkan.");
        } catch (SQLException e) {
            System.out.println("Gagal menambah barang: " + e.getMessage());
        }
    }

    public static void tampilkanBarang() {
        String query = "SELECT * FROM barang";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("Daftar Barang:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " +
                                   rs.getString("nama_barang") + " - " +
                                   rs.getString("kategori") + " - " +
                                   rs.getInt("jumlah") + " - Rp" +
                                   rs.getDouble("harga"));
            }
        } catch (SQLException e) {
            System.out.println("Gagal menampilkan barang: " + e.getMessage());
        }
    }

    public static void updateBarang() {
        System.out.print("Masukkan ID barang yang ingin diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Nama Baru: ");
        String nama = scanner.nextLine();
        System.out.print("Kategori Baru: ");
        String kategori = scanner.nextLine();
        System.out.print("Jumlah Baru: ");
        int jumlah = scanner.nextInt();
        System.out.print("Harga Baru: ");
        double harga = scanner.nextDouble();
        scanner.nextLine(); 

        String query = "UPDATE barang SET nama_barang=?, kategori=?, jumlah=?, harga=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nama);
            stmt.setString(2, kategori);
            stmt.setInt(3, jumlah);
            stmt.setDouble(4, harga);
            stmt.setInt(5, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Barang berhasil diperbarui.");
            } else {
                System.out.println("Barang tidak ditemukan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal memperbarui barang: " + e.getMessage());
        }
    }

    public static void hapusBarang() {
        System.out.print("Masukkan ID barang yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        String query = "DELETE FROM barang WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Barang berhasil dihapus.");
            } else {
                System.out.println("Barang tidak ditemukan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menghapus barang: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Menu Inventaris Barang ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Tampilkan Barang");
            System.out.println("3. Update Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1: tambahBarang(); break;
                case 2: tampilkanBarang(); break;
                case 3: updateBarang(); break;
                case 4: hapusBarang(); break;
                case 5: System.out.println("Terima kasih!"); return;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
