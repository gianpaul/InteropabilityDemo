package surgir.pe.myapplication.domain.usecases;

import java.util.List;
import javax.inject.Inject;
import surgir.pe.myapplication.domain.entity.Character;
import surgir.pe.myapplication.domain.repository.CharacterRepository;
import surgir.pe.myapplication.presentation.usecases.FetchCharacterUseCase;

public class FetchCharacterUseCaseImpl implements FetchCharacterUseCase {
    private final CharacterRepository characterRepository;

    @Inject
    public FetchCharacterUseCaseImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<Character> execute(){
        return characterRepository.getCharacters();
    }
}
