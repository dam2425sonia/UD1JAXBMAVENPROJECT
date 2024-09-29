package com.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.File;
import java.util.Arrays;

//Marshalling
//Aquí se muestra cómo convertir una instancia de Book a XML.
public class Marshall {
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

            //**** 2. Crear un marshaller para convertir el objeto a XML
            Marshaller marshaller = context.createMarshaller();
            // Para una salida formateada
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //**** 3. Crear una instancia de la clase Book
            Book book = new Book("Manejo de Ficheros", "Anónimo", 2024, 45.00);            
            
            //**** 4. Marshalling: convertir el objeto Java a XML y lo guardar en un archivo
            marshaller.marshal(book, new File("book.xml"));

            System.out.println("Marshalling completado. Salia al fichero book.xml");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
