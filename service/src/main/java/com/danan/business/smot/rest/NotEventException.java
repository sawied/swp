package com.danan.business.smot.rest;

public class NotEventException extends Exception {

    private static final long serialVersionUID = 1193911279127737764L;
    
    private Long id =null;
    
    

    public NotEventException(Long id,String message) {
	super(message);
	this.id = id;
    }



    public Long getId() {
        return id;
    }
    
    

}
