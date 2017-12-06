INSERT INTO promocao (PRODUTO_ID, DT_INICIO, DT_FIM, PERC_DESCONTO)
    VALUES
    (1, NOW(), NULL, 10.0)
    , (2, NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), 50.0)
    , (3, NOW(), NULL, 15.0)
    , (4, DATE_ADD(NOW(), INTERVAL -60 DAY), DATE_ADD(NOW(), INTERVAL -55 DAY), 80.0)
    , (4, DATE_ADD(NOW(), INTERVAL -54 DAY), DATE_ADD(NOW(), INTERVAL 5 DAY), 80.0);