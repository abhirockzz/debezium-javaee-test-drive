
package com.wordpress.simplydistributed.debezium.domain.key;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "schema",
    "payload"
})
public class Key {

    @JsonProperty("schema")
    private Schema schema;
    @JsonProperty("payload")
    private Payload payload;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Key() {
    }

    /**
     * 
     * @param schema
     * @param payload
     */
    public Key(Schema schema, Payload payload) {
        super();
        this.schema = schema;
        this.payload = payload;
    }

    @JsonProperty("schema")
    public Schema getSchema() {
        return schema;
    }

    @JsonProperty("schema")
    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    @JsonProperty("payload")
    public Payload getPayload() {
        return payload;
    }

    @JsonProperty("payload")
    public void setPayload(Payload payload) {
        this.payload = payload;
    }

}
