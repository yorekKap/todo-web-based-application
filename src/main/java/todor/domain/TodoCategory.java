package todor.domain;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "todo_category")
public class TodoCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String description;

	@OneToMany(mappedBy = "todoCategory", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true )
	List<Todo> todos;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}
	
	public Todo getTodo(String todoName){
		
		return todos.stream()
					.filter(e -> e.getName().trim().equals(todoName))
					.findFirst()
					.get();
		
	}
	
	public void addTodo(Todo todo){
		
		todos.add(todo);
		todo.setTodoCategory(this);
		
	}
	
	public void deleteDone(){
		
		List<Todo> filteredTodos = todos.stream()
			 .filter(e -> !e.getDone())
			 .collect(Collectors.toList());
		this.setTodos(filteredTodos);
	}
}
