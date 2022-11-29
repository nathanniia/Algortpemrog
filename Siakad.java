import java.util.Scanner;
public class siakad {

    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];
    static int jumlahData = 0;

    public static void tambahData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Silahkan Tambah Data");
        System.out.print("NIM = ");
        String nim = scan.nextLine();
        System.out.print("Nama = ");
        String nama = scan.nextLine();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNim(nim);
        mahasiswa[jumlahData].setNama(nama);
        jumlahData++;
    }

    public static void lihatData() {
        System.out.println("Berikut Data Anda");
        int i = 0;
        while (i<jumlahData) {
            System.out.println(mahasiswa[i].getNim()+ " "+mahasiswa[i].getNama());
            i++;
        }
    }

    public static void urutkanData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih algoritma pengurutan");
        System.out.println("1. EXCHANGE SORT");
        System.out.print("Pilih algoritma = ");
        int algo = scanner.nextInt();
        switch (algo) {
            case 1: {
                exchangeSort();
                break;
            }
        }
    }

    public static void exchangeSort() {
        for (int x = 0; x<jumlahData; x++) {
            for (int y = x+1; y<jumlahData; y++) {
                if (mahasiswa[x].getNim().compareTo(mahasiswa[y].getNim())>=1) {
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;
        do {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah data");
            System.out.println("2. Lihat data");
            System.out.println("3. Urutkan data");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu = ");
            menu = scan.nextInt();
            if (menu == 1) {
                tambahData();
            } else if (menu == 2) {
                lihatData();
            } else if (menu == 3){
                urutkanData();
            }
        } while (menu != 4);
    }
}