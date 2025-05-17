package com.semvlu.armoury;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmouryRepo extends JpaRepository<Rifle, String> {
}
