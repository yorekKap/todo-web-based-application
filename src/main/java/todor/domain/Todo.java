package todor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.AttributeAccessor;

@Entity
@Table(name = "todo")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
		
	@Column
	private String state;
	
	@Column
	private int priority;
	
	@Column
	private char done;
	
	@ManyToOne
	@JoinColumn(name = "todo_category_id")
	private TodoCategory todoCategory;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public TodoCategory getTodoCategory() {
		return todoCategory;
	}

	public void setTodoCategory(TodoCategory todoCategory) {
		this.todoCategory = todoCategory;
	}

	public boolean getDone() {
		return done == 'y';
	}

	public void setDone(boolean done) {
		
		if(done)
			this.done = 'y';
		else
			this.done = 'n';
	}

	public void toggleDone(){
		
		if(done == 'y')
			done = 'n';
		else
			done = 'y';
		
	}

}
