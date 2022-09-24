package br.com.performacao.api.cravoecanela.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
@Getter
@Setter
public class PageDTO<T> {

    private boolean first = true;
    private boolean last = true;
    private int number = 1;
    private int numberOfElements = 0;
    private int size = 0;
    private long totalElements = 0;
    private long totalPages = 1;
    private Sort sort;
    private String pageKey;

    private final List<T> content;

    public PageDTO(List<T> content) {
        this.content =content;
    }

    public PageDTO() {
        this.content = Collections.emptyList();
    }

    public boolean hasContent() {
        return content != null && !content.isEmpty();
    }

    public boolean isFirst() {
        return first;
    }

    public boolean isLast() {
        return last;
    }

    public <R> PageDTO<R> mapEach(Function<T, R> func){

        if(this.content != null && !this.content.isEmpty())
            return null;//new PageDTO<>(this.content.stream().map(func).collect(Collectors.toList()), this);

        return new PageDTO<>();
    }

    @JsonIgnore
    public boolean isEmpty() {
        return this.content == null || this.content.isEmpty();
    }

}
