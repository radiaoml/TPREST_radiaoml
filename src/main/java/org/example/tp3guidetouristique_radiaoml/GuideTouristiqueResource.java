package org.example.tp3guidetouristique_radiaoml;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

// Définit le chemin de base de cette ressource : /api/guide
@Path("/guide")
public class GuideTouristiqueResource {

    /**
     * Endpoint : /api/guide/lieu/{ville_ou_pays}
     * Retourne une liste de String (qui sera convertie en tableau JSON).
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLieuxAVisiter(@PathParam("ville_ou_pays") String lieu) {

        // Simuler la logique : Retourner un tableau de String
        List<String> lieux;

        if ("Maroc".equalsIgnoreCase(lieu)) {
            lieux = Arrays.asList("Marrakech (Medina)", "Désert du Sahara");
        } else if ("Paris".equalsIgnoreCase(lieu)) {
            lieux = Arrays.asList("Tour Eiffel", "Musée du Louvre");
        } else {
            // Cas de test pour vérifier la sérialisation et le paramètre
            lieux = Arrays.asList("Lieu non référencé pour l'exemple", "Paramètre reçu : " + lieu);
        }

        // Retourne un statut 200 OK avec le corps JSON.
        return Response.ok(lieux).build();
    }
}