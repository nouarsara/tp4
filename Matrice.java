
package tp4;



   import java.io.Serializable;
import java.util.Random;

public class Matrice implements Serializable {
    private int n, m;
    private int[][] mat;

    public Matrice(int n, int m) {
        this.n = n;
        this.m = m;
        mat = new int[n][m];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = rand.nextInt(10);
            }
        }
    }

    public Matrice(int[][] mat) {
        this.n = mat.length;
        this.m = mat[0].length;
        this.mat = mat;
    }

    public int get(int i, int j) {
        return mat[i][j];
    }

    public void set(int i, int j, int val) {
        mat[i][j] = val;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public Matrice ajouter(Matrice other) {
        if (n != other.n || m != other.m) {
            throw new IllegalArgumentException("Les dimensions des matrices ne correspondent pas.");
        }
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = mat[i][j] + other.get(i, j);
            }
        }
        return new Matrice(result);
    }

    public Matrice multiplier(Matrice other) {
        if (m != other.n) {
            throw new IllegalArgumentException("Les dimensions des matrices ne correspondent pas.");
        }
        int[][] result = new int[n][other.m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < other.m; j++) {
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += mat[i][k] * other.get(k, j);
                }
                result[i][j] = sum;
            }
        }
        return new Matrice(result);
    }

    public Matrice transposer() {
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][i] = mat[i][j];
            }
        }
        return new Matrice(result);
    }

    Matrice add(Matrice b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Matrice multiply(Matrice b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Matrice transpose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

