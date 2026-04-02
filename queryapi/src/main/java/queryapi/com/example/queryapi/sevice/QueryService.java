package queryapi.com.example.queryapi.sevice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import queryapi.com.example.queryapi.dto.QueryRequest;
import queryapi.com.example.queryapi.dto.QueryResponse;
import queryapi.com.example.queryapi.entity.CallDetailsRecord;
import queryapi.com.example.queryapi.repository.CallDetailsRecordRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueryService {

    private static final Logger log = LoggerFactory.getLogger(QueryService.class);

    private final CallDetailsRecordRepository callDetailsRecordRepository;
    private static final DateTimeFormatter RECORD_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public QueryService(CallDetailsRecordRepository callDetailsRecordRepository) {
        this.callDetailsRecordRepository = callDetailsRecordRepository;
    }

    public List<QueryResponse> queryCallDetailsRecords(QueryRequest queryRequest) {
        LocalDateTime start_date =  LocalDateTime.parse(queryRequest.getRecord_date_start(), RECORD_DATE_FORMATTER);
        LocalDateTime end_date = LocalDateTime.parse(queryRequest.getRecord_date_end(), RECORD_DATE_FORMATTER);
        List<CallDetailsRecord> records = callDetailsRecordRepository.findByDateRangeAndOptionalFilters(
                start_date, end_date, queryRequest.getMsisdn(), queryRequest.getImsi());

        return records.stream().map(this::mapToQueryResponse).collect(Collectors.toList());
    }

    private QueryResponse mapToQueryResponse(CallDetailsRecord record) {
        QueryResponse response = new QueryResponse();
        response.setRecordDate(record.getRecordDate());
        response.setMsisdn(record.getMsisdn());
        response.setImsi(record.getImsi());
        return response;
    }

}
