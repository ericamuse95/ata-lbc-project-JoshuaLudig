package com.kenzie.appserver.repositories.model;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface AppDisplayRepository extends CrudRepository<AppDisplayRecord, String> {

    static Object findBySongId(String id) {
        return id;
    }

    static Object findArtistsByUserId(String id) {
        return id;
    }

    static Object findArtistsByGenre(String id) {
        return id;
    }

    static Object findArtistsByYear(String id) {
        return null;
    }
}
