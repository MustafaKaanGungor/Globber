import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;

public class BlogSystem {
    
    static private Hesap userSession;
    static private Kullanici kullaniciSession;
    static private Yazar yazarSession;
    static Scanner input = new Scanner(System.in);
    
    static ArrayList<Hesap> hesapList = new ArrayList<Hesap>(); // tüm yazarlar ve kullanıcılar burada -Mustafa
    static ArrayList<BlogYazisi> blogList = new ArrayList<BlogYazisi>(); // tüm blog postları
    static ArrayList<Yorum> yorumList = new ArrayList<Yorum>(); // yorumlar
    
    static void startBlogger(Hesap usrSession, int preset) {
        userSession = (Hesap) usrSession;
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
        }
    }      // TODO Burası tamamen gereksiz glb? usergiris(preset) ve usersession yeter
        
    static void Usergiris(int preset){
        
        System.out.println("----------   HAVALI ANA MENÜ WOOO   ----------");
        System.out.println("Gitmek istediğiniz yeri seçin: ");
        System.out.print("1-Popular Blogs 2-Following 3-Profile 4-Exit account ");
        
        if (preset == 2 || preset == 3) {
            Yazargiris();
        }  // burada yazar giriş yapıosa blog yaz-düzenle şıklarını ekliyo
        
        int destination = input.nextInt();
        
        switch (destination) {
            case 1:
            System.out.println("Popular Blogs");
            
            for (int i = 0; i < blogList.size(); i++) {
                System.out.print(i+1 +". blog: ");
                System.out.println(blogList.get(i).baslik);
            }
            System.out.println("Type the blog you want to read");
            int read = input.nextInt();
            blogOku(read);
            break;
            case 2:
            Profile(destination);
            break;
            case 3:
            Start.logOut();
            break;
            case 4:
            BlogEkle();
            break;
            case 5:
            break;      
            default:
            System.out.println("Please select one of the given options");
            Usergiris(preset);
            break;
        }
    }
    
    static void Yazargiris() {
        System.out.println("4-Add new blog 5-Edit a blog");
    }
    
    static void Profile(int destination) {
        System.out.println("Name:    " + userSession.getKullaniciAd() + "Birth Date: " + userSession.getDogumTarihi());
        System.out.println("Press 1 to Edit your profile, 2 for your blogging history");
        destination = input.nextInt();
        
        while (destination != 0 || destination != 1 || destination != 2) {
            switch (destination) {
                case 0:
                Usergiris(destination);
                break;
                case 1:
                EditProfile(destination);
                break;
                case 2:
                BloggingHistory();
                break;
                default:
                System.out.println("Please select one of the options.");
                Profile(destination);
                break;
            }
        }
    }
    
    static void EditProfile(int destination) {
        System.out.println("1 for editing name  2 for editing password  3 for editing birth date");
        int editing = input.nextInt();
        
        switch (editing) {
            case 0:
            Profile(destination);
            break;
            case 1:
            System.out.println("Enter a new name."); 
            String isim1 = input.next(); 
            
            for(int i=0;i<hesapList.size();i++){
                if(hesapList.get(i).getKullaniciAd().equals(userSession.getKullaniciAd())){
                    hesapList.get(i).setKullaniciAd(isim1);
                }
            }

            userSession.setKullaniciAd(isim1);
            break;
            case 2:
            System.out.println("Enter a new password.");
            String sifre1 = input.next();
            if(Start.checkPasswordSuffiency(sifre1)== 1){
                userSession.setPassword(sifre1);
            }else{
                System.out.println("Password should be at least 8 characters and should include;");
                System.out.println(" - At least 1 capital letter");
                System.out.println(" - At least 1 lowercase letter");
                System.out.println(" - At least 1 number");
                EditProfile(destination);}
                break;
                case 3:
                System.out.println("Enter Birth Date (DD/MM/YYYY):  (0- Back)");
                System.out.print("=>");
                String dogumtarihi = input.next();
                dogumtarihi = dogumtarihi.trim();
                userSession.setDogumTarihi(dogumtarihi);
                break;
                default: 
                System.out.println("Please enter one of the options.");
                EditProfile(destination);
                break;
            }
        }
        
    static void BloggingHistory() {
        System.out.println("Your blogging history:");
            
            
        }

    static void BlogEkle() {
        Random randomID = new Random();
        int ID = randomID.nextInt(10000);
            
        System.out.println("Enter blog name:");
        String xd = input.nextLine();
        String isim = input.nextLine();
        System.out.println("Enter contents.");
        String icerik = input.nextLine();
            
        DateFormat currentDate = new SimpleDateFormat();
        String publishDate = currentDate.format(new Date());
            
        blogList.add(new BlogYazisi(ID, isim, icerik, publishDate));
        // System.out.println(blogList.get(0).ID + blogList.get(0).icerik);
        }

      
    /*static void BlogDuzenle(){
            for (int i = 0; i < blogList.size(); i++) {
                System.out.print(i+1 +". blog: ");
                System.out.println(blogList.get(i).baslik);
            }

        System.out.println("Select the blog you want to edit.");
        int edit = input.nextInt();
        System.out.println(blogList.get(edit-1).icerik);
        System.out.println("Enter the edited version of your blog: ");
        String edited = input.nextLine();

        blogList.set(edit-1, edited).icerik;   // ????
    }*/
    static void yorumGoruntule(int IDs){
        System.out.println(yorumList.get(IDs).yazanKisi);      
        System.out.println(yorumList.get(IDs).text); 
        System.out.println(yorumList.get(IDs).likeCount); 
    }

    static void blogOku(int read){
        System.out.println(blogList.get(read-1).icerik);
        System.out.println("Begeni sayisi: " + blogList.get(read-1).begeniSayisi);
        //userSession.okumaGecmisi.add().blogList.get(read-1);
        int IDs = blogList.get(read-1).ID;
        System.out.println("0 to return 1 to view comments");
        int secenek = input.nextInt();
        switch (secenek){
            case 0:
            Usergiris(secenek);
            break;
            case 1:
            yorumGoruntule(IDs);
            break;
        }
    }
        
    }
    