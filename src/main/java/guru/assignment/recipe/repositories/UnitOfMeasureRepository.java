package guru.assignment.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.assignment.recipe.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

}
