package org.sid.serviceclient.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@DiscriminatorValue("PAR")
@Data

@AllArgsConstructor @NoArgsConstructor


public class Client_Particulier extends Client {
    private int CIN;
    private Date  date_de_naissance ;
    private String lieu_de_naissance;
    private String profession;
    private String status ;



}
