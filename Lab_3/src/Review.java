public class Review {
    private String username;
    private double rating ;
    private String comment;

    Review(){}
    Review(String username,double rating,String comment){
        this.username=username;
        this.rating=rating;
        this.comment=comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public double getRating() {
        return rating;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Review{" +
                "username='" + username + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
