import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*public interface KullaniciIslem {
    //hem kullanıcıların hem yazarların hem de adminin yapabilceği işlemler buraya -Mustafa

    //kullanıcılar hesaplarındaki bilgileri düzenleyebilmeli
    //ama başkalarınkine elleyemeyecek

    //blog okunduğu zaman kullanıcının okuma geçmişine update

    //blog beğenme, yorum yapma, var olan yorumu beğenme
    //yazar takip etme
    //tag takip etmest
    void yorumYap();

    void yorumunuSil();

    void yazarTakipEt();

    void yazarTakiptenCik();

    void tagTakipEt();

    void tagTakiptenCik();

    void blogOku(); */


public interface KullaniciIslem {
    private List<String> okumaGecmisi;
    private List<String> yorumlar;
    private List<String> takipEdilenYazarlar;
    private List<String> takipEdilenTagler;

    public BlogSayfasi(){
        okumaGecmisi = new ArrayList<>();
        yorumlar = new ArrayList<>();
        takipEdilenYazarlar = new ArrayList<>();
        takipEdilenTagler = new ArrayList<>();
    }

    private String kullaniciGirisiniAl(String mesaj){
        Scanner scanner = new Scanner(System.in);
        System.out.print(mesaj);
        return scanner.nextLine();
    }

    private int kullaniciGirisiniAlInt(String mesaj){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try{
                System.out.print(mesaj);
                return Integer.parseInt(scanner.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Geçersiz bir sayı girdiniz. Tekrar deneyin.");
            }
        }
    }

    private void listeleYorumlar(){
        System.out.println("Yorumlar:");
        for (int i = 0; i < yorumlar.size(); i++){
            System.out.println(i + ". " + yorumlar.get(i));
        }
    }

    private void listeleTakipEdilenYazarlar(){
        System.out.println("Takip Edilen Yazarlar:");
        for (String yazar : takipEdilenYazarlar){
            System.out.println("- " + yazar);
        }
    }

    private void listeleTakipEdilenTagler(){
        System.out.println("Takip Edilen Tag'ler:");
        for (String tag : takipEdilenTagler){
            System.out.println("- " + tag);
        }
    }

    @Override
    public void yorumYap(){
        System.out.println("Yorum yapma işlemi");
        System.out.println("-------------------");

        // Kullanıcıdan yorumu al
        String yorum = kullaniciGirisiniAl("Yorumunuzu girin: ");

        // Yorumu yorumlar listesine ekle
        yorumlar.add(yorum);

        System.out.println("Yorumunuz başarıyla eklendi.");
        System.out.println();
    }

    @Override
    public void yorumunuSil(){
        System.out.println("Yorum silme işlemi");
        System.out.println("-------------------");

        // Yorumları listele
        listeleYorumlar();

        // Kullanıcıdan silinecek yorumun indeksini al
        int indeks = kullaniciGirisiniAlInt("Silmek istediğiniz yorumun indeksini girin: ");

        // Geçerli bir indeks kontrolü yap
        if(indeks >= 0 && indeks < yorumlar.size()){
            // Yorumu listeden çıkar
            yorumlar.remove(indeks);
            System.out.println("Yorum başarıyla silindi.");
        }else{
            System.out.println("Geçersiz bir indeks girdiniz.");
        }

        System.out.println();
    }

    @Override
    public void yazarTakipEt(){
        System.out.println("Yazar takip etme işlemi");
        System.out.println("-----------------------");

        // Kullanıcıdan takip edilecek yazarın adını al
        String yazarAdi = kullaniciGirisiniAl("Takip etmek istediğiniz yazarın adını girin: ");

        // Yazarı takipEdilenYazarlar listesine ekle
        takipEdilenYazarlar.add(yazarAdi);

        System.out.println(yazarAdi + " takip ediliyor.");
        System.out.println();
    }

    @Override
    public void yazarTakiptenCik(){
        System.out.println("Yazardan takip çıkma işlemi");
        System.out.println("---------------------------");

        // Takip edilen yazarları listele
        listeleTakipEdilenYazarlar();

        // Kullanıcıdan takipten çıkılacak yazarın adını al
        String yazarAdi = kullaniciGirisiniAl("Takipten çıkmak istediğiniz yazarın adını girin: ");

        // Yazarı takipEdilenYazarlar listesinden çıkar
        if (takipEdilenYazarlar.remove(yazarAdi)){
            System.out.println(yazarAdi + " takipten çıkarıldı.");
        }else{
            System.out.println(yazarAdi + " zaten takip edilmiyor.");
        }
        System.out.println();
    }

    @Override
    public void tagTakipEt(){
        System.out.println("Tag takip etme işlemi");
        System.out.println("---------------------");

        // Kullanıcıdan takip edilecek tag'ın adını al
        String tagAdi = kullaniciGirisiniAl("Takip etmek istediğiniz tag'ın adını girin: ");

        // Tag'ı takipEdilenTagler listesine ekle
        takipEdilenTagler.add(tagAdi);

        System.out.println(tagAdi + " takip ediliyor.");
        System.out.println();
    }

    @Override
    public void tagTakiptenCik(){
        System.out.println("Tag'dan takip çıkma işlemi");
        System.out.println("--------------------------");

        // Takip edilen tag'ları listele
        listeleTakipEdilenTagler();
    }

    @Override
    public void blogOku(){
        System.out.println("Blog okuma işlemi");
        System.out.println("-----------------");

        // Kullanıcının okuma geçmişini güncelle
        okumaGecmisi.add("Örnek Blog Başlığı"); // Örnek olarak bir blog başlığı ekledim

        // Okuma geçmişini listele
        System.out.println("Okuma Geçmişi:");
        for(String blog : okumaGecmisi){
            System.out.println("- " + blog);
        }
        System.out.println("Okuma işlemi tamamlandı.");
        System.out.println();
    }

    public static void main(String[] args){
        BlogSayfasi blogSayfasi = new BlogSayfasi();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Yapmak istediğiniz işlemi seçin:");
            System.out.println("1. Yorum Yap");
            System.out.println("2. Yorum Sil");
            System.out.println("3. Yazar Takip Et");
            System.out.println("4. Yazar Takipten Çık");
            System.out.println("5. Tag Takip Et");
            System.out.println("6. Tag Takipten Çık");
            System.out.println("7. Blog Oku");
            System.out.println("0. Çıkış");

            int secim = kullaniciGirisiniAlInt("Seçiminizi yapın: ");

            switch(secim){
                case 1:
                    blogSayfasi.yorumYap();
                    break;
                case 2:
                    blogSayfasi.yorumunuSil();
                    break;
                case 3:
                    blogSayfasi.yazarTakipEt();
                    break;
                case 4:
                    blogSayfasi.yazarTakiptenCik();
                    break;
                case 5:
                    blogSayfasi.tagTakipEt();
                    break;
                case 6:
                    blogSayfasi.tagTakiptenCik();
                    break;
                case 7:
                    blogSayfasi.blogOku();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
            }
        }
    }
}
