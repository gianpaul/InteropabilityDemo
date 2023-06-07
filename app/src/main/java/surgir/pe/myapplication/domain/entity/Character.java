package surgir.pe.myapplication.domain.entity;

import androidx.annotation.NonNull;

public class Character {
    private String image;
    private String gender;
    private String species;
    private String name;
    private String type;

    public Character(String image, String gender, String species, String name, String type) {
        this.image = image;
        this.gender = gender;
        this.species = species;
        this.name = name;
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @NonNull
    @Override
    public String toString() {
        return "Character{" +
                "image='" + image + '\'' +
                ", gender='" + gender + '\'' +
                ", species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
