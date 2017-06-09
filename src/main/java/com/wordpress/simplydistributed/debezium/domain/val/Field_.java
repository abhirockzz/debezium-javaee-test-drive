
package com.wordpress.simplydistributed.debezium.domain.val;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "optional",
    "field"
})
public class Field_ {

    @JsonProperty("type")
    private String type;
    @JsonProperty("optional")
    private Boolean optional;
    @JsonProperty("field")
    private String field;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Field_() {
    }

    /**
     * 
     * @param field
     * @param optional
     * @param type
     */
    public Field_(String type, Boolean optional, String field) {
        super();
        this.type = type;
        this.optional = optional;
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

    @JsonProperty("field")
    public String getField() {
        return field;
    }

    @JsonProperty("field")
    public void setField(String field) {
        this.field = field;
    }

}
