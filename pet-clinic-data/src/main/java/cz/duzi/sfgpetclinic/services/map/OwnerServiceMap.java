package cz.duzi.sfgpetclinic.services.map;

import cz.duzi.sfgpetclinic.model.Owner;
import cz.duzi.sfgpetclinic.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }


    @Override
    public Owner findByLastName(String lastName) {
        // TODO: 13.01.2020  
        return null;
    }
}
