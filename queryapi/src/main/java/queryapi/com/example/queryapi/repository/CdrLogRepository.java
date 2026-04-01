package queryapi.com.example.queryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import queryapi.com.example.queryapi.entity.CdrLog;

public interface CdrLogRepository extends JpaRepository<CdrLog, Long> {

}
