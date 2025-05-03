package spring_restful_api_test.spring_restful_api_test.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PagingResponse {

    private Integer currentPage;

    private Integer totalPage;

    private Integer size;

}
