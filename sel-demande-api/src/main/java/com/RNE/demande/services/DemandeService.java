package com.RNE.demande.services;

import java.util.List;
import com.RNE.demande.entities.Demande;


public interface DemandeService {

    Demande saveDemande(Demande demande);

    List<Demande> getAllDemandes();

    Demande getDemandeById(Long id);



    void deleteDemande(Long id);

}