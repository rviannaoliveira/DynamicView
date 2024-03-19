package com.github.rviannaoliveira.dynamic.core.data.model.button

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.rviannaoliveira.dynamic.core.data.model.action.DynamicActionProperties
import com.github.rviannaoliveira.dynamic.core.domain.Align

@JsonIgnoreProperties(ignoreUnknown = true)
data class ButtonProperties(
    @JsonProperty("text") val text: String? = null,
    @JsonProperty("textColorHex") val textColorHex: String? = null,
    @JsonProperty("align") val align: Align? = null,
    @JsonProperty("textSize") val textSize: String? = null,
    @JsonProperty("textAllCaps") val textAllCaps: Boolean? = false,
    @JsonProperty("backgroundHex") val backgroundHex: String? = null,
    @JsonProperty("actionProperties") var actionProperties: DynamicActionProperties? = null,
)
