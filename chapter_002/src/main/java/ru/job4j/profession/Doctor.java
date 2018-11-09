package ru.job4j.profession;

import ru.job4j.profession.models.Diagnose;
import ru.job4j.profession.models.Pacient;

public class Doctor extends Profession {
    public Doctor (String name) {
        this.name = name;
    }

    public Diagnose heal(Pacient pacient) {

    }
}
