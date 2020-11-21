public class TugasArray {
    public static void main(String[] args) { 
       String Case = args[0];
        switch(Case){
        case "1" : 
           int persegi = volumeBangun(Integer.parseInt(args[1]));
           System.out.println("Kubus = " + persegi);
        break;
        case "2" : 
           double lingkaran = volumeBangun(Float.parseFloat(args[1]));
           System.out.println("Bola = " + lingkaran);
        break;
        case "3" : 
        int dua = Arr2(Integer.parseInt(args[1]));
        int tiga = Arr3(Integer.parseInt(args[1]));

            if(dua==2){
                String[][] arr = { 
                    {"satu","dua","tiga","empat" },
                    { "satu", "dua", "tiga" }
                };
                for(int i=0;i<arr.length;i++){
                    for(int j=0;j<arr[i].length;j++){
                        System.out.print(arr[i][j]+" ");
                    }
                    System.out.print("\n");
                }
            }
            else if(tiga==3){
                String[][] arr = { 
                    { "satu", "dua", "tiga", "empat" },
                    { "satu", "dua", "tiga" },
                    { "satu" },
                };
                for(int i=0;i<arr.length;i++){
                    for(int j=0;j<arr[i].length;j++){
                        System.out.print(arr[i][j]+" ");
                    }
                    System.out.print("\n");
                }
            }
        break;
        default :
          System.out.println("Null");
        break;
        }
    }
 
    public static int volumeBangun(int s) {
        int volume = s*s*s ;
        return volume;
     }
 
    public static double volumeBangun(float r) {
        float volume = (4f/3f)*3.14f * (r * r) ;
        return volume;
    }
    public static int Arr2(int r) {
        int dua = r;
        return dua;
    }

    public static int Arr3(int r) {
        int tiga = r;
        return tiga;
    }
 }
 