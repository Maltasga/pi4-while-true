CREATE VIEW SELECT_CLIENTE_COMPLETO
(
    ID,
    NOME,
    CPF,
    EMAIL,
    DT_NASCIMENTO,
    SEXO,
    TELEFONE,
    CELULAR,
    DT_CADASTRO,
    LOGRADOURO,
    NUMERO,
    COMPLEMENTO,
    CIDADE,
    UF,
    CEP
)
AS
(
    SELECT
        C.ID,
        C.NOME,
        C.CPF,
        C.EMAIL,
        C.DT_NASCIMENTO,
        C.SEXO,
        C.TELEFONE,
        C.CELULAR,
        C.DT_CADASTRO,
        E.LOGRADOURO,
        E.NUMERO,
        E.COMPLEMENTO,
        E.CIDADE,
        E.UF,
        E.CEP
    FROM CLIENTE C
        JOIN ENDERECO E ON E.CLIENTE_ID = C.ID AND E.PRINCIPAL = TRUE
    WHERE C.ATIVO = TRUE
);