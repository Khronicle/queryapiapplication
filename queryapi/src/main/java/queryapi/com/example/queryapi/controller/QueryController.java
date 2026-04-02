package queryapi.com.example.queryapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queryapi.com.example.queryapi.dto.QueryRequest;
import queryapi.com.example.queryapi.dto.QueryResponse;
import queryapi.com.example.queryapi.sevice.QueryService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QueryController {

    private final QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @PostMapping("/query")
    public List<QueryResponse> query(@RequestBody QueryRequest request) {
        return queryService.queryCallDetailsRecords(request);
    }
}
