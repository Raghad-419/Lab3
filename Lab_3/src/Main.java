import java.util.ArrayList;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Movie> movieCatalog =new ArrayList<>();
        ArrayList<Music> musicCatalog=new ArrayList<>();
        ArrayList<User> userArrayList=new ArrayList<>();
        ArrayList<Media> mediaArrayList=new ArrayList<>();
        Store store =new Store(mediaArrayList,userArrayList);

        Book arabic = new Book("Arabic" ,"Mohamad","4", 40,3);
        Review review3 = new Review("Nermen",3,"Kind of good");
        User ahmad = new User("Ahmad","Ahmad@gmail.com");
        User sara=new User("Sara","sara@gmail.com");
        userArrayList.add(ahmad);
        userArrayList.add(sara);
        mediaArrayList.add(arabic);


        Movie moanaMovi = new Movie("Moana" ,"Jone","5",30 ,90);
        Movie rabitMovi = new Movie("Rabbit" ,"yara","6",40 ,150);
        Movie lucaMovi =new Movie("Luca" ,"Jone","7",40 ,140);
        movieCatalog.add(moanaMovi);
        movieCatalog.add(rabitMovi);
        movieCatalog.add(lucaMovi);
        mediaArrayList.add(moanaMovi);
        mediaArrayList.add(rabitMovi);
        mediaArrayList.add(lucaMovi);

        Music babyShark = new Music("baby shark","Lolo","8",30,"Lena");
        Music animals =new Music("Animals","Naser","9",5 ,"Hussam");
        Music colors =new Music("Colors","Naser","10",15 ,"Khaled");
        musicCatalog.add(babyShark);
        musicCatalog.add(animals);
        musicCatalog.add(colors);
        mediaArrayList.add(babyShark);
        mediaArrayList.add(animals);
        mediaArrayList.add(colors);

        babyShark.listen(sara);
        colors.listen(ahmad);
        System.out.println("Playlist of Music Similar to Animal Sounds: "+animals.generatePlaylist(musicCatalog));
        System.out.println(animals.getTitle()+" MediaType: "+animals.getMediaType());
        System.out.println(colors.getTitle()+" Media Type: "+colors.getMediaType());


        Review mazenReview =new Review();
        mazenReview.setUsername("Mazen");
        mazenReview.setComment("Very good");
        mazenReview.setRating(4.5);

        Review review2 =new Review();
        review2.setUsername("Nora");
        review2.setComment(" good");
        review2.setRating(4);

        Media mediaArt = new Media();
        mediaArt.setTitle("Art");
        mediaArt.setAuteur("Ahmad");
        mediaArt.setISBN("1");
        mediaArt.setPrice(30);
        ////////////////////////////
        Book math =new Book();
        math.setStock(3);
        math.setTitle("Math");
        math.setAuteur("Mazen");
        math.setISBN("2");
        math.setPrice(40);
        math.addReview(mazenReview);
        store.addMedia(math);
        ////////////////////////////////////////
        Book english =new Book();
        english.setTitle("English");
        english.setPrice(50);
        english.setStock(1);
        english.setISBN("3");
        english.setAuteur("Maha");
        english.addReview(review2);
        store.addMedia(english);
        ////////////////////////////////////////
        User raghad = new User();
        userArrayList.add(raghad);
        raghad.setUsername("Raghad");
        raghad.setEmail("raghad.gmail");
        raghad.setEmail("Raghad@gmail.com");
        math.purchase(raghad);
        System.out.println("purchase List: "+titleOfgBook(raghad.getPurchaseMediaList()));
        raghad.addToCart(english);
        raghad.addToCart(mediaArt);
        raghad.addToCart(arabic);
        raghad.removeFromCart(arabic);
        System.out.println("shopping Cart: "+titleOfgBook(raghad.getShoppingCart()));
        raghad.checkOut();
        System.out.println("purchase Media List: "+titleOfgBook(raghad.getPurchaseMediaList()));
        System.out.println("Math Average rating: "+math.getAverageRating());
        english.purchase(ahmad);
        english.restock(2);
        System.out.println("English new stock= "+english.getStock());

/////////////////////////////////////////////////////
        rabitMovi.watch(ahmad);
        System.out.println("purchase List: "+titleOfgBook(ahmad.getPurchaseMediaList()));
        System.out.println("Recommend Similar Movies to luca movie"+lucaMovi.recommendSimilarMovies(movieCatalog));
        System.out.println("luca Movie type: "+lucaMovi.getMediaType());
        System.out.println("moana Movie type: "+moanaMovi.getMediaType());
        System.out.println(movieCatalog);
        System.out.println(lucaMovi.toString());
        System.out.println("Math is best seller? "+ math.isBestSeller());
        System.out.println("Math Reviews: "+ math.getReview().toString());
//////////////////////////////////////////////////////////
        System.out.println("*******************************************");
        System.out.println("All users of store: "+usernames(store.displayUsers()));
        System.out.println("All media of store: "+titleOfgBook(store.displayMedia()));
        arabic.addReview(review2);
        arabic.addReview(mazenReview);
        Book book1= store.searchBook("arabic");
        System.out.println(book1);
        Book book2=store.searchBook("Cars");
        /////////////////////////////////////////////
        AcademicBook academicBook1 =new AcademicBook("calculus","Eman","11",200,2,"math2");
        Novel novel1=new Novel("Friends","gogo","12",30,4,"friendship");
        academicBook1.addReview(mazenReview);
        novel1.addReview(review2);
        System.out.println("Friends Media Type: "+novel1.getMediaType());
        System.out.println("calculus Media Type: "+academicBook1.getMediaType());
        System.out.println(academicBook1);
        System.out.println(novel1);




        


    }

    private static ArrayList<String> titleOfgBook(ArrayList<Media> media) {
        ArrayList<String> titles=new ArrayList<>();
        for (Media m: media){
            titles.add(m.getTitle());}
        return titles;
    }

    private static ArrayList<String> usernames(ArrayList<User> users) {
        ArrayList<String> names =new ArrayList<>();
        for (User u: users){
            names.add(u.getUsername());}
        return names;
    }




}