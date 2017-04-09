package com.github.sawied.persistent.domain;

public class SearchAuditResponse {
    
    private Long id =null;
    
    private String name=null;
    
    private Integer duration=null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    
    

}
