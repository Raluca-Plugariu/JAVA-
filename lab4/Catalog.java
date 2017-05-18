package lab4;


import java.io.File;
import java.io.*;
import java.awt.Desktop;
import java.lang.String;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.OutputStream;
import static java.awt.Desktop.getDesktop;
import static java.lang.System.exit;
import java.lang.Exception;
import java.util.Scanner;
import java.io.IOException;
public class Catalog
{
    private File Path;
    private ArrayList<AbstractClass> lista ;

    Catalog (){
        this.Path=null;
        this.lista=new ArrayList<AbstractClass>();
    }
    void  add(AbstractClass obiect)
    {
        this.lista.add(obiect);
    }
    void list()
    {
        System.out.println(this.lista);
    }
    void play (String muzica)
    {
        File f1 = null;
        try {
            f1 = new File(muzica);
            Desktop desc = getDesktop();
            desc.open(f1);
        } catch (FileNotFoundException e) {
            System.err.println("Fisierul " + f1 + "nu a fost gasit!");
        } catch (IOException err) {
            System.out.println("Eroare la citire");
            err.printStackTrace();
        }
    }
    void save(String nume)
    {

        try {
            OutputStream out = new FileOutputStream(nume);
            ObjectOutputStream out2 = new ObjectOutputStream(out);
            out2.writeObject(lista);
            out.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("Fisierul " + this.lista + "nu a fost gasit!");
        } catch (IOException err) {
            System.out.println("Eroare la citire");
            err.printStackTrace();
        }
    }
    void load(String nume)
    {
       try {
           FileInputStream fis = new FileInputStream(nume);
            ObjectInputStream in = new ObjectInputStream(fis);

           lista = (ArrayList<AbstractClass>) in.readObject();

           fis.close();
       } catch (FileNotFoundException e) {
           System.out.println(" " + e);

       } catch (IOException e) {
           System.out.println(" " + e);
       }catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
       catch (ClassCastException e ) {
           e.printStackTrace();
       }
       System.out.println();
    }

     void reportHTML(String fisierHTML)
    {
        File htmlFile = null;
        try{
            //bagare
            BufferedWriter bw = new BufferedWriter(new FileWriter(fisierHTML));
            bw.write(String.valueOf(lista));
            bw.close();
            //afisare
            htmlFile = new File(fisierHTML);
            Desktop desc = getDesktop();
            desc.open(htmlFile);

        }
        catch (IOException e) {
            System.out.println(" " + e);
        } catch (ClassCastException e ) {
            e.printStackTrace();
        }
    }
    public String toString()
    {

        String line = null;
        int i;
        for(i=0; i<this.lista.size(); i++)
        {
            line = String.valueOf(this.lista.get(i));
            System.out.println(line);
        }
        return null;
    }
    public static void main (String argc[]) {

        Catalog catalog = new Catalog();
        Command add=new CommandAdd(catalog);
        Command save=new CommandSave(catalog);
        Command load=new CommandLoad(catalog);
        Command list=new CommandList(catalog);
        Command play=new CommandPlay(catalog);
        Command report =new CommandReport(catalog);

        //catalog.play("C:\\Users\\raresarv\\Desktop\\YAVA\\PA_lab4\\src\\Proiect\\melodii\\ACDC---Shoot-To-Thrill.mp3");
      
       String[] parametru;

      
        while(true) {
            Scanner read = new Scanner((System.in));
			String sir = read.nextLine();
			parametru = new String [sir.split(" ").length-1];
			for (int i=1;i<sir.split(" ").length;i++)
			    parametru[i-1] = sir.split(" ")[i];

			switch (sir.split(" ")[0]) {
			    case "add": {
			        if(parametru[0].equals("Song")) {
			            Song muz = new Song(parametru[1], parametru[2], Integer.parseInt(parametru[3]));
			            catalog.add(muz);
			        }
			        if(parametru[0].equals("Movie")) {
			            Movie moz = new Movie(parametru[1], parametru[2], Integer.parseInt(parametru[3]));
			            catalog.add(moz);
			        }
			        break;
			    }
			    case "play": {
			        play.Citire(parametru);
			        break;
			    }
			    case "save": {
			        save.Citire(parametru);
			        break;
			    }
			    case "load": {
			        load.Citire(parametru);
			        break;
			    }
			    case "list": {
			        list.Citire(parametru);
			        break;
			    }
			    case "report": {
			        report.Citire(parametru);//"C:\\Users\\raresarv\\Desktop\\YAVA\\PA_lab4\\src\\Proiect\\lista\\da.html"
			        break;
			    }
			    case "exit": {
			        exit(0);
			    }
			}
        }
    }
}
