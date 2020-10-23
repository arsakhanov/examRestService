package ru.arsakhanov.exam.repository;

import org.springframework.data.repository.CrudRepository;
import ru.arsakhanov.exam.entity.Cat;

public interface CatRepository extends CrudRepository<Cat, Long> {

}
