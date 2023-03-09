package ru.example.featureswitcher.model;

import lombok.Data;

@Data
public class FeatureToggle {
    private String name;
    private String value;
    private FeatureToggleType type;
}
