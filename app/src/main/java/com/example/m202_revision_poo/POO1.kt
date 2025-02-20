package com.example.m202_revision_poo

// Classe mère Voiture
open class Voiture(val marque: String, val modele: String, val annee: Int,val prixJour: Double) {

    open fun getUnitePrice(): Double {
        return prixJour  // Par défaut, renvoie simplement le prix initial
    }

    open fun afficherInfos() {
        println("Voiture: $marque $modele ($annee) - Prix par jour: ${getUnitePrice()} MAD")
    }
}

// Classe VoitureEconomique (10% de réduction sur le prix)
class VoitureEconomique(marque: String, modele: String, annee: Int, prixJour: Double) :
    Voiture(marque, modele, annee, prixJour) {

    override fun getUnitePrice(): Double {
        return prixJour * 0.9  // Appliquer la réduction de 10%
    }

    override fun afficherInfos() {
        println("Voiture Économique: $marque $modele ($annee) - Prix réduit: ${getUnitePrice()} MAD")
    }
}

// Classe VoitureLuxe (Ajoute un supplément de 500 MAD si chauffeur)
class VoitureLuxe(marque: String, modele: String, annee: Int, prixJour: Double, val avecChauffeur: Boolean) :
    Voiture(marque, modele, annee, prixJour) {

    override fun getUnitePrice(): Double {
        val prixAvecChauffeur = if (avecChauffeur) prixJour + 500 else prixJour
        return prixAvecChauffeur  // Ajouter 500 MAD/jour si chauffeur
    }

    override fun afficherInfos() {
        val chauffeurTexte = if (avecChauffeur) "Avec chauffeur (+500 MAD/jour)" else "Sans chauffeur"
        println("Voiture de Luxe: $marque $modele ($annee) - $chauffeurTexte - Prix: ${getUnitePrice()} MAD")
    }
}

// Classe Location
class Location(val voiture: Voiture, val nbJours: Int) {

    fun calculerPrixTotal(): Double {
        return voiture.getUnitePrice() * nbJours
    }

    fun afficherFacture() {
        voiture.afficherInfos()
        println("Durée de location: $nbJours jours")
        println("Prix total: ${calculerPrixTotal()} MAD")
    }
}

// --- TEST ---
fun main() {
    val voiture1 = VoitureEconomique("Toyota", "Yaris", 2022, 500.0)
    val voiture2 = VoitureLuxe("Mercedes", "Classe S", 2023, 2000.0, true)  // Avec chauffeur
    val voiture3 = VoitureLuxe("BMW", "Série 7", 2023, 1800.0, false)  // Sans chauffeur

    val location1 = Location(voiture1, 5)
    val location2 = Location(voiture2, 3)
    val location3 = Location(voiture3, 2)

    println("Facture 1 :")
    location1.afficherFacture()
    println("\nFacture 2 :")
    location2.afficherFacture()
    println("\nFacture 3 :")
    location3.afficherFacture()
}