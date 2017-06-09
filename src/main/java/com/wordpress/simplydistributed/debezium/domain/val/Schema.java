
package com.wordpress.simplydistributed.debezium.domain.val;

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
    "version"
})
public class Schema {

    @JsonProperty("type")
    private String type;
    @JsonProperty("fields")
    private List<Field> fields = null;
    @JsonProperty("optional")
    private Boolean optional;
    @JsonProperty("name")
    private String name;
    @JsonProperty("version")
    private Integer version;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Schema() {
    }

    /**
     * 
     * @param name
     * @param optional
     * @param type
     * @param version
     * @param fields
     */
    public Schema(String type, List<Field> fields, Boolean optional, String name, Integer version) {
        super();
        this.type = type;
        this.fields = fields;
        this.optional = optional;
        this.name = name;
        this.version = version;
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
    public List<Field> getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(List<Field> fields) {
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

    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
    }

}
