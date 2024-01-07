import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java. util. Random;

public class BlogSystem {

    static private Kullanici kullaniciSession;
    static private Yazar yazarSession;
    static private Admin adminSession;
    static Scanner input = new Scanner(System.in);
    
    static ArrayList<Hesap> hesapList = new ArrayList<Hesap>(); //tüm adminler yazarlar ve kullanıcılar burada -Mustafa
    static ArrayList<BlogYazisi> blogList = new ArrayList<BlogYazisi>(); //tüm blog postları
    static ArrayList<Yorum> yorumList = new ArrayList<Yorum>();  // yorumlar


    static void Profile(int destination) {
        System.out.println("Name:         Birth date:    "); // bunlara nerden erişeceğimi bulamadm 
        System.out.println("Press 1 to Edit your profile, 2 for your blogging history");
        destination = input.nextInt();

        while(destination!= 0 || destination!=1 || destination!=2){
            switch(destination){
                case 0:
                Usergiris(destination);
                break;            
                case 1:
                EditProfile();
                break;
                case 2:
                BloggingHistory();
                break;
                default:
                System.out.println("Please select one of the options.");
                break;
            }
        }
    }

    static void EditProfile() {
        System.out.println("1 for editing name  2 for editing password  3 for editing birth date");
        int editing = input.nextInt();

        switch(editing){
            case 1:
                System.out.println("Buraya isim editleme işlemleri gelio inş");
            break;
            case 2:
                System.out.println("Buraya şifre editleme işlemleri gelio inş");
            break;
            case 3:
                System.out.println("Buraya doğum tarihi editleme gelio inş");
            break;
        }

    }
    static void BloggingHistory() {
        System.out.println("Your blogging history:");



    }

    static void Usergiris(int preset){

        System.out.println("----------   USER HAVALI ANA MENÜ WOOO   ----------");
        System.out.println("Gitmek istediğiniz yeri seçin: ");
        System.out.print("1-Latest Blogs  2-Popular Blogs  3-Following  4-Followers  5-Profile 6-Exit account ");

        if(preset == 2 || preset == 3){
        Yazargiris();
        }else if(preset == 3){
            Admingiris();
        }    //  burada yazar veya admin giriş yapıosa blog yaz-düzenle şıklarını ekliyo

        int destination = input.nextInt();

        switch (destination) {
            case 1:
                System.out.println("Latest Blogs: ");
                
                for (int i = 0; i < blogList.size(); i++) {
                    System.out.println(blogList.get(i));
                  }
                  /*System.out.println("Geri dönmek için 0 basın.");
                  int a = 1;
                  while(a != 0){
                    a = input.nextInt();
                  };*/
                break;
            case 2:
                System.out.println("Popular Blogs");
                
                for (int i = 0; i < blogList.size(); i++) {
                    System.out.println(blogList.get(i));
                  }
                  /*System.out.println("Geri dönmek için 0 basın.");
                  a = 1;
                  while(a != 0){
                    a = input.nextInt();
                  };*/
                break;
            case 3:
                System.out.println("Followers: ");
                 /*  a = 1;
                  while(a != 0){
                    a = input.nextInt();
                  };*/
                break;
            case 4:
                System.out.println("Following: ");
                  /*a = 1;
                  while(a != 0){
                    a = input.nextInt();
                  };*/
                break;
            case 5:
                Profile(destination);
                break;
            case 6:
                Start.logOut();
                break;
            case 7:
                BlogEkle();
                break;
            case 8:
            break;

            default:
                System.out.println("Please select one of the given options");
                Usergiris(preset);
                break;
        }
    }

        static void Yazargiris() { 
            System.out.print("7-Add new blog 8-Edit a blog");
        }

        static void Admingiris() {
            System.out.println(" 9- Burn it all down");
        }

    
        static void BlogEkle(){
            Random randomID = new Random();
            int ID = randomID.nextInt(10000);

            System.out.println("Blog ismini yazın:");
            String xd = input.nextLine();
            String isim = input.nextLine();
            System.out.println("İçerik giriniz.");
            String icerik = input.nextLine(); 

            DateFormat currentDate = new SimpleDateFormat();
            String publishDate = currentDate.format(new Date());

            blogList.add(new BlogYazisi(ID , isim , icerik, publishDate));
            System.out.println("Blogunuz başariyla oluşturuldu!");
            System.out.println(blogList.get(0).ID + blogList.get(0).icerik);
        }

    static void startBlogger(Hesap usrSession, int preset) {
        switch (preset) {
            case 1:
            kullaniciSession = (Kullanici) usrSession;
            Usergiris(preset);
            break;
            case 2:
            yazarSession = (Yazar) usrSession;
            System.out.println("Yazar girisi");
            Usergiris(preset);

            break;
            case 3:
            adminSession = (Admin) usrSession;
            System.out.println("Admin girisi");
            Usergiris(preset);
            break;
        }
    }


    
}

