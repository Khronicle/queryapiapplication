package queryapi.com.example.queryapi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QueryResponse {
    private LocalDateTime recordDate;
    private String msisdn;
    private String imsi;
}
