/*
 * All work contained within is subject to copyright.
 * (c)2018 - MrScabby, Phil C. 
 * no work may be reproduced without prior consent.
 * All Rights Reserved.
 */
package qd2;

/**
 *
 * @author idiot
 */
public class IAttachment {
    
    private String filename = "";
    private int filesize = 0;
    private long longID = 0;
    private String url = "";
    
    public IAttachment (String aFilename, int aFilesize, long anID, String aUrl){
        
        this.filename = aFilename;
        this.filesize = aFilesize;
        this.longID = anID;
        this.url = aFilename;
        
    }
    public IAttachment(){
        this.filename = "";
        this.filesize = 0;
        this.longID = 0;
        this.url = "";
        
    }
    
    public void setFilename(String aFilename){
        this.filename = aFilename;
    }
    public String getFilename(){
        return this.filename;
    }
    public void setFilesize(int aFilesize){
        this.filesize = aFilesize;
    }
    public int getFilesize(){
        return this.filesize;
    }
    public void setAttachmentID(long anID){
        this.longID = anID;
    }
    public long getAttachmentID(){
        return this.longID;
    }
    public void setUrl(String aUrl){
        this.url = aUrl;
    }
    public String getUrl(){
        return this.url;
    }
    
}
