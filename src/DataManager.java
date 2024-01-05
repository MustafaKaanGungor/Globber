import java.io.File;

public class DataManager {
    
    static File dosya = new File("data/Hello.txt");
    public static void loadData() {
        if(dosya.canRead()) {
            System.out.println("okunabiliyor");
        }
        else {
            System.out.println("okunmuyor :(");
        }
    }
}
