package C_Inheritance.Exercises.BookShop;

class GoldenEditionBook extends Book {

    GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + super.getPrice() * 0.3;
    }
}
