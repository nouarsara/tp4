
package tp4;

import java.io.Serializable;

public class Utilisateur implements Serializable {
    public String id;
    public String pass;

    public Utilisateur(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }
}
