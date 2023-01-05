package com.kenzie.appserver.repositories;

import com.kenzie.appserver.repositories.model.ExampleRecord;

import com.kenzie.appserver.repositories.model.SongServiceRecord;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface SongServiceRepository extends CrudRepository<SongServiceRecord, String> {

}
