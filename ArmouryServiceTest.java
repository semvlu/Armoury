package com.semvlu.armoury;
import com.semvlu.armoury.Exception.NotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArmouryServiceTest {
    @Test
    void updateRifle() {
        Rifle r = new Rifle();
        assertNotNull(r);
        assertTrue(r.isStock());
        assertEquals(0, r.getStockCmnt().length());
    }

    @Test
    void deleteRifle() {
        ArmouryRepo armouryRepo = new ArmouryRepo();
        PersonRepo personRepo = new PersonRepo();
        ArmouryService armouryService = new ArmouryService(armouryRepo, personRepo);
        String rifleId = "955579";
        String ownerId = "123456";

        assertThrows(NotFoundException.class, () -> {
            armouryService.deleteRifle(rifleId, ownerId);
        });
    }
}

