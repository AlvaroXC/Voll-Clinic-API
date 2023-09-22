package med.voll.api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//haremos todo el proceso de crud de la base de datos
public interface MedicoRepository extends JpaRepository<Medico, Long> {


    Page<Medico> findByActivoTrue(Pageable paginacion);
}