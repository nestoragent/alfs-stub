package com.nestor.logic;

/**
 * Created by sbt-velichko-aa on 17.03.17.
 */
public final class Sessions {

    private int session_id;
    private String publicAddress;
    private String serverId;
    private String nodeName;
    private long createdTime;
    private long deleteTime;

    public Sessions(){}

    public int getId() {
        return session_id;
    }

    public Sessions setId(int session_id) {
        this.session_id = session_id;
        return this;
    }

    public String getPublicAddress() {
        return publicAddress;
    }

    public Sessions setPublicAddress(String publicAddress) {
        this.publicAddress = publicAddress;
        return this;
    }

    public String getServerId() {
        return serverId;
    }

    public Sessions setServerId(String serverId) {
        this.serverId = serverId;
        return this;
    }

    public String getNodeName() {
        return nodeName;
    }

    public Sessions setNodeName(String nodeName) {
        this.nodeName = nodeName;
        return this;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public Sessions setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public long getDeleteTime() {
        return deleteTime;
    }

    public Sessions setDeleteTime(long deleteTime) {
        this.deleteTime = deleteTime;
        return this;
    }

    @Override
    public String toString() {
        return "Sessions{" +
                "session_id=" + session_id +
                ", publicAddress='" + publicAddress + '\'' +
                ", serverId='" + serverId + '\'' +
                ", nodeName='" + nodeName + '\'' +
                ", createdTime=" + createdTime +
                ", deleteTime=" + deleteTime +
                '}';
    }
}
