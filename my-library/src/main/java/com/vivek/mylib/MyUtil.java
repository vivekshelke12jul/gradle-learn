package com.vivek.mylib;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;

public class MyUtil {
    public static JsonNode getData(){
        ObjectNode node = new ObjectMapper().createObjectNode();

        String name = "  Vivek  ";
        name = StringUtils.trim(name);
        name = StringUtils.capitalize(name);

        node.put("name", name);
        node.put("age", 27);
        return node;
    }
}
