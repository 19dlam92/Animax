package com.lam.anime.repositories;
import java.util.List;
import com.lam.anime.models.AnimeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// ====================================================
// TALKS TO THE DATABASE
// ====================================================
@Repository
public interface AnimeRepository extends CrudRepository<AnimeModel, Long> {
    List<AnimeModel>findAll();                      // <ModelClassName, refers to the IDs data type>

}

// Talks directly to the database
// This file consists of methods that query our database
// further documentation is in CrudRepository library
// This method converts SQL syntax to Java syntax
// Looking for other queries?
// Go to CrudRepository
