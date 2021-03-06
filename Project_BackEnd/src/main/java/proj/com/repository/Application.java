package proj.com.repository;

import proj.com.entity.Todo;
import proj.com.repository.JpaTodoRepository;
import proj.com.repository.TodoRepository;
import io.javalin.Javalin;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Application {

    static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
    }

    //-------------------------------------------------

    static TodoRepository todoRepository = new JpaTodoRepository(entityManagerFactory);

    //--------------------------------------------------

    public static void main(String[] args) {

        Javalin app = Javalin.create().start(8080); // server:8080

        app.get("/", ctx -> {
            ctx.result("welcome to todos-backend-service");
        });

        app.get("/todos", ctx -> {
            List<Todo> todos = todoRepository.findAll();
            ctx.json(todos);
        });

    }
}
