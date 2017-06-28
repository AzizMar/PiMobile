/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBEntities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author azizx
 */
@Entity
@Table(name = "message_metadata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MessageMetadata.findAll", query = "SELECT m FROM MessageMetadata m")
    , @NamedQuery(name = "MessageMetadata.findById", query = "SELECT m FROM MessageMetadata m WHERE m.id = :id")
    , @NamedQuery(name = "MessageMetadata.findByIsRead", query = "SELECT m FROM MessageMetadata m WHERE m.isRead = :isRead")})
public class MessageMetadata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "is_read")
    private boolean isRead;
    @JoinColumn(name = "message_id", referencedColumnName = "id")
    @ManyToOne
    private Message messageId;
    @JoinColumn(name = "participant_id", referencedColumnName = "id")
    @ManyToOne
    private Utilisateur participantId;

    public MessageMetadata() {
    }

    public MessageMetadata(Integer id) {
        this.id = id;
    }

    public MessageMetadata(Integer id, boolean isRead) {
        this.id = id;
        this.isRead = isRead;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public Message getMessageId() {
        return messageId;
    }

    public void setMessageId(Message messageId) {
        this.messageId = messageId;
    }

    public Utilisateur getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Utilisateur participantId) {
        this.participantId = participantId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageMetadata)) {
            return false;
        }
        MessageMetadata other = (MessageMetadata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBEntities.MessageMetadata[ id=" + id + " ]";
    }
    
}
