package com.kenzie.appserver.repositories;

import com.kenzie.appserver.repositories.model.ExampleRecord;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ExampleRepository extends CrudRepository<ExampleRecord, String> {
    Object findArtistsByYear(String id);

    Object findArtistsByGenre(String id);

    Object findArtistsByUserId(String id);

    Object findBySongId(String id);
}
