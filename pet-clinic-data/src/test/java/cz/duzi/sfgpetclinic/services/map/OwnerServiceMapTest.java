package cz.duzi.sfgpetclinic.services.map;

import cz.duzi.sfgpetclinic.model.Owner;
import cz.duzi.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    final Long ownerId = 1L;
    final String lastName = "Novak";
    private OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        ownerServiceMap.save(Owner.builder().lastName(lastName).id(ownerId).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(ownerId, owners.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        final Long id = 2L;
        Owner owner1 = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner1);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = Owner.builder().build();
        Owner savedOwner = ownerServiceMap.save(owner);

        assertEquals(2L, savedOwner.getId());
    }

    @Test
    void saveNoObject() {
        Owner savedOwner = ownerServiceMap.save(null);

        assertNull(savedOwner);
    }

    @Test
    void saveObjectWithNoPetType() {
        Set<Pet> pets = new HashSet<>();
        pets.add(Pet.builder().petType(null).build());
        Owner owner = Owner.builder().pets(pets).build();

        assertThrows(RuntimeException.class, () -> ownerServiceMap.save(owner));
    }

    @Test
    void findByLastName() {
        Owner novak = ownerServiceMap.findByLastName(lastName);

        assertNotNull(novak);

        assertEquals(ownerId, novak.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner missing = ownerServiceMap.findByLastName("missing");

        assertNull(missing);
    }
}