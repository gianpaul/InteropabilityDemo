package surgir.pe.myapplication.data.remote.dto.character;

import androidx.annotation.NonNull;
import java.util.List;

public class Results {
    private String image;
    private String gender;
    private String species;
    private String created;
    private Origin origin;
    private String name;
    private Origin location;
    private List<String> episode;
    private Integer id;
    private String type;
    private String url;
    private String status;


    public Results(String image, String gender, String species, String created, Origin origin, String name, Origin location, List<String> episode, Integer id, String type, String url, String status) {
        this.image = image;
        this.gender = gender;
        this.species = species;
        this.created = created;
        this.origin = origin;
        this.name = name;
        this.location = location;
        this.episode = episode;
        this.id = id;
        this.type = type;
        this.url = url;
        this.status = status;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Origin getOrigin() {
        return this.origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Origin getLocation() {
        return this.location;
    }

    public void setLocation(Origin location) {
        this.location = location;
    }

    public List<String> getEpisode() {
        return this.episode;
    }

    public void setEpisode(List<String> episode) {
        this.episode = episode;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NonNull
    @Override
    public String toString() {
        return "Results{" +
                "image='" + image + '\'' +
                ", gender='" + gender + '\'' +
                ", species='" + species + '\'' +
                ", created='" + created + '\'' +
                ", origin=" + origin +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", episode=" + episode +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
