package tp4;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MatriceServer extends UnicastRemoteObject implements MatriceServerInterface {
    private static final long serialVersionUID = 1L;

public MatriceServer() throws RemoteException {
    super();
}

public static void main(String[] args) {
    try {
        MatriceServer server = new MatriceServer();
        Registry registry = LocateRegistry.createRegistry(1000);
        registry.bind("MatriceServer", server);
        System.out.println("Serveur prêt");
    } catch (Exception e) {
        System.err.println("Erreur: " + e.getMessage());
        e.printStackTrace();
    }
}


    @Override
    public boolean authenticate(Utilisateur user) throws RemoteException {
    // vérification de l'authentification de l'utilisateur
    return true;
}


    @Override
    public Matrice add(Matrice a, Matrice b) throws RemoteException {
    // addition de deux matrices
    return a.add(b);
}


    @Override
    public Matrice multiply(Matrice a, Matrice b) throws RemoteException {
    // multiplication de deux matrices
    return a.multiply(b);
}


    @Override
    public Matrice transpose(Matrice a) throws RemoteException {
    // transposition d'une matrice
    return a.transpose();
}

}