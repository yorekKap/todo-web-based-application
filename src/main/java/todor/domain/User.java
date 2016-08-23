package todor.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "photo")
	private String photo;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TodoCategory> categories;
	
	@Transient
	private String confirmPassword;
	
	@Transient
	private boolean registered = true;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public List<TodoCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<TodoCategory> categories) {
		this.categories = categories;
	}

	public TodoCategory getCategory(int index){
		
		return categories.get(index);
		
	}
	
	public TodoCategory getCategory(String categoryName){
		
          return categories.stream()
          			.filter(e -> e.getName().equals(categoryName))
          			.findFirst()
          			.get();
		
	}

	
	public void addCategory(TodoCategory todoCategory){
		
		this.getCategories().add(todoCategory);
		todoCategory.setUser(this);
		
	} 
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", photo="
				+ photo + ", confirmPassword=" + confirmPassword + ", categories=" + categories + "]";
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	public void removeCategory(String categoryName){
		
		TodoCategory toDelete =  categories.stream()
				  				.filter(e -> e.getName().equals(categoryName))
				  				.findFirst()
				  				.get();
		
		categories.remove(toDelete);

	}
	
	public boolean isCategoryExist(String categoryName){
		
		for(TodoCategory category : getCategories()){
			
			if(category.getName().equals(categoryName))
				return true;
			
		}
		
		return false;
		
	}
}
