package lab4;


/**
 * Created by RALUCAx2 on 3/13/2017.
 */
import java.lang.String;

public class Movie extends AbstractClass
{
    private String NumeMovie;
    private String PathMovie;
    private int AnMovie;
    Movie(String nume, String path, int an) {
        this.NumeMovie = nume;
        this.PathMovie= path;
        this.AnMovie = an;

    }
    @Override
    public double add() {
        return 0;
    }

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
        return this.NumeMovie + " " + this.PathMovie + " " + this.AnMovie + "\n";

    }
}

