package com.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

//Unmarshalling
//Para convertir un archivo XML de vuelta a una instancia de Book.
public class Unmarshall {
    public static void main(String[] args) {
        try {
            //**** 1. Crear el contexto de JAXB para la clase Book, de la siguiente forma:
            //JAXBContext: Esta clase es la entrada principal para el proceso de marshalling y unmarshalling en JAXB. 
            //Proporciona un contexto que permite realizar las operaciones de conversión entre objetos Java y XML.
            //newInstance(Book.class): Aquí se le está indicando al contexto que trabaje con la clase Book (o cualquier clase anotada con @XmlRootElement o las demás anotaciones de JAXB). 
            //El contexto JAXB debe saber con qué clases va a trabajar para preparar la serialización/deserialización.
            //Si tienes más de una clase involucrada en el proceso, puedes pasar un array de clases, como por ejemplo:
            // JAXBContext context = JAXBContext.newInstance(Book.class, Author.class);
            JAXBContext context = JAXBContext.newInstance(Book.class);
            
            //**** 2. Crear objeto unmarshaller. 
            //El método createUnmarshaller crea un objeto Unmarshaller, 
            //que es el responsable de realizar el proceso de unmarshalling, es decir, 
            //convertir un documento XML en un objeto Java.
            Unmarshaller unmarshaller = context.createUnmarshaller();

            //**** 3. Unmarshalling: convertir el contenido del archivo XML a un objeto Java
            File file = new File("book.xml");
            Book book = (Book) unmarshaller.unmarshal(file);

            System.out.println("Unmarshalling completado. Book detalles:");
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Year: " + book.getYear());
            System.out.println("Price: " + book.getPrice());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
