import java.util.ArrayList;

public class User {

    private String username;
    private String email;
    private ArrayList<Media> purchaseMediaList = new ArrayList<>();
    private ArrayList<Media> shoppingCart = new ArrayList<>();

    User(){}
    User(String username,String email){
        this.username=username;
        this.email=email;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        int atPosition = email.indexOf('@');
        int dotPosition = email.lastIndexOf('.');

        if (atPosition > 0 && atPosition == email.lastIndexOf('@') && atPosition < email.length() - 1) {
            if (dotPosition > atPosition + 1 && dotPosition < email.length() - 1) {
                this.email = email;
                return;
            }
        }

        System.out.println("Invalid email format.");}

    public void setPurchaseMediaList(ArrayList<Media> purchaseMediaList) {
        this.purchaseMediaList = purchaseMediaList;
    }

    public void setShoppingCart(ArrayList<Media> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Media> getPurchaseMediaList() {
        return purchaseMediaList;
    }

    public ArrayList<Media> getShoppingCart() {
        return shoppingCart;
    }


    public void addToCart(Media media) {
        if (media instanceof Book) {
            Book book = (Book) media;
            if (book.getStock() > 0) {
                shoppingCart.add(media);
            } else System.out.println("The book '" + book.getTitle() + "' is out of stock and cannot be add to cart.");
        }else shoppingCart.add(media);
    }

    public void removeFromCart(Media media) {
        shoppingCart.remove(media);
    }


    public void checkOut() {
        for (Media media : shoppingCart) {
            purchaseMediaList.add(media);
            if (media instanceof Book) {
                Book book = (Book) media;
                if (book.getStock() > 0) {
                    book.setStock(book.getStock() - 1);
                } else System.out.println("The book:" + book.getTitle() + " is out of stock and cannot be purchased.");
            }

        }
        shoppingCart.clear();
        System.out.println("Checkout completed successfully.");
    }

    @Override
    public String toString() {
        return "User\n" +
                "username='" + username + '\'' +
                "\nemail='" + email + '\'' +
                "\npurchaseMediaList=\n" + purchaseMediaList +
                "\nshoppingCart=\n" + shoppingCart ;
    }
}//end class
