package trelloApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class List {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("idBoard")
    private String idBoard;

    public void setId(final String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }

    public void setName(final String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setIdBoard(final String idBoard){
        this.idBoard = idBoard;
    }
    public String getIdBoard(){
        return idBoard;
    }
}
