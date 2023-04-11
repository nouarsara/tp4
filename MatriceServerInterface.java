package tp4;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatriceServerInterface extends Remote {
    boolean authenticate(Utilisateur user) throws RemoteException;

Matrice add(Matrice a, Matrice b) throws RemoteException;

Matrice multiply(Matrice a, Matrice b) throws RemoteException;

Matrice transpose(Matrice a) throws RemoteException;

}