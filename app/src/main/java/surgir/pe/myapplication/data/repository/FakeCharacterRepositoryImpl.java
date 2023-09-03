package surgir.pe.myapplication.data.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import surgir.pe.myapplication.data.remote.api.ApiService;
import surgir.pe.myapplication.di.AppExecutor;
import surgir.pe.myapplication.domain.entity.Character;
import surgir.pe.myapplication.domain.mapper.CharacterMapper;
import surgir.pe.myapplication.domain.repository.CharacterRepository;

public class FakeCharacterRepositoryImpl implements CharacterRepository {
    private final ApiService apiService;
    private final CharacterMapper characterMapper;
    private final AppExecutor appExecutor;

    @Inject
    public FakeCharacterRepositoryImpl(ApiService apiService, CharacterMapper characterMapper, AppExecutor appExecutor) {
        this.apiService = apiService;
        this.characterMapper = characterMapper;
        this.appExecutor = appExecutor;
    }

    @Override
    public List<Character> getCharacters() {
        List<Character> list = new ArrayList<>();
        list.add(new Character("url","hombre","deybi","jordan","1"));
        list.add(new Character("url","hombre","deybi","jordan","1"));
        list.add(new Character("url","hombre","deybi","jordan","1"));
        list.add(new Character("url","hombre","deybi","jordan","1"));
        list.add(new Character("url","hombre","deybi","jordan","1"));
        list.add(new Character("url","hombre","deybi","jordan","1"));
        list.add(new Character("url","hombre","deybi","jordan","1"));
        list.add(new Character("url","hombre","deybi","jordan","1"));
        list.add(new Character("url","hombre","deybi","jordan","1"));
        return list;
    }
}
