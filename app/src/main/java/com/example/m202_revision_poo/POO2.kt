package com.example.m202_revision_poo

// Classe de base Chambre
open class Chambre(val numero: Int, val prixParNuit: Double) {

    open fun getPrixFinal(): Double {
        return prixParNuit  // Par défaut, renvoie simplement le prix de base
    }

    open fun afficherDetails() {
        println("Chambre N°$numero - Prix par nuit: $prixParNuit MAD")
    }
}

// Classe ChambreLuxe (Sous-classe de Chambre)
class ChambreLuxe(numero: Int, prixParNuit: Double, val avecJacuzzi: Boolean) : Chambre(numero, prixParNuit) {

    override fun getPrixFinal(): Double {
        return if (avecJacuzzi) {
            prixParNuit + 200  // Ajouter un supplément de 200 MAD par nuit si jacuzzi
        } else {
            prixParNuit
        }
    }

    override fun afficherDetails() {
        val jacuzziTexte = if (avecJacuzzi) "Avec jacuzzi (+200 MAD/nuit)" else "Sans jacuzzi"
        println("Chambre Luxe N°$numero - Prix par nuit: $prixParNuit MAD - $jacuzziTexte")
    }
}

// Classe ChambreFamiliale (Sous-classe de Chambre)
class ChambreFamiliale(numero: Int, prixParNuit: Double, val capaciteMax: Int, val litBebeDispo: Boolean) : Chambre(numero, prixParNuit) {

    override fun getPrixFinal(): Double {
        return if (litBebeDispo) {
            prixParNuit + 50  // Ajouter un supplément de 50 MAD par nuit si lit bébé disponible
        } else {
            prixParNuit
        }
    }

    override fun afficherDetails() {
        val litBebeTexte = if (litBebeDispo) "Lit bébé disponible (+50 MAD/nuit)" else "Pas de lit bébé"
        println("Chambre Familiale N°$numero - Capacité maximale: $capaciteMax personnes - $litBebeTexte - Prix par nuit: $prixParNuit MAD")
    }
}

// Classe Reservation
class Reservation(val chambre: Chambre, val nbNuits: Int) {

    fun calculerPrixTotal(): Double {
        return chambre.getPrixFinal() * nbNuits  // Calcul du prix total de la réservation
    }

    fun afficherFacture() {
        chambre.afficherDetails()  // Affiche les détails de la chambre
        println("Nombre de nuits: $nbNuits")
        println("Prix total: ${calculerPrixTotal()} MAD")
    }
}

// --- TEST ---

fun main() {
    val chambre1 = Chambre(101, 500.0)
    val chambreLuxe = ChambreLuxe(102, 800.0, true)  // Avec jacuzzi
    val chambreFamiliale = ChambreFamiliale(103, 600.0, 4, true)  // Lit bébé disponible

    val reservation1 = Reservation(chambre1, 3)
    val reservation2 = Reservation(chambreLuxe, 2)
    val reservation3 = Reservation(chambreFamiliale, 4)

    println("Facture 1 :")
    reservation1.afficherFacture()
    println("\nFacture 2 :")
    reservation2.afficherFacture()
    println("\nFacture 3 :")
    reservation3.afficherFacture()
}
