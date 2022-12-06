package com.dsaurabh.HibernateMappingSelf.request;

import com.dsaurabh.HibernateMappingSelf.entity.Order;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateNewOrderRequest {

    @NotNull
    private String userId;
    @NotNull
    private List<String> bookIds;

}
