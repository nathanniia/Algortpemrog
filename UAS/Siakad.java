import java.util.Scanner;


public class Siakad{

    static Mahasiswa[]  mahasiswa = new Mahasiswa[1000];
    static int jumlahData = 0;

    public static void tambahData(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Silahkan Tambah Data");
        System.out.print("NIM : ");
        String nim = scan.nextLine();
        System.out.print("Nama : ");
        String nama = scan.nextLine();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNama(nama);
        mahasiswa[jumlahData].setNim(nim);
        jumlahData++;
        menu();
    }

    public static void lihatData(){
        System.out.println("Berikut Data Anda : ");
        int i = 0;
        while (i<jumlahData){
            int nomer = i+1;
            System.out.println(nomer+". " + mahasiswa[i].getNama() + "  " + mahasiswa[i].getNim());
            i++;
        }
        menu();
    }

    public static void urutData(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Pilih Algoritma Pengurutan");
        System.out.println("1. Exchange Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Quick Sort");
        System.out.println("4. Bubble Sort");
        System.out.println("5. Shell Sort");
        System.out.print("Pilih Algoritma = ");
        int algo = scan.nextInt();
        switch(algo){
            case 1:
                exchangeSort();
                break;
            case 2:
                selectionSort();
                break;
            case 3:
                quickSort(mahasiswa,0,jumlahData-1);
                menu();
                break;
            case 4:
                bubbleSort();
                break;
            case 5:
                shellSort();
                break;
        }

    }

    public static void exchangeSort(){
        for(int x = 0; x<jumlahData; x++){
            for(int y = (x+1); y<jumlahData; y++){
                if(mahasiswa[x].getNim().compareTo(mahasiswa[y].getNim()) >= 1){
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
        menu();
    }

    public static void selectionSort(){
        for(int i = 0;i<jumlahData-1;i++){
            int indek = i;
            for(int j = i+1;j<jumlahData;j++){
                if(mahasiswa[indek].getNim().compareTo(mahasiswa[j].getNim()) >= 1){
                    indek = j;
                }
            }
            if(indek != i){
                Mahasiswa temp = mahasiswa[i];
                mahasiswa[i] = mahasiswa[indek];
                mahasiswa[indek] = temp;
            
            }
        }
        menu();
    }

    public static void bubbleSort(){
        for(int i = 0; i<jumlahData;i++){
            for(int j=1;j<jumlahData-i;j++){
                if(mahasiswa[j - 1].getNim().compareTo(mahasiswa[j].getNim()) >= 1){
                    Mahasiswa temp = mahasiswa[j - 1];
                    mahasiswa[j - 1] = mahasiswa[j];
                    mahasiswa[j] = temp;
                } 
            }
        }
        menu();
    }

    public static void quickSort(Mahasiswa[] arr, int low, int high) {
        if(low < high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        } 
    }

    public static int partition(Mahasiswa[] arr, int low, int high) {
        int p = low, j;
        for(j=low+1; j <= high; j++)
            if(arr[j].getNim().compareTo(arr[low].getNim())<=-1)
                swap(arr, ++p, j);
        swap(arr, low, p);
        return p;
    }

    public static void swap(Mahasiswa[] arr, int low, int pivot){
        Mahasiswa tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    public static void shellSort(){
        for(int interval = jumlahData / 2; interval > 0; interval /= 2){
            for(int i = interval; i < jumlahData; i++){
                Mahasiswa temp = mahasiswa[i];
                int j;
                for(j = i; j >= interval && mahasiswa[j-interval].getNim().compareTo(temp.getNim()) >= 1; j -= interval){
                    mahasiswa[j] = mahasiswa[j - interval];
                }
                mahasiswa[j] = temp;
            }
        }
    }

    public static void caridata(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Pilih Metode Pencarian");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Pilih Metode = ");
        int cari = scan.nextInt();
        switch(cari){
            case 1:
                linearSearch();
                break;
            case 2:
                System.out.print("Masukan Nim = ");
                String filterValue=scan.next();
                Integer indexFound=binarySearch(mahasiswa,filterValue,0,jumlahData-1);
                if(indexFound!=null){
                    System.out.println("Data yang anda cari :");
                    System.out.println(mahasiswa[indexFound].getNama() + " " + mahasiswa[indexFound].getNim());
                }
                else{
                    System.out.println("Data tidak ditemukan");
                }

                menu();
                break;
        }
    }

    public static void linearSearch(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan Nama/NIM = ");
        String xdata = scan.nextLine();
        for (int i = 0; i < jumlahData; i++) {
            String temp = mahasiswa[i].getNama();
            String temp2 = mahasiswa[i].getNim();
            if (xdata.equals(temp)){
                System.out.println("Data Yang Dicari Ditemukan!!");
                System.out.println(mahasiswa[i].getNama() + "  " + mahasiswa[i].getNim());
                System.out.println(" ");
            }
            else if (xdata.equals(temp2)){
                System.out.println("Data Yang Dicari Ditemukan!!");
                System.out.println(mahasiswa[i].getNama() + "  " + mahasiswa[i].getNim());
                System.out.println(" ");
            }
        }
        menu();
    }

    public static Integer binarySearch(Mahasiswa []arr,String filterValue, int low, int high){

        quickSort(mahasiswa,0,jumlahData-1);
        if (low>high){
            return null;
        }

        else {
            int mid=(low+high)/2;
            int temp2 = Integer.parseInt(arr[mid].getNim());
            if(Integer.valueOf(filterValue)==temp2){

                return mid;
            }
            else if(Integer.valueOf(filterValue)>temp2){
                return binarySearch(mahasiswa,filterValue,mid+1,high);

            }
            else{
                return binarySearch(mahasiswa,filterValue,low,mid-1);
            }
        }
    }

    public static void editData(){
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while (i<jumlahData){
            System.out.print(i+1+ ". ");
            System.out.println(mahasiswa[i].getNama() + " " + mahasiswa[i].getNim());
            i++;
        }
        System.out.print("Masukan Nomer Yang Akan Diubah = ");
        int xdata = scan.nextInt() - 1;
        System.out.print("Masukan Nama Baru = ");
        String nama = scan.next();
        System.out.print("Masukan NIM Baru = ");
        String nim = scan.next();

        mahasiswa[xdata].setNama(nama);
        mahasiswa[xdata].setNim(nim);

        menu();
    }

    public static void hapusData(){

        Scanner scan = new Scanner(System.in);
        int i = 0;
        int j;
        while (i<jumlahData){
            System.out.print(i +1 + ". ");
            System.out.println(mahasiswa[i].getNama() + " " + mahasiswa[i].getNim());
            i++;
        }
        System.out.print("Masukan Nomer Yang Akan Dihapus = ");
        int xdata = scan.nextInt() - 1;

        System.out.println("Nama : "+mahasiswa[xdata].getNama());
        System.out.println("Nim : "+mahasiswa[xdata].getNim());
        System.out.println("Hapus Data ini? y/n");
        String pil= scan.next();
        if(pil.equalsIgnoreCase("y")){
            mahasiswa[xdata]=null;
            for(i=0;i<jumlahData-1;i++){
                Mahasiswa temp;
                if(mahasiswa[i]==null){
                    temp=mahasiswa[i+1];
                    mahasiswa[i]=mahasiswa[i+1];
                    mahasiswa[i+1]=null;

                }
            }
            jumlahData=jumlahData-1;

            System.out.println("Data Terhapus!");
        }
        else{

        }
        menu();
    }

    public static void UAS(){
        if(jumlahData == 0){
            System.out.println("Tidak ada data");
            menu();
        }else{ //O(1)
            int jarak = jumlahData;
            int susut = 13;
            int urut = 0;
            while(urut == 0){
                jarak = (jarak*10)/susut;
                if(jarak <= 1){
                    jarak = 1;
                    urut = 1;
                    for(int i=0;i+jarak<jumlahData;i++){
                        if(mahasiswa[i].getNim().compareTo(mahasiswa[i + jarak].getNim()) >= 1){
                            Mahasiswa temp = mahasiswa[i];
                            mahasiswa[i] = mahasiswa[i + jarak];
                            mahasiswa[i + jarak] = temp;
                            urut = 0;
                        }
                    }
                }
            }
            System.out.println("Data telah diurutkan silahkan tampilkan data");
            menu();
        }
    }

    public static void menu(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Menu Siakad\n" + "1. Tambah Data\n" + "2. Lihat Data\n" + "3. Urutkan Data\n" + "4. Cari Data\n" + "5. Edit Data\n" + "6. Hapus Data\n" + "7. UAS\n" + "8. Exit" );
            System.out.print("Pilih Menu = ");
            int s = scan.nextInt();
            switch(s){
                case 1:
                    tambahData();
                    break;
                case 2:
                    lihatData();
                    break;
                case 3:
                    urutData();
                    break;
                case 4:
                    caridata();
                    break;
                case 5:
                    editData();
                    break;
                case 6:
                    hapusData();
                    break;
                case 7:
                    UAS();
                    break;
                case 8:
                    System.exit(0);
                default:
                    menu();
                    break;
            }
        }
    }
    public static void main(String[] args){
        menu();
    }
}