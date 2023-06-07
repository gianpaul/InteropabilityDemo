package surgir.pe.myapplication.domain.repository;

import java.util.List;
import surgir.pe.myapplication.domain.entity.Character;

public interface CharacterRepository {

    List<Character> getCharacters();
}
