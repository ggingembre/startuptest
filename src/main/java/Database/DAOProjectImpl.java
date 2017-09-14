package Database;

import Classes.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;


/**
 * Created by guillaume on 9/14/17.
 */
public class DAOProjectImpl implements DAOProject {


    @Override
    public void create(Project project) {

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();

        em.close();
        factory.close();

    }

    @Override
    public boolean update(int projectId, Project project) {
        boolean updated;

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        // get project to update
        Project updateProject = em.find(Project.class, projectId);

        updateProject.setProjectName(project.getProjectName());
        updateProject.setProjectDescription(project.getProjectDescription());
        updateProject.setProjectAddressId(project.getProjectAddressId());

        em.getTransaction().commit();

        em.close();
        factory.close();

        updated = true;

        return updated;
    }

    @Override
    public Project read(int projectId) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        // get customer to update
        Project result = em.find(Project.class, projectId);

        em.close();
        factory.close();

        return result;
    }

    @Override
    public boolean delete(int projectId) {
        boolean deleted = false;

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        // get project to update
        Project result = em.find(Project.class, projectId);

        if (result != null)
        {
            em.remove(result);
            em.getTransaction().commit();
            deleted = true;
        }

        em.close();
        factory.close();

        return deleted;
    }
}
