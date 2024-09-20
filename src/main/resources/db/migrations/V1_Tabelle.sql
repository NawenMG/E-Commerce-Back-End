-- Tabella Products
CREATE TABLE Products (
    ProductID INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(50) NOT NULL,
    Descrizione TEXT,
    Prezzo DECIMAL(10, 2) NOT NULL,
    Quantita INT NOT NULL,
    Immagine VARCHAR(255),
    DataCreazione TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabella Categories
CREATE TABLE Categories(
    CategoriesID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(20)
);

-- Tabella per gestire la relazione molti a molti fra la tabella products e categories
CREATE TABLE ProductCategories (
    ProductID INT,
    CategoriesID INT,
    PRIMARY KEY (ProductID, CategoriesID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
    FOREIGN KEY (CategoriesID) REFERENCES Categories(CategoriesID)
);

-- Tabella Users
CREATE TABLE Users (
    UsersID INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(20) NOT NULL,
    Cognome VARCHAR(20) NOT NULL,
    Ruolo VARCHAR(20) NOT NULL,
    NomeUtente VARCHAR(20) NOT NULL UNIQUE,
    Email VARCHAR(50) NOT NULL UNIQUE,  
    Password VARCHAR(50) NOT NULL,
    Immagine VARCHAR(255),
    Category INT,
);

-- Tabella Orders
CREATE TABLE Orders(
    OrderID INT PRIMARY KEY AUTO_INCREMENT,
    UsersID INT,
    FOREIGN KEY(UsersID) REFERENCES Users(UsersID), --Relazione uno-molti con la tabella users
    StatoDiSpedizione TIME,
    DataDiConsegna DATE,
    DataDiRichiesta DATE,
    AccettazioneOrdine BOOLEAN,
    Status BOOLEAN UNIQUE,
    FOREIGN KEY(Status) REFERENCES Payments(Status), --Relazione uno-uno con la tabella payments
    Corriere VARCHAR(20),
    Posizione VARCHAR(20)
);

-- Tabella Returns
CREATE TABLE Returns(
    ReturnsID INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
    UsersID INT,
    FOREIGN KEY(UsersID) REFERENCES Users(UsersID),  --Relazione uno-molti con la tabella users
    Status BOOLEAN,
    AccettazioneReso BOOLEAN,
    DataRichiesta DATE
);

-- Tabella Payments
CREATE TABLE Payments(
    PaymentsID INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
    Type VARCHAR(50),
    Data DATE,
    Status BOOLEAN,
    Total DECIMAL(10, 2) NOT NULL
);
