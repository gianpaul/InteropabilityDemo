package surgir.pe.myapplication.domain.usecases;

import java.util.List;
import java.util.stream.Collectors;

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

    private List<Character> filtredCharacters(List<Character> characters){
        return characters.stream()
                .filter(s -> s.getName().startsWith("R"))
                .collect(Collectors.toList());

    }
}
