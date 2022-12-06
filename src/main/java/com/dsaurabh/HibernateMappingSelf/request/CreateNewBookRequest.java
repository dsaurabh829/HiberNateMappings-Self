package com.dsaurabh.HibernateMappingSelf.request;

import com.dsaurabh.HibernateMappingSelf.entity.Books;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
public class CreateNewBookRequest {

    @NotNull
    private String bookName;

    @Positive
    private Double bookPrice;

    public Books toBook(){
        return Books.builder()
                .bookName(bookName)
                .bookPrice(bookPrice).build();
    }
}
