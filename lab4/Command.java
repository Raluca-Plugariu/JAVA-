package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public  abstract class Command {
    public Catalog catalog;

    Command(Catalog catalog1)
    {
        this.catalog=catalog1;
    }
    public abstract void Citire(String[] parametru1);
}
