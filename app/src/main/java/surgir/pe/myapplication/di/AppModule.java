package surgir.pe.myapplication.di;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import surgir.pe.myapplication.data.local.AppDatabase;
import surgir.pe.myapplication.data.local.dao.CharacterDao;
import surgir.pe.myapplication.data.remote.api.ApiService;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public static ApiService provideApiService() {
        return new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
    }

    @Provides
    @Singleton
    public static AppDatabase provideAppDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "database").build();
    }

    @Provides
    public static CharacterDao provideCharacterDao(AppDatabase database) {
        return database.characterDao();
    }
}
