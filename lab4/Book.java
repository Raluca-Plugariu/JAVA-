package lab4;

public class Book extends AbstractClass{
	private String NumeBook;
    private String PathBook;
    private int AnBook;
    private String AuthorBook;

    Book(String nume, String path, int an,String author) {
        this.NumeBook = nume;
        this.PathBook = path;
        this.AnBook = an;
        this.AuthorBook = author;
    }
    @Override
    public double add() {
        return 0;
    }

    @Override
    public double list() {
        return 0;
    }

    @Override
    public double play() {
        return 0;
    }

    @Override
    public double save() {
        return 0;
    }

    @Override
    public double load() {
        return 0;
    }
    
    public String toString()
    {
        return this.NumeBook + " " + this.PathBook + " " + this.AnBook + " " + this.AuthorBook + "\n";

    }

}
