package com.example.m202_revision_poo

// Fonction d'extension pour MutableList<Int> qui supprime les doublons et trie les éléments
fun MutableList<Int>.trierEtSupprimerDoublons() {
    // Supprimer les doublons et trier la liste
    val uniqueList = this.distinct().sorted()
    this.clear() // On vide la liste originale
    this.addAll(uniqueList) // On ajoute les éléments triés et uniques à la liste
}

fun main() {
    // Création d'une MutableList avec des valeurs initiales
    val list = mutableListOf(5, 3, 8, 1, 3, 5, 2, 8)

    println("Liste originale : $list")

    // Utilisation de la fonction d'extension pour trier et supprimer les doublons
    list.trierEtSupprimerDoublons()

    // Afficher la liste après modification
    println("Liste après tri et suppression des doublons : $list")
}
