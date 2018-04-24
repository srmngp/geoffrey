package es.alfatecsistemas.glpinfo.geoffrey.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.alfatecsistemas.glpinfo.geoffrey.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
