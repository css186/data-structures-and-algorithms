// Astronaut.java
package cse41321.examples.lesson4.setCovering;

import cse41321.containers.Set;
import cse41321.exceptions.DuplicateElementException;

public class Astronaut {
    private String name;

    private Set<Skill> skills = new Set<Skill>();

    public Astronaut(String name, Skill... skills)
            throws DuplicateElementException {
        this.name = name;
        for (Skill skill : skills) {
            this.skills.insert(skill);
        }
    }

    public String getName() {
        return name;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Astronaut))
            return false;

        Astronaut other = (Astronaut)o;

        return !(name != null ? !name.equals(other.name) : other.name != null);
    }
}
