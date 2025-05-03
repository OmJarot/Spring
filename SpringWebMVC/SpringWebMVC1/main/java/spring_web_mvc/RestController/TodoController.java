package spring_web_mvc.RestController;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController//otomatis menambahkan @ResponseBody ke semua mapping
public class TodoController {

    private List<String> todos = new ArrayList<>();

    @PostMapping(path = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> addTodos(@RequestParam("todo") String todo) {
        todos.add(todo);
        return todos;
    }

    @GetMapping(path = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getTodos() {
        return todos;
    }
}
