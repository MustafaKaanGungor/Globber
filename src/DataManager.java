import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManager {
    
    static int accountType = 0;
    static String usrName = "";
    static String signDate = "";
    static String birthDate = "";
    static String usrGender = "";
    static String usrPassword = "";
    static String usrBio = "";
    static String usrComments = "";
    static String usrFollowWriter = "";
    static String usrFollowTag = "";
    static String usrHistory = "";
    static String writtenBlogs = "";
    static String followers = "";
    
    
    static File dosya = new File("data/Hesaplar.txt");
    public static void loadData() {
        Scanner reader;
        
        try {
            reader = new Scanner(dosya);
            
            while(reader.hasNextLine()) {
                switch(reader.next()) {
                    case "Hesap":
                    accountType = reader.nextInt();
                    if(!reader.next().equals("ISM")) {
                        break;
                    }
                    case "ISM":
                    usrName = reader.next();
                    if(!reader.next().equals("KAT")) {
                        break;
                    }
                    case "KAT":
                    signDate = reader.next();
                    if(!reader.next().equals("DOT")) {
                        break;
                    }
                    case "DOT":
                    birthDate = reader.next();
                    if(!reader.next().equals("CIN")) {
                        break;
                    }
                    case "CIN":
                    usrGender = reader.next();
                    if(!reader.next().equals("PAW")) {
                        break;
                    }
                    case "PAW":
                    usrPassword = reader.next();
                    if(!reader.next().equals("BIO")) {
                        break;
                    }
                    case "BIO":
                    usrBio = reader.nextLine();
                    
                    if(accountType == 1) {
                        switch(reader.next()) {
                            case "YRM":
                            usrComments = reader.nextLine();
                            if(!reader.next().equals("YZR")) {
                                break;
                            }
                            case "YZR":
                            usrFollowWriter = reader.nextLine();
                            if(!reader.next().equals("TAG")) {
                                break;
                            }
                            case "TAG":
                            usrFollowTag = reader.nextLine();
                            if(!reader.next().equals("HST")) {
                                break;
                            }
                            case "HST":
                            usrHistory = reader.nextLine();
                        }
                    }
                    else if(accountType == 2) {
                        switch(reader.next()) {
                            case "WRB":
                            writtenBlogs = reader.nextLine();
                            if(!reader.next().equals("TKP")) {
                                break;
                            }
                            case "TKP":
                            followers = reader.nextLine();
                        }
                    }
                    case "BOSLUK-":
                    default:
                }
                
                ArrayList<String> usrFollowedWriters = new ArrayList<String>();
                ArrayList<Integer> usrComment = new ArrayList<Integer>();
                ArrayList<Tag> usrFollowedTags = new ArrayList<Tag> ();
                ArrayList<Integer> usrHistoryList = new ArrayList<Integer>();
                
                ArrayList<Integer> writtenBlogList = new ArrayList<Integer>();
                ArrayList<String> followersList = new ArrayList<String>();
                
                if(accountType == 1) {
                    if(!usrComments.isEmpty()) {
                        usrComments = usrComments.trim();
                        for(String comment:usrComments.split("[^0-9]")) {
                            Integer commentID = Integer.parseInt(comment);
                            usrComment.add(commentID);
                        }
                    }
                    if(!usrFollowWriter.isEmpty()) {
                        usrFollowWriter = usrFollowWriter.trim();
                        for(String writer:usrFollowWriter.split("[^a-z]")) {
                            writer = writer.trim();
                            usrFollowedWriters.add(writer);
                        }
                    }
                    if(!usrFollowTag.isEmpty()) { //TODO burası çalışmıyor
                        usrFollowTag = usrFollowTag.trim();
                        for(String tagString: usrFollowTag.split("[^A-Za-z]")) {
                            tagString = tagString.trim();
                            if(!tagString.isEmpty()) {
                                Tag tempTag = Tag.valueOf(tagString);
                                usrFollowedTags.add(tempTag);
                            }
                        }
                    }
                    if(!usrHistory.isEmpty()) {
                        usrHistory = usrHistory.trim();
                        for(String history:usrHistory.split("[^0-9]")) {
                            Integer blogID = Integer.parseInt(history);
                            usrHistoryList.add(blogID);
                        } 
                    }
                }
                else if(accountType == 2) {
                    if(!writtenBlogs.isEmpty()) {
                        writtenBlogs = writtenBlogs.trim();
                        for(String blog: writtenBlogs.split("[^0-9]")) {
                            Integer blogID = Integer.parseInt(blog);
                            writtenBlogList.add(blogID);
                        }
                    }
                    if(!followers.isEmpty()) {
                        followers = followers.trim();
                        for(String follower: followers.split("[^a-z]")) {
                            follower = follower.trim();
                            followersList.add(follower);
                        }
                    }
                }
                
                if(accountType == 1) {
                    BlogSystem.hesapList.add(new Kullanici(usrName, signDate, birthDate, usrGender, usrPassword, usrBio,
                    usrComment, usrFollowedWriters,usrFollowedTags,usrHistoryList));
                }
                else if(accountType == 2) {
                    BlogSystem.hesapList.add(new Yazar(usrName, signDate, birthDate, usrGender, usrPassword, usrBio,
                    writtenBlogList, followersList));
                }
                else if(accountType == 3) {
                    BlogSystem.hesapList.add(new Admin(usrName, signDate, birthDate, usrGender, usrPassword));
                }
                
                accountType = 0;
                usrName = "";
                signDate = "";
                birthDate = "";
                usrGender = "";
                usrPassword = "";
                usrBio = "";
                usrComments = "";
                usrFollowWriter = "";
                usrFollowTag = "";
                usrHistory = "";
                writtenBlogs = "";
                followers = "";
            }
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
