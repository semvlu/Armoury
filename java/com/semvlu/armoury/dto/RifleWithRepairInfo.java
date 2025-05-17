package com.semvlu.armoury.dto;
import com.semvlu.armoury.Rifle;

public record RifleWithRepairInfo(Rifle rifle, String repairInfo) {
    public Rifle getRifle() { return rifle; }
    public String getRepairInfo() { return repairInfo; }
}
