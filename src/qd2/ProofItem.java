/*
 * All work contained within is subject to copyright.
 * (c)2018 - MrScabby, Phil C. 
 * no work may be reproduced without prior consent.
 * All Rights Reserved.
 */
package qd2;

import java.time.Instant;
import java.util.List;
import sx.blah.discord.handle.impl.obj.Guild;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;

/**
 *
 * @author idiot
 */
public class ProofItem {
    
    private String messageID = "";
    private String author = "";
    private List<IAttachment> attachments = null;
    private IChannel channel = null;
    private String content = "";
    private String modifiedDate = "";
    private List<IEmbed> embeds = null;
    private String formattedContent = "";
    private IGuild guild = null;
    private Instant timestamp = null;
    private boolean pinned = false;
    private boolean deleted = false;
    
    public ProofItem(String aMessageID, String anAuthor, List<IAttachment> someAttachments, IChannel aChannel,
            String aContent, String aModifiedDate, List<IEmbed> someEmbeds, String aFormattedContent, Guild aGuild,
            Instant aTimestamp, boolean aPinned, boolean aDeleted){
        
        this.messageID = aMessageID;
        this.author = anAuthor;
        this.attachments = someAttachments;
        this.channel = aChannel;
        this.content = aContent;
        this.modifiedDate = aModifiedDate;
        this.embeds = someEmbeds;
        this.formattedContent = aFormattedContent;
        this.guild = aGuild;
        this.timestamp = aTimestamp;
        this.pinned = aPinned;
        this.deleted = aDeleted;
    }
    
    public void setMessageID(String anId){
        this.messageID = anId;
    }
    public String getMessageID(){
        return this.messageID;
    }
    public void setAuthor(String anAuthor){
        this.author = anAuthor;
    }
    public String getAuthor(){
        return this.author;
    }
    public boolean addAttachment(IAttachment anAttachment){
        if (this.attachments.contains(anAttachment)) { return false; }
        this.attachments.add(anAttachment);
        return true;
    }
    public IAttachment getAttachmentByID(String ID){
        if (this.attachments.size()<1) { return new IAttachment(); }
        for(int i = 0;i<this.attachments.size();i++){
            IAttachment it = this.attachments.get(i);
            if (ID.contains(it.getAttachmentID()+"")) { return it;}
        }
        return new IAttachment();
    }
    public boolean saveAttachmentByID(IAttachment anIt){
        if (this.attachments.size()<1) { return false; }
        for(int i = 0;i<this.attachments.size();i++){
            IAttachment it = this.attachments.get(i);
            
            if (anIt.getAttachmentID() == it.getAttachmentID()) { 
                this.attachments.remove(it);
                this.attachments.add(anIt);
                return true;}
        }
        return false;
    }
    public boolean deleteAttachment(IAttachment anIt){
        if (this.attachments.size()<1) { return false; }
        return this.attachments.remove(anIt);
    }
    public void setChannel(IChannel aChannel){
        this.channel = aChannel;
    }
    public IChannel getChannel(){
        return this.channel;
    }
    public void setContent(String aContent){
        this.content = aContent;
    }
    public String getContent(){
        return this.content;
    }
    public void setModifiedDate(String aModifiedDate){
        this.modifiedDate = aModifiedDate;
    }
    public String getModifiedDate(){
        return this.modifiedDate;
    }
    public boolean addEmbed(IEmbed anEmbed){
        if (this.embeds.contains(anEmbed)) { return false; }
        this.embeds.add(anEmbed);
        return true;
    }
    public IEmbed getEmbedByTimestamp(Instant timestamp){
        if (this.embeds.size()<1) { return new IEmbed(); }
        for(int i = 0;i<this.embeds.size();i++){
            IEmbed it = this.embeds.get(i);
            if (timestamp.equals(it.getTimestamp())) { return it;}
        }
        return new IEmbed();
    }
    public boolean saveEmbedByTimestamp(IEmbed anIt){
        if (this.embeds.size()<1) { return false; }
        for(int i = 0;i<this.embeds.size();i++){
            IEmbed it = this.embeds.get(i);
            
            if (timestamp.equals(it.getTimestamp())) { 
                this.embeds.remove(it);
                this.embeds.add(anIt);
                return true;}
        }
        return false;
    }
    public boolean deleteEmbed(IEmbed anIt){
        if (this.embeds.size()<1) { return false; }
        return this.embeds.remove(anIt);
    }
    public void setFormattedString(String aFormattedString){
        this.formattedContent = aFormattedString;
    }
    public String getFormattedString(){
        return this.formattedContent;
    }
    public void setGuild(IGuild aGuild){
        this.guild = aGuild;
    }
    public IGuild getGuild(){
        return this.guild;
    }
    
    public void setTimestamp(Instant anInstant){
        this.timestamp = anInstant;
    }
    public Instant getTimestamp(){
        return this.timestamp;
    }
    public void setPinned(boolean aPinned){
        this.pinned = aPinned;
    }
    public boolean getPinned(){
        return this.pinned;
    }
    public void setDeleted(boolean aDeleted){
        this.deleted = aDeleted;
    }
    public boolean getDeleted(){
        return this.deleted;
    }
    
    
}
