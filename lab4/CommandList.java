package lab4;

public class CommandList extends Command {

    CommandList(Catalog catalog1) {
        super(catalog1);
    }
    @Override
    public void Citire(String[] parametru1)
    {
        this.catalog.list();
    }
}

