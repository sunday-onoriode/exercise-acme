package com.example.acme.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdviceResponse implements Serializable {

    private List<String> fortune = new ArrayList<>();
}
