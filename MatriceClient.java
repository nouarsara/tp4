package tp4;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MatriceClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1000);
            MatriceServer server = (MatriceServer) registry.lookup("MatriceServer");

            Utilisateur user = new Utilisateur("username", "password");
            if (server.authenticate(user)) {
                Matrice a = new Matrice(3, 2);
                Matrice b = new Matrice(2, 3);
                Matrice c = server.add(a, b);
                Matrice d = server.multiply(a, b);
                Matrice e = server.transpose (a);
                System.out.println("Somme de deux matrices:");
                System.out.println(c);
                System.out.println("Multiplication de deux matrices:");
                System.out.println(d);
                System.out.println("Transposée d'une matrice:");
                System.out.println(e);
            } else {
                System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
            }
        } catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
