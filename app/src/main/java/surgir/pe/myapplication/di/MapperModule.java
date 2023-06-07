package surgir.pe.myapplication.di;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import surgir.pe.myapplication.domain.mapper.CharacterMapper;

@Module
@InstallIn(SingletonComponent.class)
public class MapperModule {
    @Provides
    public CharacterMapper provideCharacterMapper() {
        return new CharacterMapper();
    }
}
