package com.github.rviannaoliveira.dynamic.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SimpleProperties(
    @JsonProperty("key") val key: String = "",
    @JsonProperty("value") val value: Any? = null
)
