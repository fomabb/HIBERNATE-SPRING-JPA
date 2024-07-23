package org.iase24.com.repository;

import org.iase24.com.entity.Project;

import java.util.List;

public interface ProjectRepository {

    void add(Project project);

    List<Project> getAll();

    Project getById(Long id);

    void update(Project project);

    void remove(Project project);
}
