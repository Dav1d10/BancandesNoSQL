SET TRANSACTION ISOLATION LEVEL READ COMMITTED;

UPDATE cuenta
SET saldo = saldo + 1000000
WHERE numero_cuenta = 1;

INSERT INTO operacion_bancaria(id, valor, hora, fecha, producto, tipo)
VALUES(id_operacion_bancaria.nextval, 1000000, '13:00:00', TO_DATE('19-04-2024', 'DD-MM-YYYY'), 'CUENTA', 'CONSIGNACION');

UPDATE cuenta
SET saldo = saldo - 50000
WHERE numero_cuenta = 5;

INSERT INTO operacion_bancaria(id, valor, hora, fecha, producto, tipo)
VALUES(id_operacion_bancaria.nextval, 50000, '14:00:00', TO_DATE('19-04-2024', 'DD-MM-YYYY'), 'CUENTA', 'RETIRO');

COMMIT;

SELECT saldo
FROM cuenta
WHERE numero_cuenta = 1;

SELECT saldo
FROM cuenta
WHERE numero_cuenta = 5;


SET TRANSACTION ISOLATION LEVEL READ COMMITTED;

UPDATE CUENTA
SET SALDO = SALDO - 30000
WHERE NUMERO_CUENTA = 1;

INSERT INTO operacion_bancaria (ID, VALOR, HORA, FECHA, PRODUCTO, TIPO)
VALUES (id_operacion_bancaria.nextval, 30000, '13:00:00', TO_DATE('19-04-2024', 'DD-MM-YYYY'), 'CUENTA', 'RETIRO');

UPDATE CUENTA
SET SALDO = SALDO + 5000
WHERE NUMERO_CUENTA = 5;

INSERT INTO operacion_bancaria (ID, VALOR, HORA, FECHA, PRODUCTO, TIPO)
VALUES (id_operacion_bancaria.nextval, 5000, '14:00:00', TO_DATE('19-04-2024', 'DD-MM-YYYY'), 'CUENTA', 'CONSIGNACION');

COMMIT;

SELECT saldo
FROM cuenta
WHERE numero_cuenta = 1;

SELECT saldo
FROM cuenta
WHERE numero_cuenta = 5;


SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;

UPDATE cuenta
SET saldo = saldo + 1000000
WHERE numero_cuenta = 1;

INSERT INTO operacion_bancaria(id, valor, hora, fecha, producto, tipo)
VALUES(id_operacion_bancaria.nextval, 1000000, '13:00:00', TO_DATE('19-04-2024', 'DD-MM-YYYY'), 'CUENTA', 'CONSIGNACION');

UPDATE cuenta
SET saldo = saldo - 50000
WHERE numero_cuenta = 5;

INSERT INTO operacion_bancaria(id, valor, hora, fecha, producto, tipo)
VALUES(id_operacion_bancaria.nextval, 50000, '14:00:00', TO_DATE('19-04-2024', 'DD-MM-YYYY'), 'CUENTA', 'RETIRO');

COMMIT;

SELECT saldo
FROM cuenta
WHERE numero_cuenta = 1;

SELECT saldo
FROM cuenta
WHERE numero_cuenta = 5;


SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;

UPDATE CUENTA
SET SALDO = SALDO - 30000
WHERE NUMERO_CUENTA = 1;

INSERT INTO operacion_bancaria (ID, VALOR, HORA, FECHA, PRODUCTO, TIPO)
VALUES (id_operacion_bancaria.nextval, 30000, '13:00:00', TO_DATE('19-04-2024', 'DD-MM-YYYY'), 'CUENTA', 'RETIRO');

UPDATE CUENTA
SET SALDO = SALDO + 5000
WHERE NUMERO_CUENTA = 5;

INSERT INTO operacion_bancaria (ID, VALOR, HORA, FECHA, PRODUCTO, TIPO)
VALUES (id_operacion_bancaria.nextval, 5000, '14:00:00', TO_DATE('19-04-2024', 'DD-MM-YYYY'), 'CUENTA', 'CONSIGNACION');

COMMIT;

SELECT saldo
FROM cuenta
WHERE numero_cuenta = 1;

SELECT saldo
FROM cuenta
WHERE numero_cuenta = 5;
