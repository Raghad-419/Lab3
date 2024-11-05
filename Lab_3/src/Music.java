import java.util.ArrayList;

public class Music extends Media{
    private String artist;

    Music(){}

    Music(String title, String auteur,String ISBN,double price,String artist) {
        super(title, auteur, ISBN, price);
        this.artist=artist;

    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


    public String getArtist() {
        return artist;
    }


    public void listen(User user){
        user.getPurchaseMediaList().add(this);
        System.out.println(user.getUsername()+" listen successfully");
    }

    public  ArrayList<Music> generatePlaylist(ArrayList<Music> musicCatalog){
        ArrayList<Music> recommend =new ArrayList<>();
    for (Music music: musicCatalog){
        if(music.getAuteur().equalsIgnoreCase(this.getAuteur())){
            recommend.add(music);
        }
    }
      return recommend;
    }


    @Override
    public String getMediaType() {
        if(this.getPrice()>=10){
            return "Premium Music";
        }else return  "Music";
    }

    @Override
    public String toString() {
        return "Music information\n"+ super.toString()+"\nArtist: "+artist;
    }
}//end class
