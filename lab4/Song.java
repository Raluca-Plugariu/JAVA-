package lab4;
/**
 * Created by RALUCAx2 on 3/13/2017.
 */


import java.lang.String;


public class Song extends AbstractClass {
    private String NumeSong;
    private String PathSong;
    private int AnSong;

    Song(String nume, String path, int an) {
        this.NumeSong = nume;
        this.PathSong = path;
        this.AnSong = an;
        
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
        return this.NumeSong + " " + this.PathSong + " " + this.AnSong + "\n";

    }
}
