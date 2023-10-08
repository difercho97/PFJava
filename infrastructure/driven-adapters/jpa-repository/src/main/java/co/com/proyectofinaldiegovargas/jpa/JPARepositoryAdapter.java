package co.com.proyectofinaldiegovargas.jpa;

import co.com.proyectofinaldiegovargas.jpa.entities.AnimalEntity;
import co.com.proyectofinaldiegovargas.jpa.helper.AdapterOperations;
import co.com.proyectofinaldiegovargas.model.animal.Animal;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JPARepositoryAdapter
    extends AdapterOperations<
        Animal /* change for domain model */,
        AnimalEntity /* change for adapter model */,
        String,
        JPARepository>
// implements ModelRepository from domain
{

  public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
    /**
     * Could be use mapper.mapBuilder if your domain model implement builder pattern
     * super(repository, mapper, d ->
     * mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build()); Or using mapper.map with
     * the class of the object model
     */
    super(repository, mapper, d -> mapper.map(d, Animal.class /* change for domain model */));
  }
}
