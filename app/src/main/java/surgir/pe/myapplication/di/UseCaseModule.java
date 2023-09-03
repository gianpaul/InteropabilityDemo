package surgir.pe.myapplication.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import surgir.pe.myapplication.domain.usecases.FakeFetchCharacterUseCaselmpl;
import surgir.pe.myapplication.domain.usecases.FetchCharacterUseCaseImpl;
import surgir.pe.myapplication.presentation.usecases.FetchCharacterUseCase;

@Module
@InstallIn(SingletonComponent.class)
public class UseCaseModule {

    @Singleton
    @Provides
    public static FetchCharacterUseCase provideCharacterUseCase(FakeFetchCharacterUseCaselmpl characterUseCase) {
        return characterUseCase;
    }
}
