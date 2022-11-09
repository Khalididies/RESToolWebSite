package APIObjectModel.APICharacterObject;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "thumbnail",
        "name",
        "realName",
        "location",
        "isAlive",
        "numberTest"
})

public class CharacterItem {

        @JsonProperty("id")
        public String id;
        @JsonProperty("thumbnail")
        public String thumbnail;
        @JsonProperty("name")
        public String name;
        @JsonProperty("realName")
        public String realName;
        @JsonProperty("location")
        public String location;
        @JsonProperty("isAlive")
        public Boolean isAlive;
        @JsonProperty("numberTest")
        public Integer numberTest;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

}


