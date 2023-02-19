package org.sid.serviceclient.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("PRO")
@AllArgsConstructor @NoArgsConstructor
public class Client_Professionnel extends Client{
    private String raison_Social;
    private String matricule_fiscal;
    private int num_registre_commerce;
}