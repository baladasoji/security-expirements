package dbplay;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class App {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String client_id;
    private String client_secret;
    private String redirect_uri;



    
    /**
     * Get client_secret.
     *
     * @return client_secret as String.
     */
    public String getClient_secret()
    {
        return client_secret;
    }
    
    /**
     * Set client_secret.
     *
     * @param client_secret the value to set.
     */
    public void setClient_secret(String client_secret)
    {
        this.client_secret = client_secret;
    }
    
    /**
     * Get id.
     *
     * @return id as Integer.
     */
    public Integer getId()
    {
        return id;
    }
    
    /**
     * Set id.
     *
     * @param id the value to set.
     */
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    /**
     * Get name.
     *
     * @return name as String.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Set name.
     *
     * @param name the value to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Get client_id.
     *
     * @return client_id as String.
     */
    public String getClient_id()
    {
        return client_id;
    }
    
    /**
     * Set client_id.
     *
     * @param client_id the value to set.
     */
    public void setClient_id(String client_id)
    {
        this.client_id = client_id;
    }
    
    /**
     * Get redirect_uri.
     *
     * @return redirect_uri as String.
     */
    public String getRedirect_uri()
    {
        return redirect_uri;
    }
    
    /**
     * Set redirect_uri.
     *
     * @param redirect_uri the value to set.
     */
    public void setRedirect_uri(String redirect_uri)
    {
        this.redirect_uri = redirect_uri;
    }
}
