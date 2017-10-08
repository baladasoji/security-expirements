package net.dasoji;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;
@ConfigurationProperties(prefix = "greet")
@Component
public class Greeting {

    private String Name;
    private List<String> hobbies;

	/**
	* Returns value of Name
	* @return
	*/
	public String getName() {
		return Name;
	}

	/**
	* Sets new value of Name
	* @param
	*/
	public void setName(String Name) {
		this.Name = Name;
	}

	/**
	* Returns value of hobbies
	* @return
	*/
	public List<String> getHobbies() {
		return hobbies;
	}

	/**
	* Sets new value of hobbies
	* @param
	*/
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
}
