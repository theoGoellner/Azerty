package com.bourse.sessions;

import com.bourse.entities.Client;
import com.bourse.entities.Employe;
import com.bourse.entities.Entreprise;
import com.bourse.entities.Particulier;
import com.bourse.enumeration.EnumFormEntreprise;
import com.bourse.facades.ClientFacadeLocal;
import com.bourse.facades.EntrepriseFacadeLocal;
import com.bourse.facades.IdentificationFacadeLocal;
import com.bourse.facades.ParticulierFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BackOfficeSession implements BackOfficeSessionLocal {

    @EJB
    private ClientFacadeLocal clientFacade;

    @EJB
    private EntrepriseFacadeLocal entrepriseFacade;

    @EJB
    private ParticulierFacadeLocal particulierFacade;

    @EJB
    private IdentificationFacadeLocal identificationFacade;

    
    
    // GESTION DES CLIENTS

    @Override
    public Particulier creationParticulier(String nom, String prenom, Date dateNais, String lieuNais, String telephone, String email, String adresse, int niveau, Employe courtier) {
        return particulierFacade.creerParticulier(nom, prenom, dateNais, lieuNais, telephone, email, adresse, niveau, courtier);
    }

    @Override
    public Particulier rechercheParticulierParNomPrenom(String nom, String prenom) {
        return particulierFacade.rechercherParticulierParNomPrenom(nom, prenom);
    }
    
    @Override
    public void modificationParticulier(Particulier part, String nom, String prenom, Date dateNais, String lieuNais, String telephone, String email, String adresse, int niveau) {
        particulierFacade.modifierParticulier(part, nom, prenom, dateNais, lieuNais, telephone, email, adresse, niveau);
    }
    ///teste
    @Override
    public Entreprise creationEntreprise(String siret, String nomEntreprise, EnumFormEntreprise formeEntreprise, String contact, String tphContact, String telephone, String email, String adresse, int niveau, Employe courtier) {
        return entrepriseFacade.creerEntreprise(siret, nomEntreprise, formeEntreprise, contact, tphContact, telephone, email, adresse, niveau, courtier);
    }

    @Override
    public Entreprise rechercheEntrepriseParSIRET(String siret) {
        return entrepriseFacade.rechercherEntrepriseParSIRET(siret);
    }
    
    @Override
    public void modificationEntreprise(Entreprise entr, String siret, String nomEntreprise, EnumFormEntreprise formeEntreprise, String contact, String tphContact, String telephone, String email, String adresse, int niveau) {
        entrepriseFacade.modifierEntreprise(entr, siret, nomEntreprise, formeEntreprise, contact, tphContact, telephone, email, adresse, niveau);
    }
    
    @Override
    public List<Particulier> getListeParticuliersActifs() {
        return particulierFacade.getListeParticuliersActifs();
    }

    @Override
    public List<Entreprise> getListeEntreprisesActives() {
        return entrepriseFacade.getListeEntreprisesActives();
    }

    @Override
    public void archivageClient(Client client) {
        clientFacade.archiverClient(client);
        identificationFacade.archiverIdentification(identificationFacade.rechercherIdentParIDUserEtType(client.getId(), "Client"));
    }
    
    @Override
    public Client rechercheClientParID(Long idClient) {
        return clientFacade.rechercherClientParID(idClient);
    }

    @Override
    public List<Client> getListeClients() {
        return clientFacade.getListeClients();
    }

    

    
}
