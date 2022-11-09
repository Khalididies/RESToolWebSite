package APIObjectModel.APIExtrasObject;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "page",
        "limit",
        "total",
        "items"
})

public class RequestExtras {
    @JsonProperty("page")
    public Integer page;
    @JsonProperty("limit")
    public Integer limit;
    @JsonProperty("total")
    public Integer total;
    @JsonProperty("items")
    public List<APIObjectModel.APIExtrasObject.ExtrasItem> ExtrasItem = null;
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
