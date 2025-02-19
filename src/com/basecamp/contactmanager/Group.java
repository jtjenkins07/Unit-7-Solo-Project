package com.basecamp.contactmanager;

public class Group {
    private int groupId;
    private String name;

    public Group(int groupId, String name){
        this.groupId = groupId;
        this.name = name;
    }

    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", name='" + name + '\'' +
                '}';
    }
}

