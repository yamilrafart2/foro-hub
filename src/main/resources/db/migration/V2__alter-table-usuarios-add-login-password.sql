ALTER TABLE usuarios CHANGE COLUMN correo_electronico login VARCHAR(255) NOT NULL;
ALTER TABLE usuarios CHANGE COLUMN contrasena password VARCHAR(255) NOT NULL;