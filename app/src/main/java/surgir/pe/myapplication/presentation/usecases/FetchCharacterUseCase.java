package surgir.pe.myapplication.presentation.usecases;

import java.util.List;
import surgir.pe.myapplication.domain.entity.Character;

public interface FetchCharacterUseCase {

    List<Character> execute();
}
