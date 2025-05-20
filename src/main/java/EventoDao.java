import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventoDao{
    private EntityManager em;

    public EventoDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    public void salva(Evento evento){
        em.getTransaction().begin();

        em.persist(evento);

        em.getTransaction().commit();

    }

    public Evento getById(Long id){
        return em.find(Evento.class,id);
    }
    public void rimuovi(Long id){
        Evento e = getById(id);

        if(e!=null){
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        }
        else{
            System.out.println("Evento con id " + id + " non trovato");
        }
    }

}
