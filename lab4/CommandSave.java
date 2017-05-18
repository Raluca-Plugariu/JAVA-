package lab4;

public class CommandSave extends Command {

    CommandSave(Catalog catalog1) {
        super(catalog1);
    }
    @Override
    public void Citire(String[] parametru1)
    {
        this.catalog.save(String.valueOf(Integer.parseInt(parametru1[0])));
    }
}
