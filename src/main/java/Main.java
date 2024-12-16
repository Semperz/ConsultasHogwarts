import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.HousePoint;
import model.Person;


import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        //studentsByProfesor(99);

        bestStudent();
    }


    public static void studentsByProfesor (Integer idProfesor){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Query qr= em.createQuery("select p from Enrollment e JOIN e.personEnrollment p WHERE e.courseEnrollment.teacher.id = :idProfesor");
        qr.setParameter("idProfesor", idProfesor);
        List<Person> nombresAlumnos = qr.getResultList();
        int numAlumnos = 0;
        try {
            for (Person p : nombresAlumnos) {
                System.out.println(p.getFirstName());
                numAlumnos +=  1;
            }
            System.out.println("Numero de alumnos: " + numAlumnos);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }



    public static void bestStudent(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Query qr= em.createQuery("select hp.receiver.firstName from HousePoint hp group by hp.receiver order by sum(hp.points) desc LIMIT 1");
        String bestStudent = (String) qr.getSingleResult();
        try {
            System.out.println(bestStudent);

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
