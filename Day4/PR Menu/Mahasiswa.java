import java.util.*;
import java.io.*; 
public class Mahasiswa implements Comparable{
    int id = 0;
    String nama = "";
    String nilai = "";

    public static void main(String[] args)throws Exception{ 
        //Menu
        Mahasiswa aksi_mahasiswa = new Mahasiswa();
        aksi_mahasiswa.Menus();
    }

public Mahasiswa(int id, String nama, String nilai){
    this.id = id;
    this.nama = nama;
    this.nilai = nilai;
}

public Mahasiswa(){
    
}

public void Menus()throws Exception{
    List<Mahasiswa> mahasiswa=new ArrayList<Mahasiswa>();
        System.out.println("Menu ");
            System.out.println("1. Buat Objek Mahasiswa");
            System.out.println("2. Edit Data Mahasiswa");
            System.out.println("3. Remove Object Mahasiswa");
            System.out.println("4. Laporan Data Mahasiswa");
            System.out.println("5. Tulis Laporan ke File TXT");
            System.out.println("6. Exit");

                InputStreamReader r=new InputStreamReader(System.in); 
                BufferedReader br=new BufferedReader(r); 
                System.out.print("Pilih Menu 1/2/3/4/5/6 : "); 
                String menu=br.readLine(); 
                String Menu = menu;
            
            while(!Menu.equals("6")){ 
            switch(Menu){ 
                case "0":
                System.out.println(" Menu ");
                System.out.println("1. Buat Objek Mahasiswa");
                System.out.println("2. Edit Data Mahasiswa");
                System.out.println("3. Remove Object Mahasiswa");
                System.out.println("4. Laporan Data Mahasiswa");
                System.out.println("5. Tulis Laporan ke File TXT");
                System.out.println("6. Exit");
    
                    System.out.print("Pilih Menu 1/2/3/4/5/6 : "); 
                    menu=br.readLine(); 
                    Menu = menu;
                break;
                case "1":
                        System.out.print("ID :"); 
                        String id=br.readLine(); 
                        int ids=Integer.parseInt(id);
                        System.out.print("Nama :"); 
                        String nama=br.readLine(); 
                        System.out.print("Nilai :"); 
                        String nilai=br.readLine(); 
                        
                            Mahasiswa mhs = new Mahasiswa(ids,nama,nilai);
                            mahasiswa.add(mhs);
                            for(Mahasiswa obj:mahasiswa){
                                System.out.println(obj.getNama()+" "+obj.getNilai()); 
                            }
                            Menu="0";
                break;
                case "2":
                try{
                    System.out.print("ID :"); 
                    String idss=br.readLine();
                    int id1=Integer.parseInt(idss); 
                    for (int i=0;i<mahasiswa.size();i++){
                        if (mahasiswa.get(i).getId()==Integer.parseInt(idss)){
                            System.out.println("Nama : "+mahasiswa.get(i).getNama());
                            System.out.println("Nilai : "+mahasiswa.get(i).getNilai());
                            System.out.println();
                            System.out.println("Masukan Nama: ");
                            String nama1=br.readLine();
                            System.out.println("Masukan Nilai: ");
                            String nilai1=br.readLine();
                            Mahasiswa mhs1 = new Mahasiswa(id1,nama1,nilai1);
                            mahasiswa.set(i,mhs1);
                            System.out.println("Data Setelah DiEdit :");
                            System.out.print("Nama : "+mahasiswa.get(i).getNama());
                            System.out.println("\nNilai : "+mahasiswa.get(i).getNilai());
                            Menu="0";
                        }
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
                break;
                case "3":
                try{
                    System.out.print("ID :"); 
                    String idss=br.readLine();
                    for (int i=0;i<mahasiswa.size();i++){
                        if (mahasiswa.get(i).getId()==Integer.parseInt(idss)){
                            mahasiswa.remove(i);
                            System.out.println("Data Saat Ini :");
                            for(Mahasiswa obj:mahasiswa){
                                System.out.println("Id : "+obj.getId()+" , "+ "Nama : "+obj.getNama()+" , "+"Nilai : "+obj.getNilai()); 
                            }
                            Menu="0";
                        }
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
                break;
                case "4":
                try{
                    Collections.sort(mahasiswa);
                    for(Mahasiswa obj: mahasiswa){
                        System.out.print("Id: "+obj.getId() + ", Nama: "+obj.getNama()+", Nilai: "+obj.getNilai()+"\n");
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
                Menu="0";
                break;
                case "5":
                try{ 
                    Collections.sort(mahasiswa);
                    System.out.print("Nama File :"); 
                    String file=br.readLine();
                    FileWriter fw=new FileWriter(file); 
                    for(Mahasiswa obj: mahasiswa){
                        fw.write("ID : " + obj.getId() + "\n"); 
                        fw.write("Nama : " + obj.getNama() + "\n"); 
                        fw.write("Nilai : " + obj.getNilai() + "\n"); 
                    }
                    
                    fw.close(); 
                }catch(Exception e){
                    System.out.println(e);
                } 
                System.out.println("FileWrite Success...");
                Menu="0";
                break;
                default : 
                    Menus();
                break;
                }
        }
    }

    
    int getId(){
        return this.id;
    }

    String getNama(){
        return this.nama;
    }

    String getNilai(){
        return this.nilai;
    }

    @Override 
        public int compareTo(Object o) {
            int banding= ((Mahasiswa)o).getId();
            return this.id-banding;
        }
}