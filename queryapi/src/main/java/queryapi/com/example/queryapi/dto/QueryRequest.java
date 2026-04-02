package queryapi.com.example.queryapi.dto;

import lombok.Getter;

@Getter
public class QueryRequest {
    private String record_date_start;
    private String record_date_end;
    private String msisdn;
    private String imsi;

}
