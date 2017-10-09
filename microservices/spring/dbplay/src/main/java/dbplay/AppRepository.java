package dbplay;

import org.springframework.data.repository.CrudRepository;

import dbplay.App;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AppRepository extends CrudRepository<App, Long> {

}
