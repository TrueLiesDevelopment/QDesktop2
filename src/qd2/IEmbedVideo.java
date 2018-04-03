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
public class IEmbedVideo {
    
    private int height = 0;
    private int width = 0;
    private String url = "";
    
    public IEmbedVideo(int aHeight, int aWidth, String aUrl){
        
        this.height = aHeight;
        this.width = aWidth;
        this.url = aUrl;
    }
    
    public void setHeight(int aHeight){
        this.height = aHeight;        
    }
    public int getHeight(){
        return this.height;
    }
    public void setWidth(int aWidth){
        this.width = aWidth;        
    }
    public int getWidth(){
        return this.width;
    }
    public void setUrl(String aUrl){
        this.url = aUrl;        
    }
    public String getUrl(){
        return this.url;
    }
}
