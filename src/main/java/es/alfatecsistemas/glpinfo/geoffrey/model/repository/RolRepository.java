package es.alfatecsistemas.glpinfo.geoffrey.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import es.alfatecsistemas.glpinfo.geoffrey.model.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
	
	@Query("select r from Rol r where r.nombre = :nombre")
	Rol buscarRolByNombre(@Param("nombre") String nombre);
	
}
