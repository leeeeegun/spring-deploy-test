package com.codingrecipe.uigunlee.order.controller.response_form;

import com.codingrecipe.uigunlee.order.service.response.ListOrdersResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class ListOrdersResponseForm {
    final private List<Map<String, Object>> ordersSummaryList;
    final private Integer totalPages;
    final private Long totalElements;

    public static ListOrdersResponseForm from(final ListOrdersResponse response) {
        return response.transformToResponseForm();
    }
}
