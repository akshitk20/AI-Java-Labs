package com.javaaiexample.records;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpenAiRecords {
    // List the models
    public record ModelList(List<Model> data) {
        public record Model(
                String id,
                long created,
                @SerializedName("owned_by") String ownedBy) {
        }
    }
}
