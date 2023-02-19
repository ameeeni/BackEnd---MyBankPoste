package org.sid.serviceclient.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Component
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", length =4)
public  class  Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;
    private String nom;
    private String prénom;
    private String email;
    private String mot_de_passe;

}
