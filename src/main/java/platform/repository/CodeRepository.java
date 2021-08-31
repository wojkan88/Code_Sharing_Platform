package platform.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.model.Code;

import java.util.Optional;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {

    Optional<Code> findByUuid(String uuid);
}