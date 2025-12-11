import java.util.Scanner;
// Nama  : Isya Putra Ragil
// NIM   : 254107060116
// Kelas : SIB-1B
// Absen : 13

public class CM2Beasiswa13 {
    // Deklarasi Scanner dan array data
    static Scanner sc = new Scanner(System.in);
    static String[][] data = new String[100][5];
    // Variabel untuk menghitung jumlah pendaftar
    static int jumlahPendaftar = 0;

    // Pilihan menu
    public static void menu() {
        System.out.println("=== Sistem Pendaftaran Beasiswa ===");
        System.out.println("1. Tambah Data Pendaftar Beasiswa");
        System.out.println("2. Tampilkan Semua Pendaftar");
        System.out.println("3. Cari Pendaftar berdasarkan Jenis Beasiswa");
        System.out.println("4. Hitung Rata-rata IPK per Jenis Beasiswa");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu (1-5): ");
    }

    // Tambah data pendaftar
    public static void tambahData() {
        if (jumlahPendaftar >= 100) {
            System.out.println("Data pendaftar sudah penuh.");
            return;
        }
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();
        System.out.print("Masukkan IPK Terakhir (0.0 - 4.0): ");
        String ipkStr = sc.nextLine();
        System.out.print("Masukkan Jenis Beasiswa (Reguler/Unggulan/Riset): ");
        String jenis = sc.nextLine();
        System.out.print("Masukkan Penghasilan Orang Tua (<= 2000000): ");
        String penghasilanStr = sc.nextLine();
        // Simpan data ke array
        data[jumlahPendaftar][0] = nama;
        data[jumlahPendaftar][1] = nim;
        data[jumlahPendaftar][2] = ipkStr;
        data[jumlahPendaftar][3] = jenis;
        data[jumlahPendaftar][4] = penghasilanStr;
        jumlahPendaftar++;
        System.out.println("Data pendaftar berhasil ditambahkan. Total pendaftar" + jumlahPendaftar);
    }
    // Tampilkan semua data pendaftar
    public static void tampilkanData() {
        System.out.println("=== Daftar Pendaftar Beasiswa ===");
        System.out.printf("%-20s %-15s %-6s %-10s %-15s%n", "Nama", "NIM", "IPK", "Jenis", "Penghasilan Ortu");
        // Loop untuk menampilkan semua data pendaftar
        for (int i = 0; i < jumlahPendaftar; i++) {
            System.out.printf("%-20s %-15s %-6.2f %-10s %-15.2f%n", data[i][0], data[i][1], Double.parseDouble(data[i][2]), data[i][3], Double.parseDouble(data[i][4]));
        }
    }

    // Cari data pendaftar berdasarkan jenis beasiswa
    public static void cariData() {
        System.out.print("Masukkan Jenis Beasiswa yang dicari (Reguler/Unggulan/Riset): ");
        String jenisCari = sc.nextLine();
        System.out.println("=== Hasil Pencarian Pendaftar Beasiswa ===");
        System.out.printf("%-20s %-15s %-6s %-10s %-15s%n", "Nama", "NIM", "IPK", "Jenis", "Penghasilan Ortu");
        // Loop untuk mencari dan menampilkan data sesuai jenis beasiswa
        for (int i = 0; i < jumlahPendaftar; i++) {
            if (data[i][3].equalsIgnoreCase(jenisCari)) {
                System.out.printf("%-20s %-15s %-6.2f %-10s %-15.2f%n", data[i][0], data[i][1], Double.parseDouble(data[i][2]), data[i][3], Double.parseDouble(data[i][4]));
            }
        }
    }   

    // Hitung rata-rata IPK per jenis beasiswa
    public static void hitungRataRataIPK() {
        System.out.println("=== Rata-rata IPK per Jenis Beasiswa ===");
        String[] jenisBeasiswa = {"Reguler", "Unggulan", "Riset"};
        // Loop untuk menghitung dan menampilkan rata-rata IPK per jenis beasiswa
        for (String jenis : jenisBeasiswa) {
            double totalIPK = 0;
            int count = 0;
            // Loop untuk menjumlahkan IPK dan menghitung jumlah pendaftar per jenis beasiswa
            for (int i = 0; i < jumlahPendaftar; i++) {
                if (data[i][3].equalsIgnoreCase(jenis)) {
                    totalIPK += Double.parseDouble(data[i][2]);
                    count++;
                }
            }
            // Hitung rata-rata IPK
            double rataRata = (count > 0) ? totalIPK / count : 0;
            // Tampilkan hasil rata-rata IPK
            System.out.printf("%s: %.2f%n", jenis, rataRata);
        }
    }
    // Main method
    public static void main(String[] args) {
        int pilihan;
        do {
            menu();
            pilihan = Integer.parseInt(sc.nextLine());
            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilkanData();
                    break;
                case 3:
                    cariData();
                    break;
                case 4:
                    hitungRataRataIPK();
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);
    }
}