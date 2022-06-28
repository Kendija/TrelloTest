package trelloApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Board {
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;

    public void setName(final String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setId(final String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
}
