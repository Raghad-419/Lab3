import java.util.ArrayList;

public class Store {
    ArrayList<Media> mediaArrayList =new ArrayList<>();
    ArrayList<User> userArrayList =new ArrayList<>();

    Store(){}
    Store(ArrayList<Media> mediaArrayList , ArrayList<User> userArrayList){
        this.mediaArrayList=mediaArrayList;
        this.userArrayList=userArrayList;
    }


    public void addUser(User user){
        userArrayList.add(user);
    }

    public ArrayList<User> displayUsers(){
        return userArrayList;
    }

    public void addMedia(Media media){
        mediaArrayList.add(media);
    }

    public ArrayList<Media> displayMedia(){
        return mediaArrayList;
    }


    public Book searchBook(String title){
        for (Media media :mediaArrayList) {
            if (media instanceof Book) {
                if (media.getTitle().equalsIgnoreCase(title))
                    return (Book) media;
            }
        }
        System.out.println("There is no book with this title.");
return  null ;
    }


}//end class
