package org.iase24.com.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.iase24.com.entity.Project;
import org.iase24.com.repository.ProjectRepository;
import org.iase24.com.util.SessionUtil;

import java.util.List;

public class ProjectServiceImpl extends SessionUtil implements ProjectRepository {

    public void add(Project project) {
        openTransactionSession();

        Session session = getSession();
        session.save(project);
        closeTransactionSession();
    }

    public List<Project> getAll() {
        openTransactionSession();

        Session session = getSession();
        String sql = "SELECT * FROM project";
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        List<Project> projects = query.list();
        closeTransactionSession();

        return projects;
    }

    public Project getById(Long id) {
        openTransactionSession();

        Session session = getSession();
        String sql = "SELECT * FROM project WHERE id=:id";
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter("id", id);
        Project project = (Project) query.getSingleResult();
        closeTransactionSession();

        return project;
    }

    public void update(Project project) {
        openTransactionSession();

        Session session = getSession();
        session.update(project);
        closeTransactionSession();
    }

    public void remove(Project project) {
        openTransactionSession();

        Session session = getSession();
        session.remove(project);
        closeTransactionSession();
    }
}
