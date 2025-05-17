package com.semvlu.armoury;

import com.semvlu.armoury.dto.RifleWithRepairInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ArmouryController {
    private final ArmouryService armouryService;
    public ArmouryController(ArmouryService armouryService) {
        this.armouryService = armouryService;
    }

    // CRUD: Create/POST
    @PostMapping("/rifles")
    public void addRifle(@RequestBody Rifle rifle) {
        armouryService.insertRifle(rifle);
    }

    @PostMapping("/persons")
    public void addPerson(@RequestBody Person person) {
        armouryService.insertPerson(person);
    }

    // CRUD: Read/GET
    @GetMapping(path = "/rifles/{rifleId}") // Routing
    // Request header to send ownerId for security
    public RifleWithRepairInfo getRifleById(@PathVariable String rifleId, @RequestHeader("X-Owner-Id") String ownerId) {
        return armouryService.getRifleById(rifleId, ownerId);
    }

    // get person info
    @GetMapping("/persons/{personId}")
    public Person getPersonById(@PathVariable String personId) {
        return armouryService.getPersonById(personId);
    }

    // CRUD: Update/PUT
    @PutMapping("/rifles/change-owner/{rifleId}")
    public void updateRifle(@PathVariable String rifleId, @RequestHeader("X-Owner-Id") String ownerId) {
        armouryService.updateRifleOwner(rifleId, ownerId);
    }

    @PutMapping("/rifles/components/{rifleId}")
    public void updateRifleComponentComments(@PathVariable String rifleId, @RequestHeader("X-Owner-Id") String ownerId, @RequestBody Rifle rifle) {
        armouryService.updateRifleComponent(rifleId, rifle.getStockCmnt(), rifle.getBarrelCmnt(), rifle.getHandleCmnt(), rifle.getBoltCmnt());
    }

    // CRUD: Delete/DELETE
    @DeleteMapping("/rifles/{rifleId}")
    public void deleteRifle(@PathVariable String rifleId, @RequestHeader("X-Owner-Id") String ownerId) {
        armouryService.deleteRifle(rifleId, ownerId);
    }

    @DeleteMapping("/persons/{personId}")
    public void deletePerson(@PathVariable String personId) {
        armouryService.deletePerson(personId);
    }

}
