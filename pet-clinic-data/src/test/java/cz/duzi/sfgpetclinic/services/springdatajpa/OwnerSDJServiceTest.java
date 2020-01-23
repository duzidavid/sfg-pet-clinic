package cz.duzi.sfgpetclinic.services.springdatajpa;

import cz.duzi.sfgpetclinic.model.Owner;
import cz.duzi.sfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJServiceTest {

    private static final String LAST_NAME = "Smith";
    Owner returnOwner;

    @InjectMocks
    OwnerSDJService sdjService;

    @Mock
    OwnerRepository ownerRepository;


    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = sdjService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1L).build());
        returnOwnerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = sdjService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = sdjService.findById(1L);

        assertNotNull(owner);
        assertEquals(LAST_NAME, owner.getLastName());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = sdjService.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = sdjService.save(ownerToSave);

        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        sdjService.delete(returnOwner);

        // it the same as verify(ownerRepository).delete(any());
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        sdjService.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}