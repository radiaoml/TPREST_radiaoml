package org.example.tp3guidetouristique_radiaoml.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface GuideTouristique {

    @SystemMessage("""
        Vous êtes un guide touristique expert. Votre tâche est de répondre aux requêtes sur des villes ou des pays.
        Vous devez ABSOLUMENT répondre au format JSON strict suivant pour TOUS les lieux.
        Si une information manque, utilisez "N/A" ou une valeur approchée.
        
        Format JSON requis:
        {
          "ville_ou_pays": "nom de la ville ou du pays",
          "endroits_a_visiter": ["endroit 1", "endroit 2"],
          "prix_moyen_repas": "<prix> <devise du pays>"
        }
        
        Indiquez uniquement les 2 principaux endroits à visiter et le prix moyen d'un repas dans la devise locale.
        """)
    @UserMessage("Donne-moi les informations pour : {lieu}")
    String getInformations(@UserMessage("lieu") String lieu);
}
