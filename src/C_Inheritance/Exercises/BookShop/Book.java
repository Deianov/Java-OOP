package C_Inheritance.Exercises.BookShop;

class Book {
    private String title;
    private String author;
    private double price;

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    private void setAuthor(String author) {
        if (author.matches(".*\\s\\d.*")) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    String getTitle() { return this.title; }
    String getAuthor() { return this.author; }
    double getPrice() { return this.price; }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return stringBuilder.toString();
    }
}