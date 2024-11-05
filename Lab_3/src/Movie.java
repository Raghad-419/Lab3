import java.util.ArrayList;

public class Movie extends Media{
private int duration;

Movie(){}

    Movie(String title, String auteur,String ISBN,double price,int duration) {
        super(title, auteur, ISBN, price);
        this.duration = duration;
    }


    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }


    public void watch(User user){
        user.getPurchaseMediaList().add(this);
        System.out.println(user.getUsername()+" watch successfully");
    }

   public ArrayList<Movie> recommendSimilarMovies(ArrayList<Movie> movieCatalog){
        ArrayList<Movie> recommends =new ArrayList<>();
        for(Movie movie: movieCatalog){
          if(movie.getAuteur().equals(this.getAuteur())){
              recommends.add(movie);
          }}
        return recommends;
   }

    @Override
    public String getMediaType() {
        if(duration>=120){
            return "Long Movie";
        }else return "Movie";
    }


    @Override
    public String toString() {
        return"Movie information:\n"+ super.toString()+"\nDuration of movie: "+duration+"\n";
    }
}//end class
