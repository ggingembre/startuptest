package Database;

import Classes.Project;

/**
 * Created by guillaume on 9/14/17.
 */
public interface DAOProject {

    void create(Project project);
    boolean update (int projectId, Project project);
    Project read(int projectId);
    boolean delete(int projectId);

}
