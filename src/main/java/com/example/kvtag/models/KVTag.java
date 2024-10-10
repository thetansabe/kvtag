package com.example.kvtag.models;

import ai.qworks.dao.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KVTag extends BaseEntity {
    private String name;
    private List<String> values;
    private boolean isActive;
}
