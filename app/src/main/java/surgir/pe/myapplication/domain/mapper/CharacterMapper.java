package surgir.pe.myapplication.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import surgir.pe.myapplication.data.local.entity.CharacterEntity;
import surgir.pe.myapplication.data.remote.dto.character.ResponseDTO;
import surgir.pe.myapplication.data.remote.dto.character.Results;
import surgir.pe.myapplication.domain.entity.Character;

public class CharacterMapper {

    private Character toDomain(Results dto) {
        return new Character(dto.getImage(), dto.getGender(), dto.getSpecies(), dto.getName(), dto.getType());
    }

    public List<Character> toDomain(ResponseDTO responseDTO) {
        List<Character> characters = new ArrayList<>();
        for (Results dto : responseDTO.getResults()) {
            characters.add(toDomain(dto));
        }
        return characters;
    }

    public List<CharacterEntity> toEntity(List<Character> characters){
        List<CharacterEntity> charactersEntities = new ArrayList<>();
        for (Character character: characters) {
            charactersEntities.add(toEntity(character));
        }
        return charactersEntities;
    }

    private CharacterEntity toEntity(Character character){
        return new CharacterEntity(character.getName(), character.getImage());
    }

    public List<Character> toDomainFromEntity(List<CharacterEntity> characterEntities){
        List<Character> characters = new ArrayList<>();
        for (CharacterEntity charactersEntities: characterEntities) {
            characters.add(toEntity(charactersEntities));
        }
        return characters;
    }

    private Character toEntity(CharacterEntity character){
        return new Character(character.getName(), character.getImage());
    }
}
