public class TestMyDate {
     		public static void main(String[] args) {
     			MyDate my_birth = new MyDate(22, 7, 1964);
                 my_birth.addDays(7);
                 System.out.println(my_birth);
                 my_birth.kurangDays(8);
                 System.out.println(my_birth);
               my_birth.tambahBulan(1);
               System.out.println(my_birth);
                 my_birth.tambahTahun(2);
                 System.out.println(my_birth);
     		}
     	}
    