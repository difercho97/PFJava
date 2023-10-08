package co.com.proyectofinaldiegovargas.api;

import co.com.proyectofinaldiegovargas.model.animal.Animal;
import co.com.proyectofinaldiegovargas.usecase.crudanimal.CrudAnimalUseCase;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@ResponseBody
@RequestMapping(value = "/crudanimales", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
  private final CrudAnimalUseCase crudAnimalUseCase;

  @GetMapping(path = "/animal/{id}")
  public Animal read(@PathVariable String id) {
    return crudAnimalUseCase.read(id);
  }

  @PostMapping(path = "/animal")
  public void create(@RequestBody Animal animal) {
    crudAnimalUseCase.create(animal);
  }

  @PutMapping(path = "/animal/{id}")
  public void update(@PathVariable String id, @RequestBody Animal animal) {
    try {
      crudAnimalUseCase.update(id, animal);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @DeleteMapping(path = "/animal/{id}")
  public void delete(@PathVariable String id) {
    crudAnimalUseCase.delete(id);
  }

  @GetMapping(path = "/animal")
  public List<Animal> getAll() {
    return crudAnimalUseCase.getAll();
  }
}
