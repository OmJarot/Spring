package spring_restful_api_test.spring_restful_api_test.Model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WebResponse <T>{

    private T data;

    private String error;

    private PagingResponse paging;

}
