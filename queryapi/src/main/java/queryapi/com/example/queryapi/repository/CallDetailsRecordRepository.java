package queryapi.com.example.queryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import queryapi.com.example.queryapi.entity.CallDetailsRecord;

public interface CallDetailsRecordRepository extends JpaRepository<CallDetailsRecord, String> {

}
