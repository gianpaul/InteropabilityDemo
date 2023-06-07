package surgir.pe.myapplication.domain.mapper;

import java.util.ArrayList;
import java.util.List;
import surgir.pe.myapplication.data.remote.dto.character.ResponseDTO;
import surgir.pe.myapplication.data.remote.dto.character.Results;
import surgir.pe.myapplication.domain.entity.Character;

public class CharacterMapper {

    public Character toDomain(Results dto) {
        return new Character(dto.getImage(), dto.getGender(), dto.getSpecies(), dto.getName(), dto.getType());
    }

    public List<Character> toDomain(ResponseDTO responseDTO) {
        List<Character> characters = new ArrayList<>();
        for (Results dto : responseDTO.getResults()) {
            characters.add(toDomain(dto));
        }
        return characters;
    }
}
