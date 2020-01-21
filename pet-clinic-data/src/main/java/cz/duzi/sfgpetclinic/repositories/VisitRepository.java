package cz.duzi.sfgpetclinic.repositories;

import cz.duzi.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
