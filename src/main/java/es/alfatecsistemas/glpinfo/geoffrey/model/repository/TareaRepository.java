package es.alfatecsistemas.glpinfo.geoffrey.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.alfatecsistemas.glpinfo.geoffrey.model.entity.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

}
