DROP TABLE IF EXISTS Livro;

CREATE TABLE Livro (
    id SERIAL PRIMARY KEY,               
    titulo VARCHAR(255) NOT NULL,        
    autor VARCHAR(255) NOT NULL,         
    categoria VARCHAR(100) NOT NULL,     
    nota INTEGER CHECK (nota BETWEEN 1 AND 5), 
    comentario TEXT
);