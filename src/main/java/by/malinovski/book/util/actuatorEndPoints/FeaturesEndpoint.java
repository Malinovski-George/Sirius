package by.malinovski.book.util.actuatorEndPoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "features") //   http://localhost:8080/actuator/features
public class FeaturesEndpoint {

  //    private Map<String, Feature> features = new ConcurrentHashMap<>();
  // ----------
  @ReadOperation
  public String features() {
    return "asd";
  }

  /*@ReadOperation
  public Feature feature(@Selector String name) {
      features.put("asd", new Feature());
      return features.get(name);
  }

  @WriteOperation
  public void configureFeature(@Selector String name, Feature feature) {
      features.put(name, feature);
  }

  @DeleteOperation
  public void deleteFeature(@Selector String name) {
      features.remove(name);
  }

  public static class Feature {
      private Boolean enabled;

      // [...] getters and setters

      public Boolean getEnabled() {
          return enabled;
      }

      public void setEnabled(Boolean enabled) {
          this.enabled = enabled;
      }
  }*/

}
