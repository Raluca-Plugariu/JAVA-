package lab4;
/**
 * Created by RALUCAx2 on 3/13/2017.
 */
import java.io.Serializable;

public abstract class AbstractClass implements InterfataCatalog, Serializable{
    @Override
    public abstract double add() ;
    @Override
    public abstract double list() ;
    @Override
    public abstract double play() ;
    @Override
    public abstract double save() ;
    @Override
    public abstract double load() ;
}
