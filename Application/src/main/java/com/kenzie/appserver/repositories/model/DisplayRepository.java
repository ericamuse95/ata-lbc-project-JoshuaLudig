package com.kenzie.appserver.repositories.model;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface DisplayRepository extends CrudRepository<DisplayRecord, String> {

    static Object findBySongId(String id) {
        return null;
    }

    static Object findArtistsByUserId(String id) {
        return null;
    }

    static Object findArtistsByGenre(String id) {
        return null;
    }

    static Object findArtistsByYear(String id) {
        return null;
    }
}
