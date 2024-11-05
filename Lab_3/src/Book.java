import java.util.ArrayList;

public class Book extends Media{
    private int stock;
    private ArrayList<Review> review =new ArrayList<>();

    public Book() {}

    public Book(String title, String auteur,String ISBN,double price,int stock){
        super(title,auteur,ISBN,price);
        this.stock=stock;

    }


    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setReview(ArrayList<Review> review) {
        this.review = review;
    }

    public int getStock() {
        return stock;
    }

    public ArrayList<Review> getReview() {
        return review;
    }

    public void addReview(Review r){
        review.add(r);
        System.out.println("Review added successfully");
    }

    public double getAverageRating() {
        double sum = 0;

        for (int i = 0; i < review.size(); i++) {
            sum = sum + review.get(i).getRating();
        }
        return sum / review.size();
    }

    public void purchase(User user){
        if(stock>0){
            user.getPurchaseMediaList().add(this);
            stock--;
            System.out.println("Book "+this.getTitle()+" purchased successfully.");
        }else System.out.println("Sorry, this book is out of stock.");

    }

    public boolean isBestSeller(){
        if(getAverageRating()>= 4.5){
            return true;
        }
        else return false;
    }


    public void restock(int quantity){
        this.stock=stock+quantity ;
        System.out.println("Restocked successfully");
    }

    @Override
    public String getMediaType() {
        if(isBestSeller()){
            return "Bestselling Book";
        }else
            return "Book";
    }

    @Override
    public String toString() {
        return super.toString() +"\nStock: "+stock+"\nList of reviews: "+review +"\n";
    }
}//end class
