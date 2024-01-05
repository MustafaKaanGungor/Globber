import java.util.ArrayList;
import java.util.Scanner;
public class BlogSystem {

    static private Kullanici kullaniciSession;
    static private Yazar yazarSession;
    static private Admin adminSession;
    static Scanner input = new Scanner(System.in);
    
    static ArrayList<Hesap> hesapList = new ArrayList<Hesap>(); //tüm adminler yazarlar ve kullanıcılar burada -Mustafa
    static ArrayList<BlogYazisi> blogList = new ArrayList<BlogYazisi>(); //tüm blog postları

    static void Profile(int destination) {
        System.out.println("Name:         Birth date:    ");

        System.out.println("Press 1 to Edit your profile, 2 for your blogging history");
        destination = input.nextInt();
        if(destination==1){
            EditProfile();
        }else if(destination==2){
            BloggingHistory();
        }else {
            System.out.println("Please select one of the options.");
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

        // eklencek daha :sob:
    }

    static void Usergiris(){

        System.out.println("----------   USER HAVALI ANA MENÜ WOOO   ----------");
        System.out.println("Gitmek istediğiniz yeri seçin: ");
        System.out.println("1-Latest Blogs  2-Popular Blogs  3-Takip edilenler  4-Takipçiler  5-Profil");
        int destination = input.nextInt();

        switch (destination) {
            case 1:
                System.out.println("Latest Blogs: ");
                break;
            case 2:
                System.out.println("Popular Blogs");
                break;
            case 3:
                System.out.println("Followers: ");
                break;
            case 4:
                System.out.println("Following: ");
                break;
            case 5:
                Profile(destination);
                break;
            default:
                System.out.println("Please select one of the given options");
                Usergiris();
                break;
        }

        }
    static void startBlogger(Hesap usrSession, int preset) {
        switch (preset) {
            case 1:
            kullaniciSession = (Kullanici) usrSession;
            Usergiris();
            break;
            case 2:
            yazarSession = (Yazar) usrSession;
            System.out.println("Yazar girisi");

            break;
            case 3:
            adminSession = (Admin) usrSession;
            System.out.println("Admin girisi");
            break;
        }
    }


    
}

