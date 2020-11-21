public class CommandLine {
   public static void main(String[] args) { 
      String Case = args[0];
       switch(Case){
       case "1" : 
          int persegi = luasBangun(Integer.parseInt(args[1]));
          System.out.println("Persegi = " + persegi);
       break;
       case "2" : 
          double lingkaran = luasBangun(Float.parseFloat(args[1]));
          System.out.println("Lingkaran = " + lingkaran);
       break;
       case "3" : 
          double segitiga = luasBangun(Double.parseDouble(args[1]),Double.parseDouble(args[2]));
          System.out.println("Segitiga = " + segitiga);
       break;
       case "4" : 
          int umur = luasBangun(Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]));
          System.out.println("Umur = " + umur);
       break;
       default :
         System.out.println("Null");
       break;
       }
       

   }

   public static double luasBangun(double a, double t) {
      double luas = 1/2*(a*t) ;
      return luas;
   }
   public static int luasBangun(int s) {
       int luas = s*s ;
       return luas;
    }

    public static double luasBangun(float r) {
       float luas = 3.14f * (r * r) ;
       return luas;
    }

    public static int luasBangun(int d, int m, int y) {
      int tahun = 2020;
      int umur = tahun - y;
      return umur;
   }
}
