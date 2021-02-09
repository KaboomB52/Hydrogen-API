package com.ddylan.hydrogen.api.repository;

import com.ddylan.hydrogen.api.model.Heartbeat;
import com.ddylan.hydrogen.api.model.Rank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartbeatRepository extends MongoRepository<Heartbeat, String> {
    Rank findById(int paramInt);
}
