package surgir.pe.myapplication.data.repository;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;

import javax.inject.Inject;

import surgir.pe.myapplication.data.remote.api.ApiService;
import surgir.pe.myapplication.di.AppExecutor;
import surgir.pe.myapplication.domain.entity.Character;
import surgir.pe.myapplication.domain.mapper.CharacterMapper;
import surgir.pe.myapplication.domain.repository.CharacterRepository;

public class CharacterRepositoryImpl implements CharacterRepository {
    private final ApiService apiService;
    private final CharacterMapper characterMapper;
    private final AppExecutor appExecutor;

    @Inject
    public CharacterRepositoryImpl(ApiService apiService, CharacterMapper characterMapper, AppExecutor appExecutor) {
        this.apiService = apiService;
        this.characterMapper = characterMapper;
        this.appExecutor = appExecutor;
    }

    @Override
    public List<Character> getCharacters() {
        final Future<List<Character>> handle =
                appExecutor.getNetworkIO().submit(() -> characterMapper.toDomain(Objects.requireNonNull(apiService.getCharacters().execute().body())));
        try {
            return handle.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
