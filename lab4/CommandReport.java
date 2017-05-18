package lab4;

public class CommandReport extends Command {

    CommandReport(Catalog catalog1) {
        super(catalog1);
    }

    @Override
    public void Citire(String[] parametru1) {
        this.catalog.reportHTML((parametru1[0]));
    }
}