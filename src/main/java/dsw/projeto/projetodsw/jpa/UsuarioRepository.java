package dsw.projeto.projetodsw.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dsw.projeto.projetodsw.user.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByUsuario(String username);
}
