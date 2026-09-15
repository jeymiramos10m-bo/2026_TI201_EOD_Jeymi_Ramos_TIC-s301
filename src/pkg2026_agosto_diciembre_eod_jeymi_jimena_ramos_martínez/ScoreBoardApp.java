package pkg2026_agosto_diciembre_eod_jeymi_jimena_ramos_martínez;
/*
 * FJMP-EDU
 * ITESS TIC´s
 * Estructura y Organizacion
 * Tema 1 fundamentos de estructuras de datos
 * 1.3 Estructura Lineal y no lineal
 * 1.4 Estructura
 *
 * compilador: javac ScoreBoardApp.java
 * test: java ScoreBoardApp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// ---------------------------------------------------------
// Clase GameEntry
// ---------------------------------------------------------
class GameEntry {

    private String name;
    private int score;

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "GameEntry " + name + ", " + score + "!";
    }
}


// ---------------------------------------------------------
// Clase ScoreBoard
// ---------------------------------------------------------
class ScoreBoard {

    private int numMax;
    private GameEntry[] score;
    private int numEntry = 0;

    public ScoreBoard(int numMax) {
        this.numMax = numMax;
        score = new GameEntry[numMax];
    }

    // Agregar una nueva entrada
    public void addGameEntry(GameEntry e) {

        // -------------------------------------------------
        // CASO 1: El arreglo todavía tiene espacio
        // -------------------------------------------------
        if (numEntry < numMax) {

            // Primero aumentamos el número de entradas
            numEntry++;

            // Posición donde vamos a insertar
            int i = numEntry - 1;

            // Movemos los elementos menores hacia la derecha
            while (i > 0 && score[i - 1].getScore() < e.getScore()) {
                score[i] = score[i - 1];
                i--;
            }

            // Insertamos el nuevo elemento
            score[i] = e;
        }

        // -------------------------------------------------
        // CASO 2: El arreglo está lleno
        // -------------------------------------------------
        else {

            // Si el nuevo score es menor o igual al último,
            // no se guarda y se ignora.
            if (e.getScore() <= score[numMax - 1].getScore()) {
                return;
            }

            // Si llegó aquí significa que el nuevo score
            // es mayor que el último.
            int i = numMax - 1;

            // Movemos los elementos menores hacia la derecha
            while (i > 0 && score[i - 1].getScore() < e.getScore()) {
                score[i] = score[i - 1];
                i--;
            }

            // Insertamos el nuevo elemento
            score[i] = e;
        }
    }

    // Regresa el nombre del jugador con mayor score
    public String GetNumMaxScore() {
        if (numEntry == 0) {
            return "No hay registros";
        }

        return score[0].getName();
    }

    // Mostrar todos los elementos del arreglo
    public void mostrar() {

        for (int i = 0; i < numEntry; i++) {
            System.out.println(
                (i + 1) + ". " +
                score[i].getName() + " - " +
                score[i].getScore()
            );
        }
    }
}


// ---------------------------------------------------------
// Clase principal
// ---------------------------------------------------------
public class ScoreBoardApp {

    ScoreBoard sb;
    FastReader reader = new FastReader();


    // -----------------------------------------------------
    // FastReader
    // -----------------------------------------------------
    static class FastReader {

        BufferedReader b;
        StringTokenizer s;

        public FastReader() {
            b = new BufferedReader(
                new InputStreamReader(System.in)
            );
        }

        String next() {

            while (s == null || !s.hasMoreElements()) {

                try {
                    s = new StringTokenizer(b.readLine());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return s.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        char nextChar() {
            return next().charAt(0);
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {

            String str = "";

            try {

                if (s != null && s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }
    }


    // -----------------------------------------------------
    // Leer datos
    // -----------------------------------------------------
    public void leerDatos() {

        int N = reader.nextInt();
        int m = reader.nextInt();

        sb = new ScoreBoard(N);

        for (int i = 0; i < m; i++) {

            String name = reader.next();
            int score = reader.nextInt();

            sb.addGameEntry(
                new GameEntry(name, score)
            );
        }
    }


    // -----------------------------------------------------
    // Resolver
    // -----------------------------------------------------
    public void resuelve() {

        System.out.println("Jugador con mayor score:");
        System.out.println(sb.GetNumMaxScore());

        System.out.println("\nScoreBoard:");
        sb.mostrar();
    }


    // -----------------------------------------------------
    // Main
    // -----------------------------------------------------
    public static void main(String[] args) {

        ScoreBoardApp id = new ScoreBoardApp();

        id.leerDatos();
        id.resuelve();
    }
}