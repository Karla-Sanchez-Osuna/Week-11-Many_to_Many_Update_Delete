package projects.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import projects.entity.Project;
import projects.dao.ProjectDao;
import projects.exception.DbException;

public class ProjectService {

	private ProjectDao ProjectDao = new ProjectDao();
	
	public Project addProject(Project project) {
		
		return ProjectDao.insertProject(project);
		
	}

	public List<Project> fetchAllProjects() {
		

		return ProjectDao.fetchAllProjects();
		// use if order by project name
//		.stream()
//		.sorted((p1, p2) -> p1.getProjectId() - p2.getProjectId())
//		.collect(Collectors.toList());
	}

	public Project fetchProjectByld(Integer projectId) {
	
		return ProjectDao.fetchProjectByld(projectId).orElseThrow(
				() -> new NoSuchElementException("Project with project ID=" + projectId + " does not exist."));
	}

	public void modifyProjectDetails(Project project) {
		if(!ProjectDao.modifyProjectDetails(project)) {
			throw new DbException("Project with ID =" + project.getProjectId() + " does not exist.");
		}
		
	}

	public void deleteProject(Integer projectId) {
		if(!ProjectDao.deleteProject(projectId)) {
			throw new DbException("Project with ID =" + projectId + " does not exist.");
		}
		
	}


}
