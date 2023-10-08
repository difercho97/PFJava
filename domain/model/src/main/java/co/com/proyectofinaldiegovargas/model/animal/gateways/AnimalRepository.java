package co.com.proyectofinaldiegovargas.model.animal.gateways;

import co.com.proyectofinaldiegovargas.model.animal.Animal;

import java.util.List;

public interface AnimalRepository {

  void create(Animal animal);

  Animal read(String id);

  default Animal update(String id, Animal animal) throws Exception {
    return animal;
  }

  void delete(String id);

  List<Animal> getAll();
}
