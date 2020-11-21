public class PR {

    public static void main(String[] args) {
        //input data
        int[] data = {21,23,26,12,15};
        System.out.print("Data yang di input : ");
        //Perulangan untuk menampilkan data input
        for(int z = 0; z<data.length; z++) {
			System.out.print(" "+data[z]);
        }

        //sortir data
        int[] arr = sortir(data);//membuat array arr yang isinya data dari array data yang telah disortir
        System.out.print("\n");
        System.out.print("Data setelah di sortir : ");
        //perulangan untuk menampilkan isi dari array yang telah disortir
        for(int z = 0; z<arr.length; z++) {
			System.out.print(" "+arr[z]);
        }

        //search data
        System.out.print("\n");
        searching(arr,15);//memanggil method searching
    }

    public static int[] sortir(int[] arr){//inisialisasi method untuk fungsi sortir     
        for (int i = 0; i < arr.length - 1; i++) {//perulangan dengan batas panjang array
            for (int j = 0; j < arr.length - 1 - i; j++) {//perulangan dengan batas panjang array-1-i
                if (arr[j + 1] < arr[j]) { //jika index array setelahnya lebih kecil dari index array saat ini, maka
                    int temp = arr[j]; 
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = temp; 
                } 
            } 
        }
        return arr;
    }

    public static int[] searching(int[] a, int target){//inisialisasi method untuk fungsi search 
        int left = 0;//deklarasi variabel left dengan tipe data integer yang memiliki value 0
        int middle; //deklarasi variabel middle
        int right = a.length - 1; //deklarasi variabel right(integer) dengan value=(panjang array a - 1)
        while (left <= right) { //bila left kurang dari sama dengan right, maka
            middle = (left + right) / 2; //nilai dari middle adalah (left + right) / 2
            if (a[middle] == target) { //jika nilai array a[middle] sama dengan target, maka
                System.out.println("Data ditemukan : "+ target + " found at index " + middle);//tampilkan data target yang ditemukan
                break;
            } else if (a[middle] < target) { //jika nilai array a[middle] kurang dari target, maka
                left = middle + 1; // nilai dari left adalah (middle+1)
            } else if (a[middle] > target) { //jika nilai array a[middle] lebih dari target, maka
                right = middle - 1;// nilai dari left adalah (middle-1)
            }
        }
        return a;//return array a
    }
}
