package org.example.tp3guidetouristique_radiaoml.llm;

import dev.langchain4j.model.google.GoogleGeminiModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.ws.rs.core.Configuration;

@ApplicationScoped
public class GuideTouristiqueService {

    @Produces
    public GuideTouristique createGuideTouristique() {

        // Utilisez GoogleGeminiModel à la place de VertexAiGeminiModel
        GoogleGeminiModel model = GoogleGeminiModel.builder()
                .apiKey(System.getenv("GEMINI_API_KEY")) // La clé est lue ici
                .modelName("gemini-2.5-flash")
                .logRequests(true)
                .logResponses(true)
                .build();

        return AiServices.builder(GuideTouristique.class)
                .chatLanguageModel(model)
                .build();
    }
}
