package guru.assignment.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.assignment.recipe.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
