package me.dev.motospring.repositories;

import me.dev.motospring.model.Make;
import org.springframework.data.repository.CrudRepository;

public interface MakeRepository extends CrudRepository<Make, Long> {
}
