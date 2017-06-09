
package com.wordpress.simplydistributed.debezium.domain.key;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "field",
    "type",
    "optional"
})
public class Field {

    @JsonProperty("field")
    private String field;
    @JsonProperty("type")
    private String type;
    @JsonProperty("optional")
    private Boolean optional;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Field() {
    }

    /**
     * 
     * @param field
     * @param optional
     * @param type
     */
    public Field(String field, String type, Boolean optional) {
        super();
        this.field = field;
        this.type = type;
        this.optional = optional;
    }

    @JsonProperty("field")
    public String getField() {
        return field;
    }

    @JsonProperty("field")
    public void setField(String field) {
        this.field = field;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("optional")
    public Boolean getOptional() {
        return optional;
    }

    @JsonProperty("optional")
    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

}
