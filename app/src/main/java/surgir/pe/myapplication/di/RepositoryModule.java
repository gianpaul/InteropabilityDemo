package surgir.pe.myapplication.di;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import surgir.pe.myapplication.data.repository.CharacterRepositoryImpl;
import surgir.pe.myapplication.domain.repository.CharacterRepository;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Provides
    public static CharacterRepository provideCharacterRepository(CharacterRepositoryImpl characterRepository) {
        return characterRepository;
    }
}
