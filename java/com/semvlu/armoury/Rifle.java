package com.semvlu.armoury;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;


import java.util.Date;

@Entity
@Table(name = "rifle")
public class Rifle {
    @Id
    @Pattern(regexp = "\\d{6}", message = "ID must be exactly 6 digits")
    private String id;

    private Date mfg;
    private String owner;

    private boolean stock = true;
    private String stockCmnt;
    private boolean barrel = true;
    private String barrelCmnt;
    private boolean handle = true;
    private String handleCmnt;
    private boolean bolt = true;
    private String boltCmnt;

    private boolean bayonet;
    private boolean inInventory;

    public Rifle() {}

    public Rifle(String id, Date mfg, String owner, boolean stock, String stockCmnt,
                 boolean barrel, String barrelCmnt, boolean handle, String handleCmnt,
                 boolean bolt, String boltCmnt, boolean bayonet, boolean inInventory) {
        this.id = id;
        this.mfg = mfg;
        this.owner = owner;
        this.stock = stock;
        this.stockCmnt = stockCmnt;
        this.barrel = barrel;
        this.barrelCmnt = barrelCmnt;
        this.handle = handle;
        this.handleCmnt = handleCmnt;
        this.bolt = bolt;
        this.boltCmnt = boltCmnt;
        this.bayonet = bayonet;
        this.inInventory = inInventory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getMfg() {
        return mfg;
    }

    public void setMfg(Date mfg) {
        this.mfg = mfg;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public String getStockCmnt() {
        return stockCmnt;
    }

    public void setStockCmnt(String stockCmnt) {
        this.stockCmnt = stockCmnt;
    }

    public boolean isBarrel() {
        return barrel;
    }

    public void setBarrel(boolean barrel) {
        this.barrel = barrel;
    }

    public String getBarrelCmnt() {
        return barrelCmnt;
    }

    public void setBarrelCmnt(String barrelCmnt) {
        this.barrelCmnt = barrelCmnt;
    }

    public boolean isHandle() {
        return handle;
    }

    public void setHandle(boolean handle) {
        this.handle = handle;
    }

    public String getHandleCmnt() {
        return handleCmnt;
    }

    public void setHandleCmnt(String handleCmnt) {
        this.handleCmnt = handleCmnt;
    }

    public boolean isBolt() {
        return bolt;
    }

    public void setBolt(boolean bolt) {
        this.bolt = bolt;
    }

    public String getBoltCmnt() {
        return boltCmnt;
    }

    public void setBoltCmnt(String boltCmnt) {
        this.boltCmnt = boltCmnt;
    }

    public boolean isBayonet() {
        return bayonet;
    }

    public void setBayonet(boolean bayonet) {
        this.bayonet = bayonet;
    }

    public boolean isInInventory() {
        return inInventory;
    }

    public void setInInventory(boolean inInventory) {
        this.inInventory = inInventory;
    }

    @Override
    public String toString() {
        return "Rifle{" +
                "id='" + id + '\'' +
                ", mfg=" + mfg +
                ", owner='" + owner + '\'' +
                ", stock=" + stock +
                ", stockCmnt='" + stockCmnt + '\'' +
                ", barrel=" + barrel +
                ", barrelCmnt='" + barrelCmnt + '\'' +
                ", handle=" + handle +
                ", handleCmnt='" + handleCmnt + '\'' +
                ", bolt=" + bolt +
                ", boltCmnt='" + boltCmnt + '\'' +
                ", bayonet=" + bayonet +
                ", inInventory=" + inInventory +
                '}';
    }

    public String requireRepair() {
        String result = "Reparation required: ";
        if(this.stock == false)
            result += "Stock issue: " + this.stockCmnt + "    ";
        if (this.barrel == false)
            result += "Barrel issue: " + this.barrelCmnt + "    ";
        if (this.handle == false)
            result += "Handle issue: " + this.handleCmnt + "    ";
        if (this.bolt == false)
            result += "Bolt issue: " + this.boltCmnt + "    ";

        return result;
    }
}
