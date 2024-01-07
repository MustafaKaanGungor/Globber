import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManager {
    
    static File accountFile = new File("data/Hesaplar.txt");
    static File blogFile = new File("data/Blogler.txt");
    static File commentFile = new File("data/Yorumlar.txt");
    
    static Scanner reader;
    
    public static void loadData() {
        
        loadAccounts();
        loadBlogs();
        loadComments();
    }
    
    static void loadAccounts() {
        
        int accountType = 0;
        String usrName = "";
        String signDate = "";
        String birthDate = "";
        String usrGender = "";
        String usrPassword = "";
        String usrBio = "";
        String usrComments = "";
        String usrFollowWriter = "";
        String usrFollowTag = "";
        String usrHistory = "";
        String writtenBlogs = "";
        String followers = "";
        
        try {
            reader = new Scanner(accountFile);
            
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
                    if(!usrFollowTag.isEmpty()) {
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
    
    static void loadBlogs() {
        
        Integer ID = 0;
        String title = "";
        String content = "";
        String publishDate = "";
        String tag = "";
        int likeCount = 0;
        String comment = "";
        int viewCount = 0;
        
        try {
            reader = new Scanner(blogFile);
            
            while(reader.hasNextLine()) {
                switch(reader.next()) {
                    case "Blog":
                    
                    case "IDN":
                    ID = reader.nextInt();
                    if(!reader.next().equals("BAS")) {
                        break;
                    }
                    case "BAS":
                    title = reader.nextLine();
                    if(!reader.next().equals("CON")) {
                        break;
                    }
                    case "CON":
                    content = reader.nextLine();
                    if(!reader.next().equals("PUB")) {
                        break;
                    }
                    case "PUB":
                    publishDate = reader.next();
                    if(!reader.next().equals("TAG")) {
                        break;
                    }
                    case "TAG":
                    tag = reader.next();
                    if(!reader.next().equals("LKE")) {
                        break;
                    }
                    case "LKE":
                    likeCount = reader.nextInt();
                    if(!reader.next().equals("COM")) {
                        break;
                    }
                    case "COM":
                    comment = reader.nextLine();
                    if(!reader.next().equals("RRT")) {
                        break;
                    }
                    case "RRT":
                    viewCount = reader.nextInt();
                    default:
                }
                ArrayList<Integer> comments = new ArrayList<Integer>();
                Tag BlogTag = null;
                
                if(!comment.isEmpty()) {
                    comment = comment.trim();
                    for(String commentTemp:comment.split("[^0-9]")) {
                        Integer commentID = Integer.parseInt(commentTemp);
                        comments.add(commentID);
                    }
                }
                if(!tag.isEmpty()) {
                    tag = tag.trim();
                    if(!tag.isEmpty()) {
                        BlogTag = Tag.valueOf(tag);
                        
                    }
                }
                
                BlogSystem.blogList.add(new BlogYazisi(ID,title,content,publishDate,BlogTag,likeCount,comments,viewCount));
                
                ID = 0;
                title = "";
                content = "";
                publishDate = "";
                tag = "";
                likeCount = 0;
                comment = "";
                viewCount = 0;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    static void loadComments() {
        
        Integer ID = 0;
        Integer blog = 0;
        String writer = "";
        String text = "";
        int likeCount = 0;
        
        try {
            reader = new Scanner(commentFile);
            
            while (reader.hasNextLine()) {
                switch(reader.next()) {
                    case "Yorum":
                    
                    case "IDN":
                    ID = reader.nextInt();
                    if(!reader.next().equals("KON")) {
                        break;
                    }
                    case "KON":
                    blog = reader.nextInt();
                    if(!reader.next().equals("YZR")) {
                        break;
                    }
                    case "YZR":
                    writer = reader.next();
                    if(!reader.next().equals("TEX")) {
                        break;
                    }
                    case "TEX":
                    text = reader.nextLine();
                    if(!reader.next().equals("LKE")) {
                        break;
                    }
                    case "LKE":
                    likeCount = reader.nextInt();
                    default:
                }
                
                BlogSystem.yorumList.add(new Yorum(ID, blog, writer, text, likeCount));
                
                ID = 0;
                blog = 0;
                writer = "";
                text = "";
                likeCount = 0;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
