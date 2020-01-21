package cz.duzi.sfgpetclinic.repositories;

import cz.duzi.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
