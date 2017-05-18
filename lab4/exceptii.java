package lab4;

import java.lang.Exception;
public class exceptii extends Exception {

    void spatiu(String mesaj) {
        if(mesaj != "list" )
            System.out.println("Introduceti date valide");
    }

   /* public exceptii (Throwable cause) {
        super (cause);
    }

    public exceptii (String message, Throwable cause) {
        super (message, cause);
    }*/
}