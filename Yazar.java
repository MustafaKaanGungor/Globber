import java.util.ArrayList;

public class Yazar extends Hesap implements YazarIslem, KullaniciIslem{
    ArrayList<BlogYazisi> yazilanBloglar = new ArrayList<BlogYazisi>();
    int yazilanBlogSayisi;
    ArrayList<Kullanici> takipciler = new ArrayList<Kullanici>();
}
