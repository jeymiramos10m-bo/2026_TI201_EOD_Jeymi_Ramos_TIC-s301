package pkg2026_agosto_diciembre_eod_jeymi_jimena_ramos_martínez;

public class TestScoreBoard {

    public static void main(String[] args) {

        //ScoreBoard con espacio para 3 jugadores
        ScoreBoard sb = new ScoreBoard(3);

        // Agregamos jugadores
        sb.addGameEntry(new GameEntry("Ana", 100));
        sb.addGameEntry(new GameEntry("Pedro", 80));
        sb.addGameEntry(new GameEntry("Luis", 60));

        System.out.println("Tabla inicial:");
        sb.mostrar();

        //  prueva para agregar una puntuación mayor que la última
        System.out.println("\nAgregando a Juan con 90:");
        sb.addGameEntry(new GameEntry("Juan", 90));
        sb.mostrar();

        // prueva para agregar una puntuación menor que la última
        System.out.println("\nAgregando a Carlos con 50:");
        sb.addGameEntry(new GameEntry("Carlos", 50));
        sb.mostrar();

        // Mostramos el jugador con mayor puntuación
        System.out.println("\nJugador con mayor score:");
        System.out.println(sb.GetNumMaxScore());
    }
}