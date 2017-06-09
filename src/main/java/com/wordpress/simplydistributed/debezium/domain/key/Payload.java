
package com.wordpress.simplydistributed.debezium.domain.key;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id"
})
public class Payload {

    @JsonProperty("id")
    private Integer id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Payload() {
    }

    /**
     * 
     * @param id
     */
    public Payload(Integer id) {
        super();
        this.id = id;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Payload{" + "id=" + id + '}';
    }


}
