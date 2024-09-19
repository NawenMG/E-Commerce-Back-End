CREATE TABLE Prodotti(
    ProductID INT PRIMARY KEY UNIQUE NOT NULL AUTOINCREMENT,
    Nome VARCHAR(20) NOT NULL,
    Prezzo DOUBLE NOT NULL,
    Descrizione TEXT(1000),
    Immagine VARCHAR(20),
    AmountAvailable INT NOT NULL,
    Categoria VARCHAR NOT NULL REFERENCES Categorie(CategoryID),
    DataDiInserimento DATE NOT NULL
)