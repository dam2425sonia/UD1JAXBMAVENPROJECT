package com.example;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

//Supongamos que queremos manejar información sobre libros. 
//Primero, tenemos que definir una clase Book.
//Y definir Clases Java Anotadas @Xml...

//Esta anotación se utiliza para definir una clase como el elemento raíz de un documento XML 
//cuando se convierte entre objetos Java y XML (proceso conocido como marshalling y unmarshalling).
@XmlRootElement
public class Book implements Serializable {
    private String title;
    private String author;
    private int year;
    private double price;

    // Constructor sin parámetros necesario para JAXB
    public Book() { }

    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    //Esta anotación tiene dos atributos opcionales que permiten personalizar el nombre del elemento raíz y su espacio de nombres.
    //@XmlRootElement(name = "book", namespace = "http://www.ejemplo.com/libros")
    //name: Especifica el nombre del elemento raíz en el XML. Si no se define, utiliza el nombre de la clase.
    //namespace: Define el espacio de nombres XML para el elemento raíz. En nuestro caso no es necesario el namespace.
    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlElement
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @XmlElement
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
