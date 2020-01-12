package cz.duzi.sfgpetclinic.services;

import cz.duzi.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);


}
