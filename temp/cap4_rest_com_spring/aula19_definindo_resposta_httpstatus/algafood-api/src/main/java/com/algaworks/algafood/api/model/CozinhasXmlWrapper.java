package com.algaworks.algafood.api.model;



/*
 * @JacksonXmlRootElement é uma alternativa à @JsonRootName e
 * @JacksonXmlProperty à @JsonProperty.
 *
 * A diferença é que as anotações iniciadas com @JacksonXml só afetam
 * a serialização em XML. Já as anotações iniciadas com @Json
 * afetam tanto a serialização JSON como também XML.
 */

import com.algaworks.algafood.domain.model.Cozinha;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

@JsonRootName("cozinhas")
//@JacksonXmlRootElement(localName = "cozinhas")
public class CozinhasXmlWrapper {

    @JsonProperty("cozinha")
//	@JacksonXmlProperty(localName = "cozinha")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Cozinha> cozinhas;

    public CozinhasXmlWrapper(List<Cozinha> cozinhas) {
        this.cozinhas = cozinhas;
    }

    public List<Cozinha> getCozinhas() {
        return cozinhas;
    }

    public void setCozinhas(List<Cozinha> cozinhas) {
        this.cozinhas = cozinhas;
    }

}