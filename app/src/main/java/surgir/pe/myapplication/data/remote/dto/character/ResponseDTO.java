package surgir.pe.myapplication.data.remote.dto.character;

import androidx.annotation.NonNull;
import java.util.List;

public class ResponseDTO {
  private List<Results> results;
  private Info info;

  public ResponseDTO(List<Results> results, Info info) {
    this.results = results;
    this.info = info;
  }

  public List<Results> getResults() {
    return this.results;
  }

  public void setResults(List<Results> results) {
    this.results = results;
  }

  public Info getInfo() {
    return this.info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }

  @NonNull
  @Override
  public String toString() {
    return "ResponseDTO{" +
            "results=" + results +
            ", info=" + info +
            '}';
  }
}
