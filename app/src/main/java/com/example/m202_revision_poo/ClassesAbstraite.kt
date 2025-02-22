package com.example.m202_revision_poo

// Classe abstraite Véhicule
abstract class Vehicule(val marque: String, val modele: String) {

    // Méthode abstraite à implémenter dans les sous-classes
    abstract fun demarrer()

    // Méthode concrète partagée par toutes les sous-classes
    fun afficherDetails() {
        println("Véhicule: $marque $modele")
    }
}

// Sous-classe Voiture
class Car(marque: String, modele: String, val nombreDePortes: Int) : Vehicule(marque, modele) {

    // Implémentation de la méthode abstraite
    override fun demarrer() {
        println("La voiture $marque $modele démarre avec un moteur à combustion.")
    }

    // Méthode spécifique à la voiture
    fun ouvrirCoffre() {
        println("Coffre de la voiture $modele ouvert.")
    }
}

// Sous-classe Moto
class Moto(marque: String, modele: String, val typeDeMoto: String) : Vehicule(marque, modele) {

    // Implémentation de la méthode abstraite
    override fun demarrer() {
        println("La moto $marque $modele démarre avec un moteur deux-temps.")
    }

    // Méthode spécifique à la moto
    fun fairePop() {
        println("La moto $modele fait un pop sur la route !")
    }
}

fun main() {
    // Création d'une instance de Voiture
    val voiture = Car("Toyota", "Corolla", 4)
    voiture.afficherDetails()  // "Véhicule: Toyota Corolla"
    voiture.demarrer()         // "La voiture Toyota Corolla démarre avec un moteur à combustion."
    voiture.ouvrirCoffre()     // "Coffre de la voiture Corolla ouvert."

    // Création d'une instance de Moto
    val moto = Moto("Honda", "CBR600", "Sport")
    moto.afficherDetails()    // "Véhicule: Honda CBR600"
    moto.demarrer()           // "La moto Honda CBR600 démarre avec un moteur deux-temps."
    moto.fairePop()           // "La moto CBR600 fait un pop sur la route !"
}
