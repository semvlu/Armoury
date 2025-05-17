package com.semvlu.armoury;

import com.semvlu.armoury.Exception.NotFoundException;
import com.semvlu.armoury.dto.RifleWithRepairInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ArmouryService {
    private final ArmouryRepo armouryRepo;
    private final PersonRepo personRepo;
    public ArmouryService(ArmouryRepo armouryRepo, PersonRepo personRepo) {
        this.armouryRepo = armouryRepo;
        this.personRepo = personRepo;
    }

    // CRUD Methods
    @Transactional
    public RifleWithRepairInfo getRifleById(String rifleId, String ownerId) {
        Optional<Rifle> rifleOpt = armouryRepo.findById(rifleId);
        if (rifleOpt.isPresent()) {
            Rifle rifle = rifleOpt.get();
            if (!rifle.getOwner().equals(ownerId))
                return null;
            rifle.setInInventory(false);
            String repairInfo = rifle.requireRepair();
            return new RifleWithRepairInfo(rifle, repairInfo);
        }
        return null;
    }
    /*
     In the context of JPA and most Spring Data repo, when calling sth e.g. repo.findById(id),
     the obj you get is NOT a copy, but the actual managed entity instance.
     However, it requires @Transactional or repo.save(entity) to update the DB.
     */

    public Person getPersonById(String personId) {
        return personRepo.findById(personId).orElseThrow(() -> new NotFoundException("Person not found" + personId));
    }


    public void insertRifle(Rifle rifle) {
        if (armouryRepo.findById(rifle.getId()).isEmpty())
            armouryRepo.save(rifle);
        else throw new IllegalStateException("Rifle already exists with ID: " + rifle.getId());;
    }

    public void insertPerson(Person person) {
        if (personRepo.findById(person.getId()).isEmpty())
            personRepo.save(person);
        else throw new IllegalStateException("Person already exists with ID: " + person.getId());;
    }

    @Transactional
    public void updateRifleOwner(String rifleId, String ownerId) {
        Rifle rifle = armouryRepo.findById(rifleId).orElse(null);
        if (rifle != null) {
            rifle.setOwner(ownerId);
            armouryRepo.save(rifle);
        }
    }

    @Transactional
    public void updateRifleComponent(String rifleId, String stockCmnt, String barrelCmnt, String handleCmnt, String boltCmnt) {
        Rifle rifle = armouryRepo.findById(rifleId).orElse(null);
        if (rifle != null) {

            if (stockCmnt != null && !stockCmnt.isBlank()){ // modifier exists
                rifle.setStock(false);
                if (rifle.getStockCmnt() == null || rifle.getStockCmnt().isBlank()) // original cmnt is empty
                    rifle.setStockCmnt(stockCmnt);
                else if (rifle.getStockCmnt() != null && !rifle.getStockCmnt().isBlank())
                    rifle.setStockCmnt(rifle.getStockCmnt() + "  " + stockCmnt);
            }


            if (barrelCmnt != null && !barrelCmnt.isBlank()){ // modifier exists
                rifle.setBarrel(false);
                if (rifle.getBarrelCmnt() == null || rifle.getBarrelCmnt().isBlank()) // original cmnt is empty
                    rifle.setBarrelCmnt(barrelCmnt);
                else if (rifle.getBarrelCmnt() != null && !rifle.getBarrelCmnt().isBlank())
                    rifle.setBarrelCmnt(rifle.getBarrelCmnt() + "  " + barrelCmnt);
            }

            if (handleCmnt != null && !handleCmnt.isBlank()){ // modifier exists
                rifle.setHandle(false);
                if (rifle.getHandleCmnt() == null || rifle.getHandleCmnt().isBlank()) // original cmnt is empty
                    rifle.setHandleCmnt(barrelCmnt);
                else if (rifle.getHandleCmnt() != null && !rifle.getHandleCmnt().isBlank())
                    rifle.setHandleCmnt(rifle.getHandleCmnt() + "  " + handleCmnt);
            }

            if (boltCmnt != null && !boltCmnt.isBlank()){ // modifier exists
                rifle.setBolt(false);
                if (rifle.getBoltCmnt() == null || rifle.getBoltCmnt().isBlank()) // original cmnt is empty
                    rifle.setBoltCmnt(barrelCmnt);
                else if (rifle.getBoltCmnt() != null && !rifle.getBoltCmnt().isBlank())
                    rifle.setBoltCmnt(rifle.getBoltCmnt() + "  " + boltCmnt);
            }


        }
    }

    public void deleteRifle(String rifleId, String ownerId) {
        if (!armouryRepo.findById(rifleId).get().getOwner().equals(ownerId))
            throw new NotFoundException("Rifle not found: " + rifleId);
        armouryRepo.deleteById(rifleId);
    }

    public void deletePerson(String personId) {
        if(!personRepo.findById(personId).isPresent())
            throw new NotFoundException("Person not found: " + personId);
        personRepo.deleteById(personId);
    }
}
