
package com.wordpress.abhirockzz.kafEEne.concurrency.utils.domain.val;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "fields",
    "optional",
    "name",
    "field"
})
public class Field {

    @JsonProperty("type")
    private String type;
    @JsonProperty("fields")
    private List<Field_> fields = null;
    @JsonProperty("optional")
    private Boolean optional;
    @JsonProperty("name")
    private String name;
    @JsonProperty("field")
    private String field;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Field() {
    }

    /**
     * 
     * @param field
     * @param name
     * @param optional
     * @param type
     * @param fields
     */
    public Field(String type, List<Field_> fields, Boolean optional, String name, String field) {
        super();
        this.type = type;
        this.fields = fields;
        this.optional = optional;
        this.name = name;
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

    @JsonProperty("fields")
    public List<Field_> getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(List<Field_> fields) {
        this.fields = fields;
    }

    @JsonProperty("optional")
    public Boolean getOptional() {
        return optional;
    }

    @JsonProperty("optional")
    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
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
