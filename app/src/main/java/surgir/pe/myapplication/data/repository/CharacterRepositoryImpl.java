package surgir.pe.myapplication.data.repository;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;
import javax.inject.Inject;

import kotlin.ranges.CharRange;
import surgir.pe.myapplication.data.local.dao.CharacterDao;
import surgir.pe.myapplication.data.local.entity.CharacterEntity;
import surgir.pe.myapplication.data.remote.api.ApiService;
import surgir.pe.myapplication.di.AppExecutor;
import surgir.pe.myapplication.domain.entity.Character;
import surgir.pe.myapplication.domain.mapper.CharacterMapper;
import surgir.pe.myapplication.domain.repository.CharacterRepository;

public class CharacterRepositoryImpl implements CharacterRepository {
    private final ApiService apiService;
    private final CharacterMapper characterMapper;
    private final AppExecutor appExecutor;
    private final CharacterDao characterDao;

    @Inject
    public CharacterRepositoryImpl(ApiService apiService, CharacterMapper characterMapper, AppExecutor appExecutor, CharacterDao characterDao) {
        this.apiService = apiService;
        this.characterMapper = characterMapper;
        this.appExecutor = appExecutor;
        this.characterDao = characterDao;
    }

    @Override
    public List<Character> getCharacters() {
        final Future<List<Character>> response =
                appExecutor.getNetworkIO().submit(() -> characterMapper.toDomain(Objects.requireNonNull(apiService.getCharacters().execute().body())));
        try {
            List<Character> characters = response.get();
            addLocalCharacters(characters);
            return characterMapper.toDomainFromEntity(Objects.requireNonNull(getLocalCharacters()));
        } catch (Exception e) {
            e.printStackTrace();
            return characterMapper.toDomainFromEntity(Objects.requireNonNull(getLocalCharacters()));
        }
    }

    private void addLocalCharacters(List<Character> characters){
        characterDao.deleteAll();
        characterDao.insertAll(characterMapper.toEntity(characters));
    }

    private List<CharacterEntity> getLocalCharacters() {
        try {
            return characterDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
