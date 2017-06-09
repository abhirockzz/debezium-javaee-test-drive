
package com.wordpress.simplydistributed.debezium.domain.val;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "server_id",
    "ts_sec",
    "gtid",
    "file",
    "pos",
    "row",
    "snapshot",
    "thread",
    "db",
    "table"
})
public class Source {

    @JsonProperty("name")
    private String name;
    @JsonProperty("server_id")
    private Integer serverId;
    @JsonProperty("ts_sec")
    private Integer tsSec;
    @JsonProperty("gtid")
    private Object gtid;
    @JsonProperty("file")
    private String file;
    @JsonProperty("pos")
    private Integer pos;
    @JsonProperty("row")
    private Integer row;
    @JsonProperty("snapshot")
    private Object snapshot;
    @JsonProperty("thread")
    private Integer thread;
    @JsonProperty("db")
    private String db;
    @JsonProperty("table")
    private String table;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Source() {
    }

    /**
     * 
     * @param db
     * @param tsSec
     * @param snapshot
     * @param file
     * @param thread
     * @param name
     * @param table
     * @param serverId
     * @param gtid
     * @param row
     * @param pos
     */
    public Source(String name, Integer serverId, Integer tsSec, Object gtid, String file, Integer pos, Integer row, Object snapshot, Integer thread, String db, String table) {
        super();
        this.name = name;
        this.serverId = serverId;
        this.tsSec = tsSec;
        this.gtid = gtid;
        this.file = file;
        this.pos = pos;
        this.row = row;
        this.snapshot = snapshot;
        this.thread = thread;
        this.db = db;
        this.table = table;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("server_id")
    public Integer getServerId() {
        return serverId;
    }

    @JsonProperty("server_id")
    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    @JsonProperty("ts_sec")
    public Integer getTsSec() {
        return tsSec;
    }

    @JsonProperty("ts_sec")
    public void setTsSec(Integer tsSec) {
        this.tsSec = tsSec;
    }

    @JsonProperty("gtid")
    public Object getGtid() {
        return gtid;
    }

    @JsonProperty("gtid")
    public void setGtid(Object gtid) {
        this.gtid = gtid;
    }

    @JsonProperty("file")
    public String getFile() {
        return file;
    }

    @JsonProperty("file")
    public void setFile(String file) {
        this.file = file;
    }

    @JsonProperty("pos")
    public Integer getPos() {
        return pos;
    }

    @JsonProperty("pos")
    public void setPos(Integer pos) {
        this.pos = pos;
    }

    @JsonProperty("row")
    public Integer getRow() {
        return row;
    }

    @JsonProperty("row")
    public void setRow(Integer row) {
        this.row = row;
    }

    @JsonProperty("snapshot")
    public Object getSnapshot() {
        return snapshot;
    }

    @JsonProperty("snapshot")
    public void setSnapshot(Object snapshot) {
        this.snapshot = snapshot;
    }

    @JsonProperty("thread")
    public Integer getThread() {
        return thread;
    }

    @JsonProperty("thread")
    public void setThread(Integer thread) {
        this.thread = thread;
    }

    @JsonProperty("db")
    public String getDb() {
        return db;
    }

    @JsonProperty("db")
    public void setDb(String db) {
        this.db = db;
    }

    @JsonProperty("table")
    public String getTable() {
        return table;
    }

    @JsonProperty("table")
    public void setTable(String table) {
        this.table = table;
    }

}
