//package com.kenzie.appserver.repositories;
//
//import com.kenzie.appserver.repositories.model.NewMusicFeaturesRecord;
//import com.kenzie.appserver.service.NewMusicFeaturesService;
//import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.Optional;
//
//@EnableScan
//public interface NewMusicFeaturesRepository extends CrudRepository<NewMusicFeaturesRecord, String> {
//    Optional<NewMusicFeaturesRecord> findByFeatureId(String id);
//    Optional<NewMusicFeaturesRecord> findBySongId(String id);
//    Optional<NewMusicFeaturesRecord> save(NewMusicFeaturesRecord newMusicFeaturesRecord);
//}
//
