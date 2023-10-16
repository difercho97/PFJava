package co.com.proyectofinaldiegovargas.api;

import co.com.proyectofinaldiegovargas.model.animal.Animal;
import co.com.proyectofinaldiegovargas.usecase.crudanimal.CrudAnimalUseCase;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<String> create(@RequestBody Animal animal) {
    ResponseEntity<String> re;
    try {
      if (animal.getNombre().isEmpty()) {
        re = new ResponseEntity<>(
                "Error! Se debe digitar el nombre del animal.",
                HttpStatus.BAD_REQUEST);
      } else if (animal.getGenero() != 'H' && animal.getGenero() != 'M') {
        re = new ResponseEntity<>(
                "Error! El campo de genero solo puede tener 2 valores (H o M): H cuando es hembra y M cuando es macho.",
                HttpStatus.BAD_REQUEST);
      } else {
        crudAnimalUseCase.create(animal);
        re = new ResponseEntity<>(
                "Excelente! Se creo el animal correctamente.",
                HttpStatus.CREATED);
      }

    } catch (Exception e){
      re = new ResponseEntity<>(
              "Error! Revise que este enviando correctamente todos los datos necesarios para crear el animal.",
              HttpStatus.BAD_REQUEST);
    }
      return re;
  }

  @PutMapping(path = "/animal/{id}")
  public ResponseEntity<String> update(@PathVariable String id, @RequestBody Animal animal) {
    ResponseEntity<String> re;
    try {
      if (crudAnimalUseCase.read(id) == null) {
        re = new ResponseEntity<>(
                "Error! El animal que se quiere actualizar no existe.",
                HttpStatus.BAD_REQUEST);
      } else if (animal.getNombre().isEmpty()) {
        re = new ResponseEntity<>(
                "Error! Se debe digitar el nombre del animal.",
                HttpStatus.BAD_REQUEST);
      } else if (animal.getGenero() != 'H' && animal.getGenero() != 'M') {
        re = new ResponseEntity<>(
                "Error! El campo de genero solo puede tener 2 valores (H o M): H cuando es hembra y M cuando es macho.",
                HttpStatus.BAD_REQUEST);
      } else {
        crudAnimalUseCase.update(id, animal);
        re = new ResponseEntity<>(
                "Excelente! Se actualizo el animal correctamente.",
                HttpStatus.OK);
      }

    } catch (Exception e){
      re = new ResponseEntity<>(
              "Error! Revise que este enviando correctamente todos los datos necesarios para actualizar el animal.",
              HttpStatus.BAD_REQUEST);
    }
    return re;
  }

  @DeleteMapping(path = "/animal/{id}")
  public ResponseEntity<String> delete(@PathVariable String id) {
    ResponseEntity<String> re;
    try {
      if (crudAnimalUseCase.read(id) == null) {
        re = new ResponseEntity<>(
                "Error! El animal que se quiere eliminar no existe.",
                HttpStatus.BAD_REQUEST);
      } else {
        crudAnimalUseCase.delete(id);
        re = new ResponseEntity<>(
                "Excelente! El animal se elimino correctamente.",
                HttpStatus.OK);
      }

    } catch (Exception e){
      re = new ResponseEntity<>(
              "Error! Revise que este enviando correctamente todos los datos necesarios para eliminar el animal.",
              HttpStatus.BAD_REQUEST);
    }
    return re;

  }

  @GetMapping(path = "/animal")
  public List<Animal> getAll() {
    return crudAnimalUseCase.getAll();
  }
}
