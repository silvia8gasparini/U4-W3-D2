import java.time.LocalDate;
import java.util.Random;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        EventoDao dao = new EventoDao();

        Evento e1 = new Evento(
                "Festival del Cinema",
                LocalDate.of(2025, 9, 15),
                "Evento culturale con proiezioni internazionali",
                TipoEvento.PUBBLICO,
                300
        );

        try {
            dao.salva(e1);
        } catch (Exception e) {
            System.out.println("Errore durante il salvataggio: " + e.getMessage());
        }

        System.out.println(dao.getById(e1.getId()));

        dao.rimuovi(2L);
    }
}
