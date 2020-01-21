package cz.duzi.sfgpetclinic.repositories;

import cz.duzi.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
