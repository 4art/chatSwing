package com.github.chat.model;

public class User {

    private String username;
    private String color;



    /*
    Das sind Instanzvariablen, die die Eigenschaften unseres Objekts bestimmen.
    Unser Objekt wird einen Usernamen, eine Farbe (für den Usernamen) und eine ID bekommen!
     */

/*
Konstruktor(Name muss mit dem Namen der Klasse übereinstimmen): hier werden Objekte dieser Klasse gebaut.
 Ein Konstruktor stößt die Initialisierung eines Objektes an, also das (v)erstellen eines Objekts. Die ganzen
 Informationen in einer Klasse werden zusammengepackt(intern) und in einem Objekt abgespeichert.
 Instanzvariablen sind im Konstruktor verfügbar.
 Man kann auch die Parameterliste benutzen, in dem man lokale Variablen anlegt und diese dann
  den Instanzvariablen zuweits, damit wir die Eigenschaften unseres Objekts jeder Zeit auf wunsch
 ändern können.

 */

    public User() {


    }

    public User(String username, String color) {

        this.username = username;
        this.color = color;


    }



    /*
    Instanzmethoden: bestimmen die Interaktion mit dem Objekt, das heißt, was kann man mit dem Objekt machen?
    Hier wird eine Instanzmethode verwendet, die uns den Usernamen zurück gibt.
    Die Methode spezifiziert einen Rückgabedatentyp, in dem Fall String, weil wir ja den usernamen zurückbekommen wollen.
    Etwas zurückgeben kann man in einer Methode mit dem Schlüsselwort return und dahinter folgt dann das Literal
    (bzw. eine Variable) von dem Datentyp.
    So haben wir lesenen Zugriff auf Instanzvariablen, obwohl sie private sind.

     */


    /*
    Man hat bis jetzt nur lesenen Zugriff, das heißt, man kann den Wert nur abfragen, aber noch nicht ändern!
    Dafür erstellt man wieder eine Instanzmethode, die auch wieder (wegen der Konvention) public sind, die
    den Wert verändern! Die Methode hat jedoch den Datentypwert void, weil wir hier nur etwas verändern, aber nichts
    zurückgeben! Die Methode nennen wir jetzt mal setUsername und hier spezifizieren wir jetzt die Parameterliste,
    und zwar den Wert, den man setzten will.
     */

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
