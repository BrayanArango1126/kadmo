package co.edu.ue.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.DatosUsuarios;
import co.edu.ue.entity.Usuarios;

public interface IDatoUsuarioJPA extends JpaRepository<DatosUsuarios, Integer> {

    DatosUsuarios findByUsuario(Usuarios usuario);
}
