package queryapi.com.example.queryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import queryapi.com.example.queryapi.entity.CallDetailsRecord;

import java.time.LocalDateTime;
import java.util.List;

public interface CallDetailsRecordRepository extends JpaRepository<CallDetailsRecord, String> {
    @Query("SELECT c FROM CallDetailsRecord c WHERE c.recordDate BETWEEN :start AND :end " +
            "AND (:msisdn IS NULL OR c.msisdn = :msisdn) AND (:imsi IS NULL OR c.imsi = :imsi)")
    List<CallDetailsRecord> findByDateRangeAndOptionalFilters
            (@Param("start") LocalDateTime start, @Param("end") LocalDateTime end,
             @Param("msisdn") String msisdn, @Param("imsi") String imsi);
}
