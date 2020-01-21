package cz.duzi.sfgpetclinic.repositories;

import cz.duzi.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
