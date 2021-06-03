package com.algaworks.algafoodapi.api.exceptionhandler;

public enum ProblemType {

    ENTIDADE_NAO_ENCONTRADA("Entidade não encontrada", "/entidade-nao-encontrada");

    private String title;
    private String uri;

    ProblemType(String title, String path) {
        this.title = title;
        this.uri = "https://algafood.com.br" + path;
    }

    public String getTitle() {
        return title;
    }

    public String getUri() {
        return uri;
    }
}
