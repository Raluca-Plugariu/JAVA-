package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class CommandPlay extends Command {

    CommandPlay(Catalog catalog1) {
        super(catalog1);
    }

    @Override
    public void Citire(String[] parametru1)
    {
        this.catalog.play((parametru1[0]));
    }
}

