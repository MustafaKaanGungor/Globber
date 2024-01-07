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
    
    static ArrayList<Hesap> hesapList = new ArrayList<Hesap>(); // tüm adminler yazarlar ve kullanıcılar burada -Mustafa
    static ArrayList<BlogYazisi> blogList = new ArrayList<BlogYazisi>(); // tüm blog postları
    static ArrayList<Yorum> yorumList = new ArrayList<Yorum>(); // yorumlar
    
    static void Profile(int destination) {
        System.out.println("Name:         Birth date:    "); // bunlara nerden erişeceğimi bulamadm
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
            System.out.println("Yeni isim giriniz."); 
            String isim1 = input.next();     //    TODO büyük küçük harf kontrol et
            
            for(int i=0;i<hesapList.size();i++){
                if(hesapList.get(i).getKullaniciAd().equals(userSession.getKullaniciAd())){    //wtf
                    hesapList.get(i).setKullaniciAd(isim1);
                }
            }
            userSession.setKullaniciAd(isim1);
            break;
            case 2:
            System.out.println("Yeni şifre giriniz.");
            String sifre1 = input.next();
            if(Start.checkPasswordSuffiency(sifre1)== 1){
                userSession.setPassword(sifre1);
            }
            break;
            case 3:
            System.out.println("Enter Birth Date (DD/MM/YYYY):  (0- Back)");
            System.out.print("=>");
            String dogumtarihi = input.next();
            dogumtarihi = dogumtarihi.trim();
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
                System.out.print(i+". blog: ");
                System.out.println(blogList.get(i));
            }
            System.out.println("");
            // TODO System.out.println("Bloglari okumak icin 0 Geri dönmek için 1 basın.");
            break;
            case 2:
            System.out.println("Followers: ");
            break;
            case 3:
            Profile(destination);
            break;
            case 4:
            Start.logOut();
            break;
            case 5:
            System.out.println("Following: ");
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
                System.out.println("5-Followers 6-Add new blog 7-Edit a blog");
            }
            
            static void BlogEkle() {
                Random randomID = new Random();
                int ID = randomID.nextInt(10000);
                
                System.out.println("Blog ismini yazın:");
                String xd = input.nextLine();
                String isim = input.nextLine();
                System.out.println("İçerik giriniz.");
                String icerik = input.nextLine();
                
                DateFormat currentDate = new SimpleDateFormat();
                String publishDate = currentDate.format(new Date());
                
                blogList.add(new BlogYazisi(ID, isim, icerik, publishDate));
                // System.out.println(blogList.get(0).ID + blogList.get(0).icerik);
            }
            
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
            }
            
        }
        