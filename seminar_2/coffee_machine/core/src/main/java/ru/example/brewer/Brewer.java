package ru.example.brewer;

import ru.example.model.Coffee;
import ru.example.model.Water;

public interface Brewer {
    Coffee brew(Water water);
}
