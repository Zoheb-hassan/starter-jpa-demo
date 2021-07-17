package com.home.tut.dao;

import javax.persistence.*;

@Entity
public class AccessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String organization;
    private String firmwareVersion;
    @OneToOne(mappedBy = "accessCard")
    private Employee cardOwnedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public Employee getCardOwnedBy() {
        return cardOwnedBy;
    }

    public void setCardOwnedBy(Employee cardOwnedBy) {
        this.cardOwnedBy = cardOwnedBy;
    }

    @Override
    public String toString() {
        return "AccessCard{" +
                "id=" + id +
                ", organization='" + organization + '\'' +
                ", firmwareVersion='" + firmwareVersion + '\'' +
                ", cardOwnedBy=" + cardOwnedBy +
                '}';
    }
}
