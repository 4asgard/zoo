package org.example;

public enum Country {
    POLAND("Europe", "Polish", "616"),
    AUSTRALIA("Australia","Australian english","036"),
    EGYPT("Afrika","Arabic", "818"),
    INDIA("Asia", "Hindi", "356"),
    USA("North America", "American english", "840");

    final String continent;
    final String language;
    final String countryCode;

    Country(String continent, String language, String countryCode) {
        this.continent = continent;
        this.language = language;
        this.countryCode = countryCode;
    }
}