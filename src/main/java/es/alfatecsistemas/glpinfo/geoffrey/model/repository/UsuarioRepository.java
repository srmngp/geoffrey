package es.alfatecsistemas.glpinfo.geoffrey.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.alfatecsistemas.glpinfo.geoffrey.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	@Query("select u from Usuario u where u.login = :login")
	Usuario buscarUsuarioByLogin(@Param("login") String login);
}
