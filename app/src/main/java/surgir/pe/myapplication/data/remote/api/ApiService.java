package surgir.pe.myapplication.data.remote.api;

import retrofit2.Call;
import retrofit2.http.GET;
import surgir.pe.myapplication.data.remote.dto.character.ResponseDTO;

public interface ApiService {
    @GET("character")
    Call<ResponseDTO> getCharacters();
}
