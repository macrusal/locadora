package br.com.hibejix.locadora.repositories;

import br.com.hibejix.locadora.entities.Filme;
import br.com.hibejix.locadora.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
