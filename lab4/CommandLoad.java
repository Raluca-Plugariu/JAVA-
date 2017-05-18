package lab4;

public class CommandLoad extends Command {

    CommandLoad(Catalog catalog1) {
        super(catalog1);
    }
    @Override
    public void Citire(String[] parametru1)
    {
        this.catalog.load(String.valueOf(Integer.parseInt(parametru1[0])));
    }
}
