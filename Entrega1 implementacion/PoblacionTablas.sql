INSERT INTO operacion_bancaria(id, valor, hora, fecha, producto, tipo)
VALUES(1, 50000, '18:00:00', '27/04/24', 'CUENTA', 'RETIRO');

CREATE SEQUENCE id_operacion_bancaria
START WITH 2
INCREMENT BY 1;

INSERT INTO operacion_bancaria(id, valor, hora, fecha, producto, tipo)
VALUES(id_operacion_bancaria.nextval, 60000, '13:00:00', '22/04/24', 'CDT', 'CONSIGNACION');

INSERT INTO operacion_bancaria(id, valor, hora, fecha, producto, tipo)
VALUES(id_operacion_bancaria.nextval, 70000, '14:00:00', '25/04/24', 'CUENTA', 'PEDIR_PRESTAMO');

INSERT INTO operacion_bancaria(id, valor, hora, fecha, producto, tipo)
VALUES(id_operacion_bancaria.nextval, 80000, '12:00:00', '13/04/24', 'CDT', 'PAGAR_PRESTAMO');

INSERT INTO operacion_bancaria(id, valor, hora, fecha, producto, tipo)
VALUES(id_operacion_bancaria.nextval, 90000, '19:00:00', '01/04/24', 'CUENTA', 'CONSIGNACION');

INSERT INTO persona(numero_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES(1234567890, 1234567890, 'David Caro', 'Colombia', 'Cll1', 'kingcold55@gmail.com', 'Cundinamarca', '11111', 'Bogot�', 'CC');

INSERT INTO cliente(numero_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES(1234567890, 1234567890, 'David Caro', 'Colombia', 'Cll1', 'kingcold55@gmail.com', 'Cundinamarca', '11111', 'Bogot�', 'CC');

INSERT INTO gerente_de_oficina(numero_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES(1234567890, 1234567890, 'David Caro', 'Colombia', 'Cll1', 'kingcold55@gmail.com', 'Cundinamarca', '11111', 'Bogot�', 'CC');

INSERT INTO persona(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('9876543210', '9876543210', 'Laura Gomez', 'Colombia', 'Cll2', 'laura123@gmail.com', 'Antioquia', '22222', 'Medellin', 'CC');

INSERT INTO persona(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('4567890123', '4567890123', 'Carlos Perez', 'Colombia', 'Cll3', 'carlos456@gmail.com', 'Valle del Cauca', '33333', 'Cali', 'CC');

INSERT INTO persona(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('6543210987', '6543210987', 'Maria Rodriguez', 'Colombia', 'Cll4', 'maria789@gmail.com', 'Santander', '44444', 'Bucaramanga', 'CC');

INSERT INTO persona(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('7890123456', '7890123456', 'Juan Martinez', 'Colombia', 'Cll5', 'juanmartinez@gmail.com', 'Atlantico', '55555', 'Barranquilla', 'CC');

INSERT INTO persona(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('2345678901', '2345678901', 'Ana Gutierrez', 'Colombia', 'Cll6', 'anagutierrez@gmail.com', 'Risaralda', '66666', 'Pereira', 'CC');

INSERT INTO persona(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('3456789012', '3456789012', 'Pedro Hernandez', 'Colombia', 'Cll7', 'pedrohernandez@gmail.com', 'Quindio', '77777', 'Armenia', 'CC');

INSERT INTO persona(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('5678901234', '5678901234', 'Diana Ramirez', 'Colombia', 'Cll8', 'dianaramirez@gmail.com', 'Huila', '88888', 'Neiva', 'CC');

INSERT INTO persona(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('6789012345', '6789012345', 'Camilo Castro', 'Colombia', 'Cll9', 'camilocastro@gmail.com', 'Tolima', '99999', 'Ibague', 'CC');

INSERT INTO persona(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('1357924680', '1357924680', 'Elena Vargas', 'Colombia', 'Cll10', 'elena.vargas@example.com', 'Meta', '12345', 'Villavicencio', 'CC');

INSERT INTO cliente(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('9876543210', '9876543210', 'Laura Gomez', 'Colombia', 'Cll2', 'laura123@gmail.com', 'Antioquia', '22222', 'Medellin', 'CC');

INSERT INTO cliente(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('4567890123', '4567890123', 'Carlos Perez', 'Colombia', 'Cll3', 'carlos456@gmail.com', 'Valle del Cauca', '33333', 'Cali', 'CC');

INSERT INTO cliente(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('6543210987', '6543210987', 'Maria Rodriguez', 'Colombia', 'Cll4', 'maria789@gmail.com', 'Santander', '44444', 'Bucaramanga', 'CC');

INSERT INTO cliente(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('7890123456', '7890123456', 'Juan Martinez', 'Colombia', 'Cll5', 'juanmartinez@gmail.com', 'Atlantico', '55555', 'Barranquilla', 'CC');

INSERT INTO cliente(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('2345678901', '2345678901', 'Ana Gutierrez', 'Colombia', 'Cll6', 'anagutierrez@gmail.com', 'Risaralda', '66666', 'Pereira', 'CC');

INSERT INTO cliente(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('3456789012', '3456789012', 'Pedro Hernandez', 'Colombia', 'Cll7', 'pedrohernandez@gmail.com', 'Quindio', '77777', 'Armenia', 'CC');

INSERT INTO cliente(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('5678901234', '5678901234', 'Diana Ramirez', 'Colombia', 'Cll8', 'dianaramirez@gmail.com', 'Huila', '88888', 'Neiva', 'CC');

INSERT INTO cliente(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('6789012345', '6789012345', 'Camilo Castro', 'Colombia', 'Cll9', 'camilocastro@gmail.com', 'Tolima', '99999', 'Ibague', 'CC');

INSERT INTO cliente(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES('1357924680', '1357924680', 'Elena Vargas', 'Colombia', 'Cll10', 'elena.vargas@example.com', 'Meta', '12345', 'Villavicencio', 'CC');

INSERT INTO cajero(numero_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES(9876543210, 9876543210, 'Laura Gomez', 'Colombia', 'Cll2', 'laura123@gmail.com', 'Antioquia', '22222', 'Medell�n', 'CC');

INSERT INTO cajero(numero_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES(4567890123, 4567890123, 'Carlos Perez', 'Colombia', 'Cll3', 'carlos456@gmail.com', 'Valle del Cauca', '33333', 'Cali', 'CC');

INSERT INTO cajero(numero_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES(6543210987, 6543210987, 'Maria Rodriguez', 'Colombia', 'Cll4', 'maria789@gmail.com', 'Santander', '44444', 'Bucaramanga', 'CC');

INSERT INTO gerente_de_oficina(numero_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES(7890123456, 7890123456, 'Juan Martinez', 'Colombia', 'Cll5', 'juanmartinez@gmail.com', 'Atl�ntico', '55555', 'Barranquilla', 'CC');

INSERT INTO gerente_de_oficina(numero_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES(2345678901, 2345678901, 'Ana Gutierrez', 'Colombia', 'Cll6', 'anagutierrez@gmail.com', 'Risaralda', '66666', 'Pereira', 'CC');

INSERT INTO gerente_de_oficina(numero_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES(3456789012, 3456789012, 'Pedro Hernandez', 'Colombia', 'Cll7', 'pedrohernandez@gmail.com', 'Quind�o', '77777', 'Armenia', 'CC');

INSERT INTO gerente_general(numero_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES(5678901234, 5678901234, 'Diana Ramirez', 'Colombia', 'Cll8', 'dianaramirez@gmail.com', 'Huila', '88888', 'Neiva', 'CC');

INSERT INTO gerente_general(numero_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES(6789012345, 6789012345, 'Camilo Castro', 'Colombia', 'Cll9', 'camilocastro@gmail.com', 'Tolima', '99999', 'Ibagu�', 'CC');

INSERT INTO gerente_general(numero_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento)
VALUES(1357924680, 1357924680, 'Elena Vargas', 'Colombia', 'Cll10', 'elena.vargas@example.com', 'Meta', '12345', 'Villavicencio', 'CC');

INSERT INTO prestamo(id_prestamo, monto, interes, numero_cuotas, dia_pago, valor_cuota, estado_prestamo)
VALUES(1, 200000, 5, 6, TO_DATE('19-04-2024', 'DD-MM-YYYY'), 33333, 'SOLICITADO');

CREATE SEQUENCE id_prestamo
START WITH 2
INCREMENT BY 1;

INSERT INTO prestamo(id_prestamo, monto, interes, numero_cuotas, dia_pago, valor_cuota, estado_prestamo)
VALUES(id_prestamo.nextval, 200000, 5, 6, TO_DATE('19-04-2024', 'DD-MM-YYYY'), 33333, 'SOLICITADO');

INSERT INTO prestamo(id_prestamo, monto, interes, numero_cuotas, dia_pago, valor_cuota, estado_prestamo)
VALUES(id_prestamo.nextval, 250000, 6, 7, TO_DATE('20-04-2024', 'DD-MM-YYYY'), 35714, 'APROBADO');

INSERT INTO prestamo(id_prestamo, monto, interes, numero_cuotas, dia_pago, valor_cuota, estado_prestamo)
VALUES(id_prestamo.nextval, 180000, 4, 5, TO_DATE('21-04-2024', 'DD-MM-YYYY'), 36000, 'RECHAZADO');

INSERT INTO prestamo(id_prestamo, monto, interes, numero_cuotas, dia_pago, valor_cuota, estado_prestamo)
VALUES(id_prestamo.nextval, 300000, 7, 8, TO_DATE('22-04-2024', 'DD-MM-YYYY'), 37500, 'PAGADO');

INSERT INTO cuenta(numero_cuenta, saldo, fecha_ultima_transaccion, fecha_creacion, tipo_cuenta, estado_cuenta)
VALUES(1, 300000, TO_DATE('13-04-2024', 'DD-MM-YYYY'), TO_DATE('15-07-2018', 'DD-MM-YYYY'), 'AHORROS', 'ACTIVA');

CREATE SEQUENCE id_cuenta
START WITH 2
INCREMENT BY 1;

INSERT INTO cuenta(numero_cuenta, saldo, fecha_ultima_transaccion, fecha_creacion, tipo_cuenta, estado_cuenta)
VALUES(id_cuenta.nextval, 300000, TO_DATE('13-04-2024', 'DD-MM-YYYY'), TO_DATE('15-07-2018', 'DD-MM-YYYY'), 'AHORROS', 'ACTIVA');

INSERT INTO cuenta(numero_cuenta, saldo, fecha_ultima_transaccion, fecha_creacion, tipo_cuenta, estado_cuenta)
VALUES(id_cuenta.nextval, 250000, TO_DATE('14-04-2024', 'DD-MM-YYYY'), TO_DATE('16-07-2018', 'DD-MM-YYYY'), 'CORRIENTE', 'CERRADA');

INSERT INTO cuenta(numero_cuenta, saldo, fecha_ultima_transaccion, fecha_creacion, tipo_cuenta, estado_cuenta)
VALUES(id_cuenta.nextval, 200000, TO_DATE('15-04-2024', 'DD-MM-YYYY'), TO_DATE('17-07-2018', 'DD-MM-YYYY'), 'AFC', 'DESACTIVADA');

INSERT INTO cuenta(numero_cuenta, saldo, fecha_ultima_transaccion, fecha_creacion, tipo_cuenta, estado_cuenta)
VALUES(id_cuenta.nextval, 350000, TO_DATE('16-04-2024', 'DD-MM-YYYY'), TO_DATE('18-07-2018', 'DD-MM-YYYY'), 'AHORROS', 'ACTIVA');

INSERT INTO cuenta(numero_cuenta, saldo, fecha_ultima_transaccion, fecha_creacion, tipo_cuenta, estado_cuenta)
VALUES(id_cuenta.nextval, 400000, TO_DATE('17-04-2024', 'DD-MM-YYYY'), TO_DATE('19-07-2018', 'DD-MM-YYYY'), 'CORRIENTE', 'CERRADA');

INSERT INTO cuenta(numero_cuenta, saldo, fecha_ultima_transaccion, fecha_creacion, tipo_cuenta, estado_cuenta)
VALUES(id_cuenta.nextval, 150000, TO_DATE('18-04-2024', 'DD-MM-YYYY'), TO_DATE('20-07-2018', 'DD-MM-YYYY'), 'AFC', 'DESACTIVADA');

INSERT INTO cuenta(numero_cuenta, saldo, fecha_ultima_transaccion, fecha_creacion, tipo_cuenta, estado_cuenta)
VALUES(id_cuenta.nextval, 280000, TO_DATE('19-04-2024', 'DD-MM-YYYY'), TO_DATE('21-07-2018', 'DD-MM-YYYY'), 'AHORROS', 'ACTIVA');

INSERT INTO cuenta(numero_cuenta, saldo, fecha_ultima_transaccion, fecha_creacion, tipo_cuenta, estado_cuenta)
VALUES(id_cuenta.nextval, 320000, TO_DATE('20-04-2024', 'DD-MM-YYYY'), TO_DATE('22-07-2018', 'DD-MM-YYYY'), 'CORRIENTE', 'CERRADA');

INSERT INTO cuenta(numero_cuenta, saldo, fecha_ultima_transaccion, fecha_creacion, tipo_cuenta, estado_cuenta)
VALUES(id_cuenta.nextval, 180000, TO_DATE('21-04-2024', 'DD-MM-YYYY'), TO_DATE('23-07-2018', 'DD-MM-YYYY'), 'AFC', 'DESACTIVADA');

INSERT INTO punto_de_atencion(id_punto_atencion, localizacion, tipo_punto_atencion)
VALUES(1, 'Cll20', 'CAJERO AUTOMATICO');

CREATE SEQUENCE id_punto_atencion
START WITH 2
INCREMENT BY 1;

INSERT INTO punto_de_atencion(id_punto_atencion, localizacion, tipo_punto_atencion)
VALUES(id_punto_atencion.nextval, 'Cll20', 'CAJERO AUTOMATICO');

INSERT INTO punto_de_atencion(id_punto_atencion, localizacion, tipo_punto_atencion)
VALUES(id_punto_atencion.nextval, 'Cll146A', 'CAJERO AUTOMATICO');

INSERT INTO punto_de_atencion(id_punto_atencion, localizacion, tipo_punto_atencion)
VALUES(id_punto_atencion.nextval, 'Av. Principal', 'ATENCION PERSONALIZADA');

INSERT INTO punto_de_atencion(id_punto_atencion, localizacion, tipo_punto_atencion)
VALUES(id_punto_atencion.nextval, 'Plaza Mayor', 'CAJERO AUTOMATICO');

INSERT INTO punto_de_atencion(id_punto_atencion, localizacion, tipo_punto_atencion)
VALUES(id_punto_atencion.nextval, 'https://www.example.com/punto_atencion_digital', 'PUNTO_DE_ATENCION_DIGITAL');

INSERT INTO punto_de_atencion(id_punto_atencion, localizacion, tipo_punto_atencion)
VALUES(id_punto_atencion.nextval, 'Calle 10', 'ATENCION PERSONALIZADA');

INSERT INTO punto_de_atencion(id_punto_atencion, localizacion, tipo_punto_atencion)
VALUES(id_punto_atencion.nextval, 'Plaza de la Ciudad', 'CAJERO AUTOMATICO');

INSERT INTO punto_de_atencion(id_punto_atencion, localizacion, tipo_punto_atencion)
VALUES(id_punto_atencion.nextval, 'Avenida Central', 'ATENCION PERSONALIZADA');

INSERT INTO punto_de_atencion(id_punto_atencion, localizacion, tipo_punto_atencion)
VALUES(id_punto_atencion.nextval, 'https://www.example.com/punto_atencion_digital2', 'PUNTO_DE_ATENCION_DIGITAL');

INSERT INTO punto_de_atencion(id_punto_atencion, localizacion, tipo_punto_atencion)
VALUES(id_punto_atencion.nextval, 'Calle Principal', 'ATENCION PERSONALIZADA');

INSERT INTO oficina(id_oficina, nombre, direccion, puntos_atencion)
VALUES(1, 'oficina 1', 'Cll1', 2);

CREATE SEQUENCE id_oficina
START WITH 2
INCREMENT BY 1;

INSERT INTO oficina(id_oficina, nombre, direccion, puntos_atencion)
VALUES(id_oficina.nextval, 'Oficina 2', 'Av. Principal', 3);

INSERT INTO oficina(id_oficina, nombre, direccion, puntos_atencion)
VALUES(id_oficina.nextval, 'Oficina 3', 'Plaza Mayor', 1);

INSERT INTO oficina(id_oficina, nombre, direccion, puntos_atencion)
VALUES(id_oficina.nextval, 'Oficina 4', 'Centro Comercial', 4);

INSERT INTO oficina(id_oficina, nombre, direccion, puntos_atencion)
VALUES(id_oficina.nextval, 'Oficina 5', 'Calle 10', 2);

INSERT INTO oficina(id_oficina, nombre, direccion, puntos_atencion)
VALUES(id_oficina.nextval, 'Oficina 6', 'Plaza de la Ciudad', 3);

INSERT INTO oficina(id_oficina, nombre, direccion, puntos_atencion)
VALUES(id_oficina.nextval, 'Oficina 7', 'Avenida Central', 1);

INSERT INTO oficina(id_oficina, nombre, direccion, puntos_atencion)
VALUES(id_oficina.nextval, 'Oficina 8', 'Centro Financiero', 4);

INSERT INTO oficina(id_oficina, nombre, direccion, puntos_atencion)
VALUES(id_oficina.nextval, 'Oficina 9', 'Calle Principal', 2);

INSERT INTO pertenece(id_punto_de_atencion, id_oficina)
VALUES(1, 4);

INSERT INTO ocurre(id_punto_de_atencion, id_operacion_bancaria)
VALUES(3, 1);

INSERT INTO ejecuta(id_cliente, id_operacion_bancaria)
VALUES(6, 3);

INSERT INTO pide(id_cliente, id_prestamo)
VALUES(8, 1);

INSERT INTO tiene(id_cliente, id_cuenta)
VALUES(10, 8);

INSERT INTO hace(id_operacion_bancaria, id_cuenta)
VALUES(2, 2);